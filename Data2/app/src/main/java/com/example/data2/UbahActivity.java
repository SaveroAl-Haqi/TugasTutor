package com.example.data2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UbahActivity extends AppCompatActivity {
    EditText editTextNRP, editTextNama, editTextAlamat;
    Button buttonUbah, buttonKembali;

    @Override
    protected void  onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.activity_ubah);
        editTextNRP = findViewById(R.id.ubahEditTextNRP);
        editTextNama = findViewById(R.id.ubahEditTextNama);
        editTextAlamat = findViewById(R.id.ubahEditTextAlamat);
        buttonUbah = findViewById(R.id.ubahButtonUbah);

        int nrpMahasiswa = getIntent().getIntExtra("MainNrp", 0);
        MyDB myDB = new MyDB( UbahActivity.this);
        Cursor cursor = myDB.tampilDataMahasiswa(Integer.toString(nrpMahasiswa));

        editTextNRP.setText(cursor.getString(0));
        editTextNama.setText(cursor.getString(0));
        editTextAlamat.setText(cursor.getString(0));
        String nrpLama = cursor.getString(0);
    }
    public void fungsiUbah(View view){
        try{
            boolean result = MainActivity.myDB.insertData(
                    Integer.parseInt(editTextNRP.getText().toString().trim()),
                    editTextNRP.getText().toString().trim(),
                    editTextNama.getText().toString().trim());
            editTextAlamat.getText().toString().trim();
            if (result) {
                Intent intent = new Intent(UbahActivity.this, MainActivity.class);
                startActivity(intent);
                UbahActivity.this.finish();

            }
        }catch (Exception err) {
            err.printStackTrace();
            Toast.makeText(getApplicationContext(),
                    "Mohon diisi semua data",
                    Toast.LENGTH_LONG).show();
        }

    }
    public void fungsiKembali(View view){
        Intent intent = new Intent(UbahActivity.this, MainActivity.class);
        startActivity(intent);
        UbahActivity.this.finish();

    }
}
