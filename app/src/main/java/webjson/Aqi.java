/**
 * Copyright 2024 lzltool.com
 */

package webjson;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Auto-generated: 2024-05-27 19:39:32
 *
 * @author lzltool.com
 * @website https://www.lzltool.com/JsonToJava
 */

public class Aqi {

    @JsonProperty("update_time")
    private String updateTime;
    private String cityid;
    private String city;
    private String cityEn;
    private String country;
    private String countryEn;
    private String air;
    @JsonProperty("air_level")
    private String airLevel;
    @JsonProperty("air_tips")
    private String airTips;
    private String pm25;
    @JsonProperty("pm25_desc")
    private String pm25Desc;
    private String pm10;
    @JsonProperty("pm10_desc")
    private String pm10Desc;
    private String o3;
    @JsonProperty("o3_desc")
    private String o3Desc;
    private String no2;
    @JsonProperty("no2_desc")
    private String no2Desc;
    private String so2;
    @JsonProperty("so2_desc")
    private String so2Desc;
    private String co;
    @JsonProperty("co_desc")
    private String coDesc;
    private String kouzhao;
    private String yundong;
    private String waichu;
    private String kaichuang;
    private String jinghuaqi;

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public String getUpdateTime() {
        return this.updateTime;
    }
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
    public void setAir(String air) {
        this.air = air;
    }
    public String getAir() {
        return this.air;
    }
    public void setAirLevel(String airLevel) {
        this.airLevel = airLevel;
    }
    public String getAirLevel() {
        return this.airLevel;
    }
    public void setAirTips(String airTips) {
        this.airTips = airTips;
    }
    public String getAirTips() {
        return this.airTips;
    }
    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }
    public String getPm25() {
        return this.pm25;
    }
    public void setPm25Desc(String pm25Desc) {
        this.pm25Desc = pm25Desc;
    }
    public String getPm25Desc() {
        return this.pm25Desc;
    }
    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }
    public String getPm10() {
        return this.pm10;
    }
    public void setPm10Desc(String pm10Desc) {
        this.pm10Desc = pm10Desc;
    }
    public String getPm10Desc() {
        return this.pm10Desc;
    }
    public void setO3(String o3) {
        this.o3 = o3;
    }
    public String getO3() {
        return this.o3;
    }
    public void setO3Desc(String o3Desc) {
        this.o3Desc = o3Desc;
    }
    public String getO3Desc() {
        return this.o3Desc;
    }
    public void setNo2(String no2) {
        this.no2 = no2;
    }
    public String getNo2() {
        return this.no2;
    }
    public void setNo2Desc(String no2Desc) {
        this.no2Desc = no2Desc;
    }
    public String getNo2Desc() {
        return this.no2Desc;
    }
    public void setSo2(String so2) {
        this.so2 = so2;
    }
    public String getSo2() {
        return this.so2;
    }
    public void setSo2Desc(String so2Desc) {
        this.so2Desc = so2Desc;
    }
    public String getSo2Desc() {
        return this.so2Desc;
    }
    public void setCo(String co) {
        this.co = co;
    }
    public String getCo() {
        return this.co;
    }
    public void setCoDesc(String coDesc) {
        this.coDesc = coDesc;
    }
    public String getCoDesc() {
        return this.coDesc;
    }
    public void setKouzhao(String kouzhao) {
        this.kouzhao = kouzhao;
    }
    public String getKouzhao() {
        return this.kouzhao;
    }
    public void setYundong(String yundong) {
        this.yundong = yundong;
    }
    public String getYundong() {
        return this.yundong;
    }
    public void setWaichu(String waichu) {
        this.waichu = waichu;
    }
    public String getWaichu() {
        return this.waichu;
    }
    public void setKaichuang(String kaichuang) {
        this.kaichuang = kaichuang;
    }
    public String getKaichuang() {
        return this.kaichuang;
    }
    public void setJinghuaqi(String jinghuaqi) {
        this.jinghuaqi = jinghuaqi;
    }
    public String getJinghuaqi() {
        return this.jinghuaqi;
    }
}