package com.zjmobile.apple.moeweather.util;

import android.text.TextUtils;

import com.zjmobile.apple.moeweather.db.City;
import com.zjmobile.apple.moeweather.db.County;
import com.zjmobile.apple.moeweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by apple on 17/5/10.
 */

public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response)
    {
        if (!TextUtils.isEmpty(response))
        {
            try {
                JSONArray allProvinces= new JSONArray(response);
                for (int i =0;i< allProvinces.length();i++)
                {
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     * @param response
     * @param provinceId
     * @return
     */

    public static boolean handleCitiesResponse(String response, int provinceId)
    {
        if (!TextUtils.isEmpty(response))
        {
            try {
                JSONArray allCitys= new JSONArray(response);
                for (int i =0;i< allCitys.length();i++)
                {
                    JSONObject cityObject=allCitys.getJSONObject(i);
                    City city=new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProcinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public static boolean handleCountiesResponse(String response, int cityId)
    {
        if (!TextUtils.isEmpty(response))
        {
            try {
                JSONArray allCountys= new JSONArray(response);
                for (int i =0;i< allCountys.length();i++)
                {
                    JSONObject cityObject=allCountys.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(cityObject.getString("name"));
                    county.setWeatherId(cityObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }




}
