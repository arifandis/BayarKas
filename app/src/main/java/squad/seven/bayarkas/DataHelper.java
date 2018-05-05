package squad.seven.bayarkas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by afridha on 05/05/18.
 */

    public class DataHelper extends SQLiteOpenHelper {
        public static final String DATABASE_NAME = "Biodata.db";
        public static final int DATABASE_VERSION = 1;

        public DataHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
//            String sql = "create table biodata (no integer primary key, nama text null, tgl text null, jk text null, alamat text null);";
//            String komen = "create table komen (komen text);";
//            Log.d("Data","onCreate: "+sql);
//            db.execSQL(sql);
//            db.execSQL(komen);
        }

        @Override
        public void onUpgrade (SQLiteDatabase arg0, int arg1, int arg2){

        }


    }