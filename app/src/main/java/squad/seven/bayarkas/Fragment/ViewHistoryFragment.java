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

import squad.seven.bayarkas.HistoryKas;
import squad.seven.bayarkas.R;

public class ViewHistoryFragment extends Fragment {
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
        recyclerView = v.findViewById(R.id.recycler_list_history);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayout = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayout);
        linearLayout.setStackFromEnd(true);

        listitem = new ArrayList<>();
        for (int i = 0; i<100; i++){
            HistoryKas listitems = new HistoryKas("namaorang"+(i+1), "1000"+(i+1));
            listitem.add(listitems);
        }

        adapter = new ViewHistoryAdapter(listitem, this.getActivity());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return v;
    }

}
