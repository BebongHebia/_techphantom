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

public class MyCompanyCarsCustomAdapter extends RecyclerView.Adapter<MyCompanyCarsCustomAdapter.MyCompanyCarsViewHolder> {
    private Context context;
    private ArrayList carID, carName;
    private ArrayList<AddCarModelClass> objectModelClassList;

    MyCompanyCarsCustomAdapter(Context context, ArrayList carID, ArrayList carName, ArrayList objectModelClassList){
        this.context = context;
        this.carID = carID;
        this.carName = carName;
        this.objectModelClassList = objectModelClassList;

    }


    @NonNull
    @Override
    public MyCompanyCarsCustomAdapter.MyCompanyCarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_company_cars_row, parent, false);
        return new MyCompanyCarsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyCompanyCarsCustomAdapter.MyCompanyCarsViewHolder holder, int position) {
        holder.carID_TV.setText(String.valueOf(carID.get(position)));
        holder.carName_TV.setText(String.valueOf(carName.get(position)));

        AddCarModelClass addCarModelClass = objectModelClassList.get(position);

        holder.imageView19.setImageBitmap(addCarModelClass.getImage());


    }

    @Override
    public int getItemCount() {
        return carID.size();
    }

    public class MyCompanyCarsViewHolder extends RecyclerView.ViewHolder {
        TextView carID_TV, carName_TV;
        ImageView imageView19;

        public MyCompanyCarsViewHolder(@NonNull View itemView) {
            super(itemView);

        carID_TV = itemView.findViewById(R.id.myCompanyCars_carID_textView);
        carName_TV = itemView.findViewById(R.id.myCompanyCars_textView);
        imageView19 = itemView.findViewById(R.id.imageView19);
        }
    }
}
