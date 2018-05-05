package squad.seven.bayarkas.Fragment;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import squad.seven.bayarkas.DataHelper;
import squad.seven.bayarkas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTambahData extends Fragment {
    TextView nama, kementrian;
    DataHelper dbHelper;
    Button simpan, batal;

    public FragmentTambahData() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_tambah_data, container, false);
        nama = v.findViewById(R.id.nama_tambah_data);
        kementrian = v.findViewById(R.id.kementrian_tambah_data);
        batal = v.findViewById(R.id.batal_tambah_data);
        simpan =v.findViewById(R.id.simpan_tambah_data);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into staff_bem(kodebayar, nama, kementrian) values('" +
                        nama.getText().toString() + "','" +
                        kementrian.getText().toString() +"')");
                Toast.makeText(getActivity(), "Berhasil menambah data baru", Toast.LENGTH_SHORT).show();
            }
        });

        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return v;
    }

}
