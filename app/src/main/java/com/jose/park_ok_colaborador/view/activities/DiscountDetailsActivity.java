package com.jose.park_ok_colaborador.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Historic;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.jose.park_ok_colaborador.utils.Constants.FORM_OF_PAYMENT_CARD;
import static com.jose.park_ok_colaborador.utils.Constants.FORM_OF_PAYMENT_AMOUNT;
import static com.jose.park_ok_colaborador.utils.Constants.FORM_OF_PAYMENT_APP;
import static com.jose.park_ok_colaborador.utils.Constants.HISTORIC;
import static com.jose.park_ok_colaborador.utils.MaskTextView.boad;
import static com.jose.park_ok_colaborador.utils.MaskTextView.cpf;
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
    private TextView tvDiscountAmount;
    private TextView tvTotalDiscount;
    private MaterialToolbar mtToolbarDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount_details);
        initViews();
        setSupportActionBar(mtToolbarDetails);

        Bundle extras = getIntent().getExtras();
        Historic historic = extras.getParcelable(HISTORIC);


        if (historic != null) {
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/freedelivery-8ff6e.appspot.com/o/imagens%2FUsuario%2FyO40m4hU9dR2eoQLANMrSkkcIQP2jpeg?alt=media&token=30dffe08-64ba-4b08-acca-10c6f1ac7d0f").into(cimPhotoUserDetais);
            tvAmount.setText(getString(R.string.amount_paid, formatCurrency(this, historic.getAmountPaid())));
            tvInputDetails.setText(getString(R.string.input_time, timeFormat(historic.getInput(), this)));
            tvExitDetails.setText(getString(R.string.exit_time, timeFormat(historic.getExit(), this)));
            tvNameUserDetails.setText(historic.getNome());
            tvDetailsCpf.setText(cpf(historic.getCpf()));
            tvBoardUserDetails.setText(boad(historic.getBoad()));
            switch (historic.getFormOfPayment()) {
                case 1:
                    tvPaymentMethod.setText(getString(R.string.form_of_payment, FORM_OF_PAYMENT_APP));
                    break;
                case 2:
                    tvPaymentMethod.setText(getString(R.string.form_of_payment, FORM_OF_PAYMENT_AMOUNT));
                    break;
                case 3:
                    tvPaymentMethod.setText(getString(R.string.form_of_payment, FORM_OF_PAYMENT_CARD));
            }
        }

        if (historic.getTypeService()==1){
            tvDiscountAmount.setText(getString(R.string.amount_discount_details, formatCurrency(this, historic.getAmount())));
            ivDiscountBenefit.setImageResource(R.drawable.ic_discount_benefit);
            tvTotalDiscount.setText(getString(R.string.discount_benefit, formatCurrency(this, historic.getDiscountAmount())));


        }else {
            ivDiscountBenefit.setImageResource(R.drawable.ic_gift);
            tvTotalDiscount.setVisibility(View.VISIBLE);
            tvTotalDiscount.setText("Benefício de tempo: + 10 minutos");
        }

        mtToolbarDetails.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
    }
    @Override
    public void onBackPressed(){

        SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
        editor.putInt("SCREEN_ORIGEN", 3);
        editor.commit();
        super.onBackPressed();
    }

    private void initViews() {
        tvAmount =  findViewById(R.id.tv_amount); //Valor pago: amount_paid
        ivAmountPaidDetails =  findViewById(R.id.iv_amount_paid_details);
        tvBoardUserDetails =  findViewById(R.id.tv_board_user_details);
        ivDetailsCard =  findViewById(R.id.iv_details_card);
        ivDetailsBoard =  findViewById(R.id.iv_details_board);
        ivDetailsTime =  findViewById(R.id.iv_details_time);
        tvDiscountAmount = findViewById(R.id.tv_total_amount_benefit); // Benefício de desconto:
        ivDiscountBenefit =  findViewById(R.id.iv_discount_benefit);
        tvDetailsCpf =  findViewById(R.id.tv_details_cpf);
        tvExitDetails =  findViewById(R.id.tv_exit_details);
        tvHoursmanDetails =  findViewById(R.id.tv_Hoursman_details);
        tvInputDetails =  findViewById(R.id.tv_input_details);
        tvNameUserDetails =  findViewById(R.id.tv_name_user_details);
        tvPaymentMethod =  findViewById(R.id.tv_payment_method); //Forma de pagamento: form_of_payment
        cimPhotoUserDetais =  findViewById(R.id.aciv_photo_user_detais);
        tvTotalDiscount = findViewById(R.id.tv_total_discount); //desconto  amount
        mtToolbarDetails = findViewById(R.id.mt_toolbar_details);
    }
}
