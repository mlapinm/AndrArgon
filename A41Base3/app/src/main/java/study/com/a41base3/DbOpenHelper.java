package study.com.a41base3;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by argon on 25.06.2019.
 */

public class DbOpenHelper extends SQLiteOpenHelper {

    final static String DB_NAME = "notes.db";
    final static String DB_TABLE = "notes";
    final static String COLUMN_NOTE = "note";
    final static int DB_VERSION = 1;

    // SQL-запрос для создания БД
    private static final String DB_CREATE = "CREATE TABLE "
            + DB_TABLE +
            " ( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NOTE
            + " text not null);";

    Context mContext;

    public DbOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mContext = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
        //TODO DELETE AFTER DEBBUGING
        ContentValues values = new ContentValues(1);
        for(int i=0; i<5;i++){
            values.put(COLUMN_NOTE, "Note #" + i);
            db.insert(DB_TABLE, null,values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
