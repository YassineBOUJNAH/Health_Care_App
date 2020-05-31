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
import com.ensias.healthcareapp.model.Doctor;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyDoctorsAdapter extends FirestoreRecyclerAdapter<Doctor, MyDoctorsAdapter.MyDoctorAppointementHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.
     * @param options
     */
    public MyDoctorsAdapter(@NonNull FirestoreRecyclerOptions<Doctor> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyDoctorAppointementHolder myDoctorsHolder, int position, @NonNull final Doctor doctor) {
        myDoctorsHolder.textViewTitle.setText(doctor.getName());
        myDoctorsHolder.textViewDescription.setText("Specialite : "+doctor.getSpecialite());
        myDoctorsHolder.sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(v.getContext(),doctor);
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_doctor_item, parent, false);
        return new MyDoctorAppointementHolder(v);
    }

    class MyDoctorAppointementHolder extends RecyclerView.ViewHolder{
        //Here we hold the MyDoctorItems
        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewStatus;
        ImageView imageViewDoctor;
        Button sendMessageButton;
        public MyDoctorAppointementHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.doctor_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewStatus = itemView.findViewById(R.id.onlineStatut);
            imageViewDoctor = itemView.findViewById(R.id.doctor_item_image);
            sendMessageButton = itemView.findViewById(R.id.voir_fiche_btn);
        }
    }




}
