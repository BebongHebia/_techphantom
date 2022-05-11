


package com.example.cafinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafinder.R;

import java.util.ArrayList;

public class CustomAdapterForConfirmBooking extends RecyclerView.Adapter<CustomAdapterForConfirmBooking.MyViewHolderForConfirmBooking> {

    private Context context;
    private ArrayList booking_id, booking_full_name, booking_car_name, booking_trip_from, booking_trip_to, booking_payment_method, booking_trip_address;

    private SelectingBookingOnClickListener listener;

    CustomAdapterForConfirmBooking(Context context,
                                   ArrayList booking_id,
                                   ArrayList booking_full_name,
                                   ArrayList booking_car_name,
                                   ArrayList booking_trip_from,
                                   ArrayList booking_trip_to,
                                   ArrayList booking_payment_method,
                                   ArrayList booking_trip_address,
                                   SelectingBookingOnClickListener listener
                                   ){

        this.context = context;
        this.booking_id = booking_id;
        this.booking_full_name = booking_full_name;
        this.booking_car_name = booking_car_name;
        this.booking_trip_from = booking_trip_from;
        this.booking_trip_to = booking_trip_to;
        this.booking_payment_method = booking_payment_method;
        this.booking_trip_address = booking_trip_address;

        this.listener = listener;

    }


    @NonNull
    @Override
    public MyViewHolderForConfirmBooking onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_for_confirm_booking, parent, false);
        return new MyViewHolderForConfirmBooking(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderForConfirmBooking holder, int position) {
        holder.booking_id_TV.setText(String.valueOf(booking_id.get(position)));
        holder.booking_full_name_TV.setText(String.valueOf(booking_full_name.get(position)));
        holder.booking_car_name_TV.setText(String.valueOf(booking_car_name.get(position)));
        holder.booking_trip_from_TV.setText(String.valueOf(booking_trip_from.get(position)));
        holder.booking_trip_to_TV.setText(String.valueOf(booking_trip_to.get(position)));
        holder.booking_payment_method_TV.setText(String.valueOf(booking_payment_method.get(position)));
        holder.booking_trip_address_TV.setText(String.valueOf(booking_trip_address.get(position)));
    }

    @Override
    public int getItemCount() {
        return booking_id.size();
    }

    public class MyViewHolderForConfirmBooking extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView booking_id_TV,
                booking_full_name_TV,
                booking_car_name_TV,
                booking_trip_from_TV,
                booking_trip_to_TV,
                booking_payment_method_TV,
                booking_trip_address_TV;

        public MyViewHolderForConfirmBooking(@NonNull View itemView) {
            super(itemView);
            booking_id_TV = itemView.findViewById(R.id.confirmBooking_BookingID);
            booking_full_name_TV = itemView.findViewById(R.id.confirmBooking_BookingFullName);
            booking_car_name_TV = itemView.findViewById(R.id.confirmBooking_BookingCarName);
            booking_trip_from_TV = itemView.findViewById(R.id.confirmBooking_BookingTripFrom);
            booking_trip_to_TV = itemView.findViewById(R.id.confirmBooking_BookingTripTo);
            booking_payment_method_TV = itemView.findViewById(R.id.confirmBooking_BookingPaymentMode);
            booking_trip_address_TV = itemView.findViewById(R.id.confirmBooking_BookingTripAddress);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    public interface SelectingBookingOnClickListener{
        void onClick(View v, int position);
    }
}
