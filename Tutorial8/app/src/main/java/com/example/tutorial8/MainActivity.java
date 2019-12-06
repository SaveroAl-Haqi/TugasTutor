package com.example.tutorial8;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
}

    // Fungsi open ketkka user menyentuh tombol
    public void open(View view) {
// Membuat Objek AlertDialog
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
// Mengatur pesan alert
        alertDialogBuilder.setMessage("Are you sure, You wanted to make decision");
// Mengatur text dan respon untuk tombol YES
        alertDialogBuilder.setPositiveButton("yes",
                new DialogInterface.OnClickListener() {
            @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(MainActivity.this, "You clicked yes button", Toast.LENGTH_LONG).show();
                }
                });
// Mengatur text dan respon untuk tombol NO
        alertDialogBuilder.setNegativeButton("No", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { finish();
                    }
                });
// Membuat alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
// Menampilkan alert dialog
        alertDialog.show();
    }
}
