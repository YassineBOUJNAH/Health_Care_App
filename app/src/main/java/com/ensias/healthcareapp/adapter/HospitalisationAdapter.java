package com.ensias.healthcareapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ensias.healthcareapp.FicheInfo;
import com.ensias.healthcareapp.R;
import com.ensias.healthcareapp.model.Fiche;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class HospitalisationAdapter  extends FirestoreRecyclerAdapter<Fiche,HospitalisationAdapter.FicheHolder2> {

    public HospitalisationAdapter(@NonNull FirestoreRecyclerOptions<Fiche> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull FicheHolder2 holder, int position, @NonNull final Fiche model) {
        holder.doctor_name.setText(model.getDoctor());
        holder.type.setText(model.getType());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(v.getContext(),model);
            }
        });
    }

    private void openPage(Context wf, Fiche m){
        Intent i = new Intent(wf, FicheInfo.class);
        i.putExtra("dateCreated", m.getDateCreated().toString());
        i.putExtra("doctor",m.getDoctor());
        i.putExtra("description",m.getDescription());
        wf.startActivity(i);
    }

    @NonNull
    @Override
    public FicheHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hospitalisation_item,
                parent, false);
        return new FicheHolder2(v);
    }

    class FicheHolder2 extends RecyclerView.ViewHolder {
        TextView doctor_name;
        TextView type;
        Button btn;
        public FicheHolder2(View itemView) {
            super(itemView);
            doctor_name = itemView.findViewById(R.id.doctor_name2);
            type = itemView.findViewById(R.id.text_view_description2);
            btn = itemView.findViewById(R.id.voir_fiche_btn2);
        }
    }
}
