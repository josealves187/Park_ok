package com.jose.park_ok_colaborador.view.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Users;
import com.jose.park_ok_colaborador.view.activities.LoginActivity;
import com.jose.park_ok_colaborador.view.activities.QRcode.QrcodeClientDataActivity;
import com.jose.park_ok_colaborador.view.activities.RegistrationDataActivity;
import com.jose.park_ok_colaborador.view.activities.AboutTheAppActivity;
import com.jose.park_ok_colaborador.view.activities.ThesesUsePrivacyActivity;
import com.jose.park_ok_colaborador.view.activities.TutorialAndFAQ;
import com.jose.park_ok_colaborador.view.adapters.listeners.RegistratioDataListener;

import static com.jose.park_ok_colaborador.utils.Constants.REGISTRATIODATA;
import static com.jose.park_ok_colaborador.utils.Constants.TEXT_USE;
import static com.jose.park_ok_colaborador.utils.Constants.TITLE_TOOLBAR;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements RegistratioDataListener, View.OnClickListener {

    private ImageView civPhotoProfile;
    private TextView tvRegistrationDat;
    private TextView tvNameProfile;
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
        civPhotoProfile = view.findViewById(R.id.civ_photo_profile);
        tvNameProfile = view.findViewById(R.id.tv_name_profile);

        // passe uma instância da sua implementação para o respectivo método setOnClickListener
        implementationInstance();




        Users users = new Users(1, "José", "14587965288", "jralves187@gmail.com");
        if (users != null) {
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/freedelivery-8ff6e.appspot.com/o/imagens%2FUsuario%2FyO40m4hU9dR2eoQLANMrSkkcIQP2jpeg?alt=media&token=30dffe08-64ba-4b08-acca-10c6f1ac7d0f").into(civPhotoProfile);
            tvNameProfile.setText(users.getNameUser());


        }

        return view;
    }

    private void implementationInstance() {
        tvRegistrationDat.setOnClickListener(this);
        tvTitleFaqProfile.setOnClickListener(this);
        tvTitleAboutProfile.setOnClickListener(this);
        tvTitleUsagePoliciesProfile.setOnClickListener(this);
        tvTitlePrivacyTermsProfile.setOnClickListener(this);
        tvTitleExitProfile.setOnClickListener(this);
    }



    /**
     *  Isso é chamado quando o usuário toca no item (no modo de toque) ou atribui foco ao item com
     *  as teclas de navegação ou o trackball e pressiona a tecla “enter” ou o pressiona no trackball.
     * */
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

                flamePoliciesProfile(R.string.title_toolbar_privacy_policies, R.string.tv_text_privacy_policies);
                break;

            case R.id.tv_title_use_terms_profile:
                flamePoliciesProfile(R.string.title_toolbar_terms_of_use, R.string.tv_text_terms_of_use);
                break;

            case R.id.tv_title_exit_profile:
                flameLogin();
                break;
        }
    }

    private void flamePoliciesProfile(int p, int p2) {
        Intent i = new Intent(getActivity(), ThesesUsePrivacyActivity.class);
        i.putExtra(TITLE_TOOLBAR, getString(p));
        i.putExtra(TEXT_USE, getString(p2));
        startActivity(i);
    }

    private void flameRegistration() {

        Intent i = new Intent(getActivity(), RegistrationDataActivity.class);
        startActivity(i);
    }

    private void flametutorialFaq() {
        Intent i = new Intent(getActivity(), TutorialAndFAQ.class);
        startActivity(i);
    }

    private void flameLogin() {
        Intent i = new Intent(getActivity(), LoginActivity.class);
        startActivity(i);
    }

    private void flameAbout() {
        Intent i = new Intent(getActivity(), AboutTheAppActivity.class);
        startActivity(i);
    }

    @Override
    public void RegistratioDataOnClick(Users users, int position) {
        Intent intent = new Intent(getContext(), QrcodeClientDataActivity.class);
        intent.putExtra(REGISTRATIODATA, users);
        startActivity(intent);

    }


}