package com.example.tutorialdua;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class ActivityAutoComplete extends Activity { AutoCompleteTextView autocmplt;

    String[] arr = {"Aditia Got Cha", "Kulsum", "Daffa Ahmad", "Edgard Jeremiah", "Farid", "Felix", "Haidar", "Raihan", "Rakha", "Savero"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.control_autocomplete);

        autocmplt = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>

                (this, android.R.layout.select_dialog_item, arr);

        autocmplt.setThreshold(2);

        autocmplt.setAdapter(adapter);
    }
}

