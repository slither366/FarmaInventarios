package com.example.farmaapp.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.symbol.emdk.EMDKManager;
import com.symbol.emdk.EMDKResults;
import com.symbol.emdk.EMDKManager.EMDKListener;
import com.symbol.emdk.EMDKManager.FEATURE_TYPE;
import com.symbol.emdk.barcode.BarcodeManager;
import com.symbol.emdk.barcode.BarcodeManager.ConnectionState;
import com.symbol.emdk.barcode.BarcodeManager.ScannerConnectionListener;
import com.symbol.emdk.barcode.ScanDataCollection;
import com.symbol.emdk.barcode.Scanner;
import com.symbol.emdk.barcode.ScannerConfig;
import com.symbol.emdk.barcode.ScannerException;
import com.symbol.emdk.barcode.ScannerInfo;
import com.symbol.emdk.barcode.ScannerResults;
import com.symbol.emdk.barcode.ScanDataCollection.ScanData;
import com.symbol.emdk.barcode.Scanner.DataListener;
import com.symbol.emdk.barcode.Scanner.StatusListener;
import com.symbol.emdk.barcode.Scanner.TriggerType;
import com.symbol.emdk.barcode.StatusData.ScannerStates;
import com.symbol.emdk.barcode.StatusData;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.content.pm.ActivityInfo;

