package squad.seven.bayarkas.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import squad.seven.bayarkas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTambahKas extends Fragment {

    public FragmentTambahKas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tambah_kas, container, false);
        return v;
    }

}
