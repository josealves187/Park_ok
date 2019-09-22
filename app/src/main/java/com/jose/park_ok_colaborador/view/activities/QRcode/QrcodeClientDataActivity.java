package com.jose.park_ok_colaborador.view.activities.QRcode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.view.activities.BoardAndDescriptionActivity;

public class QrcodeClientDataActivity extends AppCompatActivity {


    private CardView cmResgisterEntryDataClient;
    private CardView cmBonusCustomer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_client_data);

        cmResgisterEntryDataClient = findViewById(R.id.cm_resgister_entry_data_client);
        cmBonusCustomer = findViewById(R.id.cm_bonus_customer);

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
}
