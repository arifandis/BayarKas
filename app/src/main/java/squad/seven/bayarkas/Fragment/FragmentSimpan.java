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
public class FragmentSimpan extends Fragment {


    public FragmentSimpan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_simpan, container, false);

        return v;
    }

}
