package com.ensias.healthcareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ensias.healthcareapp.model.Doctor;
import com.ensias.healthcareapp.model.Hour;
import com.ensias.healthcareapp.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointementActivity extends AppCompatActivity {

    private LinearLayout lis;
    //final List<String> fruits_list = new ArrayList<String>(Arrays.asList(fruits));
    static FirebaseFirestore db = FirebaseFirestore.getInstance();
    static CollectionReference addRequest2 = db.collection("Request");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointement);
        lis = findViewById(R.id.listDate);
        final String patient_email = getIntent().getStringExtra("key1");
        String day = getIntent().getStringExtra("key2");
        final String userType = getIntent().getStringExtra("key3");
        //PATIENT EMAIL IS ACCTUELLY DOCTOR EMAIL
        final CollectionReference addRequest = db.collection("Doctor").document(patient_email).collection("calendar").document(day).collection("hour");
        final String hourPath = "Doctor/"+patient_email+"/calendar/"+day+"/hour";

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(140, 398);
        layoutParams.setMargins(150, 0, 190, 0);
        final LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(220, 398);
        layoutParams2.setMargins(70, 0, 0, 0);

        for (int i = 8; i<19;i++){
            final int j = i;
            final TextView name = new TextView(this);
            TextView text = new TextView(this);
            text.setText(i + ":00");
            final LinearLayout l = new LinearLayout(this);
            l.setMinimumHeight(250);
            l.addView(text, layoutParams);
            final Button btn = new Button(this);
            addRequest.document(i+"").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    Hour note = documentSnapshot.toObject(Hour.class);
                    if(note != null){
                        if(note.getChoosen().equals("true")) {
                            btn.setText("already choosen");
                            if (userType.equals("doctor"))
                                btn.setText("Delete appointement");
                            else
                                btn.setText("entrain de revision");
                        }
                        if(userType.equals("doctor")){
                            db.collection("User").document(note.getPatient().toString()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                   String patientName = documentSnapshot.getString("name");
                                    name.setText(patientName);
                                    l.addView(name,layoutParams2);
                                }
                            });

                        }
                    }
                    else{
                        if(userType.equals("patient")) {
                            btn.setText("confirme this hour");
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Hour h = new Hour(FirebaseAuth.getInstance().getCurrentUser().getEmail().toString());
                                    addRequest.document(j + "").set(h);
                                    Map<String, Object> note = new HashMap<>();
                                    note.put("id_patient", FirebaseAuth.getInstance().getCurrentUser().getEmail().toString());
                                    note.put("id_doctor", patient_email);
                                    note.put("hour_path", hourPath + "/" + j);
                                    addRequest2.document().set(note)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    Snackbar.make(btn, "demande de rendez-vous", Snackbar.LENGTH_SHORT).show();
                                                }
                                            });
                                }
                            });
                        }
                        else{
                            btn.setText("Block this hour");
                        }
                    }

                }
            });

            l.addView(btn);
            lis.addView(l);
        }

    }


}