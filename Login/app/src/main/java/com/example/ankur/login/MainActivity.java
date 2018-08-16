package com.example.ankur.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner myspinner = (Spinner) findViewById(R.id.simpleSpinner);

        ArrayAdapter<CharSequence> myadapter = ArrayAdapter.createFromResource(this,
                R.array.Countries,
                android.R.layout.simple_spinner_item);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myadapter);
        myspinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(this,"You Selected: "+parent.getItemIdAtPosition(position),Toast.LENGTH_LONG).show();

        if(parent.getItemIdAtPosition(position)==0 )
        {
            Spinner spinner = (Spinner) findViewById(R.id.citySpinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.States,
                    android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }
        else
        {
            Spinner spinner1 = (Spinner) findViewById(R.id.citySpinner);
            ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                    R.array.iStates,
                    android.R.layout.simple_spinner_item);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner1.setAdapter(adapter1);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
