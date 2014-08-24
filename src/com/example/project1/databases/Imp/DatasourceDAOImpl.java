package com.example.project1.databases.Imp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.project1.databases.DatasourceDAO;
import com.example.project1.domain.CustomerInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nobubele on 2014/08/19.
 */
public class DatasourceDAOImpl implements DatasourceDAO {

    private SQLiteDatabase database;
    private  DBAdapter dbHelper;

    public DatasourceDAOImpl(Context context)
    {
        dbHelper = new DBAdapter(context);
    }
     public  void  open() throws SQLException {
         database = dbHelper.getWritableDatabase();
     }

    public void close()
    {
        dbHelper.close();
    }



    @Override
    public void createCustomer(CustomerInfo customerInfo)
    {
        try
        {
            open();
            ContentValues values = new ContentValues();
            values.put(DBAdapter.Column_Name , customerInfo.getName());
            values.put(DBAdapter.Column_LastName , customerInfo.getLastName());
            values.put(DBAdapter.Column_Email, customerInfo.getEmail());
            values.put(DBAdapter.Column_Personal, customerInfo.getAddress());
            values.put(DBAdapter.Column_CellPhone, customerInfo.getCell_phone());

            //inserting rows
            database.insert(DBAdapter.TABLE_TESTING , null , values);
            close();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void updateCustomer(CustomerInfo customerInfo)
    {
        try
        {
            open();
            ContentValues values = new ContentValues();
            values.put(DBAdapter.Column_Name , customerInfo.getName());
            values.put(DBAdapter.Column_LastName , customerInfo.getLastName());
            values.put(DBAdapter.Column_Email, customerInfo.getEmail());
            values.put(DBAdapter.Column_Personal, customerInfo.getAddress());
            values.put(DBAdapter.Column_CellPhone, customerInfo.getCell_phone());

            //inserting rows
            database.update(DBAdapter.TABLE_TESTING , values , DBAdapter.Column_ID + "=?" ,
                                        new String[]{String.valueOf(customerInfo.getId())});
            close();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public CustomerInfo findCustomerByID(int id)
    {

        CustomerInfo customerInfo = new CustomerInfo();
        try
        {
            open();
            Cursor cursor = database.query(DBAdapter.TABLE_TESTING, new String[]{DBAdapter.Column_ID , DBAdapter.Column_Name
            , DBAdapter.Column_LastName , DBAdapter.Column_Email, DBAdapter.Column_CellPhone , DBAdapter.Column_Personal } , DBAdapter.Column_ID+ "= ?" ,
                                new String[]{String.valueOf(id)},null , null , null ,null);

            if (cursor!=null)
                cursor.moveToFirst();

            customerInfo.setId(cursor.getInt(0));
            customerInfo.setName(cursor.getString(1));
            customerInfo.setLastName(cursor.getString(2));
            customerInfo.setEmail(cursor.getString(3));
            customerInfo.setAddress(cursor.getString(4));
            customerInfo.setCell_phone(cursor.getString(5));



        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return  customerInfo;

    }

    @Override
    public void deleteCustomer(CustomerInfo customerInfo)
    {
        try
        {
            open();


            //deleting  rows
            database.delete(DBAdapter.TABLE_TESTING, DBAdapter.Column_ID + "=?", new String[]{String.valueOf(customerInfo.getId())});

            close();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<CustomerInfo> getCustomerInfo()
    {
        String selectQuery = "SELECT * FROM " + DBAdapter.TABLE_TESTING;
         final CustomerInfo customerInfo = new CustomerInfo();
        List<CustomerInfo> infoList =new ArrayList<CustomerInfo>();
        try
        {
            open();


            Cursor cursor = database.rawQuery(selectQuery, null);

            if(cursor.moveToFirst())
            {
                do {
                    customerInfo.setId(cursor.getInt(0));
                    customerInfo.setName(cursor.getString(1));
                    customerInfo.setLastName(cursor.getString(2));
                    customerInfo.setEmail(cursor.getString(3));
                    customerInfo.setAddress(cursor.getString(4));
                    customerInfo.setCell_phone(cursor.getString(5));

                    infoList.add(customerInfo);


                }while (cursor.moveToNext());
            }
            close();
            //return customerInfo;

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        //database.rawQuery(selectQuery, null);

        return infoList;
    }

    public CustomerInfo getContact()
    {
            CustomerInfo customerInfo = new CustomerInfo();
         try{
            open();
            database = dbHelper.getReadableDatabase();

            Cursor cursor = database.query(dbHelper.TABLE_TESTING, new String[]{dbHelper.Column_ID, dbHelper.Column_Name , dbHelper.Column_CellPhone},
                                               dbHelper.Column_ID +"=?" , new String[]{String.valueOf(customerInfo.getId())}, null, null , null , null);

             if(cursor!=null)
                 cursor.moveToFirst();

             customerInfo = new CustomerInfo(Integer.parseInt(cursor.getString(0)),
                     cursor.getString(1), cursor.getString(2));
             close();

         }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return  customerInfo;
    }
}
