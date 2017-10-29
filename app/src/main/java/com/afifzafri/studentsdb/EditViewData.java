package com.afifzafri.studentsdb;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditViewData extends AppCompatActivity {

    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_view_data);

        // initialize object
        mydb = new DBHelper(this);

        // get intent and data passed
        Intent intentPage = getIntent();
        String studID = intentPage.getStringExtra("STUD_ID");

        // initialize input
        final EditText editStudID = (EditText)findViewById(R.id.editStudID);
        editStudID.setFocusable(false); // disable input
        final EditText editName = (EditText)findViewById(R.id.editName);
        final EditText editIC = (EditText)findViewById(R.id.editIC);
        final EditText editDOB = (EditText)findViewById(R.id.editDOB);
        final EditText editAddress = (EditText)findViewById(R.id.editAddress);
        final EditText editProgram = (EditText)findViewById(R.id.editProgram);
        final EditText editPhone = (EditText)findViewById(R.id.editPhone);
        final EditText editEmail = (EditText)findViewById(R.id.editEmail);
        Button btnUpdate = (Button)findViewById(R.id.btnUpdate);
        Button btnDelete = (Button)findViewById(R.id.btnDelete);

        Cursor cursor = mydb.searchData(studID);
        cursor.moveToFirst();

        // check if cursor return data or not (data found in db or not)
        if(cursor.getCount() < 1)
        {
            // show toast message
            Toast.makeText(getApplicationContext(), "No data found",Toast.LENGTH_SHORT).show();
        }
        else
        {
            String id = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME));
            String ic = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_IC));
            String dob = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DOB));
            String address = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ADDRESS));
            String program = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_PROGRAM));
            String phone = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_PHONE));
            String email = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_EMAIL));

            //append all the data
            editStudID.setText(id);
            editName.setText(name);
            editIC.setText(ic);
            editDOB.setText(dob);
            editAddress.setText(address);
            editProgram.setText(program);
            editPhone.setText(phone);
            editEmail.setText(email);

            // show toast message
            Toast.makeText(getApplicationContext(), "Data found",Toast.LENGTH_SHORT).show();
        }

        // close cursor
        if (!cursor.isClosed())  {
            cursor.close();
        }

        // action when update button clicked
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get input text values
                String id = editStudID.getText().toString();
                String names = editName.getText().toString();
                String ics = editIC.getText().toString();
                String dobs = editDOB.getText().toString();
                String addr = editAddress.getText().toString();
                String prog = editProgram.getText().toString();
                String phones = editPhone.getText().toString();
                String emails = editEmail.getText().toString();

                if(mydb.updateData(id,names,ics,dobs,addr,prog,phones,emails))
                {
                    Toast.makeText(getApplicationContext(), "Data updated successfully",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // action when delete button clicked
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editStudID.getText().toString(); // get id
                if(mydb.deleteData(id))
                {
                    Toast.makeText(getApplicationContext(), "Data deleted successfully",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
