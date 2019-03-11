package com.example.farmaapp.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.farmaapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConteoFragment extends Fragment implements View.OnClickListener {

    View v;
    Integer vCantEntero, vCantFraccion;

    FloatingActionButton fab_entero_menos, fab_entero_mas, fab_fraccion_menos, fab_fraccion_mas;
    EditText et_entero, et_fraccion, et_anaquel, et_codProd;

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
        et_codProd = v.findViewById(R.id.et_codProd);

        et_entero.setInputType(InputType.TYPE_NULL);
        et_anaquel.setInputType(InputType.TYPE_NULL);
        et_fraccion.setInputType(InputType.TYPE_NULL);
        et_codProd.setInputType(InputType.TYPE_NULL);


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

            case R.id.et_codProd:
                et_codProd.selectAll();
                break;

        }

        //this.tv_entero.setText(this.vCantEntero);
        //this.tv_fraccion.setText(this.vCantFraccion);

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


}
