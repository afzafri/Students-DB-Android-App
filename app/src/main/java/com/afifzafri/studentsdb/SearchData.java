package com.afifzafri.studentsdb;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SearchData extends AppCompatActivity {

    // initialize object
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);

        mydb = new DBHelper(this);

        final EditText sid = (EditText)findViewById(R.id.editSearch);
        ImageButton btnSearch = (ImageButton)findViewById(R.id.btnSearch);
        ImageButton btnEdit = (ImageButton)findViewById(R.id.btnEdit);
        final TextView resID = (TextView)findViewById(R.id.resStudID);
        final TextView resName = (TextView)findViewById(R.id.resName);
        final TextView resIC = (TextView)findViewById(R.id.resIC);
        final TextView resDOB = (TextView)findViewById(R.id.resDOB);
        final TextView resAddress = (TextView)findViewById(R.id.resAddress);
        final TextView resProgram = (TextView)findViewById(R.id.resProgram);
        final TextView resPhone = (TextView)findViewById(R.id.resPhone);
        final TextView resEmail = (TextView)findViewById(R.id.resEmail);

        // action when search button clicked
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studid = sid.getText().toString();

                // access cursor data
                Cursor cursor = mydb.searchData(studid);
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
                    resID.setText(id);
                    resName.setText(name);
                    resIC.setText(ic);
                    resDOB.setText(dob);
                    resAddress.setText(address);
                    resProgram.setText(program);
                    resPhone.setText(phone);
                    resEmail.setText(email);

                    // show toast message
                    Toast.makeText(getApplicationContext(), "Data found",Toast.LENGTH_SHORT).show();
                }

                // close cursor
                if (!cursor.isClosed())  {
                    cursor.close();
                }
            }
        });

        // action when edit button clicked
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // allow edit only if student id available
                if(resID.getText().toString() != "")
                {

                }
                else
                {
                    // show toast message
                    Toast.makeText(getApplicationContext(), "No data to edit",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
