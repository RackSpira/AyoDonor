package id.dengerin.ayodonor.view.ui.home;

import id.dengerin.ayodonor.model.BaseList;
import id.dengerin.ayodonor.service.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by joedhaalzelvin on 12/07/18.
 */

public class MainPresenter {
    private MainMvp view;

    public MainPresenter(MainMvp view) {
        this.view = view;
    }

    void getGolList(){
        ApiService.newInstance()
                .getUserService()
                .getListAll()
                .enqueue(new Callback<BaseList>() {
                    @Override
                    public void onResponse(Call<BaseList> call, Response<BaseList> response) {
                        try {
                            if (response.body().getStatus().equals("success"))
                                view.showGolDar(response.body().getData().getGol());
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
}
