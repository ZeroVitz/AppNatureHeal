package com.example.greciaguzmn.natureheal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.SyncStateContract;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

/**
 * Created by CRUZ on 01/12/2016.
 */

public class SplashScreen extends AwesomeSplash {

    //DO NOT OVERRIDE onCreate()!
    //if you need to start some services do it in initSplash()!


    @Override
    public void initSplash(ConfigSplash configSplash) {
        /* you don't have to override every property */

        //Customize Circular Reveal
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
            // run your one time code
            configSplash.setBackgroundColor(R.color.colorPrimary); //any color you want form colors.xml
            configSplash.setAnimCircularRevealDuration(2000); //int ms
            configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
            configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

            //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

            //Customize Logo
            configSplash.setLogoSplash(R.mipmap.ic_launcher); //or any other drawable
            configSplash.setAnimLogoSplashDuration(2000); //int ms
            configSplash.setAnimLogoSplashTechnique(Techniques.Bounce); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)


            //Customize Path
            configSplash.setPathSplash(""); //set path String
            configSplash.setOriginalHeight(400); //in relation to your svg (path) resource
            configSplash.setOriginalWidth(400); //in relation to your svg (path) resource
            configSplash.setAnimPathStrokeDrawingDuration(3000);
            configSplash.setPathSplashStrokeSize(3); //I advise value be <5
            configSplash.setPathSplashStrokeColor(R.color.colorAccent); //any color you want form colors.xml
            configSplash.setAnimPathFillingDuration(3000);
            configSplash.setPathSplashFillColor(R.color.colorPrimary); //path object filling color


            //Customize Title
            configSplash.setTitleSplash("Bienvenido a Nature Heal");
            configSplash.setTitleTextColor(R.color.welcomeBackground0);
            configSplash.setTitleTextSize(30f); //float value
            configSplash.setAnimTitleDuration(3000);
            configSplash.setAnimTitleTechnique(Techniques.FlipInX);
            configSplash.setTitleFont("fonts/font-awesome-4.7.0/fonts/fontawesome-webfont.ttf"); //provide string to your font located in assets/fonts/

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        } else {
            Intent intent = new Intent(getApplicationContext(), GoogleSignInActivity.class);
            startActivity(intent);
        }

    }


    @Override
    public void animationsFinished() {

        Intent intent = new Intent(getApplicationContext(), GoogleSignInActivity.class);
        startActivity(intent);

    }
}
