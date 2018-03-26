package com.example.asrimanth.collegeapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by A.Srimanth on 26-Mar-18.
 */

public class CollegeDbHelper extends SQLiteOpenHelper {

    // The database name
    private static final String DATABASE_NAME = "college.db";

    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;

    //Constructor
    public CollegeDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

        final String SQL_CREATE_COURSES_TABLE = "CREATE TABLE " + CollegeDbMetadata.Courses.TABLE_NAME + " (" +
                CollegeDbMetadata.Courses.COLUMN_COURSE_ID + " INTEGER PRIMARY KEY," +
                CollegeDbMetadata.Courses.COLUMN_COURSE_NAME + " TEXT NOT NULL," +
                CollegeDbMetadata.Courses.COLUMN_COURSE_DURATION + " TEXT NOT NULL" +
                ");";

        Log.i("courseCreate",SQL_CREATE_COURSES_TABLE);



        final String SQL_CREATE_STUDENTS_TABLE =  "CREATE TABLE " + CollegeDbMetadata.Students.TABLE_NAME + " (" +
                CollegeDbMetadata.Students.COLUMN_STUDENT_FIRST_NAME + " TEXT NOT NULL," +
                CollegeDbMetadata.Students.COLUMN_STUDENT_LAST_NAME + " TEXT NOT NULL," +
                CollegeDbMetadata.Students.COLUMN_ROLL_NO + " TEXT PRIMARY KEY," +
                CollegeDbMetadata.Students.COLUMN_PHONE_NO + " INTEGER NOT NULL," +
                CollegeDbMetadata.Students.COLUMN_COURSE_ID + " INTEGER NOT NULL" +
                ");";

        Log.i("courseCreate",SQL_CREATE_STUDENTS_TABLE);

        final String SQL_CREATE_ENROLLED_TABLE = "CREATE TABLE " + CollegeDbMetadata.Enrolled.TABLE_NAME + " ( " +
                CollegeDbMetadata.Enrolled.COLUMN_ROLL_NO + " TEXT NOT NULL, " +
                CollegeDbMetadata.Enrolled.COLUMN_COURSE_ID + " INTEGER NOT NULL, " +
                CollegeDbMetadata.Enrolled.COLUMN_STUDENT_FIRST_NAME + " TEXT NOT NULL," +
                " FOREIGN KEY (" + CollegeDbMetadata.Enrolled.COLUMN_ROLL_NO + ") REFERENCES " +
                CollegeDbMetadata.Students.TABLE_NAME + " ( " +CollegeDbMetadata.Students.COLUMN_ROLL_NO + ")," +
                " FOREIGN KEY (" + CollegeDbMetadata.Enrolled.COLUMN_COURSE_ID + ") REFERENCES " +
                CollegeDbMetadata.Courses.TABLE_NAME + " ( " + CollegeDbMetadata.Courses.COLUMN_COURSE_ID +"),"+
                " PRIMARY KEY " + " ( " + CollegeDbMetadata.Enrolled.COLUMN_ROLL_NO+ ", " +
                CollegeDbMetadata.Enrolled.COLUMN_COURSE_ID +
                "));";

        sqLiteDatabase.execSQL(SQL_CREATE_COURSES_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_STUDENTS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_ENROLLED_TABLE);

        Log.i("Table","Enrolled created.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CollegeDbMetadata.Students.TABLE_NAME );
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CollegeDbMetadata.Courses.TABLE_NAME );
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CollegeDbMetadata.Enrolled.TABLE_NAME );
        onCreate(sqLiteDatabase);
    }
}
