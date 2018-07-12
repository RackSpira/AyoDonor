package id.dengerin.ayodonor.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.dengerin.ayodonor.R;
import id.dengerin.ayodonor.model.Stok;

/**
 * Created by joedhaalzelvin on 11/07/18.
 */

public class RecyclerViewStokDarah extends RecyclerView.Adapter<RecyclerViewStokDarah.ViewHolder>{
    private Context context;
    private List<Stok> stokList;

    public RecyclerViewStokDarah(Context context, List<Stok> stokList) {
        this.context = context;
        this.stokList = stokList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewStokDarah.ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_stok_darah, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewJumlah.setText(stokList.get(position).getJumlah());
        holder.textViewUnit.setText(stokList.get(position).getUnit());
    }

    @Override
    public int getItemCount() {
        return stokList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_jum_value)
        TextView textViewJumlah;
        @BindView(R.id.tv_unit_value)
        TextView textViewUnit;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
