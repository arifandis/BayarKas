package squad.seven.bayarkas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by afridha on 05/05/18.
 */

public class DataHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "BemFilkom.db";
    public static final int DATABASE_VERSION = 1;
    private static final String TAG = "";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_STAFF = "CREATE TABLE daftar_staff (kodebayar text primary key, nama text, kementrian text)";
        db.execSQL(CREATE_TABLE_STAFF);
        String CREATE_TABLE_PEMBAYARAN = "CREATE TABLE pembayaran(kodebayar text primary key, nama text, penerima text,nominalbayar text, tglbayar text)";
        db.execSQL(CREATE_TABLE_PEMBAYARAN);
// String sql = "create table biodata (no integer primary key, nama text null, tgl text null, jk text null, alamat text null);";
//            String komen = "create table komen (komen text);"; nom
//            Log.d("Data","onCreate: "+sql);
//            db.execSQL(sql);
//            db.execSQL(komen);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS daftar_staff");
        db.execSQL("DROP TABLE IF EXISTS pembayaran");
        onCreate(db);
    }

    void addDataStaff(String kode, String nama, String kementrian) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("kodebayar", kode);
        values.put("nama", nama);
        values.put("kementrian", kementrian);
        db.insert("daftar_staff", null, values);
        Log.i(TAG, "addDataStaff" +"Kode Bayar: "+ values.get("kodebayar")
                + "Nama : " + values.get("nama") + "Kementerian : " + values.get("kementrian"));
        db.close();


    }

    public void addDataTransaksi(String kode, String nama, String penerima, String tanggal, String nominal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("kodebayar", kode);
        values.put("nama", nama);
        values.put("penerima", penerima);
        values.put("nominalbayar", nominal);
        values.put("tglbayar", tanggal);
        db.insert("pembayaran", null, values);
        Log.i(TAG, "addDataPembayaran" +"Kode Bayar: "+ values.get("kodebayar")
                + "Nama : " + values.get("nama") + "Penerima : " + values.get("penerima") +"Nominal : "
                + values.get("nominalbayar") + "Tanggal : " + values.get("tglbayar"));
        db.close();
    }

    public void loadContent(){
        onUpgrade(this.getReadableDatabase(), DATABASE_VERSION, DATABASE_VERSION);
        addDataStaff("A2001", "Anjumi", "Keuangan");
        addDataStaff("B2001", "Bibil", "Keuangan");
        addDataStaff("C2001", "Nilna", "Adkest");
        addDataStaff("E2001", "Agung", "BPI");
        addDataStaff("H3001", "Ilma", "Seskab");
    }

    public String[] selectAllData() {
        try {
            String arrData[] = null;
            SQLiteDatabase db;
            db = this.getReadableDatabase();
            String SELECT_ALL_DATA = "SELECT nama FROM daftar_staff";
            Cursor cursor = db.rawQuery(SELECT_ALL_DATA, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    arrData = new String [cursor.getCount()];
                    int i = 0;
                    do {
                        arrData[i] = cursor.getString(0);
                        i++;
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            return arrData;
        } catch (Exception e) {
            return null;
        }
    }

    public List<HistoryKas> getDataHistory(){
        // DataModel dataModel = new DataModel();
        List<HistoryKas> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select nama,nominalbayar from pembayaran;",null);
        StringBuffer stringBuffer = new StringBuffer();
        HistoryKas dataModel = null;
        while (cursor.moveToNext()) {
            dataModel= new HistoryKas();
            String name = cursor.getString(cursor.getColumnIndexOrThrow("nama"));
            String nominal = cursor.getString(cursor.getColumnIndexOrThrow("nominalbayar"));
            dataModel.setNama(name);
            dataModel.setNominal(nominal);
            stringBuffer.append(dataModel);
            // stringBuffer.append(dataModel);
            data.add(dataModel);
        }

        for (HistoryKas mo:data ) {

            Log.i("Hellomo",""+mo.getNama());
        }

        //

        return data;
    }

    }