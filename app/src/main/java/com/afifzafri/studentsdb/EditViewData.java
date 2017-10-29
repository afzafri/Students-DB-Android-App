package com.afifzafri.studentsdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class EditViewData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_view_data);

        Intent intentPage = getIntent();
        String studID = intentPage.getStringExtra("STUD_ID");

        final EditText editStudID = (EditText)findViewById(R.id.editStudID);
        editStudID.setFocusable(false); // disable input
        final EditText editName = (EditText)findViewById(R.id.editName);
        final EditText editIC = (EditText)findViewById(R.id.editIC);
        final EditText editDOB = (EditText)findViewById(R.id.editDOB);
        final EditText editAddress = (EditText)findViewById(R.id.editAddress);
        final EditText editProgram = (EditText)findViewById(R.id.editProgram);
        final EditText editPhone = (EditText)findViewById(R.id.editPhone);
        final EditText editEmail = (EditText)findViewById(R.id.editEmail);

        editStudID.setText(studID);
    }
}
