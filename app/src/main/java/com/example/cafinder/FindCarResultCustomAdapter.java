package com.example.cafinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FindCarResultCustomAdapter extends RecyclerView.Adapter<FindCarResultCustomAdapter.FindCarResultMyViewHolder> {
    Context context;
    ArrayList car_id, car_model, car_rates, car_type, company_owner;

    private FindCarResultClickListener listener;

    FindCarResultCustomAdapter(Context context, ArrayList car_id, ArrayList car_model, ArrayList car_rates, ArrayList car_type, ArrayList company_owner, FindCarResultClickListener listener){
        this.context = context;
        this.car_id = car_id;
        this.car_model = car_model;
        this.car_rates = car_rates;
        this.car_type = car_type;
        this.company_owner = company_owner;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FindCarResultMyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.find_car_result_row, parent, false);
        return new FindCarResultMyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FindCarResultMyViewHolder holder, int position) {
        holder.findCarResultRow_carId_Tv.setText(String.valueOf(car_id.get(position)));
        holder.findCarResultRow_carModel_Tv.setText(String.valueOf(car_model.get(position)));
        holder.findCarResultRow_carPrice_Tv.setText(String.valueOf(car_rates.get(position)));
        holder.findCarResultRow_carType_Tv.setText(String.valueOf(car_type.get(position)));
        holder.findCarResultRow_carOwner_Tv.setText(String.valueOf(company_owner.get(position)));
    }

    @Override
    public int getItemCount() {
        return car_id.size();
    }

    public class FindCarResultMyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView findCarResultRow_carId_Tv, findCarResultRow_carModel_Tv, findCarResultRow_carPrice_Tv, findCarResultRow_carType_Tv, findCarResultRow_carOwner_Tv;

        public FindCarResultMyViewHolder(@NonNull View itemView) {
            super(itemView);

            findCarResultRow_carId_Tv = itemView.findViewById(R.id.findCarResultRow_carId_Tv);
            findCarResultRow_carModel_Tv = itemView.findViewById(R.id.findCarResultRow_carModel_Tv);
            findCarResultRow_carPrice_Tv = itemView.findViewById(R.id.findCarResultRow_carPrice_Tv);
            findCarResultRow_carType_Tv = itemView.findViewById(R.id.findCarResultRow_carType_Tv);
            findCarResultRow_carOwner_Tv = itemView.findViewById(R.id.findCarResultRow_carOwner_Tv);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    public interface FindCarResultClickListener{
        void onClick(View v, int position);
    }

}
