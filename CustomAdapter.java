package com.e.covidyodha_v2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    Activity activity;

    public CustomAdapter(Activity activity)
    {
        this.activity=activity;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =activity.getLayoutInflater().inflate(R.layout.card_layout,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.editText.setText("Foodpkt=");
        holder.editText2.setText("Name : ");
        holder.editText3.setText("Address : ");
        holder.editText4.setText("Number : ");
        holder.editText5.setText("Aadhar : ");
        holder.editText6.setText("Members : ");
        holder.editText7.setText("h ago");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView editText;
        TextView editText2;
        TextView editText3;
        TextView editText4;
        TextView editText5;
        TextView editText6;
        TextView editText7;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            editText=itemView.findViewById(R.id.editText);
            editText2=itemView.findViewById(R.id.editText2);
            editText3=itemView.findViewById(R.id.editText3);
            editText4=itemView.findViewById(R.id.editText4);
            editText5=itemView.findViewById(R.id.editText5);
            editText6=itemView.findViewById(R.id.editText6);
            editText7=itemView.findViewById(R.id.editText7);


        }
    }
}
