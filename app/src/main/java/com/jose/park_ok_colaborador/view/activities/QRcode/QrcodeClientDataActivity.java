package com.jose.park_ok_colaborador.view.activities.QRcode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Users;
import com.jose.park_ok_colaborador.view.activities.BoardAndDescriptionActivity;

import static com.jose.park_ok_colaborador.utils.MaskTextView.cpf;

public class QrcodeClientDataActivity extends AppCompatActivity {


    private CardView cmResgisterEntryDataClient;
    private CardView cmBonusCustomer;
    private MaterialToolbar mtToolbarDetails;
    private TextView tvNameDataClien;
    private TextView tvCpfDataClien;

    private ImageView acivPhotoDataClien;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_client_data);

        //inicializar componente
        initializeComponent();
        setSupportActionBar(mtToolbarDetails);
        eventBuntton();


        Users users = new Users(1, "José", "14587965288", "jralves187@gmail.com");
        if (users != null) {
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/freedelivery-8ff6e.appspot.com/o/imagens%2FUsuario%2FyO40m4hU9dR2eoQLANMrSkkcIQP2jpeg?alt=media&token=30dffe08-64ba-4b08-acca-10c6f1ac7d0f").into(acivPhotoDataClien);
            tvNameDataClien.setText(users.getNameUser());
            tvCpfDataClien.setText(cpf(users.getCpf()));

        }

    }

    private void eventBuntton() {
        /***
         * redirected screen
         * redirecionando telas Navigation da toolbar
         * */
        mtToolbarDetails.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

        cmResgisterEntryDataClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QrcodeClientDataActivity.this, BoardAndDescriptionActivity.class);
                startActivity(i);
            }
        });

        cmBonusCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QrcodeClientDataActivity.this, BoardAndDescriptionActivity.class);
                startActivity(i);
            }
        });

    }

    //controlando onBackPressed (botão de volta do aparelho celular)
    @Override
    public void onBackPressed(){

        SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
        editor.putInt("SCREEN_ORIGEN", 1);
        editor.commit();
        super.onBackPressed();
    }

    private void initializeComponent() {
        mtToolbarDetails = findViewById(R.id.mt_toolbar_details);
        cmResgisterEntryDataClient = findViewById(R.id.cm_resgister_entry_data_client);
        cmBonusCustomer = findViewById(R.id.cm_bonus_customer);
        acivPhotoDataClien = findViewById(R.id.aciv_photo_data_client);
        tvNameDataClien = findViewById(R.id.tv_name_data_client);
        tvCpfDataClien= findViewById(R.id.tv_cpf_data_client);
    }
}
