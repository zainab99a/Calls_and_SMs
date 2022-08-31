package com.zainabali.yz.callssms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
Button send;
Button call;
EditText mobile;
EditText message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send=findViewById(R.id.button);
        call=findViewById(R.id.button2);
        mobile=findViewById(R.id.phone);
        message=findViewById(R.id.messageText);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent i=new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("smsto:"));//يعني تاخذ الحدث الي هو رساله
                    i.setType("vnd.android-dir/mms-sms");
                    i.putExtra("address",new String(mobile.getText().toString()));//تحدد نوع الداتا المحموله
                    i.putExtra("sms_body",new String(message.getText().toString()));
                    startActivity(Intent.createChooser(i,"send sms via:"));

            
                } catch (Exception e) {
                  Toast.makeText(getApplicationContext(),"Error"+ e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });//---------------------------------------------------------------------------------------
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String phoneNo=mobile.getText().toString();
                    Intent callIntent=new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",phoneNo,null));
                    startActivity(callIntent);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Error"+ e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });
    }//onCreate()
}