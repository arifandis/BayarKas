package squad.seven.bayarkas.Fragment;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

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
//    View view;
    public FragmentTambahKas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tambah_kas, container, false);
        nama = (AutoCompleteTextView) view.findViewById(R.id.nama_tambah_kas);
        kodebayar = view.findViewById(R.id.kode_pembayaran);
        penerima = view.findViewById(R.id.penerima);
        nominalBayar = view.findViewById(R.id.nominal_bayar);
        tanggalBayar = view.findViewById(R.id.tanggal_bayar);
        simpan = view.findViewById(R.id.simpan);
        batal = view.findViewById(R.id.batal);

        //Set CurrentDate
        String currentDate = dateFormat.format(c.getTime());
        tanggalBayar.setText(currentDate);

        initAutoCompleteNama(namaStaff, nama);
        System.out.println(namaStaff);

        //Saat tombol simpan diklik
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into transaksi(kodebayar, nama, penerima, nominalbayar, tglbayar) values('" +
                        kodebayar.getText().toString() + "',"+ nama.getText().toString() +"',"+penerima.getText().toString()
                +"',"+ nominalBayar +"',"+tanggalBayar+ "');");
                Toast.makeText(getActivity(), "Berhasil menambah transaksi", Toast.LENGTH_SHORT).show();
//                db.close();
            }
        });

        //Saat tombol batal diklik
        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    void initAutoCompleteNama(String [] staff, AutoCompleteTextView staffAuto) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, staff);
        staffAuto.setAdapter(adapter);
        staffAuto.setThreshold(1);
        staffAuto.dismissDropDown();

        staffAuto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), (CharSequence) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });

    }





}
