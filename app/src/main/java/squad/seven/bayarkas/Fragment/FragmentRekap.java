package squad.seven.bayarkas.Fragment;


import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.util.List;

import squad.seven.bayarkas.DataHelper;
import squad.seven.bayarkas.R;
import squad.seven.bayarkas.POJO.RekapitulasiDetail;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRekap extends Fragment {
    Button mExportBtn;
    Spinner spinner;
    TextView mSum;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<RekapitulasiDetail> listitem;
    private DataHelper dbHelper;

    public FragmentRekap() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rekap, container, false);

        dbHelper = new DataHelper(getActivity());
        recyclerView = v.findViewById(R.id.recycler_list_rekap);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        spinner = v.findViewById(R.id.bulan);
        mSum = v.findViewById(R.id.sum);
        mExportBtn = v.findViewById(R.id.export_btn);

        LinearLayoutManager linearLayout = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayout);
        linearLayout.setStackFromEnd(true);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position){
                    case 0:
                        mSum.setText("Rp. "+dbHelper.selectSumPeriod("Januari"));
                        listitem = dbHelper.getDataRekap("Januari");
                        adapter = new RekapAdapter(listitem, getActivity());
                        onClickExport("Januari");
                        break;
                    case 1:
                        mSum.setText("Rp. "+dbHelper.selectSumPeriod("Februari"));
                        listitem = dbHelper.getDataRekap("Februari");
                        adapter = new RekapAdapter(listitem, getActivity());
                        onClickExport("Februari");
                        break;
                    case 2:
                        mSum.setText("Rp. "+dbHelper.selectSumPeriod("Maret"));
                        listitem = dbHelper.getDataRekap("Maret");
                        adapter = new RekapAdapter(listitem, getActivity());
                        onClickExport("Maret");
                        break;
                    case 3:
                        mSum.setText("Rp. "+dbHelper.selectSumPeriod("April"));
                        listitem = dbHelper.getDataRekap("April");
                        adapter = new RekapAdapter(listitem, getActivity());
                        onClickExport("April");
                        break;
                    case 4:
                        mSum.setText("Rp. "+dbHelper.selectSumPeriod("Mei"));
                        listitem = dbHelper.getDataRekap("Mei");
                        adapter = new RekapAdapter(listitem, getActivity());
                        onClickExport("Mei");
                        break;
                    case 5:
                        mSum.setText("Rp. "+dbHelper.selectSumPeriod("Juni"));
                        listitem = dbHelper.getDataRekap("Juni");
                        adapter = new RekapAdapter(listitem, getActivity());
                        onClickExport("Juni");
                        break;
                    case 6:
                        mSum.setText("Rp. "+dbHelper.selectSumPeriod("Juli"));
                        listitem = dbHelper.getDataRekap("Juli");
                        adapter = new RekapAdapter(listitem, getActivity());
                        onClickExport("Juli");
                        break;
                    case 7:
                        mSum.setText("Rp. "+dbHelper.selectSumPeriod("Agustus"));
                        listitem = dbHelper.getDataRekap("Agustus");
                        adapter = new RekapAdapter(listitem, getActivity());
                        onClickExport("Agustus");
                        break;
                    case 8:
                        mSum.setText("Rp. "+dbHelper.selectSumPeriod("September"));
                        listitem = dbHelper.getDataRekap("September");
                        adapter = new RekapAdapter(listitem, getActivity());
                        onClickExport("September");
                        break;
                    case 9:
                        mSum.setText("Rp. "+dbHelper.selectSumPeriod("Oktober"));
                        listitem = dbHelper.getDataRekap("Oktober");
                        adapter = new RekapAdapter(listitem, getActivity());
                        onClickExport("Oktober");
                        break;
                    case 10:
                        mSum.setText("Rp. "+dbHelper.selectSumPeriod("Nopember"));
                        listitem = dbHelper.getDataRekap("Nopember");
                        adapter = new RekapAdapter(listitem, getActivity());
                        onClickExport("Nopember");
                        break;
                    case 11:
                        mSum.setText("Rp. "+dbHelper.selectSumPeriod("Desember"));
                        listitem = dbHelper.getDataRekap("Desember");
                        adapter = new RekapAdapter(listitem, getActivity());
                        onClickExport("Desember");
                        break;
                }
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        return v;
    }

    private void onClickExport(final String bulan){
        mExportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dbHelper.createXls(bulan,getContext());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
