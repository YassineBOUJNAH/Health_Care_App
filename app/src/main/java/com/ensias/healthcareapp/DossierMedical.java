package com.ensias.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ensias.healthcareapp.adapter.ConsultationFragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class DossierMedical extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dossier_medical);
        this.configureViewPager();

    }

    private void configureViewPager() {
        // 1 - Get ViewPager from layout
        ViewPager pager = (ViewPager) findViewById(R.id.ViewPagerDossier);
        // 2 - Set Adapter PageAdapter and glue it together
        pager.setAdapter(new ConsultationFragmentAdapter(getSupportFragmentManager()));
        // 1 - Get TabLayout from layout
        TabLayout tabs = (TabLayout) findViewById(R.id.activity_main_tabs);
        // 2 - Glue TabLayout and ViewPager together
        tabs.setupWithViewPager(pager);
        // 3 - Design purpose. Tabs have the same width
        tabs.setTabMode(TabLayout.MODE_FIXED);
        //Set Adapter PageAdapter and glue it
        TextView text = new TextView(this);
        //((ViewGroup) tabs.getChildAt(0)).getChildAt(0).setBackgroundColor(0xFF00FF00);
        //((ViewGroup) tabs.getChildAt(0)).getChildAt(1).setBackgroundColor(0xFF00FF00);

    }
}