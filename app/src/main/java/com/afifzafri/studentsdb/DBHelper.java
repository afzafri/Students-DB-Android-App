package com.afifzafri.studentsdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Afif on 28/10/2017.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "StudentsDB.db";
    public static final String TABLE_NAME = "students";
    public static final String COLUMN_ID = "_id";
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
    // function for insert data into db
    public boolean insertData (String id, String name, String ic, String dob, String address,
                               String program, String phone, String email) {
        SQLiteDatabase db = this.getWritableDatabase(); // open db for writing
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", id);
        contentValues.put("name", name);
        contentValues.put("ic", ic);
        contentValues.put("dob", dob);
        contentValues.put("address", address);
        contentValues.put("program", program);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    // function to select data for list
    public Cursor listAllData () {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select "+COLUMN_ID+", "+COLUMN_NAME+", "+COLUMN_ID+" from "+TABLE_NAME, null);
        return cursor;
    }

    // function for search data
    public Cursor searchData (String searchInput) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( "select * from "+TABLE_NAME+" where _id = '"+searchInput+
                "' or name LIKE '%"+searchInput+"%'", null );
        return cursor;
    }

    // function for update data
    public boolean updateData (String id, String name, String ic, String dob, String address,
                               String program, String phone, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", id);
        contentValues.put("name", name);
        contentValues.put("ic", ic);
        contentValues.put("dob", dob);
        contentValues.put("address", address);
        contentValues.put("program", program);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        db.update(TABLE_NAME, contentValues, "_id = ? ", new String[] {id} );
        return true;
    }

    // function for delete data
    public boolean deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "_id = ? ", new String[] {id} );
        return true;
    }
}
