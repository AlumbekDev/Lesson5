package com.example.homeworklesson5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private List<LanguegeModel> list;



        public MyAdapter(List<LanguegeModel> list){
           this.list = list;
        }

        public void addBook(LanguegeModel model){
            list.add(model);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public  MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.bind(list.get(position));
        }

        @Override
        public int getItemCount(){
            return list.size();
        }

            public class MyViewHolder extends RecyclerView.ViewHolder{

            TextView myText1;
            ImageView myImage;
                public MyViewHolder(@NonNull View itemView) {
                    super(itemView);
                    myText1 = itemView.findViewById(R.id.myText1);

                    myImage = itemView.findViewById(R.id.myImageView);
                }

                public void bind(LanguegeModel languegeModel) {
                    myText1.setText(languegeModel.getTitle());
                    myImage.setImageResource(languegeModel.getImage());
                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onItemClickListener.onClickItem(getAdapterPosition());
                        }
                    });
                }
            }
}