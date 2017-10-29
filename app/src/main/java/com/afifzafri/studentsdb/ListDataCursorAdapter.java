package com.afifzafri.studentsdb;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Afif on 29/10/2017.
 */

// custom adapter thanks to https://github.com/codepath/android_guides/wiki/Populating-a-ListView-with-a-CursorAdapter
public class ListDataCursorAdapter extends CursorAdapter {
    public ListDataCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.studid_name_layout, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView display_name = (TextView) view.findViewById(R.id.display_name);
        TextView display_studid = (TextView) view.findViewById(R.id.display_studid);
        // Extract properties from cursor
        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String id = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        // Populate fields with extracted properties
        display_name.setText(name);
        display_studid.setText(id);
    }
}