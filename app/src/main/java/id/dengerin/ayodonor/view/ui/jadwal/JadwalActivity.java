package id.dengerin.ayodonor.view.ui.jadwal;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.dengerin.ayodonor.R;
import id.dengerin.ayodonor.model.Jadwal;
import id.dengerin.ayodonor.model.Provinsi;
import id.dengerin.ayodonor.view.adapter.RecyclerViewJadwal;

public class JadwalActivity extends AppCompatActivity implements View.OnClickListener, JadwalMvp {
    @BindView(R.id.spiner_daerah)
    Spinner spinnerDaerah;
    @BindView(R.id.tv_date)
    TextView textViewDate;
    @BindView(R.id.rv_jadwal)
    RecyclerView recyclerViewJadwal;
    @BindView(R.id.iv_back_jadwal)
    ImageView imageViewBack;

    public static final String[] MONTHS = {"Januari", "Februari", "Maret", "April",
            "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

    public static final String[] MONTHS_NUMBER = {"01", "02", "03", "04",
            "05", "06", "07", "08", "09", "10", "11", "12"};

    private JadwalPresenter presenter;
    private ProgressDialog progressDialog;
    private String dateParameter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        ButterKnife.bind(this);

        presenter = new JadwalPresenter(this);
        showLoading();
        presenter.getProvinsi();

        SimpleDateFormat sdf = new SimpleDateFormat( "MM/dd/yyyy" );
        SimpleDateFormat sdfName = new SimpleDateFormat( "dd MMMM yyyy" );
        String tanggal=sdfName.format( new Date() );
        textViewDate.setText(tanggal);

        dateParameter = sdf.format(new Date());

        textViewDate.setOnClickListener(this);

        spinnerDaerah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    showLoading();
                    presenter.getJadwal(dateParameter, spinnerDaerah.getSelectedItem().toString());
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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_date:
                Calendar calendar=Calendar.getInstance();
                int tahun=calendar.get(Calendar.YEAR);
                int bulan=calendar.get(Calendar.MONTH);
                int hari=calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog=new DatePickerDialog(JadwalActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String date=day+" "+MONTHS[month]+" "+year;
                        textViewDate.setText(date);

                        dateParameter=MONTHS_NUMBER[month]+"/"+formatTanggal(""+day)+"/"+year;
                        showLoading();
                        presenter.getJadwal(dateParameter, spinnerDaerah.getSelectedItem().toString());
                    }
                }, tahun, bulan, hari);
                datePickerDialog.show();
            case R.id.iv_back_jadwal:
                finish();
        }
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
    public void showJadwalDonor(List<Jadwal> jadwalList) {
        recyclerViewJadwal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        RecyclerViewJadwal adapter = new RecyclerViewJadwal(this, jadwalList);
        recyclerViewJadwal.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        removeLoading();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
        removeLoading();
    }

    String formatTanggal(String tanggal){
        if (tanggal.length()!=2)
            return "0"+tanggal;
        else
            return tanggal;
    }
}
