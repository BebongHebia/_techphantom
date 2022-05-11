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

public class OutgoingTransactionCustomAdapter extends RecyclerView.Adapter<OutgoingTransactionCustomAdapter.MyViewHolderOutGoingTransaction> {
    Context context;
    ArrayList transactionID,
            transactionFullName,
            transactionCarModel,
            transactionTripDate,
            transactionTripRoutes,
            transactionReturnStatus;

    private OutgoingTransactionClickListener listener;

    OutgoingTransactionCustomAdapter(Context context, ArrayList transactionID, ArrayList transactionFullName, ArrayList transactionCarModel,
                                     ArrayList transactionTripDate, ArrayList transactionTripRoutes, ArrayList transactionReturnStatus,
                                     OutgoingTransactionClickListener listener){

        this.context = context;
        this.transactionID = transactionID;
        this.transactionFullName = transactionFullName;
        this.transactionCarModel = transactionCarModel;
        this.transactionTripDate = transactionTripDate;
        this.transactionTripRoutes = transactionTripRoutes;
        this.transactionReturnStatus = transactionReturnStatus;

        this.listener = listener;


    }

    @NonNull
    @Override
    public MyViewHolderOutGoingTransaction onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_outgoing_transactions, parent, false);
        return new MyViewHolderOutGoingTransaction(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderOutGoingTransaction holder, int position) {
        holder.transactionID.setText(String.valueOf(transactionID.get(position)));
        holder.outgoingTransaction_Fullname.setText(String.valueOf(transactionFullName.get(position)));
        holder.outgoingTransaction_CarName.setText(String.valueOf(transactionCarModel.get(position)));
        holder.outgoingTransaction_TripDate_TV.setText(String.valueOf(transactionTripDate.get(position)));
        holder.outgoingTransaction_TripAddress_TV.setText(String.valueOf(transactionTripRoutes.get(position)));
        holder.outgoingTransaction_CarReturnStatus_TV.setText(String.valueOf(transactionReturnStatus.get(position)));
    }

    @Override
    public int getItemCount() {
        return transactionID.size();
    }

    public class MyViewHolderOutGoingTransaction extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView transactionID,
                outgoingTransaction_Fullname,
                outgoingTransaction_CarName,
                outgoingTransaction_TripDate_TV,
                outgoingTransaction_TripAddress_TV,
                outgoingTransaction_CarReturnStatus_TV;



        public MyViewHolderOutGoingTransaction(@NonNull View itemView) {
            super(itemView);
            transactionID = itemView.findViewById(R.id.transactionID);
            outgoingTransaction_Fullname = itemView.findViewById(R.id.outgoingTransaction_Fullname);
            outgoingTransaction_CarName = itemView.findViewById(R.id.outgoingTransaction_CarName);
            outgoingTransaction_TripDate_TV = itemView.findViewById(R.id.outgoingTransaction_TripDate_TV);
            outgoingTransaction_TripAddress_TV = itemView.findViewById(R.id.outgoingTransaction_TripAddress_TV);
            outgoingTransaction_CarReturnStatus_TV = itemView.findViewById(R.id.outgoingTransaction_CarReturnStatus_TV);



            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    public interface OutgoingTransactionClickListener{
        void onClick(View v, int position);
    }
}
