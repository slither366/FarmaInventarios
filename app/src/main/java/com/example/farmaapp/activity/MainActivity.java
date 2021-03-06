package com.example.farmaapp.activity;

import android.arch.persistence.room.Room;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.farmaapp.R;
import com.example.farmaapp.db.AppDatabase;
import com.example.farmaapp.entity.Producto;
import com.example.farmaapp.entity.ProductoBarra;
import com.example.farmaapp.fragments.ConteoFragment;
import com.example.farmaapp.fragments.InventarioFragment;
import com.example.farmaapp.fragments.VpAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    TabLayout tabLayoutPrincipal;
    ViewPager vpContenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Ocultar Navigation Bar Hidden
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
        tabLayoutPrincipal = findViewById(R.id.TabLayoutPrincipal);
        vpContenido = findViewById(R.id.vpContenido);

        configurarContenido();

        inicializarUI();

        iniciarEventos();

    }

    private void inicializarUI() {

    }

    private void iniciarEventos() {

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
