package com.jose.park_ok_colaborador.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Historic;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.jose.park_ok_colaborador.utils.Constants.FORMOFPAYMENTCARD;
import static com.jose.park_ok_colaborador.utils.Constants.FORMOFPAYMENTAMOUNT;
import static com.jose.park_ok_colaborador.utils.Constants.FORMOFPAYMENTAPP;
import static com.jose.park_ok_colaborador.utils.Constants.HISTORIC;
import static com.jose.park_ok_colaborador.utils.Utils.formatCurrency;
import static com.jose.park_ok_colaborador.utils.Utils.timeFormat;

public class DiscountDetailsActivity extends AppCompatActivity {


    private CircleImageView cimPhotoUserDetais;
    private ImageView ivDetailsCard;
    private ImageView ivDetailsBoard;
    private ImageView ivDetailsTime;
    private ImageView ivAmountPaidDetails;
    private ImageView ivDiscountBenefit;

    private TextView tvNameUserDetails;
    private TextView tvDetailsCpf;
    private TextView tvBoardUserDetails;
    private TextView tvHoursmanDetails;
    private TextView tvInputDetails;
    private TextView tvExitDetails;
    private TextView tvPaymentMethod;
    private TextView tvAmount;
    private TextView tvdiscountAmount;
    private TextView tvTotalDiscount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount_details);

        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViews();

        Bundle extras = getIntent().getExtras();
        Historic historic = extras.getParcelable(HISTORIC);



        if (historic != null) {
            Glide.with(this).load("https://api.adorable.io/avatars/285/abott@adorable.png").into(cimPhotoUserDetais);
            tvAmount.setText(getString(R.string.amount_paid, formatCurrency(this, historic.getAmountPaid())));

            tvInputDetails.setText(getString(R.string.input_time, timeFormat(historic.getInput(), this)));
            tvExitDetails.setText(getString(R.string.exit_time, timeFormat(historic.getExit(), this)));
            tvNameUserDetails.setText(historic.getNome());
            tvDetailsCpf.setText(String.valueOf(historic.getCpf()));
            tvBoardUserDetails.setText(historic.getBoad());
            switch (historic.getFormOfPayment()) {
                case 1:
                    tvPaymentMethod.setText(getString(R.string.form_of_payment, FORMOFPAYMENTAPP));
                    break;
                case 2:
                    tvPaymentMethod.setText(getString(R.string.form_of_payment, FORMOFPAYMENTAMOUNT));
                    break;
                case 3:
                    tvPaymentMethod.setText(getString(R.string.form_of_payment, FORMOFPAYMENTCARD));
            }
        }

        if (historic.getTypeService()==1){
            tvdiscountAmount.setText(getString(R.string.amount_discount_details, formatCurrency(this, historic.getAmount())));
            ivDiscountBenefit.setImageResource(R.drawable.ic_discount_benefit);
            tvTotalDiscount.setText(getString(R.string.discount_benefit, formatCurrency(this, historic.getDiscountAmount())));


        }else {
            ivDiscountBenefit.setImageResource(R.drawable.ic_gift);
            tvTotalDiscount.setVisibility(View.VISIBLE);
            tvTotalDiscount.setText("Benefício de tempo: + 10 minutos");

        }


    }

    private void initViews() {

        cimPhotoUserDetais =  findViewById(R.id.aciv_photo_user_detais);
        ivDetailsCard =  findViewById(R.id.iv_details_card);
        ivDetailsBoard =  findViewById(R.id.iv_details_board);
        ivDetailsTime =  findViewById(R.id.iv_details_time);
        ivAmountPaidDetails =  findViewById(R.id.iv_amount_paid_details);
        ivDiscountBenefit =  findViewById(R.id.iv_discount_benefit);
        tvNameUserDetails =  findViewById(R.id.tv_name_user_details);
        tvDetailsCpf =  findViewById(R.id.tv_details_cpf);
        tvBoardUserDetails =  findViewById(R.id.tv_board_user_details);
        tvHoursmanDetails =  findViewById(R.id.tv_Hoursman_details);
        tvInputDetails =  findViewById(R.id.tv_input_details);
        tvExitDetails =  findViewById(R.id.tv_exit_details);

        tvPaymentMethod =  findViewById(R.id.tv_payment_method); //Forma de pagamento: form_of_payment
        tvdiscountAmount = findViewById(R.id.tv_total_amount_benefit); // Benefício de desconto:
        tvAmount =  findViewById(R.id.tv_amount); //Valor pago: amount_paid
        tvTotalDiscount = findViewById(R.id.tv_total_discount); //desconto  amount


    }
}
