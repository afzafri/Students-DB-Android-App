package com.afifzafri.studentsdb;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studid = sid.getText().toString();
                Cursor cursor = mydb.searchData(studid);
            }
        });
    }
}
