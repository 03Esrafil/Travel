package com.example.test.fragment.fragAdepter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;
import com.example.test.fragment.fragModel.wishlistmodel;


import java.util.ArrayList;
import java.util.List;

public class wishlistAdepter extends RecyclerView.Adapter<wishlistAdepter.viewholder> {
    List<wishlistmodel> imagelist=new ArrayList<>();

    public wishlistAdepter(List<wishlistmodel> imagelist) {
        this.imagelist = imagelist;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlistmodel,parent,false);
        return new viewholder(view);

    }

    @Override
    public void onBindViewHolder(viewholder holder, int position) {
        holder.image.setImageResource(imagelist.get(position).imge);
        holder.title.setText(imagelist.get(position).imgetile);


    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imagelistid);
            title=itemView.findViewById(R.id.imgeTile);
        }
    }

}
