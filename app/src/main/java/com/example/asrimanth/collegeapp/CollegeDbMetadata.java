package com.example.asrimanth.collegeapp;


import android.provider.BaseColumns;

/**
 * Created by A.Srimanth on 26-Mar-18.
 */

public class CollegeDbMetadata {

    public static final class Students
    {
        public static final String TABLE_NAME = "students";
        public static final String COLUMN_STUDENT_FIRST_NAME = "firstName";
        public static final String COLUMN_STUDENT_LAST_NAME = "lastName";
        public static final String COLUMN_ROLL_NO = "rollNo";
        public static final String COLUMN_PHONE_NO = "phoneNo";
        public static final String COLUMN_COURSE_ID = "courseID";
    }

    public static final class Courses
    {
        public static final String TABLE_NAME = "courses";
        public static final String COLUMN_COURSE_ID = "courseID";
        public static final String COLUMN_COURSE_NAME = "courseName";
        public static final String COLUMN_COURSE_DURATION = "courseDuration";
    }
    public static final class Enrolled implements BaseColumns
    {
        public static final String TABLE_NAME = "enrolled";
        public static final String COLUMN_ROLL_NO = "rollNo";
        public static final String COLUMN_COURSE_ID = "courseID";
        public static final String COLUMN_STUDENT_FIRST_NAME = "firstName";
    }
}
