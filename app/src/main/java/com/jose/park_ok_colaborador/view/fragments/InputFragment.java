package com.jose.park_ok_colaborador.view.fragments;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.zxing.integration.android.IntentIntegrator;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Attendence;
import com.jose.park_ok_colaborador.view.activities.QRcode.QrcodeClientDataActivity;

import static com.jose.park_ok_colaborador.utils.Constants.ATTENDENCE;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    private CardView cmInputQrcode;

    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        cmInputQrcode = view.findViewById(R.id.cm_input_qrcode);
        eventoButton();



        return view;
    }

    private void eventoButton() {
        cmInputQrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator((Activity) getContext());
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                intentIntegrator.setCameraId(0);
                intentIntegrator.setOrientationLocked(false);
                intentIntegrator.setPrompt("Alinhar código de barra com QR code para ser lido");
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setBarcodeImageEnabled(true);
                intentIntegrator.initiateScan();
                IntentIntegrator.forSupportFragment(InputFragment.this).initiateScan();

            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Intent intent = new Intent(getContext(), QrcodeClientDataActivity.class);
        startActivity(intent);
    }



}

