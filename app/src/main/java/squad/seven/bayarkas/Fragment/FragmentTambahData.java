package squad.seven.bayarkas.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import squad.seven.bayarkas.DataHelper;
import squad.seven.bayarkas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTambahData extends Fragment {
    EditText mNamaTxt,mKodeTxt,mKementrianTxt;
    Button mBatalBtn,mSimpanBtn;
    DataHelper dataHelper;


    public FragmentTambahData() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_tambah_data, container, false);

        dataHelper = new DataHelper(this.getContext());

        mNamaTxt = v.findViewById(R.id.nama);
        mKodeTxt = v.findViewById(R.id.kode_pembayaran);
        mKementrianTxt = v.findViewById(R.id.kementrian);
        mBatalBtn = v.findViewById(R.id.batal);
        mSimpanBtn = v.findViewById(R.id.simpan);

        mSimpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addingNewStaff();
            }
        });

        mBatalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                batalBtn();
            }
        });

        return v;
    }

    void addingNewStaff(){
        String nama = mNamaTxt.getText().toString();
        String kode = mKodeTxt.getText().toString();
        String kementrian = mKementrianTxt.getText().toString();

        dataHelper.addDataStaff(kode,nama,kementrian);
        Toast.makeText(getActivity(), "Data baru berhasil ditambahkan", Toast.LENGTH_SHORT).show();
    }

    void batalBtn(){
        Fragment fragment = new ViewHistoryFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_view,fragment);
        transaction.commit();
    }

}
