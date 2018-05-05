package squad.seven.bayarkas.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import squad.seven.bayarkas.DataHelper;
import squad.seven.bayarkas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTambahData extends Fragment {
    AutoCompleteTextView nama;
    EditText kodebayar, penerima, nominalBayar, tanggalBayar;
    Button batal, simpan;
    private DataHelper dbHelper;
    View view;

    public FragmentTambahData() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tambah_data, container, false);
        kodebayar = (EditText) view.findViewById(R.id.kode_pembayaran);
        penerima = (EditText) view.findViewById(R.id.penerima);
        nominalBayar = (EditText) view.findViewById(R.id.nominal_bayar);
        tanggalBayar = (EditText) view.findViewById(R.id.tanggal_bayar);
        dbHelper = new DataHelper(this.getContext());
        dbHelper.loadContent();

        initAutoCompleteNama();
        return view;
    }

    private void initAutoCompleteNama() {
        nama = (AutoCompleteTextView) view.findViewById(R.id.nama);
        final String[] namaStaff = dbHelper.selectAllData();
        ArrayAdapter adapter = new ArrayAdapter(this.getActivity(),android.R.layout.simple_list_item_1, namaStaff);
        nama.setAdapter(adapter);
        nama.setThreshold(1);
        nama.dismissDropDown();

        nama.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), (CharSequence) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

}