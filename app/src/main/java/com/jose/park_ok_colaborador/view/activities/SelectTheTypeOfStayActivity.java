package com.jose.park_ok_colaborador.view.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.android.material.button.MaterialButton;
import com.jose.park_ok_colaborador.R;

public class SelectTheTypeOfStayActivity extends AppCompatActivity implements View.OnClickListener {

    private Dialog dialog;
    private MaterialButton confirmationIput;
    private CardView cmCarVehicle;
    private CardView cmMotorcycleVehicle;
    private CardView cmBigCarVehicle;
    private CardView cmVehicleX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_the_type_of_stay);

        //inicializar componente
        initializeComponents();
        implementationInstance();


    }
    // passe uma instância da sua implementação para o respectivo método setOnClickListener
    private void  implementationInstance(){
        cmCarVehicle.setOnClickListener(this);
        cmMotorcycleVehicle.setOnClickListener(this);
        cmBigCarVehicle.setOnClickListener(this);
        cmVehicleX.setOnClickListener(this);
    }
    /**
     * Caixas de diálogo
     * As caixas de diálogo são pequenas janelas que levam o usuário a tomar uma
     * decisão ou inserir informações adicionais
     */
    private void abrirDialog() {
        dialog = new Dialog(SelectTheTypeOfStayActivity.this);
        dialog.setContentView(R.layout.confirmation_registered_service);
        confirmationIput = dialog.findViewById(R.id.btn_confirmation_input);
        confirmationIput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTheTypeOfStayActivity.this, HomeActivity.class);
                startActivity(i);
                dialog.dismiss();

            }
        });
        dialog.show();
    }

    private void initializeComponents() {
        cmCarVehicle = findViewById(R.id.cm_car_vehicle);
        cmMotorcycleVehicle = findViewById(R.id.cm_motorcycle_vehicle);
        cmBigCarVehicle = findViewById(R.id.cm_big_car_vehicle);
        cmVehicleX = findViewById(R.id.cm_vehicle_x);
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_select_type_atay);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Isso é chamado quando o usuário toca no item (no modo de toque) ou atribui foco ao item com
     * as teclas de navegação ou o trackball e pressiona a tecla “enter” ou o pressiona no trackball.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cm_car_vehicle:
                abrirDialog();
                break;

            case R.id.cm_motorcycle_vehicle:
                abrirDialog();
                break;

            case R.id.cm_big_car_vehicle:
                abrirDialog();
                break;

            case R.id.cm_vehicle_x:
                abrirDialog();
                break;
        }

    }
}