package com.example.test.fragment.fragAdepter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;
import com.example.test.fragment.fragModel.tripModel;

import java.util.ArrayList;

public class OderTripAdepter extends RecyclerView.Adapter<OderTripAdepter.viewHolder>{
    ArrayList<tripModel> triplist;
    Context context;

    public OderTripAdepter(ArrayList<tripModel> triplist, Context context) {
        this.triplist = triplist;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.triplistmodel,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final tripModel tripmodel=triplist.get(position);

        holder.oderImage.setImageResource(tripmodel.getModelImage());
        holder.oderplaceName.setText(tripmodel.getPlaceName());
        holder.oderprice.setText(tripmodel.getPrice());
        holder.orderNumber.setText(tripmodel.getOrderNumber());

    }

    @Override
    public int getItemCount() {
        return triplist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
          ImageView oderImage;
          TextView oderplaceName,oderprice,orderNumber;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            oderImage=itemView.findViewById(R.id.imagelistid);
            oderplaceName=itemView.findViewById(R.id.Placename);
            oderprice=itemView.findViewById(R.id.Oderprice);
            orderNumber=itemView.findViewById(R.id.orderNumber);

        }
    }
}
