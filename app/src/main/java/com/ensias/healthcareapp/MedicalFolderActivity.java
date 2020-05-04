package com.ensias.healthcareapp;



import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MedicalFolderActivity extends AppCompatActivity {
    private final static String TAG = "MedicalFolderActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dossier_medical);
        Log.d(TAG, "onCreate Medical folder activity: started");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents");
        if(getIntent().hasExtra("patient_name") && getIntent().hasExtra("patient_email")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");
            String patient_name = getIntent().getStringExtra("patient_name");
            String patient_email = getIntent().getStringExtra("patient_email");
            String patient_phone = getIntent().getStringExtra("patient_phone");

            setPatientInfos(patient_name, patient_email, patient_phone);

        }
    }

    private void setPatientInfos(String patient_name, String patient_email, String patient_phone){
        Log.d(TAG, "setPatientInfos: put patient infos");

        TextView name = findViewById(R.id.patient_name);
        name.setText(patient_name);

        TextView email = findViewById(R.id.patient_address);
        email.setText(patient_email);

        TextView number = findViewById(R.id.phone_number);
        number.setText(patient_phone);
    }
}
