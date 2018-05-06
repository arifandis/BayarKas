package squad.seven.bayarkas.Fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import squad.seven.bayarkas.R;
import squad.seven.bayarkas.RekapitulasiDetail;

    /**
     * Created by afridha on 05/05/18.
     */

    public class RekapAdapter extends RecyclerView.Adapter<RekapAdapter.ViewHolder>{
        private List<RekapitulasiDetail> listitem;
        private Context context;

        public RekapAdapter(List<RekapitulasiDetail> listitem, Context context) {
            this.listitem = listitem;
            this.context = context;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            TextView namaOrang;
            TextView nominal;

            public ViewHolder(View view){
                super(view);
                namaOrang = view.findViewById(R.id.namaOrangRekap);
                nominal = view.findViewById(R.id.nominalListRekap);
            }

        }
        @Override
        public RekapAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_rekap, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RekapAdapter.ViewHolder holder, int position) {
            final RekapitulasiDetail listItem = listitem.get(position);
            holder.namaOrang.setText(listItem.getNama());
            holder.nominal.setText("Rp. "+listItem.getNominal());

        }

        @Override
        public int getItemCount() {
            return listitem.size();
        }



    }

