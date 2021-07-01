package com.karvy.retrofitexpo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbsqlite extends SQLiteOpenHelper
{

    private static final String dbname="Expodb";   //creation of db name this line

    //constructor default one
    public dbsqlite(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    //override method for creation of db table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String query= "create table empdata(_id integer primary key autoincrement,name text,jobtitle text,company text)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void insert_data(String name,String jobtitle,String company)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("jobtitle",jobtitle);
        contentValues.put("company",company);
        db.insert("empdata",null,contentValues);
    }

    public void updatedata(String name,String jobtitle,String company)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("jobtitle",jobtitle);
        contentValues.put("company",company);
        Cursor cursor=db.rawQuery("select * from empdata where name=?",new String[]{name});
        if(cursor.getCount()>0)
        {
            db.update("empdata",contentValues,"name=?",new String[]{name});
        }
    }

    public void deletedata(String name, String jobtitle, String company)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("jobtitle",jobtitle);
        contentValues.put("company",company);
        Cursor cursor=db.rawQuery("select * from empdata where name=?",new String[]{name});
        if(cursor.getCount()>0)
        {
            db.delete("empdata","name=?",new String[]{name});
        }
    }
}
