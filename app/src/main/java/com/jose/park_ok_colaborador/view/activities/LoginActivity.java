package com.jose.park_ok_colaborador.view.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.jose.park_ok_colaborador.R;

public class LoginActivity extends AppCompatActivity {

    private TextView tvTelaRecoverPassword;
    private Button bnt_send;

    private TextInputEditText tvEmail;
    private TextInputEditText tvPasswor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InitializedComponents();
        eventButton();
    }


    private void eventButton() {

        bnt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //checkUserName();
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);


            }

//            }
        });

        tvTelaRecoverPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calledScreenRecoverPasswor();

            }
        });
    }

    private void checkUserName() {

        String emailAddress = tvEmail.getText().toString().trim();
        if (tvPasswor.getText().toString().length() < 6) {
            tvPasswor.setError("Senha mínima contém 6 caracteres!");
            tvPasswor.requestFocus();
        }
        if (tvPasswor.getText().toString().equals("")) {
            tvPasswor.setError("por favor digite a senha!");
            tvPasswor.requestFocus();
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
            tvEmail.setError("Por favor insira o endereço de e-mail válido!");
            tvEmail.requestFocus();
        }
        if (tvEmail.getText().toString().equals("")) {
            tvEmail.setError("Digite o endereço de e-mail!");
            tvEmail.requestFocus();
        }
        if (!emailAddress.equals("") &&
                tvPasswor.getText().toString().length() >= 6 &&
                !tvPasswor.getText().toString().trim().equals("")
                && android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
            //verificar e-mail e tvPasswor
            //IMPORTANTE: aqui deve ser chamada a função de back-end ou mais segura para verificação
            //local; Por exemplo, simples verificação
            //Por exemplo, simples verificação

            String usernameValue = tvEmail.getText().toString();
            String passwordValue = tvPasswor.getText().toString();
            boolean validCredential = true;
            if (!usernameValue.equals("teste@gmail.com")) {
                validCredential = false;
                tvEmail.setError("Email não cadastrado");
            } else {
                tvEmail.setError(null);
            }

            if (!passwordValue.equals("123456")) {
                validCredential = false;
                tvPasswor.setError(("Senhas dados invalidos!"));

            } else {
                tvPasswor.setError(null);
            }

            if (validCredential) {
                //tudo verificado abrimos a nova atividade
                calledScreen();
                onBackPressed();

                Toast.makeText(this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();
                //fechamos esta atividade
                this.finish();
            }
        }

    }

    private void calledScreenRecoverPasswor() {
        Intent i = new Intent(LoginActivity.this, RecoverPasswordActivity.class);
        startActivity(i);
    }

    private void calledScreen() {
        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(i);
        onBackPressed();
    }

    private void InitializedComponents() {
        bnt_send = findViewById(R.id.btn_send);
        tvTelaRecoverPassword = findViewById(R.id.tv_title_rescupe_senha);
        tvEmail = findViewById(R.id.tv_tiet_emali);
        tvPasswor = findViewById(R.id.tv_tiet_Passwor);
    }

    @Override
    public void onBackPressed() {
        SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
        editor.putInt("SCREEN_ORIGEN", 1);
        editor.commit();
        super.onBackPressed();
    }

}
