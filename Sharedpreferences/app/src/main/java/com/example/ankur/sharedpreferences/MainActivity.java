package com.example.ankur.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView=findViewById(R.id.name1);
        final TextView textView1=findViewById(R.id.email);

        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor=sharedPreferences.edit();

        Spinner myspinner = (Spinner) findViewById(R.id.simpleSpinner);
        ArrayAdapter<CharSequence> myadapter = ArrayAdapter.createFromResource(this,
                R.array.mynames,
                android.R.layout.simple_spinner_item);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myadapter);

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=textView.getText().toString();
                editor.putString("Name",string);
                String string1=textView1.getText().toString();
                editor.putString("Email",string1);
                editor.commit();
                Intent intent=new Intent(MainActivity.this,Secondpage.class);
                startActivity(intent);
            }
        });
    }
}
