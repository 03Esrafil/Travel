package com.example.test.fragment.fragmentDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.test.fragment.fragModel.tripModel;

import java.util.ArrayList;

public class fragMytripDATAbaseHelper extends SQLiteOpenHelper {
    final static  String TRIP_DATABESE_NAME="TRIP_DATABASE_NAME";
    final static Integer TRIP_DATABASE_VERSION=1;
    final static  String TRIP_TABLE_NAME="TRIP_TABLE_NAME";
    final static  String  TRIP_ID="TRIP_ID";
    final static  String TRIP_HOTEL_NAME="TRIP_HOTEL_NAME";
    final static  String  TRIP_IMAGE="TRIP_IMAGE";
    final static  String  TRIP_PRICE="TRIP_PRICE";
    final static  String  TRIP_LOCATION="TRIP_LOCATION";
    final static  String TRIP_ROOM_NUMBER="TRIP_BED_NUMBER";
    final static  String TRIP_REGISTER_EMAIL="TRIP_REGISTER_ID";
    final static  String TRIP_REGISTER_CUSTOMER_NAME="TRIP_REGISTER_CUSTOMER_NAME";
    final static  String TRIP_REGISTER_PHONE_NUMBER="TRIP_REGISTER_PHONE_NUMBER";


    public fragMytripDATAbaseHelper(@Nullable Context context) {
        super(context, TRIP_DATABESE_NAME, null, TRIP_DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TRIP_TABLE_NAME+
                " ( "+TRIP_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +TRIP_REGISTER_EMAIL+" TEXT ,"
                +TRIP_REGISTER_CUSTOMER_NAME+" TEXT ,"
                +TRIP_REGISTER_PHONE_NUMBER+" TEXT ,"
                +TRIP_HOTEL_NAME+" TEXT ,"
                +TRIP_IMAGE+" INTEGER ,"
                +TRIP_LOCATION+" TEXT ,"
                +TRIP_PRICE+" INTEGER ,"
                +TRIP_ROOM_NUMBER+" TEXT "
                +" )");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists "+TRIP_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertOrder(String register_email,
                               String customer_name,
                               String Phonenmber,
                               String HotelName,
                               int image,
                               String location,
                               int hotel_Price,
                               String RoomNumber){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();

        content.put(TRIP_REGISTER_EMAIL,register_email);
        content.put(TRIP_REGISTER_CUSTOMER_NAME,customer_name);
        content.put(TRIP_REGISTER_PHONE_NUMBER,Phonenmber);
        content.put(TRIP_HOTEL_NAME,HotelName);
        content.put(TRIP_IMAGE,image);
        content.put(TRIP_LOCATION,location);
        content.put(TRIP_PRICE,hotel_Price);
        content.put(TRIP_ROOM_NUMBER,RoomNumber);

        long order=db.insert(TRIP_TABLE_NAME,null,content);
        if(order<0){
            return false;
        }else {
            return true;
        }
    }

    public ArrayList<tripModel> getBookinglist(){
        ArrayList<tripModel> triplist=new ArrayList<>();

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor poin=db.rawQuery("select "
                                     +TRIP_IMAGE+","
                                     +TRIP_HOTEL_NAME+","
                                     +TRIP_PRICE+","
                                     +TRIP_ROOM_NUMBER+
                                     " from "+TRIP_TABLE_NAME
                                          ,null);


        if(poin.moveToFirst()){
            while(poin.moveToNext()){
                tripModel modeltrip=new tripModel();

                modeltrip.setModelImage(poin.getInt(0));
                modeltrip.setPlaceName(poin.getString(1));
                modeltrip.setOrderNumber(poin.getInt(2)+"");
                modeltrip.setPrice(poin.getInt(3)+"");

                triplist.add(modeltrip);
            }
        }
        poin.close();
        db.close();
        return  triplist;
    }
}
