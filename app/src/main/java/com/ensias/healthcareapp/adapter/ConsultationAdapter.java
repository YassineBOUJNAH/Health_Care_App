package com.ensias.healthcareapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ensias.healthcareapp.R;
import com.ensias.healthcareapp.model.Fiche;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ConsultationAdapter extends FirestoreRecyclerAdapter<Fiche,ConsultationAdapter.FicheHolder> {

    public ConsultationAdapter(@NonNull FirestoreRecyclerOptions<Fiche> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull FicheHolder holder, int position, @NonNull Fiche model) {
        holder.doctor_name.setText(model.getDoctor());
        holder.type.setText(model.getType());
    }

    @NonNull
    @Override
    public FicheHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.consultation_item,
                parent, false);
        return new FicheHolder(v);
    }
    class FicheHolder extends RecyclerView.ViewHolder {
        TextView doctor_name;
        TextView type;

        public FicheHolder(View itemView) {
            super(itemView);
            doctor_name = itemView.findViewById(R.id.doctor_name);
            type = itemView.findViewById(R.id.text_view_description);
        }
    }
}
