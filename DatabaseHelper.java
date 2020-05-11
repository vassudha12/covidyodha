package com.e.covidyodha_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TAG="DatabaseHelper";
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="database";
    public static final String TABLE_NAME="tb";

    public static final String ID="id";
    public static final String NAME="name";
    public static final String ADDRESS="address";
    public static final String AADHAR="aadhar";
    public static final String MEMBER="member";
    public static final String FOODPKT="foodpkt";
    public static final String TIMESTAMP="timestamp";

    /*constructor*/
   public DatabaseHelper(Context context){
       super(context,DATABASE_NAME,null,DATABASE_VERSION);
   }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TABLE_NAME +"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" TEXT,"
                +ADDRESS+" TEXT,"+AADHAR+" INTEGER,"+MEMBER+" INTEGER,"+FOODPKT+" INTEGER,"+TIMESTAMP+
                "DATETIME DEFAULT CURRENT_TIMESTAMP"+ ")";
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


    public long addHandler(DataModel data){
        SQLiteDatabase db=getWritableDatabase() ;
        ContentValues values =new ContentValues() ;
        values.put(ID,data.getId());
        values.put(NAME, data.getName());
        values.put(ADDRESS,data.getAddress());
        values.put(AADHAR,data.getAadhar());
        values.put(MEMBER,data.getMembers());
        values.put(FOODPKT,data.getFoodpkt());
        values.put(TIMESTAMP,data.getTimestamp());

         long in=db.insert(TABLE_NAME ,null,values ) ;
        db.close();
        return db.insert(TABLE_NAME ,null,values ) ;
    }

    public long findHandler (DataModel data)
    {


    }





}
