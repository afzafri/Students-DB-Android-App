package com.afifzafri.studentsdb;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

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

        // on click listener for when the list is clicked
        listData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView sid = (TextView)view.findViewById(R.id.display_studid); //the 'view' refers to current position of the item
                String studID = sid.getText().toString();

                // new intent, open new activity and pass id val
                // intent to open new activity
                Intent intentPage = new Intent(ViewData.this, SearchData.class);
                intentPage.putExtra("STUD_ID",studID);
                startActivity(intentPage);
            }
        });
    }
}
