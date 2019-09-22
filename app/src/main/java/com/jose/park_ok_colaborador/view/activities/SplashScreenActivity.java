package com.jose.park_ok_colaborador.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.jose.park_ok_colaborador.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                abriAutenticacao();

            }
        }, 3000);
    }

    private void abriAutenticacao() {
        Intent i = new Intent(SplashScreenActivity.this,LoginActivity.class);
        startActivity(i);
        finish();
    }
}
