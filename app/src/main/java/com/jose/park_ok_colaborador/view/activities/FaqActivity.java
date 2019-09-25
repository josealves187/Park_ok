package com.jose.park_ok_colaborador.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.FAQ;
import com.jose.park_ok_colaborador.view.adapters.FaqAdapter;

import java.util.ArrayList;
import java.util.List;

public class FaqActivity extends AppCompatActivity {

    private RecyclerView rvfaq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        rvfaq = findViewById(R.id.rv_faq);

        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_faq);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        List<FAQ> faqs = new ArrayList<>();
        faqs.add(new FAQ(getString(R.string.text_faq),getString(R.string.text_faq)));
        faqs.add(new FAQ(getString(R.string.text_faq),getString(R.string.text_faq)));
        faqs.add(new FAQ(getString(R.string.text_faq),getString(R.string.text_faq)));
        faqs.add(new FAQ(getString(R.string.text_faq),getString(R.string.text_faq)));

        rvfaq.setLayoutManager(new LinearLayoutManager(this));
        rvfaq.setAdapter(new FaqAdapter(faqs,this));
    }
}
