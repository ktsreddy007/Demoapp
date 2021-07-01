package com.karvy.retrofitexpo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Recyclerviewexpo extends AppCompatActivity
{
    private RecyclerView recyclerView;   //creating handler
    private RecyclerView.LayoutManager layoutManager;
    private List<String>list;
    private Cycleradapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerviewexpo);
        recyclerView=findViewById(R.id.rc_one);


        /*Three important things for recyceler view implementation
         * Layout manager , View holder , Adapter
         * Purpose of layout manager is to align item on the list into rows and columns
         * Each item on the recycler view is represented by View holder class eg:imageview , Textview etc
         * Adapter responsible To Place the each of the viewholder in a proper position*/

        //Intialising the layout manager below line
        layoutManager =new LinearLayoutManager(this); //we have pass atleast one parameter i.e constructor here it is context
        //To tell the recycler view we need the above layoutmanager -- we have to call setlayoutmanager()
        recyclerView.setLayoutManager(layoutManager);
        //To display the items we need to use adapter and viewholder class

        list= Arrays.asList(getResources().getStringArray(R.array.lang_list));

        recyclerAdapter=new Cycleradapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerAdapter);
    }
}