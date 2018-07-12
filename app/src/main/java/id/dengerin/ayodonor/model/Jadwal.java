
package id.dengerin.ayodonor.model;

import com.google.gson.annotations.SerializedName;

public class Jadwal {

    @SerializedName("alamat")
    private String mAlamat;
    @SerializedName("instansi")
    private String mInstansi;
    @SerializedName("jam")
    private String mJam;
    @SerializedName("rencana_donor")
    private String mRencanaDonor;

    public String getAlamat() {
        return mAlamat;
    }

    public void setAlamat(String alamat) {
        mAlamat = alamat;
    }

    public String getInstansi() {
        return mInstansi;
    }

    public void setInstansi(String instansi) {
        mInstansi = instansi;
    }

    public String getJam() {
        return mJam;
    }

    public void setJam(String jam) {
        mJam = jam;
    }

    public String getRencanaDonor() {
        return mRencanaDonor;
    }

    public void setRencanaDonor(String rencanaDonor) {
        mRencanaDonor = rencanaDonor;
    }

}
