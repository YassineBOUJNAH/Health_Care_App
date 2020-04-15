package com.ensias.healthcareapp.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ensias.healthcareapp.R;
import com.ensias.healthcareapp.model.Doctor;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class DoctoreAdapter extends FirestoreRecyclerAdapter<Doctor, DoctoreAdapter.DoctoreHolder> {

    public DoctoreAdapter(@NonNull FirestoreRecyclerOptions<Doctor> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull DoctoreHolder doctoreHolder, int i, @NonNull Doctor doctor) {
        doctoreHolder.title.setText(doctor.getName());
        doctoreHolder.specialite.setText("Specialite : "+doctor.getSpecialite());
       // doctoreHolder.image.setImageURI(Uri.parse("drawable-v24/ic_launcher_foreground.xml"));
    }

    @NonNull
    @Override
    public DoctoreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_item,
                parent, false);
        return new DoctoreHolder(v);
    }

    class DoctoreHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView specialite;
        ImageView image;
        public DoctoreHolder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.doctor_view_title);
            specialite=itemView.findViewById(R.id.text_view_description);
            image=itemView.findViewById(R.id.doctor_item_image);

        }
    }
}
