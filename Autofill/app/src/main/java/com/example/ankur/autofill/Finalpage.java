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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class Finalpage extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    ArrayList<String> Name= new ArrayList<String>();
    ArrayList<String> Email= new ArrayList<String>();
    ArrayList<String> Password= new ArrayList<String>();
    public String name;
    private String email;
    private String password;
    private String country;
    private String state;
    AutoCompleteTextView autoCompleteText;
    AutoCompleteTextView autoCompleteText1;
    AutoCompleteTextView autoCompleteText2;
    Spinner spinner;
    Spinner myspinner;
    Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpage);

        Name.add(getIntent().getExtras().getString("Name"));
        Email.add(getIntent().getExtras().getString("Email"));
        Password.add(getIntent().getExtras().getString("Passoword"));

         autoCompleteText=findViewById(R.id.name1);
         autoCompleteText1=findViewById(R.id.email1);
         autoCompleteText2=findViewById(R.id.password1);

        Spinner myspinner = (Spinner) findViewById(R.id.simpleSpinner);
        ArrayAdapter<CharSequence> myadapter = ArrayAdapter.createFromResource(this,
                R.array.Countries,
                android.R.layout.simple_spinner_item);

        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myadapter);
        myspinner.setOnItemSelectedListener(this);
        country=myspinner.getSelectedItem().toString();





        ArrayAdapter<String> autocomplete=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,Name);
        AutoCompleteTextView autoCompleteTextView=findViewById(R.id.name1);
        autoCompleteTextView.setThreshold(0);
        autoCompleteTextView.setAdapter(autocomplete);




        ArrayAdapter<String> autocomplete1=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,Email);
        AutoCompleteTextView autoCompleteTextView1=findViewById(R.id.email1);
        autoCompleteTextView1.setThreshold(0);
        autoCompleteTextView1.setAdapter(autocomplete1);


        ArrayAdapter<String> autocomplete2=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,Password);
        AutoCompleteTextView autoCompleteTextView2=findViewById(R.id.password1);
        autoCompleteTextView2.setThreshold(0);
        autoCompleteTextView2.setAdapter(autocomplete2);




        Button button = (Button)findViewById(R.id.proceed);
        button.setOnClickListener(namelistner);

    }
    private View.OnClickListener namelistner=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            name=autoCompleteText.getText().toString();
            email=autoCompleteText1.getText().toString();
            password=autoCompleteText2.getText().toString();

            Intent intent=new Intent(Finalpage.this,Editpage.class);
            intent.putExtra("Name",name);
            intent.putExtra("Email",email);
            intent.putExtra("Password",password);
            intent.putExtra("Country",country);
            intent.putExtra("State",state);
//            Toast.makeText(Finalpage.this,name,Toast.LENGTH_LONG).show();
            startActivity(intent);
        }

    };

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(this,"You Selected: "+parent.getItemIdAtPosition(position),Toast.LENGTH_LONG).show();


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
