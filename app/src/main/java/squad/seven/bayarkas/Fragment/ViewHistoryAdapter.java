package squad.seven.bayarkas.Fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import squad.seven.bayarkas.HistoryKas;
import squad.seven.bayarkas.R;

/**
 * Created by afridha on 05/05/18.
 */

public class ViewHistoryAdapter extends RecyclerView.Adapter<ViewHistoryAdapter.ViewHolder>{
    private List<HistoryKas> listitem;
    private Context context;

    public ViewHistoryAdapter(List<HistoryKas> listitem, Context context) {
        this.listitem = listitem;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView namaOrang;
        TextView nominal;

        public ViewHolder(View view){
            super(view);
            namaOrang = view.findViewById(R.id.namaOrangList);
            nominal = view.findViewById(R.id.jumlahNominalList);
        }

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final HistoryKas listItem = listitem.get(position);
        holder.namaOrang.setText(listItem.getNama());
        holder.nominal.setText(listItem.getNominal());

    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }



}
