package squad.seven.bayarkas.Fragment;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import squad.seven.bayarkas.BuktiActivity;
import squad.seven.bayarkas.DataHelper;
import squad.seven.bayarkas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTambahKas extends Fragment {
    AutoCompleteTextView nama;
    EditText kodebayar, penerima, nominalBayar, tanggalBayar;
    Calendar c = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Button batal, simpan;
    private DataHelper dbHelper;
    String[] namaStaff;
    String mCurrentDate;

    //    View view;
    public FragmentTambahKas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tambah_kas, container, false);

        nama = view.findViewById(R.id.nama_tambah_kas);

        kodebayar = view.findViewById(R.id.kode_pembayaran);
        penerima = view.findViewById(R.id.penerima);
        nominalBayar = view.findViewById(R.id.nominal_bayar);
        tanggalBayar = view.findViewById(R.id.tanggal_bayar);
        simpan = view.findViewById(R.id.simpan);
        batal = view.findViewById(R.id.batal);

        //Set CurrentDate

        mCurrentDate = dateFormat.format(c.getTime());
        tanggalBayar.setText(mCurrentDate);

        initAutoCompleteNama(namaStaff, nama);
        System.out.println(namaStaff);

        //Saat tombol simpan diklik
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addingData();

            }
        });

        //Saat tombol batal diklik
        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToHome();

            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dbHelper = new DataHelper(this.getContext());
        dbHelper.loadContent();
        namaStaff = dbHelper.selectAllData();


    }

    void initAutoCompleteNama(String[] staff, AutoCompleteTextView staffAuto) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, staff);
        staffAuto.setAdapter(adapter);
        staffAuto.setThreshold(1);
        staffAuto.dismissDropDown();

        staffAuto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), (CharSequence) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();

                String name = nama.getText().toString();
                kodebayar.setText(""+dbHelper.getCode(name));
            }
        });

    }

    void addingData(){
        String kodeBayar = kodebayar.getText().toString();
        String name = nama.getText().toString();
        String penerimaStr = penerima.getText().toString();
        int nominalBayarStr = Integer.parseInt(nominalBayar.getText().toString());

        dbHelper.addDataTransaksi(kodeBayar,name,penerimaStr,getDate(),nominalBayarStr,getMonth(),getYear());
        Toast.makeText(getActivity(), "Berhasil menambah transaksi", Toast.LENGTH_SHORT).show();
        moveToHome();
        Intent intent = new Intent(getActivity(),BuktiActivity.class);
        intent.putExtra("nama", name);
        intent.putExtra("kode", kodeBayar);
        intent.putExtra("tanggal", mCurrentDate);
        intent.putExtra("nominal", nominalBayar.getText().toString());
        startActivity(intent);
    }

    void moveToHome(){
        Fragment fragment = new ViewHistoryFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_view,fragment);
        transaction.commit();
    }

    int getDate(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);

        return day;
    }

    String getMonth(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.MONTH);
        String bulan=null;

        switch (day) {
            case Calendar.JANUARY:
                bulan="Januari";
                break;
            case Calendar.FEBRUARY:
                bulan="Februari";
                break;
            case Calendar.MARCH:
                bulan="Maret";
                break;
            case Calendar.APRIL:
                bulan="April";
                break;
            case Calendar.MAY:
                bulan="Mei";
                break;
            case Calendar.JUNE:
                bulan="Juni";
                break;
            case Calendar.JULY:
                bulan="Juli";
                break;
            case Calendar.AUGUST:
                bulan="Agustus";
                break;
            case Calendar.SEPTEMBER:
                bulan="September";
                break;
            case Calendar.OCTOBER:
                bulan="Oktober";
                break;
            case Calendar.NOVEMBER:
                bulan="Nopember";
                break;
            case Calendar.DECEMBER:
                bulan="Desember";
                break;
        }
        return bulan;
    }

    int getYear(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return year;
    }
}
