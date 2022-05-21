package com.example.cafinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterForComment extends RecyclerView.Adapter<CustomAdapterForComment.MyViewHolderComment> {

    private Context context;
    private ArrayList name, comment;

    CustomAdapterForComment(Context context,  ArrayList name,  ArrayList comment){

        this.context = context;
        this.name = name;
        this.comment = comment;

    }

    @NonNull
    @Override
    public MyViewHolderComment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_client_dashboard, parent,false);
        return new CustomAdapterForComment.MyViewHolderComment(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderComment holder, int position) {
        holder.comment_Name_TV.setText(String.valueOf(name.get(position)));
        holder.comment_comment_TV.setText(String.valueOf(comment.get(position)));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolderComment extends RecyclerView.ViewHolder {

        TextView comment_Name_TV,
        comment_comment_TV;

        public MyViewHolderComment(@NonNull View itemView) {
            super(itemView);

            comment_Name_TV = itemView.findViewById(R.id.comment_Name_TV);
            comment_comment_TV = itemView.findViewById(R.id.comment_comment_TV);


        }
    }
}
