package com.ensias.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ensias.healthcareapp.adapter.ConsultationFragmentAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class DossierMedical extends AppCompatActivity {
    private final static String TAG = "DossierMedical";
    private FloatingActionButton createNewFicheButton;
    private String patient_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dossier_medical);
        patient_email = getIntent().getStringExtra("patient_email");
        this.configureViewPager();

        Log.d(TAG, "onCreate dossier medical activity: started");
        getIncomingIntent();

        createNewFicheButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        createNewFicheButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPatientFiche();
            }
        });


    }

    //Receive patient informations from the previous activity
    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents");
        //Check if the incoming intents exist
        if(getIntent().hasExtra("patient_name") && getIntent().hasExtra("patient_email")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");
            String patient_name = getIntent().getStringExtra("patient_name");
            String patient_email = getIntent().getStringExtra("patient_email");
            String patient_phone = getIntent().getStringExtra("patient_phone");

            //set patient name, email, phone number
            setPatientInfos(patient_name, patient_email, patient_phone);

        }
        Log.d(TAG, "No intent");

    }

    //Add patient name, email, phone number to the medical folder
    private void setPatientInfos(String patient_name, String patient_email, String patient_phone){
        Log.d(TAG, "setPatientInfos: put patient infos");

        TextView name = findViewById(R.id.patient_name);
        name.setText(patient_name);

        TextView email = findViewById(R.id.patient_address);
        email.setText(patient_email);

        TextView number = findViewById(R.id.phone_number);
        number.setText(patient_phone);
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

    private void openPatientFiche(){
        Intent intent = new Intent(this, FicheActivity.class);
        String patient_name = getIntent().getStringExtra("patient_name");
        String patient_email = getIntent().getStringExtra("patient_email");
        intent.putExtra("patient_email", patient_email);
        intent.putExtra("patient_name", patient_name);
        startActivity(intent);
    }

}