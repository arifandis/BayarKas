package squad.seven.bayarkas.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import squad.seven.bayarkas.DataHelper;
import squad.seven.bayarkas.HistoryKas;
import squad.seven.bayarkas.R;

public class ViewHistoryFragment extends Fragment {
    TextView dateTxt;
    Button tambahKas;
    DataHelper dbHelper;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<HistoryKas> listitem;

    public ViewHistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_view_history, container, false);
        tambahKas = v.findViewById(R.id.button_tambah);
        dateTxt = v.findViewById(R.id.date_id);
        recyclerView = v.findViewById(R.id.recycler_list_history);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);

        dateTxt.setText(getDay()+", "+" "+getDayInt()+" "+getMonth()+" "+getYear());

        LinearLayoutManager linearLayout = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayout);
        linearLayout.setStackFromEnd(true);

        dbHelper = new DataHelper(getActivity());
        listitem = dbHelper.getDataHistory();
        adapter = new ViewHistoryAdapter(listitem,getActivity());

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        tambahKas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTambahKas();
            }
        });
        return v;
    }

    void goToTambahKas(){
        Fragment fragment = new FragmentTambahKas();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_view,fragment);
        transaction.commit();
    }

    String getDay(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        String hari=null;

        switch (day) {
            case Calendar.SUNDAY:
                hari="Minggu";
                break;
            case Calendar.MONDAY:
                hari="Senin";
                break;
            case Calendar.TUESDAY:
                hari="Selasa";
                break;
            case Calendar.WEDNESDAY:
                hari="Rabu";
                break;
            case Calendar.THURSDAY:
                hari="Kamis";
                break;
            case Calendar.FRIDAY:
                hari="Jum'at";
                break;
            case Calendar.SATURDAY:
                hari="Sabtu";
                break;
        }
        return hari;
    }

    int getDayInt(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);

        return day;
    }

    String getMonth(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
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
