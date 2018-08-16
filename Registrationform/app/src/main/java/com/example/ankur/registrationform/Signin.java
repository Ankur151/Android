package com.example.ankur.registrationform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.Gravity.CENTER;

public class Signin extends AppCompatActivity {
TextView textView;
TextView textView1;
//static int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        textView=findViewById(R.id.editText3);
        textView1=findViewById(R.id.editText8);
//        textView.setText(getIntent().getExtras().getString("username"));
//        textView1.setText(getIntent().getExtras().getString("password"));

//        SharedPreferences sharedPreferences=getSharedPreferences("mypref",MODE_PRIVATE);
//        String str=sharedPreferences.getString("emailkey", "");
//        String str1=sharedPreferences.getString("phonekey","");
//        textView.setText(str);
//        textView1.setText(str1);

//        String str2=textView.getText().toString();
//        String str3=textView1.getText().toString();
//         if(str==str2){
//             Toast toast= Toast.makeText(this,"Sucessful",Toast.LENGTH_SHORT);
//             toast.show();
//
//         }
//         else{
//             Toast toast= Toast.makeText(this,"UnSucessful",Toast.LENGTH_SHORT);
//             toast.show();
//         }
    }

    public void check(View view) {
        SharedPreferences sharedPreferences=getSharedPreferences("mypref",MODE_PRIVATE);
        String str=sharedPreferences.getString("emailkey", "");
        String str1=sharedPreferences.getString("phonekey","");

        String str2=textView.getText().toString();
        String str3=textView1.getText().toString();

        Toast toast= Toast.makeText(this,str,Toast.LENGTH_SHORT);
            toast.show();

        Toast toast1= Toast.makeText(this,str1,Toast.LENGTH_SHORT);
        toast1.setGravity(CENTER,0,0);
        toast1.show();


        Toast toast2= Toast.makeText(this,str2,Toast.LENGTH_SHORT);
        toast2.show();

        Toast toast3= Toast.makeText(this,str3,Toast.LENGTH_SHORT);
        toast3.setGravity(CENTER,0,0);
        toast3.show();

//        if(str==str2){
//            Toast toast= Toast.makeText(this,"Sucessful",Toast.LENGTH_SHORT);
//            toast.show();
//
//        }
//        else{
//            Toast toast= Toast.makeText(this,"UnSucessful",Toast.LENGTH_SHORT);
//            toast.show();
//        }
    }
}
