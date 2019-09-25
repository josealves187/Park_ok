package com.jose.park_ok_colaborador.view.fragments;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.view.activities.RegistrationDataActivity;
import com.jose.park_ok_colaborador.view.activities.AboutTheAppActivity;
import com.jose.park_ok_colaborador.view.activities.ThesesUsePrivacyActivity;
import com.jose.park_ok_colaborador.view.activities.TutorialAndFAQ;

import static com.jose.park_ok_colaborador.utils.Constants.TEXT_USE;
import static com.jose.park_ok_colaborador.utils.Constants.TITLE_TOOLBAR;

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
        tvTitleAboutProfile = view.findViewById(R.id.tv_title_about);
        tvTitleUsagePoliciesProfile = view.findViewById(R.id.tv_title_policies_profile);
        tvTitlePrivacyTermsProfile = view.findViewById(R.id.tv_title_use_terms_profile);
        tvTitleExitProfile = view.findViewById(R.id.tv_title_exit_profile);


        tvRegistrationDat.setOnClickListener(this);
        tvTitleFaqProfile.setOnClickListener(this);
        tvTitleAboutProfile.setOnClickListener(this);
        tvTitleUsagePoliciesProfile.setOnClickListener(this);
        tvTitlePrivacyTermsProfile.setOnClickListener(this);
        tvTitleExitProfile.setOnClickListener(this);

        /***
         *
         * underlined text e  placed color com SpannableString
         * colocando cor e sublinhado o texto usando  SpannableString
         * */



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

            case R.id.tv_title_about:
                flameAbout();
                break;

            case R.id.tv_title_policies_profile:

                Intent i = new Intent(getActivity(), ThesesUsePrivacyActivity.class);
                i.putExtra(TITLE_TOOLBAR, getString(R.string.title_toolbar_privacy_policies));
                i.putExtra(TEXT_USE, getString(R.string.tv_text_privacy_policies));
                startActivity(i);


                break;

            case R.id.tv_title_use_terms_profile:
                Intent iv = new Intent(getActivity(), ThesesUsePrivacyActivity.class);
                iv.putExtra(TITLE_TOOLBAR, getString(R.string.title_toolbar_terms_of_use));
                iv.putExtra(TEXT_USE, getString(R.string.tv_text_terms_of_use));
                startActivity(iv);
                break;

            case R.id.tv_title_exit_profile:

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

    private void flameAbout() {
        Intent i = new Intent(getActivity(), AboutTheAppActivity.class);
        startActivity(i);
    }


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