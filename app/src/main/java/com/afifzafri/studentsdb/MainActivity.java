package com.afifzafri.studentsdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the buttons
        Button btnInsertDataPage = (Button)findViewById(R.id.btnInsertDataPage);
        Button btnViewDataPage = (Button)findViewById(R.id.btnViewDataPage);
        Button btnSearchDataPage = (Button)findViewById(R.id.btnSearchDataPage);

        // open insert data activity page
        btnInsertDataPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start new intent, for opening activity
                Intent intentPage = new Intent(MainActivity.this, InsertData.class);
                startActivity(intentPage);
            }
        });

        // open view data activity page
        btnViewDataPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPage = new Intent(MainActivity.this, ViewData.class);
                startActivity(intentPage);
            }
        });

        // open search data activity page
        btnSearchDataPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPage = new Intent(MainActivity.this, SearchData.class);
                startActivity(intentPage);
            }
        });
    }
}
