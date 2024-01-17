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

import com.example.test.Mainmodel.roomlistModel;
import com.example.test.R;
import com.example.test.hotelbooking;
import com.example.test.productDetails;

import java.util.ArrayList;

public class roomlistAdepter extends  RecyclerView.Adapter<roomlistAdepter.myviewholder>{
    ArrayList<roomlistModel> dataholders;
    Context context;

    public roomlistAdepter(ArrayList<roomlistModel> dataholders, Context context) {
        this.dataholders = dataholders;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.roomlistmodel,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        final roomlistModel  model=dataholders.get(position);
        holder.image.setImageResource(model.getRoomtImage());
        holder.hotelName.setText(model.getHotelName());
        holder.location.setText(model.getLocation());
        holder.roomprice.setText(model.roomprice);
        holder.roomNumeber.setText(model.getRoomNumeber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, hotelbooking.class);
                intent.putExtra("Image",model.getRoomtImage());
                intent.putExtra("Hotel Name",model.getHotelName());
                intent.putExtra("location",model.getLocation());
                intent.putExtra("roomPrice",model.getRoomprice());
                intent.putExtra("bedNumber",model.getRoomNumeber());
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
        TextView hotelName, location,roomNumeber,roomprice;

        public myviewholder(@NonNull View itemView) {

            super(itemView);
            image=itemView.findViewById(R.id.Roomimage);
            hotelName=itemView.findViewById(R.id.HotelName);
            location=itemView.findViewById(R.id.roomlocationid);
            roomNumeber=itemView.findViewById(R.id.roomlocationid);
            roomprice=itemView.findViewById(R.id.Roomprice);

        }

    }
}
