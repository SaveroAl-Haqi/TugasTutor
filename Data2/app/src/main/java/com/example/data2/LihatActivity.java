package com.example.data2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LihatActivity extends AppCompatActivity {
    TextView textViewNRP, textViewNama, textViewAlamat;
    Button buttonKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);
        textViewNRP = findViewById(R.id.lihatTextViewNRP);
        textViewNama = findViewById(R.id.lihatTextViewNama);
        textViewAlamat = findViewById(R.id.lihatTextViewAlamat);
        buttonKembali = findViewById(R.id.lihatButtonKembali);

        int nrpMahasiswa = getIntent().getIntExtra("MainNrp", 0);
        MyDB myDB = new MyDB( LihatActivity.this);
        Cursor cursor = myDB.tampilDataMahasiswa(Integer.toString(nrpMahasiswa));

        textViewNRP.setText(cursor.getString(0));
        textViewNama.setText(cursor.getString(0));
        textViewAlamat.setText(cursor.getString(0));
    }

    public void fungsiKembali(View view) {
        Intent intent = new Intent( LihatActivity.this, MainActivity.class);
        startActivity(intent);
        LihatActivity.this.finish();
    }
}
