package com.jose.park_ok_colaborador.view.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.appbar.MaterialToolbar;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Attendence;

import static com.jose.park_ok_colaborador.utils.Constants.ATTENDENCE;
import static com.jose.park_ok_colaborador.utils.MaskTextView.boad;
import static com.jose.park_ok_colaborador.utils.MaskTextView.cpf;
import static com.jose.park_ok_colaborador.utils.Utils.formatCurrency;
import static com.jose.park_ok_colaborador.utils.Utils.timeFormat;

public class CheckOutActivity extends AppCompatActivity {

    private CardView cmCheckOutDiscountBenefit;
    private CardView cmBonusCustomer;

    private ImageView ivCheckOutCard;
    private TextView tvCheckOutNameUser;
    private TextView tvCheckOutCpf;
    private TextView tvCheckOutBoardUser;
    private TextView tvCheckOutInput;
    private TextView tvCheckOutExit;
    private TextView tvCheckOutAmount;

    private MaterialToolbar mtToolbarCheckOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        //inicializar componente
        initializeComponents();
        setSupportActionBar(mtToolbarCheckOut);


        Bundle extras = getIntent().getExtras();
        final Attendence attendence = extras.getParcelable(ATTENDENCE);


        if (attendence != null) {
            tvCheckOutAmount.setText(getString(R.string.amount_payable, formatCurrency(this, attendence.getAmountPayable())));
            tvCheckOutInput.setText(getString(R.string.input_time, timeFormat(attendence.getDateHour(), this)));
            tvCheckOutExit.setText(getString(R.string.exit_time, timeFormat(attendence.getExitAttendece(), this)));
            tvCheckOutNameUser.setText(attendence.getNameUser());
            tvCheckOutCpf.setText(cpf(attendence.getCpf()));
            tvCheckOutBoardUser.setText(boad(attendence.getNumberBoard()));



            cmCheckOutDiscountBenefit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(CheckOutActivity.this, PaymentMethodActivity.class);
                    i.putExtra(ATTENDENCE, attendence);
                    startActivity(i);
                }
            });

        cmBonusCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckOutActivity.this, PaymentMethodActivity.class);
                i.putExtra(ATTENDENCE, attendence);
                startActivity(i);
            }
        });

    }

        mtToolbarCheckOut.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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
        cmBonusCustomer = findViewById(R.id.cm_bonus_customer);
        cmCheckOutDiscountBenefit = findViewById(R.id.cm_check_out_discount_benefit);
        ivCheckOutCard = findViewById(R.id.iv_check_out_card);
        tvCheckOutNameUser = findViewById(R.id.tv_check_out_name_user);
        tvCheckOutCpf = findViewById(R.id.tv_check_out_cpf);
        tvCheckOutBoardUser = findViewById(R.id.tv_check_out_board_user);
        tvCheckOutInput = findViewById(R.id.tv_check_out_input);
        tvCheckOutExit = findViewById(R.id.tv_check_out_exit);
        tvCheckOutAmount = findViewById(R.id.tv_check_out_amount);
        mtToolbarCheckOut = findViewById(R.id.mt_toolbar_check_out);
    }
}
