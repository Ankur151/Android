package com.example.ankur.registrationform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static android.view.Gravity.CENTER;

public class Signin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void Display(View view) {
        Toast t1=Toast.makeText(this,"Page Under Maintenance",Toast.LENGTH_LONG);
        t1.setGravity(CENTER,0,0);
        t1.show();

    }
}
