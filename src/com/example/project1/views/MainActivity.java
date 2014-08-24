package com.example.project1.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.project1.R;

/**
 * Created by nobubele on 2014/08/14.
 */
public class MainActivity extends Activity implements View.OnClickListener{

    TextView textView;
    Button mainButton;
    EditText editText;
    EditText editText1;
    EditText editText2;
    EditText editText3 , editText4;
    String message;
    String message1;
    String message2;
    String message3;
    String message4;



    public final static String EXTRA_MESSAGE = "yeah right";
    public final static String EXTRA_MESSAGE1 = "right";
    public final static String EXTRA_MESSAGE2 = "rights";
    public final static String EXTRA_MESSAGE3 = "okay";
    public final static String EXTRA_MESSAGE4 = "okays";


    @Override

    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mainButton = (Button)findViewById(R.id.button);
        mainButton.setOnClickListener(this);




    }
    public void onClick(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        editText = (EditText)findViewById(R.id.editText);
        editText1 =(EditText)findViewById(R.id.editText2);
        editText2 =(EditText)findViewById(R.id.editText3);
        editText3 =(EditText)findViewById(R.id.editText4);
        editText4 = (EditText)findViewById(R.id.editText5);


        Bundle extras = new Bundle();

         message = editText.getText().toString();
         message1 = editText1.getText().toString();
         message2 = editText2.getText().toString();
         message3 = editText3.getText().toString();
         message4 = editText4.getText().toString();

        extras.putString(EXTRA_MESSAGE , message);
        extras.putString(EXTRA_MESSAGE1 , message1);
        extras.putString(EXTRA_MESSAGE2 , message2);
        extras.putString(EXTRA_MESSAGE3 , message3);
        extras.putString(EXTRA_MESSAGE4, message4);

        intent.putExtras(extras);
        startActivity(intent);

    }


}