package eecs1022.liftbro;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by Deep on 2/21/18.
 */
public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "Data_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "Data";

    public DatabaseHelper(Context context){
        super(context, TABLE_NAME, null, 1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        //If there already exists a table (clearing the table)
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        //Create a new table with no values
        onCreate(db);
    }

    //Create a Table using the Final Variables that we have
    @Override
    public void onCreate(SQLiteDatabase db){
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT)";
        db.execSQL(createTable);
    }

    /**
     * Adds data to database method.
     * @param item(String)
     * @return Item added to the current database
     */
    public boolean addData(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //putting the value we have(item) in to the content value class
        contentValues.put(COL2, item);

        //Only for programming purpose logging
        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        //Attempting to insert content value into the table.
        long result = db.insert(TABLE_NAME, null, contentValues);

        //if data is inserted incorrectly it will return -1
        //FailSafe too see what is happening
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Clears all the existing data.
     */
    public void removeAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
        db.close();
    }

    /**
     * To access the database
     * @return cursor pointing towards the data
     */
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }


}
