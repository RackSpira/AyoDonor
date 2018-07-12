package id.dengerin.ayodonor.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.dengerin.ayodonor.R;
import id.dengerin.ayodonor.model.Gol;
import id.dengerin.ayodonor.view.ui.stokdarah.StokDarahActivity;

/**
 * Created by joedhaalzelvin on 11/07/18.
 */

public class RecyclerViewHome extends RecyclerView.Adapter<RecyclerViewHome.ViewHolder> {
    private Context context;
    private List<Gol> golList;
    private int pos;

    public RecyclerViewHome(Context context, List<Gol> golList) {
        this.context = context;
        this.golList = golList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHome.ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_main, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textViewGolDar.setText("Golongan "+golList.get(position).getContent());

        holder.listMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, StokDarahActivity.class);
                intent.putExtra("gol", golList.get(position).getValue());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return golList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_golongan_darah)
        TextView textViewGolDar;
        @BindView(R.id.list_main)
        ConstraintLayout listMain;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
