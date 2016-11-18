package com.example.greciaguzmn.natureheal;

/*
 * Created by Mauricio on 18/11/2016.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbNatureHeal extends SQLiteOpenHelper {

    private static final String DB_NAME= "NatureHeal";
    private static final int SCHEMA_VERSION= 1;
    private SQLiteDatabase db;

    public DbNatureHeal(Context context) {
        super(context, DB_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TblNatureHeal.CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
