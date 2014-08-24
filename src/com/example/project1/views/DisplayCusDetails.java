package com.example.project1.views;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.project1.R;
import com.example.project1.databases.DatasourceDAO;
import com.example.project1.databases.Imp.DatasourceDAOImpl;
import com.example.project1.domain.CustomerInfo;
import android.content.Intent;

import javax.xml.datatype.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nobubele on 2014-08-24.
 */
public class DisplayCusDetails extends Activity {


    TextView editText , lastName , email,personal_home , cell_num;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_cust_details);

        Context context = getApplicationContext();
        int  duration = Toast.LENGTH_LONG ;
        editText = (TextView)findViewById(R.id.editText);
        lastName = (TextView)findViewById(R.id.editText2);
        email = (TextView)findViewById(R.id.editText3);
        personal_home = (TextView)findViewById(R.id.editText4);
        cell_num = (TextView)findViewById(R.id.editText5);


       final DatasourceDAO dao = new DatasourceDAOImpl(this);
        ListView view =(ListView)findViewById(R.id.listView);

        final List<CustomerInfo>  customerInfo = dao.getCustomerInfo();
        ArrayList list = new ArrayList();

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);

        for(CustomerInfo info : customerInfo)
        {
            list.add(info.getName() + "             " + info.getEmail());

            String log = "Id: " + info.getId() + " ,Name: " + info.getName()+ " ,Surname: " + info.getLastName() + " ,Phone: " + info.getCell_phone() +  " ,Email: " + info.getEmail()+ " ,Address: " + info.getAddress();
           // editText.setText(info.getName());
           // lastName.setText(info.getLastName());
           // email.setText(info.getEmail());
           // personal_home.setText(info.getAddress());
           // cell_num.setText(info.getCell_phone());
            //Toast toast = Toast.makeText(getApplicationContext(), log, duration);
            //toast.show();
            Log.i("Customer" , log);
            adapter.notifyDataSetChanged();
        }
        view.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        Button show = (Button)findViewById(R.id.button);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final List<CustomerInfo>  customerInfo = dao.getCustomerInfo();


                editText = (TextView)findViewById(R.id.editText);
                lastName = (TextView)findViewById(R.id.editText2);
                email = (TextView)findViewById(R.id.editText3);
                personal_home = (TextView)findViewById(R.id.editText4);
                cell_num = (TextView)findViewById(R.id.editText5);


                for(CustomerInfo info : customerInfo) {
                    editText.setText(info.getName());
                    lastName.setText(info.getLastName());
                    email.setText(info.getEmail());
                    personal_home.setText(info.getAddress());
                    cell_num.setText(info.getCell_phone());
                }

            }
        });
        Button exits =(Button)findViewById(R.id.button2);
        exits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
   }
}