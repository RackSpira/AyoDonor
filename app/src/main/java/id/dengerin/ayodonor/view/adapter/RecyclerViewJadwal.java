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
import id.dengerin.ayodonor.model.Jadwal;

/**
 * Created by joedhaalzelvin on 12/07/18.
 */

public class RecyclerViewJadwal extends RecyclerView.Adapter<RecyclerViewJadwal.ViewHolder> {
    private Context context;
    private List<Jadwal> jadwalList;

    public RecyclerViewJadwal(Context context, List<Jadwal> jadwalList) {
        this.context = context;
        this.jadwalList = jadwalList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewJadwal.ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_jadwal, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewInstansi.setText(jadwalList.get(position).getInstansi());
        holder.textViewJum.setText(jadwalList.get(position).getRencanaDonor());
        holder.textViewTime.setText(jadwalList.get(position).getJam());
        holder.textViewPlace.setText(jadwalList.get(position).getAlamat());
    }

    @Override
    public int getItemCount() {
        return jadwalList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_jum_value)
        TextView textViewJum;
        @BindView(R.id.tv_instansi_value)
        TextView textViewInstansi;
        @BindView(R.id.tv_time_value)
        TextView textViewTime;
        @BindView(R.id.tv_place_value)
        TextView textViewPlace;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
