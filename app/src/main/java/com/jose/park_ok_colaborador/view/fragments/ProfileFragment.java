package com.jose.park_ok_colaborador.view.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.view.activities.RegistrationDataActivity;
import com.jose.park_ok_colaborador.view.activities.TermsOfUseActivity;
import com.jose.park_ok_colaborador.view.activities.TutorialAndFAQ;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {

    private TextView tvRegistrationDat;
    private TextView tvTitleFaqProfile;
    private TextView tvTitleAboutProfile;
    private TextView tvTitleUsagePoliciesProfile;
    private TextView tvTitlePrivacyTermsProfile;
    private TextView tvTitleExitProfile;



    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        tvRegistrationDat = view.findViewById(R.id.tv_registration_dat);
        tvTitleFaqProfile = view.findViewById(R.id.tv_title_faq_profile);
        tvTitleAboutProfile = view.findViewById(R.id.tv_title_about_profile);
        tvTitleUsagePoliciesProfile = view.findViewById(R.id.tv_title_policies_profile);
        tvTitlePrivacyTermsProfile = view.findViewById(R.id.tv_title_use_terms_profile);
        tvTitleExitProfile = view.findViewById(R.id.tv_title_exit_profile);


        tvRegistrationDat.setOnClickListener(this);
        tvTitleFaqProfile.setOnClickListener(this);
        tvTitleAboutProfile.setOnClickListener(this);
        tvTitleUsagePoliciesProfile.setOnClickListener(this);
        tvTitlePrivacyTermsProfile.setOnClickListener(this);
        tvTitleExitProfile.setOnClickListener(this);

        return view;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_registration_dat:
                flameRegistration();
                break;

            case R.id.tv_title_faq_profile:
                flametutorialFaq();
                break;

            case R.id.tv_title_about_profile:

                break;

            case R.id.tv_title_policies_profile:

                break;

            case R.id.tv_title_use_terms_profile:
                flameTermsUse();
                break;

            case R.id.tv_title_email:

                break;


        }


    }

    private void flameRegistration() {
        Intent i = new Intent(getActivity(), RegistrationDataActivity.class);
        startActivity(i);
    }

    private void flametutorialFaq() {
        Intent i = new Intent(getActivity(), TutorialAndFAQ.class);
        startActivity(i);
    }

    private void flameTermsUse() {
        Intent i = new Intent(getActivity(), TermsOfUseActivity.class);
        startActivity(i);
    }
//    private void flameRegistration() {
//        Intent i = new Intent(getActivity(), RegistrationDataActivity.class);
//        startActivity(i);
//    }
//
//    private void flameRegistration() {
//        Intent i = new Intent(getActivity(), RegistrationDataActivity.class);
//        startActivity(i);
//    }
//
//    private void flameRegistration() {
//        Intent i = new Intent(getActivity(), RegistrationDataActivity.class);
//        startActivity(i);
//    }
}