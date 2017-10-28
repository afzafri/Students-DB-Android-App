package com.afifzafri.studentsdb;

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
        Button btnInsertDataPage = (Button)findViewById(R.id.btnSearchDataPage);
        Button btnViewDataPage = (Button)findViewById(R.id.btnViewDataPage);
        Button btnSearchDataPage = (Button)findViewById(R.id.btnSearchDataPage);

        // open insert data activity page
        btnInsertDataPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // action here
            }
        });

        // open view data activity page
        btnViewDataPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // action here
            }
        });

        // open search data activity page
        btnSearchDataPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // action here
            }
        });
    }
}
