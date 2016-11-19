package com.example.greciaguzmn.natureheal;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AcercaFragment.OnFragmentInteractionListener, FavoritosFragment.OnFragmentInteractionListener,
        ConfiguracionFragment.OnFragmentInteractionListener, HomeFragment.OnFragmentInteractionListener, CuentaFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = HomeFragment.getInstance();
        mostrarFragment(fragment);

    }

    //private Boolean exit = false; Booleano para salir
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        /*
        Codigo para presionar atras para salir.
        El drawer no se selecciona al anterior
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Presiona Atras otra vez para salir.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }
        */

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        boolean fragmentTransaction = false;
        Fragment fragment = null;


        switch (id) {

            case R.id.nav_home:
                fragment = HomeFragment.getInstance();
                mostrarFragment(fragment);
                getSupportActionBar().setTitle("Nature Heal");
                break;

            case R.id.nav_cuenta:
                fragment = CuentaFragment.getInstance();
                mostrarFragment(fragment);
                getSupportActionBar().setTitle("Cuenta");
                break;

            case R.id.nav_fav:
                fragment = FavoritosFragment.getInstance();
                mostrarFragment(fragment);
                getSupportActionBar().setTitle("Favoritos");
                break;

            case R.id.nav_conf:
                fragment = ConfiguracionFragment.getInstance();
                mostrarFragment(fragment);
                getSupportActionBar().setTitle("Configuración");
                break;

            case R.id.nav_sugerencia:
                startActivity(new Intent(MainActivity.this, PopActivity.class));

                break;

            case R.id.nav_acerca:
                fragment = AcercaFragment.getInstance();
                mostrarFragment(fragment);
                getSupportActionBar().setTitle("Acerca de Nature Heal");

                break;

            case R.id.nav_cerrar:
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Cerrar sesión ")
                        .setMessage("¿Estás seguro que deseas cerrar esta sesión? ")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }

                        })
                        .setNegativeButton("No", null)
                        .show();
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void mostrarFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
