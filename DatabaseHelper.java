package com.e.covidyodha_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TAG="DatabaseHelper";
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="database.db";
    public static final String TABLE_NAME="tb";

    public static final String ID="id";
    public static final String NAME="name";
    public static final String ADDRESS="address";
    public static final String AADHAR="aadhar";
    public static final String MEMBER="member";
    public static final String FOODPKT="foodpkt";
    public static final String TIMESTAMP="timestamp";
    public static final String THANA="thana";

    /*constructor*/
   public DatabaseHelper(Context context){
       super(context,DATABASE_NAME,null,DATABASE_VERSION);
   }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TABLE_NAME +"("+
                ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                NAME+" TEXT,"+
                ADDRESS+" TEXT,"+
                AADHAR+" INTEGER,"+
                MEMBER+" INTEGER,"+
                FOODPKT+" INTEGER,"+
                THANA+"TEXT,"+
                TIMESTAMP+"DATETIME DEFAULT CURRENT_TIMESTAMP )";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME) ;
        onCreate(db);
    }

    public String loadHandler()
    {
        String result = "";
        String query = "Select*FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }


    public void addHandler(DataModel data){
        SQLiteDatabase db=getWritableDatabase() ;
        ContentValues values =new ContentValues() ;
        values.put(NAME, data.getName());
        values.put(ADDRESS,data.getAddress());
        values.put(AADHAR,data.getAadhar());
        values.put(MEMBER,data.getMembers());
        values.put(FOODPKT,data.getFoodpkt());
        values.put(THANA,data.getThana());
        db.insert(TABLE_NAME ,null,values ) ;
        db.close();
    }

    public DataModel findHandler(String user_data) {
        String query = "Select * FROM " + TABLE_NAME + "WHERE" + THANA + " = " + "'" + user_data + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        DataModel data = new DataModel();
        if (cursor.moveToFirst())
        {
            cursor.moveToFirst();
            data.setID(Integer.parseInt(cursor.getString(0)));
            data.setName(cursor.getString(1));
            data.setAddress(cursor.getString(2));
            data.setAadhar(cursor.getInt(3));
            data.setMembers(cursor.getInt(4));
            data.setFoodpkt(cursor.getInt(5));
            data.setThana(cursor.getString(6));
            data.setTimestamp(cursor.getString(7));
            cursor.close();
        } else {
            data = null;
        }
        db.close();
        return data;
    }

    public boolean updateHandler(int id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(ID, id);
        args.put(NAME, name);
        return db.update(TABLE_NAME, args, ID + "=" + id, null) > 0;
    }


    public List<DataModel> getUserData(){
       List<DataModel> datalist=new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME +" ORDER BY " +TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DataModel data= new DataModel();
                data.setID(Integer.parseInt(cursor.getString(0)));
                data.setName(cursor.getString(1));
                data.setAddress(cursor.getString(2));
                data.setAadhar(cursor.getInt(3));
                data.setMembers(cursor.getInt(4));
                data.setFoodpkt(cursor.getInt(5));
                data.setThana(cursor.getString(6));
                data.setTimestamp(cursor.getString(7));


                datalist.add(data);
            } while (cursor.moveToNext());
        }
        db.close();

        return datalist;

    }

    public int getCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }




}

