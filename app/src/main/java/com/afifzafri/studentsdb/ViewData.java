package com.afifzafri.studentsdb;

import android.app.ListActivity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ViewData extends AppCompatActivity {

    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        // initialize object
        mydb = new DBHelper(this);

        Cursor cursor = mydb.listAllData(); // get data from db

        // Find ListView to populate
        ListView listData = (ListView) findViewById(R.id.listData);
        // Setup cursor adapter, pass the cursor
        ListDataCursorAdapter listdataAdapter = new ListDataCursorAdapter(this, cursor);
        // Attach cursor adapter to the ListView
        listData.setAdapter(listdataAdapter);
    }
}
