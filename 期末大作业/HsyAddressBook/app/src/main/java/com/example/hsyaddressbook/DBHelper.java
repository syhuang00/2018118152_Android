package com.example.hsyaddressbook;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DBHelper extends SQLiteOpenHelper{
    //数据库版本
    private static final int DATABASE_VERSION=10;

    //数据库名称
    private static final String DATABASE_NAME="userlist.db";


    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据表
        String s=" CREATE TABLE userlist (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name STRING, phone, image BLOB);\n" +
                "\n" +
                " COMMIT TRANSACTION;\n" +
                " PRAGMA foreign_keys = on;";
        db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //如果旧表存在，删除，所以数据将会消失
//        db.execSQL("DROP TABLE IF EXISTS maillist");
//        //再次创建表
//        onCreate(db);
    }
}