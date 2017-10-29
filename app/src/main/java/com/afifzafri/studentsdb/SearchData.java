package com.afifzafri.studentsdb;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        EditText sid = (EditText)findViewById(R.id.editSearch);
        Button btnSearch = (Button)findViewById(R.id.btnSearch);
        TextView resID = (TextView)findViewById(R.id.resStudID);
        TextView resName = (TextView)findViewById(R.id.resName);
        TextView resIC = (TextView)findViewById(R.id.resIC);
        TextView resDOB = (TextView)findViewById(R.id.resDOB);
        TextView resAddress = (TextView)findViewById(R.id.resAddress);
        TextView resProgram = (TextView)findViewById(R.id.resProgram);
        TextView resPhone = (TextView)findViewById(R.id.resPhone);
        TextView resEmail = (TextView)findViewById(R.id.resEmail);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studid = sid.getText().toString();
                Cursor cursor = mydb.searchData(studid);
            }
        });
    }
}
