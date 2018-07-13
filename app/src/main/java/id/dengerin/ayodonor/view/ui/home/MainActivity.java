package id.dengerin.ayodonor.view.ui.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.dengerin.ayodonor.R;
import id.dengerin.ayodonor.model.Gol;
import id.dengerin.ayodonor.view.adapter.RecyclerViewHome;
import id.dengerin.ayodonor.view.ui.jadwal.JadwalActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainMvp {
    @BindView(R.id.slider)
    SliderLayout sliderLayout;
    @BindView(R.id.rv_jenis_darah)
    RecyclerView recyclerView;
    @BindView(R.id.iv_bg_jadwal)
    ImageView imageView;

    private ProgressDialog progressDialog;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new MainPresenter(this);

        showLoading();
        addSlider();
        presenter.getGolList();

        imageView.setOnClickListener(this);
    }

    private void addSlider(){
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Ayo Selamatkan Saudara Kita", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/37011644_1984931951551126_864565998877933568_n.jpg?_nc_cat=0&oh=72e8b8be62f84ab9ca929f957f916371&oe=5BE24A90");
        url_maps.put("Terimakasih Sudah Donor", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/36935860_1984931651551156_8079047849888710656_n.jpg?_nc_cat=0&oh=ce80681fa55a8a7f0094c500a8872fd4&oe=5BA25429");
        url_maps.put("Ayo Donor", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/36958373_1984931334884521_4776535942808731648_n.jpg?_nc_cat=0&oh=65197cc14cb3578ce3f26a2298450037&oe=5BEC1ED0");

        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_bg_jadwal:
                Intent intent = new Intent(MainActivity.this, JadwalActivity.class);
                startActivity(intent); break;
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
    public void showGolDar(List<Gol> golList) {
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        RecyclerViewHome adapter = new RecyclerViewHome(this, golList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        removeLoading();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
        removeLoading();
    }
}
