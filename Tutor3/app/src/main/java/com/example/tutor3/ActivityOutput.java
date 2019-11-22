package com.example.tutor3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityProses extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proses);
        TextView result=(TextView)findViewById(R.id.vHasil);
        //Mengambil nilai Intent dari activity sebelumnya, yakni Activity1
        Intent intent=getIntent();
        /*Mengambil nilai atribut yang diangkut Intent dari Activity lallu disimpan ke sebuah variable bertipe string dengan nama addition*/
        String addition=(String)intent.getSerializableExtra("jumlah");
        //Mengatur nilai TextField result dengan nilai didalam variable addition
        result.setText(addition);
    }
}
