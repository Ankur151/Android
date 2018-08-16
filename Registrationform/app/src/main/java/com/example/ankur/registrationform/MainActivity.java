package com.example.ankur.registrationform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.util.*;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
SharedPreferences sharedPreferences;
TextView Email;
TextView Password;
DatabaseHelper mDatabaseHelper;
private Button btnAdd,btnViewData;
private EditText editText;

public static final String mypreference="mypref";
public static final String email="emailkey";
public static final String phone="phonekey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Email=(TextView)findViewById(R.id.editText7);
        Password=(TextView)findViewById(R.id.editText5);
        sharedPreferences=getSharedPreferences(mypreference,MODE_PRIVATE);

        if(sharedPreferences.contains(email)){
            Email.setText(sharedPreferences.getString(email,""));
        }

        if(sharedPreferences.contains(phone)){
            Password.setText(sharedPreferences.getString(phone,""));
        }


        Spinner myspinner = (Spinner) findViewById(R.id.simpleSpinner);
        ArrayAdapter<CharSequence> myadapter = ArrayAdapter.createFromResource(this,
                R.array.mynames,
                android.R.layout.simple_spinner_item);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myadapter);

        Button proceed = findViewById(R.id.button);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Signin.class);
                intent.putExtra("username",Email.getText().toString());
                intent.putExtra("password",Password.getText().toString());
                startActivity(intent);
            }
        });


    }

    public void Save(View view) {
        String n=Email.getText().toString();
        String e=Password.getText().toString();

        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(email, n);
        editor.putString(phone,e);
        editor.commit();
    }

}