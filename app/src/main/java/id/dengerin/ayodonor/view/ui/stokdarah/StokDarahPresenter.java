package id.dengerin.ayodonor.view.ui.stokdarah;

import id.dengerin.ayodonor.model.BaseList;
import id.dengerin.ayodonor.model.BaseStok;
import id.dengerin.ayodonor.service.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by joedhaalzelvin on 12/07/18.
 */

public class StokDarahPresenter {
    private StokDarahMvp view;

    public StokDarahPresenter(StokDarahMvp view) {
        this.view = view;
    }

    void getProduk(){
        ApiService.newInstance()
                .getUserService()
                .getListAll()
                .enqueue(new Callback<BaseList>() {
                    @Override
                    public void onResponse(Call<BaseList> call, Response<BaseList> response) {
                        try {
                            if (response.body().getStatus().equals("success"))
                                view.showProduk(response.body().getData().getProduk());
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

    void getStok(String gol, String produk, String provinsi){
        ApiService.newInstance()
                .getUserService()
                .getStok(gol, produk, provinsi)
                .enqueue(new Callback<BaseStok>() {
                    @Override
                    public void onResponse(Call<BaseStok> call, Response<BaseStok> response) {
                        try {
                            if (response.body().getStatus().equals("success"))
                                view.showStokDarah(response.body().getData());
                            else
                                view.showError("Gagal Mengambil Data");
                        } catch (Exception e){
                            view.showError(e.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseStok> call, Throwable t) {
                        view.showError(t.getMessage());
                    }
                });
    }
}
