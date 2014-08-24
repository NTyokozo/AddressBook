package com.example.project1.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.project1.R;

/**
 * Created by nobubele on 2014/08/21.
 */
public class ViewCustomer extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_customer);

        Button view , insert;

        view =(Button)findViewById(R.id.button);
        insert = (Button) findViewById(R.id.button2);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ViewCustomer.this, MainActivity.class));
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewCustomer.this, DisplayMessageActivity.class));
            }
        });
    }
}