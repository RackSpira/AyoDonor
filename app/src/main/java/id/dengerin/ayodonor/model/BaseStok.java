
package id.dengerin.ayodonor.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BaseStok {

    @SerializedName("data")
    private List<Stok> mData;
    @SerializedName("status")
    private String mStatus;

    public List<Stok> getData() {
        return mData;
    }

    public void setData(List<Stok> data) {
        mData = data;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
