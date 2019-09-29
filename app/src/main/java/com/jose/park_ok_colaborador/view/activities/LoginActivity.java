package com.jose.park_ok_colaborador.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Users;
import com.jose.park_ok_colaborador.view.fragments.AttendanceFragment;

import java.util.List;

import static com.jose.park_ok_colaborador.utils.Constants.SCREEN_ORIGEN;

public class LoginActivity extends AppCompatActivity {

    private TextView tvTelaRecoverPassword;
    private Button bnt_send;

    private EditText tvEmail;
    private EditText tvPasswor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InitializedComponents();


        bnt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = tvEmail.getText().toString();
                String password = tvPasswor.getText().toString();
                boolean validCredential = true;
                
                if (!user.equals("teste@gmail.com")) {
                    validCredential = false;
                    tvEmail.setError("Informe seu e-mail.");
                    tvEmail.requestFocus();
                } else {
                    tvEmail.setError(null);
                }

                if (!password.equals(("123456"))) {
                    validCredential = false;
                    tvPasswor.setError(("Digite sua senha primeiro!"));
                    tvPasswor.requestFocus();
                } else {
                    tvPasswor.setError(null);
                }

                if (validCredential) {

                    onBackPressed();
                    calledScreen();
                }

            }
        });

        tvTelaRecoverPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calledScreenRecoverPasswor();

            }
        });
    }



    private void calledScreenRecoverPasswor() {
        Intent i = new Intent(LoginActivity.this, RecoverPasswordActivity.class);
        startActivity(i);
    }

    private void calledScreen() {
        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(i);
    }

    private void InitializedComponents() {
        bnt_send = findViewById(R.id.btn_send);
        tvTelaRecoverPassword = findViewById(R.id.tv_title_rescupe_senha);
        tvEmail = findViewById(R.id.tv_email);
        tvPasswor = findViewById(R.id.tv_Passwor);
    }

    @Override
    public void onBackPressed(){
        SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
        editor.putInt("SCREEN_ORIGEN", 2);
        editor.commit();
        super.onBackPressed();
    }


}
