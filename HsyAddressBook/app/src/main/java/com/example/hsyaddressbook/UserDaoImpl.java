package com.example.hsyaddressbook;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hsyaddressbook.DBHelper;
import com.example.hsyaddressbook.UserDao;
import com.example.hsyaddressbook.User;

import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    static DBHelper dbHelper ;
    public UserDaoImpl(Context context){
        dbHelper=new DBHelper(context);
        }
    @Override
    public List<User> getUser() {
        SQLiteDatabase db=null;
        LinkedList<User> l= new LinkedList<>();
        try {
        db = dbHelper.getWritableDatabase();
        String[] str = {"id","name","phone"};
        Cursor cursor = db.query("userlist", str, null, null, null,  null,"name asc");
        while (cursor.moveToNext()) {
        int id = Integer.parseInt(cursor.getString(0));
        String name = cursor.getString(1);
        String phone = cursor.getString(2);
        byte[] img = null;
            User user = new User(id, name, phone, img);
        l.add(user);
        }
        db.close();
        return l;
        }catch (Exception e){
        return l;
        }finally {
        db.close();
        }
        }

    @Override
    public boolean AddMail(User user) {
        SQLiteDatabase db=null;
        try {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",user.getName());
        values.put("phone",user.getPhone());
        values.put("image",user.getImage());
        db.insert("userlist", null, values);
        db.close();
        return true;
        }catch (Exception e){
        return false;
        }finally {
        db.close();
        }
        }

    @Override
    public boolean DelMail(String id) {
        SQLiteDatabase db=null;
        try {
        db = dbHelper.getWritableDatabase();
        db.delete("userlist","id = "+id,null);
        db.close();
        return true;
        }catch (Exception e){
        return false;
        }finally {
        db.close();
        }
        }

    @Override
    public boolean UpdateMail(User user) {
        SQLiteDatabase db=null;
        try {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",user.getName());
        values.put("phone",user.getPhone());
        values.put("image",user.getImage());
        db.update("userlist", values, "id = "+user.getId(),null);
        db.close();
        return true;
        }catch (Exception e){
        return false;
        }finally {
        db.close();
        }
        }

    @Override
    public User GetOne(String id) {
        SQLiteDatabase db=null;
        User user = null;
        try {
        db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query("userlist", null, "id = "+id, null, null, null, null);
        while (cursor.moveToNext()) {
        String name = cursor.getString(1);
        String phone = cursor.getString(2);
        byte[] img = cursor.getBlob(3);
        user = new User(Integer.valueOf(id), name, phone, img);
        }
        db.close();
        return user;
        }catch (Exception e){
        return user;
        }finally {
        db.close();
        }
        }

    @Override
    public List<User> SearchLikeUser(String s) {
        SQLiteDatabase db=null;
        List<User> l = new LinkedList<>();
        try {
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("userlist", null, "name Like '%"+s+"%'", null, null, null, "name asc");
        while (cursor.moveToNext()) {
        int id = cursor.getInt(0);
        String name = cursor.getString(1);
        String phone = cursor.getString(2);
        byte[] img = cursor.getBlob(3);
        User user = new User(id, name, phone, img);
        l.add(user);
        }
        db.close();
        return l;
        }catch (Exception e){
        return l;
        }finally {
        db.close();
        }
        }
}
