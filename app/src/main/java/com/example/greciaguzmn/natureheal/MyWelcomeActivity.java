package com.example.greciaguzmn.natureheal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.TitlePage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;
import com.stephentuso.welcome.WelcomeHelper;

public class MyWelcomeActivity extends WelcomeActivity {

        @Override
        protected WelcomeConfiguration configuration() {
            return new WelcomeConfiguration.Builder(this)
                    .defaultBackgroundColor(R.color.welcomeBackground1)
                    .page(new TitlePage(R.drawable.ic_welcome1,
                            "Bienvenido a Nature Heal")
                    )
                    .page(new BasicPage(R.drawable.ic_welcome2,
                            "Respuestas a tus necesidades",
                            "Enfermarse ya tiene solución")
                            .background(R.color.welcomeBackground2)
                    )
                    .page(new BasicPage(R.drawable.ic_welcome3,
                            "Información de calidad",
                            "Buscando la manera mas saludable de mejorar").
                            background(R.color.welcomeBackground3)
                    )
                    .swipeToDismiss(true)
                    .build();
        }
    }
