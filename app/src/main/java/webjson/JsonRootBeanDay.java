/**
 * Copyright 2024 lzltool.com
 */

package webjson;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Auto-generated: 2024-06-03 19:05:47
 *
 * @author lzltool.com
 * @website https://www.lzltool.com/JsonToJava
 */

public class JsonRootBeanDay implements Serializable {

    private String cityid;
    private String city;
    private String cityEn;
    private String country;
    private String countryEn;
    @JsonProperty("update_time")
    private Date updateTime;
    private List<DayData> data;
    private int nums;
    private Aqi aqi;

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }
    public String getCityid() {
        return this.cityid;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return this.city;
    }
    public void setCityEn(String cityEn) {
        this.cityEn = cityEn;
    }
    public String getCityEn() {
        return this.cityEn;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCountry() {
        return this.country;
    }
    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }
    public String getCountryEn() {
        return this.countryEn;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Date getUpdateTime() {
        return this.updateTime;
    }
    public void setData(List<DayData> data) {
        this.data = data;
    }
    public List<DayData> getData() {
        return this.data;
    }
    public void setNums(int nums) {
        this.nums = nums;
    }
    public int getNums() {
        return this.nums;
    }
    public void setAqi(Aqi aqi) {
        this.aqi = aqi;
    }
    public Aqi getAqi() {
        return this.aqi;
    }
}