package com.jose.park_ok_colaborador.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.jose.park_ok_colaborador.R;

public class RegistrationDataActivity extends AppCompatActivity {

    private MaterialToolbar mtToolbarDataRegistrion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_data);
        initializecomponents();

        setSupportActionBar(mtToolbarDataRegistrion);

        mtToolbarDataRegistrion.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
                editor.putInt("SCREEN_ORIGEN", 4);
                editor.commit();
            }
        });
    }

    private void initializecomponents() {
        mtToolbarDataRegistrion = findViewById(R.id.mt_toolbar_data_registrion);
    }
}
