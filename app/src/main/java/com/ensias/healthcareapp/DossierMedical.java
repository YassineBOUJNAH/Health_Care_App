package com.ensias.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ensias.healthcareapp.adapter.ConsultationFragmentAdapter;

public class DossierMedical extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dossier_medical);
    }
    private void configureViewPager(){
        // 1 - Get ViewPager from layout
        ViewPager pager = (ViewPager)findViewById(R.id.ViewPagerDossier);
        // 2 - Set Adapter PageAdapter and glue it together
        pager.setAdapter(new ConsultationFragmentAdapter(getSupportFragmentManager(), getResources().getIntArray(R.array.colorPagesViewPager)) {
        });
    }
}
