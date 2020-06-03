package com.ensias.healthcareapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ensias.healthcareapp.R;
import com.ensias.healthcareapp.model.ApointementInformation;
import com.ensias.healthcareapp.model.Doctor;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ConfirmedAppointmentsAdapter extends FirestoreRecyclerAdapter<ApointementInformation, ConfirmedAppointmentsAdapter.ConfirmedAppointmentsHolder> {
    public ConfirmedAppointmentsAdapter(@NonNull FirestoreRecyclerOptions<ApointementInformation> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ConfirmedAppointmentsHolder confirmedAppointmentsHolder, int position, @NonNull final ApointementInformation apointementInformation) {
        confirmedAppointmentsHolder.dateAppointement.setText(apointementInformation.getTime());
        confirmedAppointmentsHolder.patientName.setText(apointementInformation.getPatientName());
        confirmedAppointmentsHolder.appointementType.setText(apointementInformation.getApointementType());

    }

    @NonNull
    @Override
    public ConfirmedAppointmentsAdapter.ConfirmedAppointmentsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.confirmed_appointements_item, parent, false);
        return new ConfirmedAppointmentsAdapter.ConfirmedAppointmentsHolder(v);
    }

    class ConfirmedAppointmentsHolder extends RecyclerView.ViewHolder{
        TextView dateAppointement;
        TextView patientName;
        TextView appointementType;
        public ConfirmedAppointmentsHolder(@NonNull View itemView) {
            super(itemView);
            dateAppointement = itemView.findViewById(R.id.appointement_date);
            patientName = itemView.findViewById(R.id.patient_name);
            appointementType = itemView.findViewById(R.id.appointement_type);
        }
    }
}
