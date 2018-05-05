package squad.seven.bayarkas.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import squad.seven.bayarkas.R;
import squad.seven.bayarkas.RekapitulasiDetail;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRekap extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<RekapitulasiDetail> listitem;

    public FragmentRekap() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rekap, container, false);

        recyclerView = v.findViewById(R.id.recycler_list_rekap);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayout = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayout);
        linearLayout.setStackFromEnd(true);

        listitem = new ArrayList<>();
        for (int i = 0; i<100; i++){
            RekapitulasiDetail listitems = new RekapitulasiDetail("namaorang"+(i+1), "1000"+(i+1));
            listitem.add(listitems);
            }

        adapter = new RekapAdapter(listitem, this.getActivity());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return v;
    }

}
