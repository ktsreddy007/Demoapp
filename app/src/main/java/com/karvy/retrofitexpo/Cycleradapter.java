package com.karvy.retrofitexpo;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Cycleradapter extends RecyclerView.Adapter<Cycleradapter.MyViewholder>
{
    private List<String> list;

    //creating constructor
    public Cycleradapter(List<String>list)
    {
        this.list=list;
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        TextView textView= (TextView)LayoutInflater.from(parent.getContext()).inflate(R.layout.textforrecycler,parent,false);
        MyViewholder myViewholder=new MyViewholder(textView);
        return myViewholder;
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position)
    {
        holder.numbers.setText(list.get(position));

    }

    public int getItemCount()
    {
        return list.size();
    }

    //creating separate class for viewholder for recyclerview
    public static class MyViewholder extends RecyclerView.ViewHolder
    {
        //responsible for eachitem on the list
        TextView numbers;
        public MyViewholder(TextView itemView)
        {
            super(itemView);
            numbers=itemView;
        }
    }
}
