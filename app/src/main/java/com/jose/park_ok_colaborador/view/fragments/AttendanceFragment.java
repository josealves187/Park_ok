package com.jose.park_ok_colaborador.view.fragments;


import android.content.Intent;
import android.os.Bundle;

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
        attendences.add(new Attendence(1,1231231232,"joão",1, 122333,new Date(),1.1,1));
        attendences.add(new Attendence(2,1231231232,"joão",2, 122333,new Date(),1.1,2));
        attendences.add(new Attendence(3,1231231232,"joão",3, 122333,new Date(),1.1,3));
        attendences.add(new Attendence(4,1231231232,"joão",1, 122333,new Date(),1.1,4));
        attendences.add(new Attendence(5,1231231232,"joão",2, 122333,new Date(),1.1,4));
        attendences.add(new Attendence(6,1231231232,"joão",3, 122333,new Date(),1.1,3));
        attendences.add(new Attendence(7,1231231232,"joão",1, 122333,new Date(),1.1,2));
        attendences.add(new Attendence(8,1231231232,"joão",2, 122333,new Date(),1.1,1));
        rvCalls.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCalls.setAdapter(new AttendanceAdapter(attendences, getContext(),this));


        return view;


    }

    @Override
    public void attendanceOnClick(Attendence attendence, int position) {
        IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        intentIntegrator.setPrompt("SCAN");
        intentIntegrator.setCameraId(0);
        intentIntegrator.initiateScan();
        IntentIntegrator.forSupportFragment(AttendanceFragment.this).initiateScan();

    }

    @Override
    public void attendanceOnClickSemQR(Attendence attendence, int position) {
        Intent i = new Intent(getActivity(), ReportPlateActivity.class);
        startActivity(i);


    }

}
