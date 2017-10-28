package com.afifzafri.studentsdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Afif on 28/10/2017.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "StudentsDB.db";
    public static final String TABLE_NAME = "students";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_IC = "ic";
    public static final String COLUMN_DOB = "dob";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_PROGRAM = "program";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table " + TABLE_NAME +
                        " ("+COLUMN_ID+" text primary key, "
                        +COLUMN_NAME+ " text,"
                        +COLUMN_IC+" text,"
                        +COLUMN_DOB+" text,"
                        +COLUMN_ADDRESS+" text,"
                        +COLUMN_PROGRAM+" text,"
                        +COLUMN_PHONE+" text,"
                        +COLUMN_EMAIL+" text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
