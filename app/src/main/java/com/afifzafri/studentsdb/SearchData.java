package com.afifzafri.studentsdb;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

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
        final TextView resID = (TextView)findViewById(R.id.resStudID);
        final TextView resName = (TextView)findViewById(R.id.resName);
        final TextView resIC = (TextView)findViewById(R.id.resIC);
        final TextView resDOB = (TextView)findViewById(R.id.resDOB);
        final TextView resAddress = (TextView)findViewById(R.id.resAddress);
        final TextView resProgram = (TextView)findViewById(R.id.resProgram);
        final TextView resPhone = (TextView)findViewById(R.id.resPhone);
        final TextView resEmail = (TextView)findViewById(R.id.resEmail);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studid = sid.getText().toString();

                // access cursor data
                Cursor cursor = mydb.searchData(studid);
                cursor.moveToFirst();
                String name = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME));

                // close cursor
                if (!cursor.isClosed())  {
                    cursor.close();
                }

                resName.setText(name);
            }
        });
    }
}
