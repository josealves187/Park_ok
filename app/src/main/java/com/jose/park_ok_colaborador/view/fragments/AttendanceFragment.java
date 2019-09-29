package com.jose.park_ok_colaborador.view.fragments;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.integration.android.IntentIntegrator;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Attendence;
import com.jose.park_ok_colaborador.view.activities.QRcode.QrcodeClientDataActivity;
import com.jose.park_ok_colaborador.view.activities.ReportPlateActivity;
import com.jose.park_ok_colaborador.view.activities.TutorialAndFAQ;
import com.jose.park_ok_colaborador.view.adapters.AttendanceAdapter;
import com.jose.park_ok_colaborador.view.adapters.listeners.AttendenceListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jose.park_ok_colaborador.utils.Constants.ATTENDENCE;

public class AttendanceFragment extends Fragment implements AttendenceListener {

    private RecyclerView rvCalls;

    public AttendanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);

        rvCalls = view.findViewById(R.id.rv_calls);
        List<Attendence> attendences = new ArrayList<>();
        attendences.add(new Attendence(1,"14214521452","João",1, "fgt2333",new Date(),new Date(),18,1,17,1));
        attendences.add(new Attendence(2,"12312312322","João",2, "gdd2333",new Date(),new Date(),19,2,17,2));
        attendences.add(new Attendence(3,"12312312322","Jose",3, "zfb2333",new Date(),new Date(),15,3,12,3));
        attendences.add(new Attendence(4,"12312312322","Maria",1, "asf2333",new Date(),new Date(),14,4,10,4));
        attendences.add(new Attendence(5,"12312312327","Pedro",2, "cdc2333",new Date(),new Date(),12,6,6,1));
        attendences.add(new Attendence(6,"12312312328","Zé",3, "bes2333",new Date(),new Date(),12,8,4,2));
        attendences.add(new Attendence(7,"12312312328","João",1, "ggu2333",new Date(),new Date(),12,2,10,3));
        attendences.add(new Attendence(8,"12312312328","João",2, "efj2333",new Date(),new Date(),12,2,10,4));
        rvCalls.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCalls.setAdapter(new AttendanceAdapter(attendences, getContext(),this));



        return view;


    }

    @Override
    public void attendanceOnClick(Attendence attendence, int position) {
        attendanceOnClickSemQR(attendence, position);
        IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        intentIntegrator.setOrientationLocked(false);
        intentIntegrator.setPrompt("Alinhar código de barra com QR code para ser lido");
        intentIntegrator.setCameraId(0);
        intentIntegrator.initiateScan();
        IntentIntegrator.forSupportFragment(AttendanceFragment.this).initiateScan();


    }

    @Override
    public void attendanceOnClickSemQR(Attendence attendence, int position) {
        Intent i = new Intent(getActivity(), ReportPlateActivity.class);
        i.putExtra(ATTENDENCE,attendence);
        startActivity(i);

    }


}
