package hcmute.G7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import hcmute.G7.Model.User;

public class Database extends SQLiteOpenHelper {
    public static final String DBName="Foody_Group7.db";
    SQLiteDatabase db;
    public Database(Context context) {
        super(context, "Foody_Group7.db", null, 1);
        Log.d("mytag", "Database contructor");
        db=this.getWritableDatabase();
    }

    public void queryData(String sql){
        db=getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor getData(String sql){
        db=getWritableDatabase();
        return  db.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS User (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), password VARCHAR(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS User");
    }
    public long createUser(User user) {
        db=getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("name",user.getName());
        cv.put("password",user.getPassword());
        long res=db.insert("User",null,cv);
        return res;
    }
    public Boolean checkUserName(String name){
        Cursor cursor =this.getData("SELECT * FROM User WHERE name='"+name+"'");
        if(cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
    public Boolean authenticateUser(String name, String password){

        String slqQueryString="SELECT * FROM User WHERE name='"+name+"' AND password='"+password+"' ";
        Cursor cursor =this.getData(slqQueryString);
        if(cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
}
