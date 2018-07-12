package id.dengerin.ayodonor.service;


import id.dengerin.ayodonor.common.ApiUrl;
import id.dengerin.ayodonor.model.BaseJadwal;
import id.dengerin.ayodonor.model.BaseList;
import id.dengerin.ayodonor.model.BaseStok;
import id.dengerin.ayodonor.model.User;
import id.dengerin.ayodonor.util.Constanta;
import retrofit2.Call;

/**
 * Created by Kristiawan on 21/04/18.
 * this class for example
 */
public class RetrofitService extends BaseService<RetrofitApi> {

    private static RetrofitService instance;

    public static RetrofitService getInstance() {
        if (instance == null) {
            instance = new RetrofitService();
        }

        return instance;
    }

    public RetrofitService() {
        setApi(RetrofitApi.class);
    }

    public Call<BaseList> getListAll() {
        return getApi().getListAll(ApiUrl.API_URL, Constanta.SERVICE);
    }

    public Call<BaseStok> getStok(String gol, String produk, String provinsi) {
        return getApi().getStok(ApiUrl.API_URL, Constanta.SERVICE, gol, produk, provinsi);
    }

    public Call<BaseJadwal> getJadwal(String tanggal, String provinsi) {
        return getApi().getJadwal(ApiUrl.API_URL, Constanta.SERVICE, tanggal, provinsi);
    }
}
