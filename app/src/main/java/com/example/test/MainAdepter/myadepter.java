package com.example.test.MainAdepter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.test.Mainmodel.datamodel;
import com.example.test.R;
import com.example.test.productDetails;

import java.util.ArrayList;

public class myadepter extends  RecyclerView.Adapter<myadepter.myviewholder> {
    ArrayList<datamodel> dataholders;
    Context context;

    public myadepter(ArrayList<datamodel> dataholders ,Context context) {
        this.dataholders = dataholders;
        this.context=context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.productmodel,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        final  datamodel model=dataholders.get(position);
        holder.image.setImageResource(model.getImage());
        holder.header.setText(model.getHeader());
        holder.desc.setText(model.getDesc());
        holder.price.setText(model.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, productDetails.class);
                intent.putExtra("Image",model.getImage());
                intent.putExtra("Place Name",model.getHeader());
                intent.putExtra("Price",model.getPrice());
                intent.putExtra("Description",model.getDesc());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataholders.size();
    }

    static class myviewholder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView header, desc,price;

        public myviewholder(@NonNull View itemView) {

            super(itemView);
            image=itemView.findViewById(R.id.modelimg);
            header=itemView.findViewById(R.id.header);
            desc=itemView.findViewById(R.id.desc);
            price=itemView.findViewById(R.id.price);
        }

    }
}
