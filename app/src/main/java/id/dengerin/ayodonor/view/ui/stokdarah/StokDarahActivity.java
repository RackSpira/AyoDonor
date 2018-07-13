package id.dengerin.ayodonor.view.ui.stokdarah;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.dengerin.ayodonor.R;
import id.dengerin.ayodonor.model.Produk;
import id.dengerin.ayodonor.model.Provinsi;
import id.dengerin.ayodonor.model.Stok;
import id.dengerin.ayodonor.view.adapter.RecyclerViewStokDarah;

public class StokDarahActivity extends AppCompatActivity implements StokDarahMvp, View.OnClickListener {
    @BindView(R.id.spiner_daerah)
    Spinner spinnerDaerah;
    @BindView(R.id.spiner_produk)
    Spinner spinnerProduk;
    @BindView(R.id.rv_stok_darah)
    RecyclerView recyclerViewStokDarah;
    @BindView(R.id.iv_back_stok)
    ImageView imageViewBack;

    private ProgressDialog progressDialog;
    private StokDarahPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stok_darah);

        ButterKnife.bind(this);

        final String golDar = getIntent().getExtras().getString("gol");

        presenter = new StokDarahPresenter(this);
        showLoading();
        presenter.getProduk();
        presenter.getProvinsi();

        spinnerDaerah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    showLoading();
                    presenter.getStok(golDar, spinnerProduk.getSelectedItem().toString(), spinnerDaerah.getSelectedItem().toString());
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerProduk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    showLoading();
                    presenter.getStok(golDar, spinnerProduk.getSelectedItem().toString(), spinnerDaerah.getSelectedItem().toString());
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        imageViewBack.setOnClickListener(this);
    }

    @Override
    public void showLoading() {
        if (progressDialog != null) {
            progressDialog.show();
        } else {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please Wait");
            progressDialog.show();
        }
    }

    @Override
    public void removeLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showProduk(List<Produk> produkList) {
        String[] produkArray = new String[produkList.size()];

        for (int i = 0; i < produkList.size(); i++){
            produkArray[i] = produkList.get(i).getValue();
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, produkArray);

        spinnerProduk.setAdapter(dataAdapter);

        removeLoading();
    }

    @Override
    public void showProvinsi(List<Provinsi> provinsiList) {
        String[] provinsiArray = new String[provinsiList.size()];

        for (int i = 0; i < provinsiList.size(); i++){
            provinsiArray[i] = provinsiList.get(i).getValue();
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, provinsiArray);

        spinnerDaerah.setAdapter(dataAdapter);

        removeLoading();
    }

    @Override
    public void showStokDarah(List<Stok> stokList) {
        recyclerViewStokDarah.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        RecyclerViewStokDarah adapter = new RecyclerViewStokDarah(this, stokList);
        recyclerViewStokDarah.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        removeLoading();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
        removeLoading();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back_stok:
                finish(); break;
        }
    }
}
