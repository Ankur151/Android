package com.example.ankur.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static android.view.Gravity.CENTER;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast t=Toast.makeText(this,"On Create method started", Toast.LENGTH_SHORT);
        t.setGravity(CENTER,0,0);
        t.show();

    }

    protected void onStart()
    {
    super.onStart();
        Toast t=Toast.makeText(this,"On Start method started", Toast.LENGTH_SHORT);
        t.show();
    }
    protected void onResume()
    {
      super.onResume();
        Toast t=Toast.makeText(this,"On Resume method started", Toast.LENGTH_SHORT);
        t.show();
    }
    protected void onPause()
    {
        super.onPause();
        Toast t=Toast.makeText(this,"On Pause method started", Toast.LENGTH_SHORT);
        t.show();
    }
    protected void onRestart()
    {
        super.onRestart();
        Toast t=Toast.makeText(this,"On Restart method started", Toast.LENGTH_SHORT);
        t.show();
    }
    protected void onStop()
    {
        super.onStop();
        Toast t=Toast.makeText(this,"On Stop method started", Toast.LENGTH_SHORT);
        t.show();
    }
    protected void onDestroy()
    {
        super.onDestroy();
        Toast t=Toast.makeText(this,"On Destroy method started", Toast.LENGTH_SHORT);
        t.show();
    }
}
