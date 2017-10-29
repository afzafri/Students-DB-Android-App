package com.afifzafri.studentsdb;

import android.app.ListActivity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ViewData extends ListActivity {

    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        // initialize object
        mydb = new DBHelper(this);

        Cursor cursor = mydb.listAllData(); // get data from db

        String[] fromColumns = {DBHelper.COLUMN_NAME, DBHelper.COLUMN_ID};
        int[] toViews = {R.id.display_name, R.id.display_studid};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.studid_name_layout, cursor, fromColumns, toViews, 0);
        ListView listdata = getListView();
        listdata.setAdapter(adapter);
    }
}
