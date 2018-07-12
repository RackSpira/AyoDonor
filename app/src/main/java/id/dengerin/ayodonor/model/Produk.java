
package id.dengerin.ayodonor.model;

import com.google.gson.annotations.SerializedName;

public class Produk {

    @SerializedName("content")
    private String mContent;
    @SerializedName("value")
    private String mValue;

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }

}
