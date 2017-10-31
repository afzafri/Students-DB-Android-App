package com.afifzafri.studentsdb;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
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

        // get intent and data passed
        Intent intentPage = getIntent();
        String intstudID = intentPage.getStringExtra("STUD_ID");

        final EditText sid = (EditText)findViewById(R.id.editSearch);
        ImageButton btnSearch = (ImageButton)findViewById(R.id.btnSearch);
        final ImageButton btnCall = (ImageButton)findViewById(R.id.btnCall);
        final ImageButton btnMsg = (ImageButton)findViewById(R.id.btnMsg);
        final ImageButton btnEmail = (ImageButton)findViewById(R.id.btnEmail);
        final ImageButton btnMap = (ImageButton)findViewById(R.id.btnMap);
        final ImageButton btnEdit = (ImageButton)findViewById(R.id.btnEdit);
        final TextView resID = (TextView)findViewById(R.id.resStudID);
        final TextView resName = (TextView)findViewById(R.id.resName);
        final TextView resIC = (TextView)findViewById(R.id.resIC);
        final TextView resDOB = (TextView)findViewById(R.id.resDOB);
        final TextView resAddress = (TextView)findViewById(R.id.resAddress);
        final TextView resProgram = (TextView)findViewById(R.id.resProgram);
        final TextView resPhone = (TextView)findViewById(R.id.resPhone);
        final TextView resEmail = (TextView)findViewById(R.id.resEmail);

        // hide buttons
        btnEdit.setVisibility(View.GONE);
        btnCall.setVisibility(View.GONE);
        btnMsg.setVisibility(View.GONE);
        btnEmail.setVisibility(View.GONE);
        btnMap.setVisibility(View.GONE);

        // check if intent send an id value, populate the result
        if(intstudID != null)
        {
            // if come from view data activity, hide the search
            sid.setVisibility(View.GONE);
            btnSearch.setVisibility(View.GONE);

            // access cursor data
            Cursor cursor = mydb.searchData(intstudID);
            cursor.moveToFirst();

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

            // show buttons
            btnEdit.setVisibility(View.VISIBLE);
            btnCall.setVisibility(View.VISIBLE);
            btnMsg.setVisibility(View.VISIBLE);
            btnEmail.setVisibility(View.VISIBLE);
            btnMap.setVisibility(View.VISIBLE);

            // show toast message
            Toast.makeText(getApplicationContext(), "Data found",Toast.LENGTH_SHORT).show();

            // close cursor
            if (!cursor.isClosed())  {
                cursor.close();
            }
        }

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
                    // empty all result
                    resID.setText("");
                    resName.setText("");
                    resIC.setText("");
                    resDOB.setText("");
                    resAddress.setText("");
                    resProgram.setText("");
                    resPhone.setText("");
                    resEmail.setText("");

                    // hide edit button
                    btnEdit.setVisibility(View.GONE);
                    btnCall.setVisibility(View.GONE);
                    btnMsg.setVisibility(View.GONE);
                    btnEmail.setVisibility(View.GONE);
                    btnMap.setVisibility(View.GONE);
                    
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

                    // show buttons
                    btnEdit.setVisibility(View.VISIBLE);
                    btnCall.setVisibility(View.VISIBLE);
                    btnMsg.setVisibility(View.VISIBLE);
                    btnEmail.setVisibility(View.VISIBLE);
                    btnMap.setVisibility(View.VISIBLE);

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
                String resStudID = resID.getText().toString();
                // allow edit only if student id available
                if(resStudID != "")
                {
                    // intent to open new activity
                    Intent intentPage = new Intent(SearchData.this, EditViewData.class);
                    intentPage.putExtra("STUD_ID",resStudID);
                    startActivity(intentPage);
                }
                else
                {
                    // show toast message
                    Toast.makeText(getApplicationContext(), "No data to edit",Toast.LENGTH_SHORT).show();
                }
            }
        });

        // open dialer when call button clicked
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPage = new Intent(Intent.ACTION_DIAL);
                intentPage.setData(Uri.parse("tel:"+resPhone.getText().toString()));
                startActivity(intentPage);
            }
        });

        // open messaging app (default or whatsapp, user can choose)
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:" + resPhone.getText().toString());
                Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(Intent.createChooser(i, ""));
            }
        });

        // open email app
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("mailto:" + resEmail.getText().toString());
                Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(Intent.createChooser(i, ""));
            }
        });

        // launch Google Map and search the address
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+resAddress.getText().toString());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

    }
}
