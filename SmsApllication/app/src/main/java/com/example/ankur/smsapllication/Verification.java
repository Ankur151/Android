package com.example.ankur.smsapllication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Verification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

    }

    public void Verify(View view) {

        String string=getIntent().getExtras().getString("Random_OTP");
        Toast.makeText(this,string,Toast.LENGTH_LONG).show();
        EditText editText=findViewById(R.id.otp);
        String string1=editText.getText().toString();
        if(string.equalsIgnoreCase(string1)){
            Toast.makeText(this,"Verified",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"OTP not verified!",Toast.LENGTH_SHORT).show();
        }
    }
}
