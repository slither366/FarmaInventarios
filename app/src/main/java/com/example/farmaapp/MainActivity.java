package com.example.farmaapp;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.farmaapp.fragments.ConteoFragment;
import com.example.farmaapp.fragments.InventarioFragment;
import com.example.farmaapp.fragments.VpAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TabLayout tabLayoutPrincipal;
    ViewPager vpContenido;
    Integer vCantEntero, vCantFraccion;

    FloatingActionButton fab_entero_menos, fab_entero_mas, fab_fraccion_menos, fab_fraccion_mas;
    EditText tv_entero, tv_fraccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
        tabLayoutPrincipal = findViewById(R.id.TabLayoutPrincipal);
        vpContenido = findViewById(R.id.vpContenido);

        //tabLayoutPrincipal = findViewById(R.id.TabLayoutPrincipal);

        //tabLayoutPrincipal.addTab(tabLayoutPrincipal.newTab().setText("Conteo"));
        //tabLayoutPrincipal.addTab(tabLayoutPrincipal.newTab().setText("Inventario"));

        configurarContenido();

        //inicializarUI();

        //iniciarEventos();

    }

    private void inicializarUI() {

        fab_entero_mas = (FloatingActionButton)findViewById(R.id.fab_entero_mas);
        fab_entero_menos = (FloatingActionButton)findViewById(R.id.fab_entero_menos);
        fab_fraccion_mas = (FloatingActionButton)findViewById(R.id.fab_fraccion_mas);
        fab_fraccion_menos = (FloatingActionButton)findViewById(R.id.fab_fraccion_menos);

        tv_entero = findViewById(R.id.et_entero);
        tv_fraccion = findViewById(R.id.et_fraccion);

        this.vCantEntero = 0;
        this.vCantFraccion = 0;

    }

    private void iniciarEventos() {

        fab_entero_mas.setOnClickListener(this);
        //btn_entero_menos.setOnClickListener(this);
        //btn_fraccion_mas.setOnClickListener(this);
        //btn_fraccion_menos.setOnClickListener(this);

    }

    private void configurarContenido(){
        VpAdapter adapter = new VpAdapter(getSupportFragmentManager());
        adapter.agregarFragmento( new ConteoFragment(),"Conteo");
        adapter.agregarFragmento( new InventarioFragment(), "Inventario");
        vpContenido.setAdapter(adapter);
        tabLayoutPrincipal.setupWithViewPager(vpContenido);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void disminuirUnaFraccion() {
        this.vCantFraccion = this.vCantFraccion - 1;
        tv_fraccion.setText(this.vCantFraccion+" ");
    }

    private void agregarUnaFraccion() {
        this.vCantFraccion = this.vCantFraccion + 1;
        tv_fraccion.setText(this.vCantFraccion+" ");
    }

    private void disminuirUnEntero() {

        this.vCantEntero = this.vCantEntero - 1;
        tv_entero.setText(this.vCantEntero+" ");

    }

    private void agregarUnEntero() {

        this.vCantEntero = this.vCantEntero + 1;
        tv_entero.setText(this.vCantEntero+" ");

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.fab_entero_mas:
                Toast.makeText(this, "Click en Entero Mas!", Toast.LENGTH_SHORT).show();
                //agregarUnEntero();
                break;

            case R.id.fab_entero_menos:
                Toast.makeText(this, "Click en Entero Menos!", Toast.LENGTH_SHORT).show();
                //disminuirUnEntero();
                break;

            case R.id.fab_fraccion_mas:
                Toast.makeText(this, "Click en Fraccion Mas", Toast.LENGTH_SHORT).show();
                //agregarUnaFraccion();
                break;

            case R.id.fab_fraccion_menos:
                Toast.makeText(this, "Click en Fraccion Menos", Toast.LENGTH_SHORT).show();
                //disminuirUnaFraccion();
                break;

        }

        tv_entero.setText(this.vCantEntero);
        tv_fraccion.setText(this.vCantFraccion);

    }
}
