package com.example.tutorialdua;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ActivityEditText extends Activity { EditText eText; Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.control_edittext);

        eText = (EditText) findViewById(R.id.etxId);
        btn = (Button) findViewById(R.id.btnId);

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String str = eText.getText().toString();

                Toast msg = Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG);
                msg.show();
            }
        });
    }
}


