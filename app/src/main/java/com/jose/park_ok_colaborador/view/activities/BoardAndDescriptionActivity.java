package com.jose.park_ok_colaborador.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.button.MaterialButton;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.utils.UtilMask;

public class BoardAndDescriptionActivity extends AppCompatActivity implements Animation.AnimationListener {

    Animation animFadein;
    Animation animFadeinUp;
    private TextView tvInformation;
    private TextView tvTitleDescription;
    private EditText etAddInformation;
    private NestedScrollView nsvBoardDescription;
    private boolean informationvisible = false;
    private MaterialButton btnCheckInVehicle;
    private ImageView ivArrow;
    private EditText tvVehicleBoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_and_description);
        intComponents();

        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // set animation listener
        animFadein.setAnimationListener(this);

        tvInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informationvisible = !informationvisible;

                if (informationvisible) {
                    tvInformation.setText("OCULTAR");
                    etAddInformation.setVisibility(View.VISIBLE);
                    etAddInformation.startAnimation(animFadein);
                    ivArrow.setImageResource(R.drawable.ic_up_arrow);
                    ivArrow.setVisibility(View.VISIBLE);

                    int scrollTo = ((View) tvTitleDescription.getParent().getParent()).getTop() + tvTitleDescription.getTop();
                    nsvBoardDescription.fullScroll(View.FOCUS_DOWN);
                    nsvBoardDescription.smoothScrollTo(0, scrollTo);

                } else {

                    tvInformation.setText("INFORMAR");
                    etAddInformation.setVisibility(View.GONE);
                    etAddInformation.startAnimation(animFadeinUp);
                    ivArrow.setImageResource(R.drawable.ic_arrow_download);
                    ivArrow.setVisibility(View.VISIBLE);

                }

            }
        });

        btnCheckInVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoardAndDescriptionActivity.this ,VehicleTypeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void intComponents() {

        ivArrow = findViewById(R.id.iv_arrow);
        etAddInformation = findViewById(R.id.et_add_information);
        nsvBoardDescription = findViewById(R.id.nsv_board_description);
        btnCheckInVehicle= findViewById(R.id.btn_check_in_vehicle);

        tvInformation = findViewById(R.id.tv_information);
        tvTitleDescription= findViewById(R.id.tv_title_description);
        tvVehicleBoad = findViewById(R.id.tv_vehicle_boad);

        // load the animation
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.swipe_down_boar_description);
        // load the animation
        animFadeinUp = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up_board_description);

        /**
         * mascara no campo placa
         * ex PPZ-4185
         * */
        tvVehicleBoad.addTextChangedListener(UtilMask.mask(tvVehicleBoad, UtilMask.BOAD));
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
