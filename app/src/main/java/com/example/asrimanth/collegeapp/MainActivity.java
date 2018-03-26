package com.example.asrimanth.collegeapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try
        {
            CollegeDbHelper dbHelper = new CollegeDbHelper(this);
            mDb = dbHelper.getWritableDatabase();
//            mDb.execSQL("INSERT INTO courses VALUES (101,'java','3 hrs')");
//            mDb.execSQL("INSERT INTO students VALUES ('Srimanth','Agastyaraju','16311A05W4',9502746580,101)");
            mDb.execSQL("DELETE FROM enrolled");
            mDb.execSQL("INSERT INTO enrolled VALUES ('16311A05W4',101,'Srimanth')");
            mDb.execSQL("INSERT INTO enrolled VALUES ('12211A0587',101,'Shanmukha')");
            Cursor cursor = mDb.rawQuery("SELECT * FROM enrolled", null);

            int sfname = cursor.getColumnIndex(CollegeDbMetadata.Enrolled.COLUMN_STUDENT_FIRST_NAME);
            int rollno = cursor.getColumnIndex(CollegeDbMetadata.Enrolled.COLUMN_ROLL_NO);
            int cid = cursor.getColumnIndex(CollegeDbMetadata.Enrolled.COLUMN_COURSE_ID);

            cursor.moveToFirst();


            while (cursor != null) {
                String s = cursor.getString(sfname) + " " + " "
                        + cursor.getString(rollno) + " " + cursor.getString(cid);
                Log.i("data",s);
                cursor.moveToNext();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
