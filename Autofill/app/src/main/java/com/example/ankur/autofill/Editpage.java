package com.example.ankur.autofill;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Editpage extends AppCompatActivity {
private String name;
    private String email;
    private String password;
    private String country;
    private String state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editpage);

        TextView textView=findViewById(R.id.textView8);
        TextView textView1=findViewById(R.id.textView9);
        TextView textView2=findViewById(R.id.textView10);
        TextView textView3=findViewById(R.id.textView11);
        TextView textView4=findViewById(R.id.textView12);

        name = getIntent().getExtras().getString("Name");
        email = getIntent().getExtras().getString("Email");
        password = getIntent().getExtras().getString("Password");
        country = getIntent().getExtras().getString("Country");
        state = getIntent().getExtras().getString("State");

        textView.setText(name);
        textView1.setText(email);
        textView2.setText(password);
        textView3.setText(country);
        textView4.setText(state);

        Button button=findViewById(R.id.edit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Editpage.this,Finalpage.class);
                intent.putExtra("Name",name);
                intent.putExtra("Email",email);
                intent.putExtra("Password",password);
                intent.putExtra("Country",country);
                intent.putExtra("State",state);
                startActivity(intent);
            }
        });
    }
}
