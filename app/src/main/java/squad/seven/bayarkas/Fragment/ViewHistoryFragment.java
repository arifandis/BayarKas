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

import java.util.ArrayList;
import java.util.List;

import squad.seven.bayarkas.DataHelper;
import squad.seven.bayarkas.HistoryKas;
import squad.seven.bayarkas.R;

public class ViewHistoryFragment extends Fragment {
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
        recyclerView = v.findViewById(R.id.recycler_list_history);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);

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

}
