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

public class DeleteCarsCustomAdapter extends RecyclerView.Adapter<DeleteCarsCustomAdapter.DeleteCarsMyViewHolder> {

    private RecyclerViewForDeleteCarsClickListener listener;

    private Context context;
    private ArrayList carID, carName;

    private ArrayList<AddCarModelClass> objectModelClassList;


    DeleteCarsCustomAdapter(Context context, ArrayList carID, ArrayList carName, RecyclerViewForDeleteCarsClickListener listener, ArrayList objectModelClassList){
        this.context = context;
        this.carID = carID;
        this.carName = carName;

        this.listener = listener;

        this.objectModelClassList = objectModelClassList;


    }


    @NonNull
    @Override
    public DeleteCarsCustomAdapter.DeleteCarsMyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_delete_cars, parent,false);
        return new DeleteCarsMyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeleteCarsCustomAdapter.DeleteCarsMyViewHolder holder, int position) {
        holder.carID_TV.setText(String.valueOf(carID.get(position)));
        holder.carName_TV.setText(String.valueOf(carName.get(position)));

        AddCarModelClass addCarModelClass = objectModelClassList.get(position);

        holder.imageView20.setImageBitmap(addCarModelClass.getImage());
    }

    @Override
    public int getItemCount() {
        return carID.size();
    }

    public class DeleteCarsMyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView carID_TV, carName_TV;
        ImageView imageView20;

        public DeleteCarsMyViewHolder(@NonNull View itemView) {
            super(itemView);
            carID_TV = itemView.findViewById(R.id.row_delete_cars_id_textView);
            carName_TV = itemView.findViewById(R.id.row_delete_cars_textView);
            imageView20 = itemView.findViewById(R.id.imageView20);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            listener.OnClick(view, getAdapterPosition());
        }
    }

    public interface RecyclerViewForDeleteCarsClickListener{
        void OnClick(View v, int position);
    }
}
