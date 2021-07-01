package com.karvy.retrofitexpo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class sqlexpo extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlexpo);
        EditText et_name = (EditText) findViewById(R.id.et_name);
        EditText et_job = (EditText) findViewById(R.id.et_job);
        EditText et_comp = (EditText) findViewById(R.id.et_comp);
        RadioGroup rg =(RadioGroup)findViewById(R.id.rg);
        RadioButton rb_male =(RadioButton)findViewById(R.id.rb_male);
        RadioButton rb_female = (RadioButton)findViewById(R.id.rb_female);
        Button bt_sub = (Button)findViewById(R.id.bt_sub);
        Button bt_upd = (Button)findViewById(R.id.bt_upd);
        Button bt_del = (Button)findViewById(R.id.bt_del);


        //creating object for database class i.e dbsqlite file
        dbsqlite databess =new dbsqlite(this);
        //calling above class reference in below line
        SQLiteDatabase sqLiteDatabase=databess.getReadableDatabase();




        //Insertion opertion button
        bt_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String names=et_name.getText().toString();
                String jobs=et_job.getText().toString();
                String compu=et_comp.getText().toString();
                if(names.equals("")||jobs.equals("")||compu.equals(""))
                {
                    Toast.makeText(sqlexpo.this,"Enter all fields",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    databess.insert_data(names,jobs,compu);
                    Toast.makeText(sqlexpo.this,"Data inserted Successfully",Toast.LENGTH_SHORT).show();
                }
                //et_name.setText("");


            }
        });

        //Updation operation button
        bt_upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String names=et_name.getText().toString();
                String jobs=et_job.getText().toString();
                String compu=et_comp.getText().toString();
                /*if(names.equals("")||jobs.equals("")||compu.equals(""))
                {
                    Toast.makeText(sqlexpo.this,"Enter all fields",Toast.LENGTH_SHORT).show();
                }
                else
                {*/
                    databess.updatedata(names,jobs,compu);
                    Toast.makeText(sqlexpo.this,"Data Updated Successfully",Toast.LENGTH_SHORT).show();

                //et_name.setText("");


            }
        });


        //Deletion operation button
        bt_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String names=et_name.getText().toString();
                String jobs=et_job.getText().toString();
                String compu=et_comp.getText().toString();
                databess.deletedata(names,jobs,compu);
                Toast.makeText(sqlexpo.this,"Data Deleted Successfully",Toast.LENGTH_SHORT).show();
                //et_name.setText("");


            }
        });
    }
}
