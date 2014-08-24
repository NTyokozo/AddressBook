package com.example.project1.databases.Imp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by nobubele on 2014/08/15.
 */
public class DBAdapter extends SQLiteOpenHelper
{
    public static final  String TABLE_SETTINGS = "settings";
    public static final String TABLE_TESTING = "testings" ;

    public static final String Column_Name = "First_Name";
    public static final String Column_LastName  = "Last_Name";
    public static final String Column_Email = "Email_Address";
    public static final String Column_Personal = "Home_Address";
    public static final String Column_CellPhone = "Cell_Phone";
    public static final String Column_ID = "id";
    public static final String Column_Url = "url";

     private static final String DATABASE_NAME = "TESTING.DB";
     public static final int DATABASE_VERSION = 1;

       private static final String User_Create = "create table IF NOT EXISTS " + TABLE_SETTINGS + " ( "
               + Column_ID + " integer primary key autoincrement, "
               + Column_Url + " text not null);" ;


    private static final String User_Create_Testing = "create table IF NOT EXISTS " + TABLE_TESTING + " ( "
            + Column_ID + " integer primary key autoincrement, "
            + Column_Name+ " text not null, "
            + Column_LastName + " text not null, "
            + Column_CellPhone + " text not null , "
            + Column_Email + " text not null, "
            + Column_Personal + " text not null);" ;

    public DBAdapter(Context context)
    {
        super(context, DATABASE_NAME , null  , DATABASE_VERSION);
        Log.w("" , "database");
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL(User_Create);
        database.execSQL(User_Create_Testing);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

        Log.w(DBAdapter.class.getName(), "upgrading database from version " + oldVersion + "to" + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SETTINGS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TESTING);

        onCreate(db);
    }
}
