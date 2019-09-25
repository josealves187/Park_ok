package com.jose.park_ok_colaborador.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Attendence;

import static com.jose.park_ok_colaborador.utils.Constants.ATTENDENCE;

public class BonusCustomerActivity extends AppCompatActivity {
    private MaterialButton btnReportPlate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_customer);

        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_bonus_customer);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        final Attendence attendence = extras.getParcelable(ATTENDENCE);

        btnReportPlate = findViewById(R.id.btn_report_plate);

        btnReportPlate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BonusCustomerActivity.this, CheckOutActivity.class);
                i.putExtra(ATTENDENCE, attendence);
                startActivity(i);
            }
        });


    }
}
