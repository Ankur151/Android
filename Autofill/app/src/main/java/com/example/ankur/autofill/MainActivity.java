package com.example.ankur.autofill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
public     String name;
    public String email;
    public String password;
    TextView autoCompleteText;
    TextView autoCompleteText1;
    TextView autoCompleteText2;

    public String country;
    public String state;
    Spinner myspinner;
    Spinner spinner1;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        myspinner = (Spinner) findViewById(R.id.simpleSpinner);
        ArrayAdapter<CharSequence> myadapter = ArrayAdapter.createFromResource(this,
                R.array.Countries,
                android.R.layout.simple_spinner_item);

        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myadapter);
        myspinner.setOnItemSelectedListener(this);



//                    Toast.makeText(MainActivity.this," "+name,Toast.LENGTH_LONG).show();

        autoCompleteText=findViewById(R.id.name);
        autoCompleteText1=findViewById(R.id.email);
        autoCompleteText2=findViewById(R.id.password);


        Button button = (Button)findViewById(R.id.proceed);
        button.setOnClickListener(namelistner);
    }

    private View.OnClickListener namelistner=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            name=autoCompleteText.getText().toString();
            email= autoCompleteText1.getText().toString();
            password= autoCompleteText2.getText().toString();


            Intent intent=new Intent(MainActivity.this,Editpage.class);

            intent.putExtra("Name",name);
            intent.putExtra("Email",email);
            intent.putExtra("Password",password);
            intent.putExtra("Country",country);
            intent.putExtra("State",state);


            startActivity(intent);
        }

    };

    @Override
    public void onItemSelected (AdapterView<?> parent, View view, int position, long id) {


        if(parent.getItemIdAtPosition(position)==0 )
        {
            spinner = (Spinner) findViewById(R.id.citySpinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.States,
                    android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            myspinner = (Spinner) findViewById(R.id.simpleSpinner);
            country=myspinner.getSelectedItem().toString();

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               state=spinner.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
        else
        {
            spinner1 = (Spinner) findViewById(R.id.citySpinner);
            ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                    R.array.iStates,
                    android.R.layout.simple_spinner_item);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            state=spinner1.getItemAtPosition(position).toString();
            spinner1.setAdapter(adapter1);
            myspinner = (Spinner) findViewById(R.id.simpleSpinner);
            country=myspinner.getSelectedItem().toString();

            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               state=spinner1.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });


        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
