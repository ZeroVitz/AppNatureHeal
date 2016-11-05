package com.example.greciaguzmn.natureheal;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AcercaFragment.OnFragmentInteractionListener, FavoritosFragment.OnFragmentInteractionListener,
        ConfiguracionFragment.OnFragmentInteractionListener, fragmentHome.OnFragmentInteractionListener, cuentaFragment.OnFragmentInteractionListener {


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
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        boolean fragmentTransaction = false;
        Fragment fragment =null;


        switch (id) {
            case R.id.nav_home:
                fragment = new fragmentHome();
                fragmentTransaction = true;
                getSupportActionBar().setTitle("Nature Heal");
                break;

            case R.id.nav_cuenta:
                fragment = new cuentaFragment();
                fragmentTransaction = true;
                getSupportActionBar().setTitle("Cuenta");
                break;

            case R.id.nav_fav:
                fragment = new FavoritosFragment();
                fragmentTransaction = true;
                getSupportActionBar().setTitle("Favoritos");
                break;

            case R.id.nav_conf:
                fragment = new ConfiguracionFragment();
                fragmentTransaction = true;
                getSupportActionBar().setTitle("Configuración");
                break;

            case R.id.nav_sugerencia:
                startActivity(new Intent (MainActivity.this, Pop.class));

                break;

            case R.id.nav_acerca:
                fragment = new AcercaFragment();
                fragmentTransaction = true;
                getSupportActionBar().setTitle("Acerca de Nature Heal");

                break;

            case R.id.nav_cerrar:
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Cerrar sesión ")
                        .setMessage("¿Estás seguro que deseas cerrar esta sesión? ")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }

                        })
                        .setNegativeButton("No", null)
                        .show();
                break;

        }

        if(fragmentTransaction){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
            item.setChecked(true);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
