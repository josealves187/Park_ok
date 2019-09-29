package com.jose.park_ok_colaborador.view.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.jose.park_ok_colaborador.R;

import static com.jose.park_ok_colaborador.utils.Constants.TEXT_USE;
import static com.jose.park_ok_colaborador.utils.Constants.TITLE_TOOLBAR;

public class ThesesUsePrivacyActivity extends AppCompatActivity {

    private MaterialToolbar mtToolbar;
    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theses_use_privacy);
        //inicializar componente
        initializeComponents();

        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(mtToolbar);

        String sMessageToolbar = getIntent().getExtras().getString(TITLE_TOOLBAR, "");
        String sText = getIntent().getExtras().getString(TEXT_USE, "");

        if (sMessageToolbar != "") {
            getSupportActionBar().setTitle(sMessageToolbar);
            tvText.setText(sText);
        }

    }

    private void initializeComponents() {
        mtToolbar = findViewById(R.id.mt_toolbar);
        tvText = findViewById(R.id.tv_text);
    }
}
