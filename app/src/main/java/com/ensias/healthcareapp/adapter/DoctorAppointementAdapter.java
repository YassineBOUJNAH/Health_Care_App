package com.ensias.healthcareapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ensias.healthcareapp.ChatActivity;
import com.ensias.healthcareapp.R;
import com.ensias.healthcareapp.model.ApointementInformation;
import com.ensias.healthcareapp.model.Doctor;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DoctorAppointementAdapter extends FirestoreRecyclerAdapter<ApointementInformation, DoctorAppointementAdapter.MyDoctorAppointementHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.
     * @param options
     */
    public DoctorAppointementAdapter(@NonNull FirestoreRecyclerOptions<ApointementInformation> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyDoctorAppointementHolder myDoctorAppointementHolder, int position, @NonNull final ApointementInformation apointementInformation) {
        myDoctorAppointementHolder.dateAppointement.setText(apointementInformation.getTime());
        myDoctorAppointementHolder.patientName.setText(apointementInformation.getPatientName());
        myDoctorAppointementHolder.appointementType.setText(apointementInformation.getApointementType());
        myDoctorAppointementHolder.approveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apointementInformation.setType("Accepted");
                FirebaseFirestore.getInstance().collection("Patient").document(apointementInformation.getPatientId()).collection("calendar")
                        .document(apointementInformation.getTime().replace("/","_")).set(apointementInformation);
                FirebaseFirestore.getInstance().document(apointementInformation.getChemin()).update("type","Accepted");
                FirebaseFirestore.getInstance().collection("Doctor").document(apointementInformation.getDoctorId()).collection("calendar")
                        .document(apointementInformation.getTime().replace("/","_")).set(apointementInformation);

                getSnapshots().getSnapshot(position).getReference().delete();
            }
        });
        myDoctorAppointementHolder.cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apointementInformation.setType("Refused");
                FirebaseFirestore.getInstance().collection("Patient").document(apointementInformation.getPatientId()).collection("calendar")
                        .document(apointementInformation.getTime().replace("/","_")).set(apointementInformation);
                FirebaseFirestore.getInstance().document(apointementInformation.getChemin()).delete();
                getSnapshots().getSnapshot(position).getReference().delete();
            }
        });

    }

    private void openPage(Context wf, Doctor d){
        Intent i = new Intent(wf, ChatActivity.class);
        i.putExtra("key1",d.getEmail()+"_"+ FirebaseAuth.getInstance().getCurrentUser().getEmail().toString());
        i.putExtra("key2",FirebaseAuth.getInstance().getCurrentUser().getEmail().toString()+"_"+d.getEmail());
        wf.startActivity(i);
    }

    @NonNull
    @Override
    public MyDoctorAppointementHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_appointement_item, parent, false);
        return new MyDoctorAppointementHolder(v);
    }

    class MyDoctorAppointementHolder extends RecyclerView.ViewHolder{
        //Here we hold the MyDoctorAppointementItems
        TextView dateAppointement;
        TextView patientName;
        Button approveBtn;
        Button cancelBtn;
        TextView appointementType;
        public MyDoctorAppointementHolder(@NonNull View itemView) {
            super(itemView);
            dateAppointement = itemView.findViewById(R.id.appointement_date);
            patientName = itemView.findViewById(R.id.patient_name);
            approveBtn = itemView.findViewById(R.id.btn_accept);
            cancelBtn = itemView.findViewById(R.id.btn_decline);
            appointementType = itemView.findViewById(R.id.appointement_type);
        }
    }




}
