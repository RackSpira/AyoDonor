
package id.dengerin.ayodonor.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("gol")
    private List<Gol> mGol;
    @SerializedName("produk")
    private List<Produk> mProduk;
    @SerializedName("provinsi")
    private List<Provinsi> mProvinsi;

    public List<Gol> getGol() {
        return mGol;
    }

    public void setGol(List<Gol> gol) {
        mGol = gol;
    }

    public List<Produk> getProduk() {
        return mProduk;
    }

    public void setProduk(List<Produk> produk) {
        mProduk = produk;
    }

    public List<Provinsi> getProvinsi() {
        return mProvinsi;
    }

    public void setProvinsi(List<Provinsi> provinsi) {
        mProvinsi = provinsi;
    }

}
