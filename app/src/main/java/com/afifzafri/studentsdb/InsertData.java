package com.afifzafri.studentsdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class InsertData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        // initialize input fields
        EditText studID = (EditText)findViewById(R.id.editStudID);
        EditText name = (EditText)findViewById(R.id.editName);
        EditText ic = (EditText)findViewById(R.id.editIC);
        EditText dob = (EditText)findViewById(R.id.editDOB);
        EditText address = (EditText)findViewById(R.id.editAddress);
        EditText program = (EditText)findViewById(R.id.editProgram);
        EditText phone = (EditText)findViewById(R.id.editPhone);
        EditText email = (EditText)findViewById(R.id.editEmail);


    }
}
