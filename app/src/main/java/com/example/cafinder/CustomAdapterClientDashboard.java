package com.example.cafinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterClientDashboard extends RecyclerView.Adapter<CustomAdapterClientDashboard.MyViewHolderClientDashboard> {

    private Context context;
    private ArrayList carID, carName, carPrice, carCompanyOwner, carAvailability;
    private ArrayList<AddCarModelClass> objectModelClassList;

    private SelectingCarsOnClickListener listener;

    CustomAdapterClientDashboard(Context context, ArrayList carID,ArrayList carName,ArrayList carPrice,ArrayList carCompanyOwner, SelectingCarsOnClickListener listener, ArrayList objectModelClassList,  ArrayList carAvailability){
        this.context = context;
        this.carID = carID;
        this.carName = carName;
        this.carPrice = carPrice;
        this.carCompanyOwner = carCompanyOwner;
        this.carAvailability = carAvailability;

        this.listener = listener;

        this.objectModelClassList = objectModelClassList;
    }

    @NonNull
    @Override
    public CustomAdapterClientDashboard.MyViewHolderClientDashboard onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_client_dashboard, parent,false);
        return new MyViewHolderClientDashboard(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterClientDashboard.MyViewHolderClientDashboard holder, int position) {
        holder.carID_TV.setText(String.valueOf(carID.get(position)));
        holder.carName_TV.setText(String.valueOf(carName.get(position)));
        holder.carPrice_TV.setText(String.valueOf(carPrice.get(position)));
        holder.carCompanyOwner_TV.setText(String.valueOf(carCompanyOwner.get(position)));
        holder.carAvailability_textView.setText(String.valueOf(carAvailability.get(position)));

        AddCarModelClass addCarModelClass = objectModelClassList.get(position);

        holder.imageView22.setImageBitmap(addCarModelClass.getImage());

    }

    @Override
    public int getItemCount() {
        return carID.size();
    }

    public class MyViewHolderClientDashboard extends RecyclerView.ViewHolder implements View.OnClickListener{

            TextView carID_TV, carName_TV, carPrice_TV, carCompanyOwner_TV, carAvailability_textView;
            ImageView imageView22;

        public MyViewHolderClientDashboard(@NonNull View itemView) {
            super(itemView);

            carID_TV = itemView.findViewById(R.id.client_dashboard_carID_textView);
            carName_TV = itemView.findViewById(R.id.client_dashboard_carModelName_textView);
            carPrice_TV = itemView.findViewById(R.id.client_dashboard_carPrice_textView);
            carCompanyOwner_TV = itemView.findViewById(R.id.client_dashboard_carCompanyOwner_textView);
            carAvailability_textView = itemView.findViewById(R.id.carAvailability_textView);
            imageView22 = itemView.findViewById(R.id.imageView22);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
                listener.onClick(view, getAdapterPosition());
        }
    }

    public interface SelectingCarsOnClickListener{
        void onClick(View v, int position);
    }
}
