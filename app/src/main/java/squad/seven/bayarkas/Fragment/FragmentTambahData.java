package squad.seven.bayarkas.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import squad.seven.bayarkas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTambahData extends Fragment {


    public FragmentTambahData() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tambah_data, container, false);
    }

}