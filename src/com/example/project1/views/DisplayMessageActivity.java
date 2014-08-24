package com.example.project1.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.project1.R;
import com.example.project1.databases.DatasourceDAO;
import com.example.project1.databases.Imp.DatasourceDAOImpl;
import com.example.project1.domain.CustomerInfo;

/**
 * Created by nobubele on 2014/08/14.
 */
public class DisplayMessageActivity extends Activity {

    TextView textView , lastName , email ,personal_home, cell_num;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        final DatasourceDAO dao = new DatasourceDAOImpl(this);
        Button btnSave = (Button)findViewById(R.id.button);
        Button btnCancel =(Button)findViewById(R.id.button2);
       // Button btnView = (Button)findViewById(R.id.button3);



        Bundle extras = getIntent().getExtras();


        String message = extras.getString(MainActivity.EXTRA_MESSAGE);
        String message1 = extras.getString(MainActivity.EXTRA_MESSAGE1);
        String message2 = extras.getString(MainActivity.EXTRA_MESSAGE2);
        String message3 = extras.getString(MainActivity.EXTRA_MESSAGE3);
        String message4 = extras.getString(MainActivity.EXTRA_MESSAGE4);

        textView =(TextView)findViewById(R.id.textView);
        textView.setText(message ) ;
        lastName = (TextView)findViewById(R.id.textView3);
        lastName.setText(message1);
        email = (TextView)findViewById(R.id.textView4);
        email.setText(message2);
        personal_home = (TextView)findViewById(R.id.textView5);
        personal_home.setText(message3);
        cell_num = (TextView)findViewById(R.id.textView6);
        cell_num.setText(message4);

        Context context = getApplicationContext();
        CharSequence text = "Do you want to edit before saving, if not Save";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text,duration);
        toast.show();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CustomerInfo customerInfo = new CustomerInfo();
                customerInfo.setName(textView.getText().toString());
                customerInfo.setLastName(lastName.getText().toString());
                customerInfo.setEmail(email.getText().toString());
                customerInfo.setAddress(personal_home.getText().toString());
                customerInfo.setCell_phone(cell_num.getText().toString());

                dao.createCustomer(customerInfo);

               startActivity(new Intent(DisplayMessageActivity.this , DisplayCusDetails.class ));



            }
        });

      /*  btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CustomerInfo customerInfo = new CustomerInfo();
                Intent display = new Intent(getApplicationContext(), DisplayCusDetails.class);
                display.putExtra("id", customerInfo.getId());
                startActivity(display);
               // startActivity(new Intent(DisplayMessageActivity.this , DisplayCusDetails.class ));
            }
        }); */

       btnCancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               textView.setText(" ");
               lastName.setText(" ");
               email.setText(" ");
               personal_home.setText(" ");
               cell_num.setText(" ");
               startActivity(new Intent(DisplayMessageActivity.this , MainActivity.class ));

           }
       });

    }

}