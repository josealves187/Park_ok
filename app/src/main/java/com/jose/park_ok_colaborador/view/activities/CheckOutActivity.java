package com.jose.park_ok_colaborador.view.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Attendence;
import com.jose.park_ok_colaborador.commom.Historic;

import static com.jose.park_ok_colaborador.utils.Constants.ATTENDENCE;
import static com.jose.park_ok_colaborador.utils.Constants.FORM_OF_PAYMENT_AMOUNT;
import static com.jose.park_ok_colaborador.utils.Constants.FORM_OF_PAYMENT_APP;
import static com.jose.park_ok_colaborador.utils.Constants.FORM_OF_PAYMENT_CARD;
import static com.jose.park_ok_colaborador.utils.Constants.HISTORIC;
import static com.jose.park_ok_colaborador.utils.Utils.formatCurrency;
import static com.jose.park_ok_colaborador.utils.Utils.timeFormat;

public class CheckOutActivity extends AppCompatActivity {

    private CardView cmCheckOutDiscountBenefit;

    private ImageView ivCheckOutCard;
    private TextView tvCheckOutNameUser;
    private TextView tvCheckOutCpf;
    private TextView tvCheckOutBoardUser;
    private TextView tvCheckOutInput;
    private TextView tvCheckOutExit;
    private TextView tvCheckOutAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        initViews();

        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_check_out);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        final Attendence attendence = extras.getParcelable(ATTENDENCE);


        if (attendence != null) {

            tvCheckOutAmount.setText(getString(R.string.amount_payable, formatCurrency(this, attendence.getAmountPayable())));
            tvCheckOutInput.setText(getString(R.string.input_time, timeFormat(attendence.getDateHour(), this)));
            tvCheckOutExit.setText(getString(R.string.exit_time, timeFormat(attendence.getExitAttendece(), this)));
            tvCheckOutNameUser.setText(attendence.getNameUser());
            tvCheckOutCpf.setText(String.valueOf(attendence.getCpf()));
            tvCheckOutBoardUser.setText(String.valueOf(attendence.getNumberBoard()));
        }

            switch (attendence.getTypeAttendance()) {
                case 1:
                    cmCheckOutDiscountBenefit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                    break;
//                case 2:
//                    tvPaymentMethod.setText(getString(R.string.form_of_payment, FORM_OF_PAYMENT_AMOUNT));
//                    break;

            }

//
//            if (attendence.getTypeService() == 1) {
//                tvDiscountAmount.setText(getString(R.string.amount_discount_details, formatCurrency(this, attendence.getAmount())));
//                ivDiscountBenefit.setImageResource(R.drawable.ic_discount_benefit);
//                tvTotalDiscount.setText(getString(R.string.discount_benefit, formatCurrency(this, attendence.getDiscountAmount())));
//
//
//            } else {
//                ivDiscountBenefit.setImageResource(R.drawable.ic_gift);
//                tvTotalDiscount.setVisibility(View.VISIBLE);
//                tvTotalDiscount.setText("Benefício de tempo: + 10 minutos");
//            }



            cmCheckOutDiscountBenefit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(CheckOutActivity.this, PaymentMethodActivity.class);
                    i.putExtra(ATTENDENCE,attendence);
                    startActivity(i);
                }
            });

    }

    private void initViews() {
        cmCheckOutDiscountBenefit = findViewById(R.id.cm_check_out_discount_benefit);
        ivCheckOutCard = findViewById(R.id.iv_check_out_card);
        tvCheckOutNameUser = findViewById(R.id.tv_check_out_name_user);
        tvCheckOutCpf = findViewById(R.id.tv_check_out_cpf);
        tvCheckOutBoardUser = findViewById(R.id.tv_check_out_board_user);
        tvCheckOutInput = findViewById(R.id.tv_check_out_input);
        tvCheckOutExit = findViewById(R.id.tv_check_out_exit);
        tvCheckOutAmount = findViewById(R.id.tv_check_out_amount);
    }
}
