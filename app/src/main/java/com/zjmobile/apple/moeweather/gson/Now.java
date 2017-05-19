package com.zjmobile.apple.moeweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by apple on 17/5/17.
 */

public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More
    {
        @SerializedName("txt")
        public String info;
    }
}
