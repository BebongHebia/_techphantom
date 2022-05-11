package com.example.cafinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterForReports extends RecyclerView.Adapter<CustomAdapterForReports.MyViewHolderForReports> {


    Context context;
    ArrayList booker_id, booker_fullName, booker_carModelName;

    private ReportsClickListener listener;

    CustomAdapterForReports(Context context, ArrayList booker_id, ArrayList booker_fullName, ArrayList booker_carModelName, ReportsClickListener listener){
        this.context = context;
        this.booker_id = booker_id;
        this.booker_fullName = booker_fullName;
        this.booker_carModelName = booker_carModelName;

        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomAdapterForReports.MyViewHolderForReports onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_for_reports, parent, false);

        return new MyViewHolderForReports(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterForReports.MyViewHolderForReports holder, int position) {
        holder.report_BookingID_TV.setText(String.valueOf(booker_id.get(position)));
        holder.reports_bookerCarModel_TV.setText(String.valueOf(booker_carModelName.get(position)));
        holder.reports_bookerFullName_TV.setText(String.valueOf(booker_fullName.get(position)));
    }

    @Override
    public int getItemCount() {
        return booker_id.size();
    }

    public class MyViewHolderForReports extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView reports_bookerFullName_TV ,reports_bookerCarModel_TV, report_BookingID_TV;

        public MyViewHolderForReports(@NonNull View itemView) {
            super(itemView);

            reports_bookerFullName_TV = itemView.findViewById(R.id.reports_bookerFullName_TV);
            reports_bookerCarModel_TV = itemView.findViewById(R.id.reports_bookerCarModel_TV);
            report_BookingID_TV = itemView.findViewById(R.id.report_BookingID_TV);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    public interface ReportsClickListener{
        void onClick(View v, int position);
    }
}
