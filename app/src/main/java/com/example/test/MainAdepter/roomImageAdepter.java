package com.example.test.MainAdepter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.Mainmodel.datamodel;
import com.example.test.Mainmodel.roomimgeModel;
import com.example.test.R;

import java.util.ArrayList;

public class roomImageAdepter extends RecyclerView.Adapter<roomImageAdepter.myviewholder> {
    ArrayList<roomimgeModel> dataholders;
    Context context;
    public roomImageAdepter(ArrayList<roomimgeModel> dataholders,Context context) {
        this.dataholders = dataholders;
        this.context=context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.roomimgemodel,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        final  roomimgeModel model=dataholders.get(position);
        holder.image.setImageResource(model.getImage());
    }

    @Override
    public int getItemCount() {
        return dataholders.size();
    }


    static class myviewholder extends RecyclerView.ViewHolder{

        ImageView image;


        public myviewholder(@NonNull View itemView) {

            super(itemView);
            image=itemView.findViewById(R.id.insideRoomimage);

        }

    }
}
