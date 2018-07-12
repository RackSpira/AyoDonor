
package id.dengerin.ayodonor.model;

import com.google.gson.annotations.SerializedName;

public class Stok {

    @SerializedName("id")
    private String mId;
    @SerializedName("jumlah")
    private String mJumlah;
    @SerializedName("provinsi")
    private String mProvinsi;
    @SerializedName("unit")
    private String mUnit;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getJumlah() {
        return mJumlah;
    }

    public void setJumlah(String jumlah) {
        mJumlah = jumlah;
    }

    public String getProvinsi() {
        return mProvinsi;
    }

    public void setProvinsi(String provinsi) {
        mProvinsi = provinsi;
    }

    public String getUnit() {
        return mUnit;
    }

    public void setUnit(String unit) {
        mUnit = unit;
    }

}
