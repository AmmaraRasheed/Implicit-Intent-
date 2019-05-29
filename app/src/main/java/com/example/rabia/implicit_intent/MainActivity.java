package com.example.rabia.implicit_intent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void email(View view) {
        Intent intent=new Intent(this,Email.class);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void phone(View view) {
        Uri number = Uri.parse("tel: 03335639103");
        Intent intent = new Intent(Intent.ACTION_CALL, number);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},0);
            return;
        }
        startActivity(intent);
    }
    public  void dial(View view){
        Uri number=Uri.parse("tel: 03335639103");
        Intent intent=new Intent(Intent.ACTION_DIAL,number);
        startActivity(intent);

    }
    public  void website(View view){
        Uri website=Uri.parse("https://arprogramming.blogspot.com/");
        Intent intent=new Intent(Intent.ACTION_VIEW,website);
        startActivity(intent);
    }
}
