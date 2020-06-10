package com.ensias.healthcareapp.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ensias.healthcareapp.R;
import com.ensias.healthcareapp.model.ApointementInformation;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PatientAppointmentsAdapter extends FirestoreRecyclerAdapter<ApointementInformation, PatientAppointmentsAdapter.PatientAppointmentsHolder> {
    public PatientAppointmentsAdapter(@NonNull FirestoreRecyclerOptions<ApointementInformation> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PatientAppointmentsHolder patientAppointmentsHolder, int position, @NonNull final ApointementInformation apointementInformation) {
        patientAppointmentsHolder.dateAppointement.setText(apointementInformation.getTime());
        patientAppointmentsHolder.patientName.setText(apointementInformation.getDoctorName());
        patientAppointmentsHolder.appointementType.setText(apointementInformation.getApointementType());
        patientAppointmentsHolder.type.setText(apointementInformation.getType());
        //#3700B3

        if(apointementInformation.getApointementType().equals("Consultation")){
            //patientAppointmentsHolder.appointementType.setBackgroundColor((patientAppointmentsHolder.type.getContext().getResources().getColor(R.color.colorPrimaryDark)));
            patientAppointmentsHolder.appointementType.setBackground(patientAppointmentsHolder.appointementType.getContext().getResources().getDrawable(R.drawable.button_radius_primary_color));

        }
        if(apointementInformation.getType().equals("Accepted")){
            patientAppointmentsHolder.type.setTextColor(Color.parseColor("#20bf6b"));
        }else if(apointementInformation.getType().equals("Checked")){
            patientAppointmentsHolder.type.setTextColor(Color.parseColor("#8854d0"));
        }else{
            patientAppointmentsHolder.type.setTextColor(Color.parseColor("#eb3b5a"));
        }

    }

    @NonNull
    @Override
    public PatientAppointmentsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.patient_appointments_item, parent, false);
        return new PatientAppointmentsAdapter.PatientAppointmentsHolder(v);
    }


    class PatientAppointmentsHolder extends RecyclerView.ViewHolder{
        TextView dateAppointement;
        TextView patientName;
        TextView appointementType;
        TextView type;
        TextView phone;

        public PatientAppointmentsHolder(@NonNull View itemView) {
            super(itemView);
            dateAppointement = itemView.findViewById(R.id.appointement_date);
            patientName = itemView.findViewById(R.id.patient_name);
            appointementType = itemView.findViewById(R.id.appointement_type);
            type = itemView.findViewById(R.id.type);
            phone = itemView.findViewById(R.id.patient_phone);
        }
    }
}
