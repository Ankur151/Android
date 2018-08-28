package com.example.ankur.smsapllication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    String smsMessage;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==MY_PERMISSIONS_REQUEST_SEND_SMS){
            if(grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
                sms();

            }
            else
            {
                Toast.makeText(this,"Think Again",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.send);
    }


    public void sms()
    {
        Intent intent1=new Intent(this,Verification.class);
        EditText editText=findViewById(R.id.number);
        String destinationAddress = editText.getText().toString();
        Otp otp=new Otp();
        smsMessage =otp.getOTP();
        intent1.putExtra("Random_OTP",smsMessage);
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(destinationAddress, null, smsMessage, null, null);
        startActivity(intent1);
    }

    public void OTP(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);

        } else {
            sms();
        }
    }
}
