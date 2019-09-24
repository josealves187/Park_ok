package com.jose.park_ok_colaborador.view.activities.QRcode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.view.activities.BoardAndDescriptionActivity;

public class QrcodeClientDataActivity extends AppCompatActivity {


    private CardView cmResgisterEntryDataClient;
    private CardView cmBonusCustomer;
    private MaterialToolbar mtToolbarDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_client_data);

        mtToolbarDetails = findViewById(R.id.mt_toolbar_details);
        cmResgisterEntryDataClient = findViewById(R.id.cm_resgister_entry_data_client);
        cmBonusCustomer = findViewById(R.id.cm_bonus_customer);

        setSupportActionBar(mtToolbarDetails);

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

        mtToolbarDetails.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
                editor.putInt("SCREEN_ORIGEN", 1);
                editor.commit();
            }
        });
    }
}
