package com.afifzafri.studentsdb;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
                // get input text values
                final String id = studID.getText().toString();
                final String names = name.getText().toString();
                final String ics = ic.getText().toString();
                final String dobs = dob.getText().toString();
                final String addr = address.getText().toString();
                final String prog = program.getText().toString();
                final String phones = phone.getText().toString();
                final String emails = email.getText().toString();

                // Create dialog box, ask confirmation before proceed
                AlertDialog.Builder alert = new AlertDialog.Builder(InsertData.this);
                alert.setTitle("Insert");
                alert.setMessage("Are you sure you want to insert data?");
                // set positive button, yes etc
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!checkIsEmpty()) {
                            if (mydb.insertData(id, names, ics, dobs, addr, prog, phones, emails)) {
                                Toast.makeText(getApplicationContext(), "Data save successfully", Toast.LENGTH_SHORT).show();

                                // set text to empty value (clear)
                                studID.setText("");
                                name.setText("");
                                ic.setText("");
                                dob.setText("");
                                address.setText("");
                                program.setText("");
                                phone.setText("");
                                email.setText("");
                            } else {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                // set negative button, no etc
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alert.show(); // show alert message
            }

            // function for text field validation, check if empty or not
            public boolean checkIsEmpty(){
                boolean res = false;
                if(TextUtils.isEmpty(studID.getText()))
                {
                    studID.setError("Student ID cannot be empty.");
                    res = true;
                }
                if(TextUtils.isEmpty(name.getText()))
                {
                    name.setError("Name cannot be empty.");
                    res = true;
                }
                if(TextUtils.isEmpty(ic.getText()))
                {
                    ic.setError("Identification Card number cannot be empty.");
                    res = true;
                }
                if(TextUtils.isEmpty(dob.getText()))
                {
                    dob.setError("Date of Birth cannot be empty.");
                    res = true;
                }
                if(TextUtils.isEmpty(address.getText()))
                {
                    address.setError("Address cannot be empty.");
                    res = true;
                }
                if(TextUtils.isEmpty(program.getText()))
                {
                    program.setError("Program cannot be empty.");
                    res = true;
                }
                if(TextUtils.isEmpty(phone.getText()))
                {
                    phone.setError("Phone number cannot be empty.");
                    res = true;
                }
                if(TextUtils.isEmpty(email.getText()))
                {
                    email.setError("Email address cannot be empty.");
                    res = true;
                }

                return res;
            }
        });


    }
}
