package com.jose.park_ok_colaborador.view.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Attendence;
import com.jose.park_ok_colaborador.utils.UtilMask;
import com.jose.park_ok_colaborador.view.fragments.AttendanceFragment;

import java.util.List;

import static com.jose.park_ok_colaborador.utils.Constants.ATTENDENCE;

public class ReportPlateActivity extends AppCompatActivity {

    private MaterialToolbar mtToolbarDetails;
    private MaterialButton btnReportPlate;
    private EditText tvBoadInform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_plate);

        //inicializar componente
        initializeComponents();
        setSupportActionBar(mtToolbarDetails);



        mtToolbarDetails.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnReportPlate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                Attendence attendence = extras.getParcelable(ATTENDENCE);
                Intent intent = new Intent(ReportPlateActivity.this, BonusCustomerActivity.class);
                intent.putExtra(ATTENDENCE,attendence);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed(){
            SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
            editor.putInt("SCREEN_ORIGEN", 2);
            editor.commit();
            super.onBackPressed();
    }

    private void initializeComponents() {
        tvBoadInform = findViewById(R.id.tv_boad_inform);
        mtToolbarDetails = findViewById(R.id.mt_toolbar_details);
        btnReportPlate = findViewById(R.id.btn_report_plate);

        /**
         * mascara no campo placa
         * ex PPZ-4185
         * */
        tvBoadInform.addTextChangedListener(UtilMask.mask(tvBoadInform, UtilMask.BOAD));
    }
}
