package com.example.rabia.implicit_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Email extends AppCompatActivity {
    private EditText to,compose,subject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        to=findViewById(R.id.to);
        compose=findViewById(R.id.compose);
        subject=findViewById(R.id.subject);
    }
    public void SendEmail(View view){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String email=to.getText().toString();
        String[] array={email};
        intent.putExtra(Intent.EXTRA_EMAIL,array);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT,compose.getText().toString());
        Intent chooser=Intent.createChooser(intent,"Chosse Options");
        startActivity(chooser);

    }
}
