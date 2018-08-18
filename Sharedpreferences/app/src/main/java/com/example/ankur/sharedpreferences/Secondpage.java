package com.example.ankur.sharedpreferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Secondpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        String string=sharedPreferences.getString("Name",null);
        String string1=sharedPreferences.getString("Email",null);

        TextView textView=findViewById(R.id.name1);
        textView.setText(string);

        TextView textView1=findViewById(R.id.email1);
        textView1.setText(string1);

    }
}
