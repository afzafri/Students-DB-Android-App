package com.afifzafri.studentsdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertData extends AppCompatActivity {

    // create object for Database Helper class
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        // create object
        mydb = new DBHelper(this);

        // initialize input fields and buttons
        final EditText studID = (EditText)findViewById(R.id.editStudID);
        final EditText name = (EditText)findViewById(R.id.editName);
        final EditText ic = (EditText)findViewById(R.id.editIC);
        final EditText dob = (EditText)findViewById(R.id.editDOB);
        final EditText address = (EditText)findViewById(R.id.editAddress);
        final EditText program = (EditText)findViewById(R.id.editProgram);
        final EditText phone = (EditText)findViewById(R.id.editPhone);
        final EditText email = (EditText)findViewById(R.id.editEmail);
        Button btnClear = (Button)findViewById(R.id.btnClear);
        Button btnSave = (Button)findViewById(R.id.btnSave);

        // button on click action
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set text to empty value (clear)
                studID.setText("");
                name.setText("");
                ic.setText("");
                dob.setText("");
                address.setText("");
                program.setText("");
                phone.setText("");
                email.setText("");

                // show toast message
                Toast.makeText(getApplicationContext(), "Cleared",Toast.LENGTH_SHORT).show();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // action here
            }
        });


    }
}
