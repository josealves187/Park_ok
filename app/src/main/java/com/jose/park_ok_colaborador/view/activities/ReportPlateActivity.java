package com.jose.park_ok_colaborador.view.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.jose.park_ok_colaborador.R;

public class ReportPlateActivity extends AppCompatActivity {

    private MaterialToolbar mtToolbarDetails;
    private MaterialButton btnReportPlate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_plate);
        initcomponents();
        setSupportActionBar(mtToolbarDetails);

        mtToolbarDetails.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
                editor.putInt("SCREEN_ORIGEN", 2);
                editor.commit();
            }
        });

        btnReportPlate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportPlateActivity.this, BonusCustomerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initcomponents() {
        mtToolbarDetails = findViewById(R.id.mt_toolbar_details);
        btnReportPlate = findViewById(R.id.btn_report_plate);
    }
}
