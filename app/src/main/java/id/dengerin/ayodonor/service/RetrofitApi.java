package id.dengerin.ayodonor.service;

import id.dengerin.ayodonor.model.BaseJadwal;
import id.dengerin.ayodonor.model.BaseList;
import id.dengerin.ayodonor.model.BaseStok;
import id.dengerin.ayodonor.model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Kristiawan on 21/04/18.
 * this class for example
 */
public interface RetrofitApi {

    @GET
    Call<BaseList> getListAll(@Url String url,
                              @Query("service") String service);

    @GET
    Call<BaseStok> getStok(@Url String url,
                           @Query("service") String service,
                           @Query("gol") String gol,
                           @Query("produk") String produk,
                           @Query("provinsi") String provinsi);

    @GET
    Call<BaseJadwal> getJadwal(@Url String url,
                               @Query("service") String service,
                               @Query("tanggal") String tanggal,
                               @Query("provinsi") String provinsi);
}
