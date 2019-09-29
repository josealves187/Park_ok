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

        initializeComponents();

        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_vehicle_type);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // passe uma instância da sua implementação para o respectivo método setOnClickListener
        cmCarVehicle.setOnClickListener(this);
        cmMotorcycleVehicle.setOnClickListener(this);
        cmBigCarVehicle.setOnClickListener(this);
        cmVehicleX.setOnClickListener(this);
        cmVehicleY.setOnClickListener(this);


    }

    private void initializeComponents() {
        cmCarVehicle = findViewById(R.id.cm_car_vehicle);
        cmBigCarVehicle = findViewById(R.id.cm_big_car_vehicle);
        cmMotorcycleVehicle = findViewById(R.id.cm_motorcycle_vehicle);
        cmVehicleX = findViewById(R.id.cm_vehicle_x);
        cmVehicleY = findViewById(R.id.cm_vehicle_y);
    }


    /**
     * Isso é chamado quando o usuário toca no item (no modo de toque) ou atribui foco ao item com
     * as teclas de navegação ou o trackball e pressiona a tecla “enter” ou o pressiona no trackball.
     */

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