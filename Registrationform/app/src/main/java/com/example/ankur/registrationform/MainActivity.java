package com.example.ankur.registrationform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
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
                startActivity(intent);
            }
        });


    }
}