package com.example.photosharingapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class category_Adapter extends RecyclerView.Adapter<category_Adapter.category_ViewHolder>{

    Context context;
    List<category> categoryList;

    public category_Adapter(Context context, List<category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public category_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_menu, null);
        return new category_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull category_ViewHolder holder, int position) {

        category category = categoryList.get(position);
        holder.iconTitle.setText(category.getIcon_title());
        holder.iconImg.setImageDrawable(context.getResources().getDrawable(category.getIcon_img()));

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class category_ViewHolder extends RecyclerView.ViewHolder{
        TextView iconTitle;
        ImageView iconImg;
        public category_ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconTitle = itemView.findViewById(R.id.icontitle);
            iconImg = itemView.findViewById(R.id.iconimg);
        }
    }


}
