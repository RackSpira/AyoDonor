
package id.dengerin.ayodonor.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BaseJadwal {

    @SerializedName("data")
    private List<Jadwal> mData;
    @SerializedName("status")
    private String mStatus;

    public List<Jadwal> getData() {
        return mData;
    }

    public void setData(List<Jadwal> data) {
        mData = data;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
