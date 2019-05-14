package com.example.trainingsqli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    dataBaseHelper db;
    EditText e1, e2, e3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= new dataBaseHelper(this);
        e1=(EditText)findViewById(R.id.mail);
        e2=(EditText)findViewById(R.id.pass);
        e3=(EditText)findViewById(R.id.rpass);
        b1=(Button) findViewById(R.id.btn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if ( s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Textboxs are empty !",Toast.LENGTH_SHORT).show();
                }else{
                    if ( s2.equals(s3)){
                        Boolean chkMail = db.chkMail(s1);
                        if ( chkMail==true){
                            Boolean insert = db.insert(s1,s2);
                            if ( insert==true){
                                Toast.makeText(getApplicationContext(),"Regesterd Successfully :) ",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Email is exists :(",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"PAssword not match :(",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
