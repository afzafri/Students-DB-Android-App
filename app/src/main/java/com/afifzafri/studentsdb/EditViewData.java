package com.afifzafri.studentsdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditViewData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_view_data);

        Intent intentPage = getIntent();
        String studID = intentPage.getStringExtra("STUD_ID");

        EditText editStudID = (EditText)findViewById(R.id.editStudID);
        editStudID.setFocusable(false); // disable input

        editStudID.setText(studID);
    }
}