import com.example.farmaapp.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConteoFragment extends Fragment implements View.OnClickListener,EMDKListener, DataListener, StatusListener, ScannerConnectionListener, OnCheckedChangeListener {

    View v;
    Integer vCantEntero, vCantFraccion;

    FloatingActionButton fab_entero_menos, fab_entero_mas, fab_fraccion_menos, fab_fraccion_mas;
    EditText et_entero, et_fraccion, et_anaquel, et_codProd;
    Button btn_guardar, btn_cancelar;

    private EMDKManager emdkManager = null;
    private BarcodeManager barcodeManager = null;
    private Scanner scanner = null;

    private EditText et_codScaneado = null;

    private Spinner spinnerScannerDevices = null;

    private List<ScannerInfo> deviceList = null;

    private int scannerIndex = 0; // Keep the selected scanner
    private int defaultIndex = 0; // Keep the default scanner
    private String statusString = "";

    private boolean bSoftTriggerSelected = false;
    private boolean bDecoderSettingsChanged = false;
    private boolean bExtScannerDisconnected = false;
    private final Object lock = new Object();

    public ConteoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_contador, container, false);

        inicializarUI();

        iniciarEventos();

        deviceList = new ArrayList<ScannerInfo>();

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        setDefaultOrientation();

        EMDKResults results = EMDKManager.getEMDKManager(getActivity().getApplicationContext(), this);
        if (results.statusCode != EMDKResults.STATUS_CODE.SUCCESS) {
            updateStatus("EMDKManager object request failed!");
            return v;
        }
        addSpinnerScannerDevicesListener();


        return v;

    }

    private void inicializarUI() {

        fab_entero_mas = (FloatingActionButton) v.findViewById(R.id.fab_entero_mas);
        fab_entero_menos = (FloatingActionButton) v.findViewById(R.id.fab_entero_menos);
        fab_fraccion_mas = (FloatingActionButton) v.findViewById(R.id.fab_fraccion_mas);
        fab_fraccion_menos = (FloatingActionButton) v.findViewById(R.id.fab_fraccion_menos);

        et_entero = v.findViewById(R.id.et_entero);
        et_fraccion = v.findViewById(R.id.et_fraccion);
        et_anaquel = v.findViewById(R.id.et_anaquel);
        et_codProd = v.findViewById(R.id.et_codScaneado);

        et_entero.setInputType(InputType.TYPE_NULL);
        et_anaquel.setInputType(InputType.TYPE_NULL);
        et_fraccion.setInputType(InputType.TYPE_NULL);
        et_codProd.setInputType(InputType.TYPE_NULL);

        et_codScaneado = (EditText) v.findViewById(R.id.et_codScaneado);
        spinnerScannerDevices = (Spinner) v.findViewById(R.id.spinnerScannerDevices);

        //btn_cancelar = (Button) v.findViewById(R.id.btn_cancelar);
        //btn_guardar = (Button) v.findViewById(R.id.btn_guardar);

        this.vCantEntero = 0;
        this.vCantFraccion = 0;

    }

    private void iniciarEventos() {

        fab_entero_mas.setOnClickListener(this);
        fab_entero_menos.setOnClickListener(this);
        fab_fraccion_mas.setOnClickListener(this);
        fab_fraccion_menos.setOnClickListener(this);
        et_entero.setOnClickListener(this);
        et_fraccion.setOnClickListener(this);
        et_anaquel.setOnClickListener(this);
        et_codProd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.fab_entero_mas:
                aumentarUnEntero();
                break;

            case R.id.fab_entero_menos:
                disminuirUnEntero();
                break;

            case R.id.fab_fraccion_mas:
                aumentarUnaFraccion();
                break;

            case R.id.fab_fraccion_menos:
                disminuirUnaFraccion();
                break;

            case R.id.et_entero:
                et_entero.selectAll();
                break;

            case R.id.et_fraccion:
                et_fraccion.selectAll();
                break;

            case R.id.et_anaquel:
                et_anaquel.selectAll();
                break;

            case R.id.et_codScaneado:
                et_codProd.selectAll();
                break;

        }

        //this.tv_entero.setText(this.vCantEntero);
        //this.tv_fraccion.setText(this.vCantFraccion);

    }

    private void agregarProducto() {



    }

    private void aumentarUnEntero() {
        //this.vCantEntero =
        this.vCantEntero = this.vCantEntero + 1;
        this.et_entero.setText(this.vCantEntero + "");
    }

    private void disminuirUnEntero() {
        this.vCantEntero = this.vCantEntero - 1;
        this.et_entero.setText(this.vCantEntero + "");
    }

    private void aumentarUnaFraccion() {
        this.vCantFraccion = this.vCantFraccion + 1;
        this.et_fraccion.setText(this.vCantFraccion + "");
    }
    
    private void disminuirUnaFraccion() {
        this.vCantFraccion = this.vCantFraccion - 1;
        this.et_fraccion.setText(this.vCantFraccion + "");
    }

    @Override
    public void onOpened(EMDKManager emdkManager) {
        updateStatus("EMDK open success!");
        this.emdkManager = emdkManager;
        initBarcodeManager();
        enumerateScannerDevices();
        spinnerScannerDevices.setSelection(defaultIndex);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (emdkManager != null) {
            initBarcodeManager();
            enumerateScannerDevices();
            spinnerScannerDevices.setSelection(scannerIndex);
            initScanner();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        deInitScanner();
        deInitBarcodeManager();
    }

    @Override
    public void onClosed() {
        if (emdkManager != null) {
            emdkManager.release();
            emdkManager = null;
        }
        updateStatus("EMDK closed unexpectedly! Please close and restart the application.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (emdkManager != null) {
            emdkManager.release();
            emdkManager = null;
        }
    }

    //Obtiene la data guardada y lo setea en un <scrollViewData>
    @Override
    public void onData(ScanDataCollection scanDataCollection) {
        if ((scanDataCollection != null) && (scanDataCollection.getResult() == ScannerResults.SUCCESS)) {
            ArrayList <ScanData> scanData = scanDataCollection.getScanData();
            for(ScanData data : scanData) {
                //updateData("<font color='red'>" + data.getLabelType() + "</font> : " + data.getData());
                updateData(data.getData());
            }

        }
    }

    @Override
    public void onStatus(StatusData statusData) {
        ScannerStates state = statusData.getState();
        switch(state) {
            case IDLE:
                statusString = statusData.getFriendlyName()+" is enabled and idle...";
                updateStatus(statusString);

                if(bSoftTriggerSelected) {
                    scanner.triggerType = TriggerType.SOFT_ONCE;
                    bSoftTriggerSelected = false;
                } else {
                    scanner.triggerType = TriggerType.HARD;
                }

                if(bDecoderSettingsChanged) {
                    setDecoders();
                    bDecoderSettingsChanged = false;
                }

                if(!scanner.isReadPending() && !bExtScannerDisconnected) {
                    try {
                        scanner.read();
                    } catch (ScannerException e) {
                        updateStatus(e.getMessage());
                    }
                }
                break;
            case WAITING:
                statusString = "Scanner is waiting for trigger press...";
                updateStatus(statusString);
                break;
            case SCANNING:
                statusString = "Scanning...";
                updateStatus(statusString);
                break;
            case DISABLED:
                statusString = statusData.getFriendlyName()+" is disabled.";
                updateStatus(statusString);
                break;
            case ERROR:
                statusString = "An error has occurred.";
                updateStatus(statusString);
                break;
            default:
                break;
        }
    }

    @Override
    public void onConnectionChange(ScannerInfo scannerInfo, ConnectionState connectionState) {
        String status;
        String scannerName = "";
        String statusExtScanner = connectionState.toString();
        String scannerNameExtScanner = scannerInfo.getFriendlyName();
        if (deviceList.size() != 0) {
            scannerName = deviceList.get(scannerIndex).getFriendlyName();
        }
        if (scannerName.equalsIgnoreCase(scannerNameExtScanner)) {
            switch(connectionState) {
                case CONNECTED:
                    bSoftTriggerSelected = false;
                    synchronized (lock) {
                        initScanner();
                        bExtScannerDisconnected = false;
                    }
                    break;
                case DISCONNECTED:
                    bExtScannerDisconnected = true;
                    synchronized (lock) {
                        deInitScanner();
                    }
                    break;
            }
            status = scannerNameExtScanner + ":" + statusExtScanner;
            updateStatus(status);
        }
        else {
            bExtScannerDisconnected = false;
            status =  statusString + " " + scannerNameExtScanner + ":" + statusExtScanner;
            updateStatus(status);
        }
    }

    private void initScanner() {
        if (scanner == null) {
            if ((deviceList != null) && (deviceList.size() != 0)) {
                if (barcodeManager != null)
                    scanner = barcodeManager.getDevice(deviceList.get(scannerIndex));
            }
            else {
                updateStatus("Failed to get the specified scanner device! Please close and restart the application.");
                return;
            }
            if (scanner != null) {
                scanner.addDataListener(this);
                scanner.addStatusListener(this);
                try {
                    scanner.enable();
                } catch (ScannerException e) {
                    updateStatus(e.getMessage());
                    deInitScanner();
                }
            }else{
                updateStatus("Failed to initialize the scanner device.");
            }
        }
    }

    private void deInitScanner() {
        if (scanner != null) {
            try{
                scanner.disable();
                scanner.release();
            } catch (Exception e) {
                updateStatus(e.getMessage());
            }
            scanner = null;
        }
    }

    private void initBarcodeManager(){
        barcodeManager = (BarcodeManager) emdkManager.getInstance(FEATURE_TYPE.BARCODE);
        if (barcodeManager != null) {
            barcodeManager.addConnectionListener(this);
        }
    }

    private void deInitBarcodeManager(){
        if (emdkManager != null) {
            emdkManager.release(FEATURE_TYPE.BARCODE);
        }
    }

    private void addSpinnerScannerDevicesListener() {
        spinnerScannerDevices.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int position, long arg3) {
                if ((scannerIndex != position) || (scanner==null)) {
                    scannerIndex = position;
                    bSoftTriggerSelected = false;
                    bExtScannerDisconnected = false;
                    deInitScanner();
                    initScanner();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    // Obtienes los nombres del tipo de Barra existen CODEBARRA y QR y otros como bluetooth
    // 2D Barcode Imager
    private void enumerateScannerDevices() {
        if (barcodeManager != null) {
            List<String> friendlyNameList = new ArrayList<String>();
            int spinnerIndex = 0;
            deviceList = barcodeManager.getSupportedDevicesInfo();
            if ((deviceList != null) && (deviceList.size() != 0)) {
                Iterator<ScannerInfo> it = deviceList.iterator();
                while(it.hasNext()) {
                    ScannerInfo scnInfo = it.next();
                    friendlyNameList.add(scnInfo.getFriendlyName());
                    if(scnInfo.isDefaultScanner()) {
                        defaultIndex = spinnerIndex;
                    }
                    ++spinnerIndex;
                }
            }
            else {
                updateStatus("Failed to get the list of supported scanner devices! Please close and restart the application.");
            }
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_spinner_item, friendlyNameList);
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerScannerDevices.setAdapter(spinnerAdapter);
        }
    }

    private void setDecoders() {
        if (scanner != null) {
            try {
                ScannerConfig config = scanner.getConfig();
                // Set EAN8
                config.decoderParams.ean8.enabled = true;//checkBoxEAN8.isChecked();
                // Set EAN13
                config.decoderParams.ean13.enabled = true; //checkBoxEAN13.isChecked();
                // Set Code39
                config.decoderParams.code39.enabled = true; //checkBoxCode39.isChecked();
                //Set Code128
                config.decoderParams.code128.enabled = true; //checkBoxCode128.isChecked();
                scanner.setConfig(config);
            } catch (ScannerException e) {
                updateStatus(e.getMessage());
            }
        }
    }

    public void softScan(View view) {
        bSoftTriggerSelected = true;
        cancelRead();
    }

    private void cancelRead(){
        if (scanner != null) {
            if (scanner.isReadPending()) {
                try {
                    scanner.cancelRead();
                } catch (ScannerException e) {
                    updateStatus(e.getMessage());
                }
            }
        }
    }

    private void updateStatus(final String status){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("LogFP: ", status);
            }
        });
    }

    private void updateData(final String result){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (result != null) {
                    et_codScaneado.setText(result);
                    et_codScaneado.requestFocus();
                    et_codScaneado.selectAll();
                }
            }
        });
    }

    private void setDefaultOrientation(){
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        if(width > height){
            //setContentView(R.layout.activity_main_landscape);
        } else {
            //getActivity().setContentView(R.layout.fragment_inventario);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
        bDecoderSettingsChanged = true;
        cancelRead();
    }



}
