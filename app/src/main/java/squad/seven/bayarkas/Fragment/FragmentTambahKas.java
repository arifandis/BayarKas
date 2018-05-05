package squad.seven.bayarkas.Fragment;


import android.content.Context;
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

import java.util.List;

import squad.seven.bayarkas.DataHelper;
import squad.seven.bayarkas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTambahKas extends Fragment {
    AutoCompleteTextView nama;
    EditText kodebayar, penerima, nominalBayar, tanggalBayar;
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
        nama = view.findViewById(R.id.nama_tambah_kas);
        kodebayar = view.findViewById(R.id.kode_pembayaran);
        penerima = view.findViewById(R.id.penerima);
        nominalBayar = view.findViewById(R.id.nominal_bayar);
        tanggalBayar = view.findViewById(R.id.tanggal_bayar);

        initAutoCompleteNama(namaStaff, nama);
        System.out.println(namaStaff);


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
