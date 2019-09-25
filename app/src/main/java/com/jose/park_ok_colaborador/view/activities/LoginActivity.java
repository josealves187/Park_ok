package com.jose.park_ok_colaborador.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jose.park_ok_colaborador.R;

import static com.jose.park_ok_colaborador.utils.Constants.SCREEN_ORIGEN;

public class LoginActivity extends AppCompatActivity {

    private TextView tv_tela_recover_password;
    private Button bnt_send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        bnt_send = findViewById(R.id.btn_send);
        tv_tela_recover_password = findViewById(R.id.tv_title_rescupe_senha);

        tv_tela_recover_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RecoverPasswordActivity.class);
                startActivity(i);
            }
        });

        bnt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
                editor.putInt(SCREEN_ORIGEN, 1);
                editor.commit();
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);

            }
        });



    }
}
