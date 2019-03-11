package com.example.farmaapp.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
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
    EditText tv_entero, tv_fraccion;

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

    private void iniciarEventos() {

        fab_entero_mas.setOnClickListener(this);

    }

    private void inicializarUI() {

        fab_entero_mas = (FloatingActionButton) v.findViewById(R.id.fab_entero_mas);
        fab_entero_menos = (FloatingActionButton) v.findViewById(R.id.fab_entero_menos);
        fab_fraccion_mas = (FloatingActionButton) v.findViewById(R.id.fab_fraccion_mas);
        fab_fraccion_menos = (FloatingActionButton) v.findViewById(R.id.fab_fraccion_menos);

        tv_entero = v.findViewById(R.id.tv_entero);
        tv_fraccion = v.findViewById(R.id.tv_fraccion);

        this.vCantEntero = 0;
        this.vCantFraccion = 0;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.fab_entero_mas:
                agregarUnEntero();
                break;

        }

        this.tv_entero.setText(this.vCantEntero);
        this.tv_fraccion.setText(this.vCantFraccion);

    }

    private void agregarUnEntero() {
        this.tv_entero.setText("1");
        //this.vCantEntero = this.vCantEntero + 1;
        //this.tv_entero.setText(this.vCantEntero + " ");

    }
}
