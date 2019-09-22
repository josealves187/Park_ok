package com.jose.park_ok_colaborador.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.jose.park_ok_colaborador.R;

public class VehicleTypeActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView cmCarVehicle;
    private CardView cmMotorcycleVehicle;
    private CardView cmBigCarVehicle;
    private CardView cmVehicleX;
    private CardView cmVehicleY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_type);

        initcomponents();
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_vehicle_type);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        cmCarVehicle.setOnClickListener(this);
        cmMotorcycleVehicle.setOnClickListener(this);
        cmBigCarVehicle.setOnClickListener(this);
        cmVehicleX.setOnClickListener(this);
        cmVehicleY.setOnClickListener(this);


    }

    private void initcomponents() {
        cmCarVehicle = findViewById(R.id.cm_car_vehicle);
        cmMotorcycleVehicle = findViewById(R.id.cm_motorcycle_vehicle);
        cmBigCarVehicle = findViewById(R.id.cm_big_car_vehicle);
        cmVehicleX = findViewById(R.id.cm_vehicle_x);
        cmVehicleY = findViewById(R.id.cm_vehicle_y);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cm_car_vehicle:
                calledView();
                break;

            case R.id.cm_motorcycle_vehicle:
                calledView();
                break;

            case R.id.cm_big_car_vehicle:
                calledView();
                break;

            case R.id.cm_vehicle_x:
                calledView();
                break;

            case R.id.cm_vehicle_y:
                calledView();
                break;
        }
    }
    
    private void calledView() {

        Intent intent = new Intent(VehicleTypeActivity.this, SelectTheTypeOfStayActivity.class);
        startActivity(intent);
    }
}