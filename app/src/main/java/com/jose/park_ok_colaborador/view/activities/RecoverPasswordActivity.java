package com.jose.park_ok_colaborador.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.jose.park_ok_colaborador.R;

public class RecoverPasswordActivity extends AppCompatActivity {

    private EditText tvRecoverPassword;
    private MaterialButton inputrecoverPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);

        InitializedComponents();
        eventButton();
    }



    private void eventButton() {

        inputrecoverPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUserName();

            }
        });
    }

    private void InitializedComponents() {

        inputrecoverPassword =  findViewById(R.id.btn_input_recover);
        tvRecoverPassword = findViewById(R.id.tv_screen_recover_password);
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_recover_password);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void checkUserName() {
        String emailAddress = tvRecoverPassword.getText().toString().trim();
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
            tvRecoverPassword.setError("Por favor insira o endereço de e-mail válido!");
            tvRecoverPassword.requestFocus();
        }
        if (tvRecoverPassword.getText().toString().equals("")) {
            tvRecoverPassword.setError("Digite o endereço de e-mail!");
            tvRecoverPassword.requestFocus();
        }

        String usernameValue = tvRecoverPassword.getText().toString();
        boolean validCredential = true;
        if (!usernameValue.equals("teste@gmail.com")) {
            validCredential = false;
            tvRecoverPassword.setError("Email não cadastrado");
        }

        if (validCredential) {
            //tudo verificado abrimos a nova atividade
            calledScreen();

            Toast.makeText(this, "Senha enviada para seu Email", Toast.LENGTH_SHORT).show();
            //fechamos esta atividade
            this.finish();
        }
    }

    private void calledScreen() {
        Intent i = new Intent(RecoverPasswordActivity.this, LoginActivity.class);
        startActivity(i);
    }
}
