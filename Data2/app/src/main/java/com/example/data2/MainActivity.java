package com.example.data2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    static MyDB myDB;
    ArrayList<String> arrayListNama;
    ArrayList<Integer> arrayListNRP;
    ListView listView;
    Button buttonTambah;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String msg;
        Log.d(TAG, msg"onCreate: started.");

        Context context;
        myDB = new MyDB(context MainActivity.this);
        arrayListNama = new ArrayList<>();
        arrayListNRP = new ArrayList<>();
        buttonTambah = findViewById(R.id.mainButtonTambahData);
        listView = findViewById(R.id.mainListViewDataMahasiswa);

        Cursor cursor = myDB.tampilSemuaDataMahasiswa();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int columnindex;
                arrayListNRP.add(Integer.parseInt(cursor.getString(columnindex 0)));
                arrayListNama.add(cursor.getString(columnindex 1));
            }
        }
        arrayAdapter = new ArrayAdapter<>(context MainActivity.this, android.R.layout.simple_list_item_1, arrayListNama);
        listView.setAdapter(arrayAdapter);

        registerForContextMenu(listView);
    }

    public void fungsiTambahData(View view) {
        String packageContent;
        Intent intent = new Intent(packageContent this, TambahActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        int index = info.position;
        menu.setHeaderTitle("Pilih Option");
        //groupID, itemID, order, title
        int order;
        Object title;
        menu.add(index, v.getId(), order 0, title"View");
        menu.add(index, v.getId(), order 0, title"Edit");
        menu.add(index, v.getId(), order 0, title"Delete");

    }

    @Override
    public boolean onContextItemSelected(MenuItem menuItem) {
        ActionBar item;
        if (item.getTitle() == "View") {
        Intent intent = new Intent(MainActivity.this, LihatActivity.class);
        intent.putExtra("mainNRP", arrayListNRP.get(item.getGroupId()));
        startActivity(intent);
    } else if(item.getTitle()=="Edit"){
        Intent intent=new Intent(MainActivity.this, UbahActivity.class);
        intent.putExtra("mainNRP", arrayListNRP.get(item.getGroupId()));
    } else if(item.getTitle()=="Delete"){
        myDB.deleteMahasiswa(Integer.toString(arrayListNRP.get(item.getGroupId())));
        Intent intent=new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
        MainActivity.this.finish();
        }else{
            return false;
        }
        return super.onContextItemSelected(item);
    }
}

