package com.example.test.Databse;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.test.Mainmodel.modelUserInfo;

import java.util.ArrayList;


public class MainDatabaseHelper extends SQLiteOpenHelper {
    private  static  final String DATABASE_NAME="CustomerDB";
    private  static  final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="userinfo";
    private  static final  String USER_ID="userid";
    private static final String  USER_NAME="name";
    private static final String  USER_PASSWORD="password";
    private static final String  USER_EMAIL="email";
    private static final String  USER_PHONE_NUMBER="phone_number";
    public  static int position;

    public MainDatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL("CREATE TABLE "+TABLE_NAME+
                     " ( "
             +USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
             +USER_NAME+" TEXT ,"
             +USER_EMAIL+" TEXT UNIQUE,"
             +USER_PASSWORD+" TEXT ,"
             +USER_PHONE_NUMBER+" TEXT "
             +" )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("drop table if exists "+TABLE_NAME);
    onCreate(db);
    }

    public boolean insertData(String username,String email,String password,String phoneNumber){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(USER_NAME,username);
        values.put(USER_EMAIL,email);
        values.put(USER_PASSWORD,password);
        values.put(USER_PHONE_NUMBER,phoneNumber);

       long result= db.insert(TABLE_NAME,null,values);
        position++;
       if(result==-1){
           return false;
       }else{
           return true;
        }

    }
    public Boolean checkEmail(String email){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME+" where email =?",new String[]{email});
        if(cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkEmailPassword(String email,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from " +TABLE_NAME+" where email =? and password=?",new String[]{email,password});
        if(cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }

    public modelUserInfo getuserinfo(String email){
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME+" where email =?",new String[]{email});

        modelUserInfo userlist=new modelUserInfo();
        while(cursor.moveToNext()){

                 userlist.id=cursor.getInt(0);
                 userlist.username=cursor.getString(1);
                 userlist.email=cursor.getString(2);
                 userlist.password=cursor.getString(3);
                 userlist.phone=cursor.getString(4);

        }
        cursor.close();
        db.close();
        return userlist;
    }


    @SuppressLint("Range")
    public int getUserId(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        int userId=-1; // Default value if user is not found

        Cursor cursor=db.rawQuery("select "+USER_ID+" from "+TABLE_NAME+" where email =?",new String[]{email});

        if (cursor != null && cursor.moveToFirst()) {
            userId = cursor.getInt(cursor.getColumnIndex(USER_ID));
            cursor.close();
        }

        db.close();
        return userId;
    }

}
