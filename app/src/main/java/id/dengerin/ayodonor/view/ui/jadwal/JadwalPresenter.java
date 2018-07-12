package id.dengerin.ayodonor.view.ui.jadwal;

import id.dengerin.ayodonor.model.BaseJadwal;
import id.dengerin.ayodonor.model.BaseList;
import id.dengerin.ayodonor.service.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by joedhaalzelvin on 12/07/18.
 */

public class JadwalPresenter {
    private JadwalMvp view;

    public JadwalPresenter(JadwalMvp view) {
        this.view = view;
    }

    void getProvinsi(){
        ApiService.newInstance()
                .getUserService()
                .getListAll()
                .enqueue(new Callback<BaseList>() {
                    @Override
                    public void onResponse(Call<BaseList> call, Response<BaseList> response) {
                        try {
                            if (response.body().getStatus().equals("success"))
                                view.showProvinsi(response.body().getData().getProvinsi());
                            else
                                view.showError("Gagal Mengambil Data");
                        } catch (Exception e){
                            view.showError(e.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseList> call, Throwable t) {
                        view.showError(t.getMessage());
                    }
                });
    }

    void getJadwal(String tanggal, String provinsi){
        ApiService.newInstance()
                .getUserService()
                .getJadwal(tanggal, provinsi)
                .enqueue(new Callback<BaseJadwal>() {
                    @Override
                    public void onResponse(Call<BaseJadwal> call, Response<BaseJadwal> response) {
                        try {
                            if (response.body().getStatus().equals("success"))
                                view.showJadwalDonor(response.body().getData());
                            else
                                view.showError("Gagal Mengambil Data");
                        } catch (Exception e){
                            view.showError(e.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseJadwal> call, Throwable t) {
                        view.showError(t.getMessage());
                    }
                });
    }
}
