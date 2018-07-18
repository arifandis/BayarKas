package squad.seven.bayarkas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
import android.content.pm.PackageManager;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import squad.seven.bayarkas.POJO.RekapitulasiDetail;

/**
 * Created by afridha on 05/05/18.
 */

public class DataHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "BemFilkom.db";
    public static final int DATABASE_VERSION = 1;
    private static final String TAG = "";
    private static final String TAG2 = "DataHelper";
    public static File pdfFile;
//    final private int REQUEST_CODE_ASK_PERMISSIONS = 111;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_STAFF = "CREATE TABLE daftar_staff (kodebayar text primary key, nama text, kementrian text)";
        db.execSQL(CREATE_TABLE_STAFF);
        String CREATE_TABLE_PEMBAYARAN = "CREATE TABLE pembayaran(kodebayar text primary key, nama text, penerima text,nominalbayar integer, tglbayar integer, bulan text, tahun integer)";
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

    public void addDataStaff(String kode, String nama, String kementrian) {
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

    public void addDataTransaksi(String kode, String nama, String penerima, int tanggal, int nominal, String bulan, int year) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("kodebayar", kode);
        values.put("nama", nama);
        values.put("penerima", penerima);
        values.put("nominalbayar", nominal);
        values.put("tglbayar", tanggal);
        values.put("bulan",bulan);
        values.put("tahun",year);
        db.insert("pembayaran", null, values);
        Log.i(TAG, "addDataPembayaran" +"Kode Bayar: "+ values.get("kodebayar")
                + "Nama : " + values.get("nama") + "Penerima : " + values.get("penerima") +"Nominal : "
                + values.get("nominalbayar") + "Tanggal : " + values.get("tglbayar") + values.get("bulan")
        + values.get("tahun"));
        db.close();
    }

    public void loadContent(){
        addDataStaff("A2001", "Anjumi", "Keuangan");
        addDataStaff("B2001", "Bibil", "Keuangan");
        addDataStaff("C2001", "Nilna", "Adkest");
        addDataStaff("E2001", "Agung", "BPI");
        addDataStaff("H3001", "Ilma", "Seskab");
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

    public List<HistoryKas> getDataHistory(int tanggal, String bulan, int tahun){
        // DataModel dataModel = new DataModel();
        List<HistoryKas> data=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select nama,nominalbayar from pembayaran where tglbayar="+tanggal+" and bulan='"+bulan+"' and tahun="+tahun+";",null);
        StringBuffer stringBuffer = new StringBuffer();
        HistoryKas dataModel = null;
        while (cursor.moveToNext()) {
            dataModel= new HistoryKas();
            String name = cursor.getString(cursor.getColumnIndexOrThrow("nama"));
            String nominal = cursor.getString(cursor.getColumnIndexOrThrow("nominalbayar"));
            dataModel.setNama(name);
            dataModel.setNominal("Rp. "+nominal);
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

    public List<RekapitulasiDetail> getDataRekap(String bulan){
        // DataModel dataModel = new DataModel();
        List<RekapitulasiDetail> data=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select nama,nominalbayar from pembayaran where bulan='"+bulan+"';",null);
        StringBuffer stringBuffer = new StringBuffer();
        RekapitulasiDetail dataModel = null;
        while (cursor.moveToNext()) {
            dataModel= new RekapitulasiDetail();
            String name = cursor.getString(cursor.getColumnIndexOrThrow("nama"));
            String nominal = cursor.getString(cursor.getColumnIndexOrThrow("nominalbayar"));
            dataModel.setNama(name);
            dataModel.setNominal(nominal);
            stringBuffer.append(dataModel);
            // stringBuffer.append(dataModel);
            data.add(dataModel);
        }

        for (RekapitulasiDetail mo:data ) {

            Log.i("Hellomo",""+mo.getNama());
        }

        //
        return data;
    }

    public int selectSumPeriod(String month) {
        int total=0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select sum(nominalbayar) from pembayaran where bulan ='"+month+"';", null);
        if(cursor.moveToFirst()) {
            total = cursor.getInt(0);
        } while (cursor.moveToNext());
        return total;
//
    }

    public String getCode(String name){
        String code=null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select kodebayar from daftar_staff where nama='"+name+"';",null);
        if (cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                code = cursor.getString(0);
            }while (cursor.moveToNext());
        }
        return code;
    }

    public void createPdf(String month) throws FileNotFoundException, DocumentException {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select nama,penerima,nominalbayar,tglbayar,bulan,tahun from pembayaran where bulan='"+month+"';",null);

        File docsFolder = new File(Environment.getExternalStorageDirectory() + "/Documents");
        if (!docsFolder.exists()) {
            docsFolder.mkdir();
            Log.i(TAG, "Created a new directory for PDF");
        }

        pdfFile = new File(docsFolder.getAbsolutePath(),"Rekapan Bulan "+month+".pdf");
        OutputStream output = new FileOutputStream(pdfFile);

        Document document = new Document();
        PdfWriter.getInstance(document, output);

        document.open();
        PdfPTable table0 = new PdfPTable(4); // 4 columns.
        PdfPTable table = new PdfPTable(4); // 4 columns.

        PdfPCell cell01 = new PdfPCell(new Paragraph("Pembayar"));
        PdfPCell cell02 = new PdfPCell(new Paragraph("Penerima"));
        PdfPCell cell03 = new PdfPCell(new Paragraph("Nominal Pembayaran"));
        PdfPCell cell04 = new PdfPCell(new Paragraph("Tanggal Pembayaran"));

        table.addCell(cell01);
        table.addCell(cell02);
        table.addCell(cell03);
        table.addCell(cell04);

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow("nama"));
            String penerima = cursor.getString(cursor.getColumnIndexOrThrow("penerima"));
            String nominal = Integer.toString(cursor.getInt(cursor.getColumnIndexOrThrow("nominalbayar")));
            String tglBayar = Integer.toString(cursor.getInt(cursor.getColumnIndexOrThrow("tglbayar")));
            String bulan = cursor.getString(cursor.getColumnIndexOrThrow("bulan"));
            String tahun = Integer.toString(cursor.getInt(cursor.getColumnIndexOrThrow("tahun")));

            PdfPCell cell1 = new PdfPCell(new Paragraph(name));
            PdfPCell cell2 = new PdfPCell(new Paragraph(penerima));
            PdfPCell cell3 = new PdfPCell(new Paragraph(nominal));
            PdfPCell cell4 = new PdfPCell(new Paragraph(tglBayar+" "+bulan+" "+tahun));

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
        }

        document.add(table);
        document.close();
//        previewPdf();
    }
}