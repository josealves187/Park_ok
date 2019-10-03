package com.jose.park_ok_colaborador.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Attendence;
import com.jose.park_ok_colaborador.view.fragments.AttendanceFragment;

import java.util.List;

import static com.jose.park_ok_colaborador.utils.Constants.ATTENDENCE;
import static com.jose.park_ok_colaborador.utils.Utils.formatCurrency;

public class PaymentMethodActivity extends AppCompatActivity implements View.OnClickListener {

    private Dialog dialog;
    private MaterialButton confirmationExit;
    private CardView cmPaymentMethodFurApp;
    private CardView cmPaymentMethodMoney;
    private CardView cmPaymentMethodCard;

    private TextView tvPaymentMethodAmountPayable;
    private TextView tv_payment_method_discount;
    private TextView tv_payment_method_final_value;
    private MaterialToolbar mtToolbarPaymentMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        //inicializar componente
        initializeComponents();
        implementationInstance();
        setSupportActionBar(mtToolbarPaymentMethod);

        Bundle extras = getIntent().getExtras();
        final Attendence attendence = extras.getParcelable(ATTENDENCE);

        mtToolbarPaymentMethod.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        if (attendence != null) {

            tvPaymentMethodAmountPayable.setText(getString(R.string.amount_payable, formatCurrency(this, attendence.getValue())));
            tv_payment_method_discount.setText(getString(R.string.discount_paid, formatCurrency(this, attendence.getAmountPayable())));
            tv_payment_method_final_value.setText(getString(R.string.amount_final_value, formatCurrency(this, attendence.getFinalValue())));


        }

    }

    private void implementationInstance() {
        cmPaymentMethodFurApp.setOnClickListener(this);
        cmPaymentMethodMoney.setOnClickListener(this);
        cmPaymentMethodCard.setOnClickListener(this);

    }

    @Override
    public void onBackPressed(){

        SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
        editor.putInt("SCREEN_ORIGEN", 2);
        editor.commit();
        super.onBackPressed();
    }

    private void initializeComponents() {
        cmPaymentMethodFurApp = findViewById(R.id.cm_payment_method_fur_app);
        cmPaymentMethodMoney = findViewById(R.id.cm_payment_method_money);
        cmPaymentMethodCard = findViewById(R.id.cm_payment_method_card);
        tvPaymentMethodAmountPayable = findViewById(R.id.tv_payment_method_amount_payable);
        tv_payment_method_discount = findViewById(R.id.tv_payment_method_discount);
        tv_payment_method_final_value = findViewById(R.id.tv_payment_method_final_value);
        mtToolbarPaymentMethod = findViewById(R.id.mt_toolbar_payment_method);
    }

    private void abrirDialog() {

        dialog = new Dialog(PaymentMethodActivity.this);
        dialog.setContentView(R.layout.confirmation_check_exit);
        confirmationExit = dialog.findViewById(R.id.btn_confirmation_exit);


        confirmationExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PaymentMethodActivity.this,HomeActivity.class);
                startActivity(i);
                dialog.dismiss();

            }
        });
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cm_payment_method_fur_app:
                abrirDialog();
                break;

            case R.id.cm_payment_method_money:
                abrirDialog();
                break;

            case R.id.cm_payment_method_card:
                abrirDialog();
                break;
        }
    }
}