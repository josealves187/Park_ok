package com.jose.park_ok_colaborador.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Tutorial;
import com.jose.park_ok_colaborador.view.adapters.TutorialAdapter;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class TutorialActivity extends AppCompatActivity {

    private RecyclerView rvTutorial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        initializeComponent();


        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1,getString(R.string.text_tutorial)));
        tutorials.add(new Tutorial(2,getString(R.string.text_tutorial)));
        tutorials.add(new Tutorial(1,getString(R.string.text_tutorial)));
        tutorials.add(new Tutorial(2,getString(R.string.text_tutorial)));
        rvTutorial.setLayoutManager(new LinearLayoutManager(this));
        rvTutorial.setAdapter(new TutorialAdapter(tutorials,this));


    }

    private void initializeComponent() {

        rvTutorial = findViewById(R.id.rv_tutorial);

        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_tutorial);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
