package com.example.greciaguzmn.natureheal;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
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
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.stephentuso.welcome.WelcomeHelper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AcercaFragment.OnFragmentInteractionListener, FavoritosFragment.OnFragmentInteractionListener,
        ConfiguracionFragment.OnFragmentInteractionListener, HomeFragment.OnFragmentInteractionListener, CuentaFragment.OnFragmentInteractionListener, FragmentManager.OnBackStackChangedListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private NavigationView navigationView;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    if (firebaseAuth.getCurrentUser()==null){
                        startActivity(new Intent(MainActivity.this, GoogleSignInActivity.class));
                    }

            }
        };



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = HomeFragment.getInstance();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_main, fragment);
        transaction.commit();

        getSupportFragmentManager().addOnBackStackChangedListener(this);

        //Welcome


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
                                mAuth.signOut();
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

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
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

    @Override
    public void onBackStackChanged() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.content_main);
        if(fragment instanceof HomeFragment){
            navigationView.setCheckedItem(R.id.nav_home);
            getSupportActionBar().setTitle("Nature Heal");
        }else if(fragment instanceof CuentaFragment){
            navigationView.setCheckedItem(R.id.nav_cuenta);
            getSupportActionBar().setTitle("Cuenta");
        } else if(fragment instanceof FavoritosFragment){
            navigationView.setCheckedItem(R.id.nav_fav);
            getSupportActionBar().setTitle("Favoritos");
        }else if(fragment instanceof ConfiguracionFragment){
            navigationView.setCheckedItem(R.id.nav_conf);
            getSupportActionBar().setTitle("Configuración");
        }else if(fragment instanceof AcercaFragment){
            navigationView.setCheckedItem(R.id.nav_acerca);
            getSupportActionBar().setTitle("Acerca de Nature Heal");
        }
    }
}
