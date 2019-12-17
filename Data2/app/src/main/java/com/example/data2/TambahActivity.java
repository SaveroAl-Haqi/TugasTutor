package com.example.data2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

class TambahActivity extends AppCompatActivity {
    EditText editTextNRP, editTextNama, editTextAlamat;
    Button buttonSimpan,  buttonKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        editTextNRP = findViewById(R.id.tambahEditTextNRP);
        editTextNama = findViewById(R.id.tambahEditTextNama);
        editTextAlamat = findViewById(R.id.tambahEditTextAlamat);
        buttonSimpan = findViewById(R.id.tambahButtonSimpan);
                buttonKembali = findViewById(R.id.tambahButtonKembali);
    }

    public void fungsiKembali(View view) {
        Intent intent = new Intent(TambahActivity.this, MainActivity.class);
        startActivity(intent);
        TambahActivity.this.finish();
    }

    public void fungsiSimpan(View view) {
        try{
            boolean result = MainActivity.myDB.insertData(
                    Integer.parseInt(editTextNRP.getText().toString().trim()),
                    editTextNama.getText().toString().trim(),
                    editTextNama.getText().toString().trim());
            if (result) {
                Intent intent = new Intent(TambahActivity.this, MainActivity.class);
                startActivity(intent);
                TambahActivity.this.finish();

            }
        }catch (Exception err) {
            Toast.makeText(getApplicationContext(),
                    "Mohon diisi semua data",
                    Toast.LENGTH_LONG).show();
        }


    }
}
