package com.jose.park_ok_colaborador.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.jose.park_ok_colaborador.R;

public class SelectTheTypeOfStayActivity extends AppCompatActivity {

    private Dialog dialog;
    private MaterialButton ok;
    private CardView cmCarVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_the_type_of_stay);

        cmCarVehicle = findViewById(R.id.cm_car_vehicle);
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_select_type_atay);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cmCarVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDialog();
            }
        });
    }

    private void abrirDialog() {

        dialog = new Dialog(SelectTheTypeOfStayActivity.this);
        dialog.setContentView(R.layout.confirmation_registered_service);
        ok = dialog.findViewById(R.id.btn_ok);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        dialog.show();
    }

}