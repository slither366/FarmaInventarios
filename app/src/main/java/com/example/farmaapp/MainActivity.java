package com.example.farmaapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.farmaapp.fragments.ConteoFragment;
import com.example.farmaapp.fragments.InventarioFragment;
import com.example.farmaapp.fragments.VpAdapter;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayoutPrincipal;
    ViewPager vpContenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayoutPrincipal = findViewById(R.id.TabLayoutPrincipal);
        vpContenido = findViewById(R.id.vpContenido);

        //tabLayoutPrincipal = findViewById(R.id.TabLayoutPrincipal);

        //tabLayoutPrincipal.addTab(tabLayoutPrincipal.newTab().setText("Conteo"));
        //tabLayoutPrincipal.addTab(tabLayoutPrincipal.newTab().setText("Inventario"));

        configurarContenido();
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
}
