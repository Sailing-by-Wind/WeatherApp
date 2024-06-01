/**
 * Copyright 2024 lzltool.com
 */

package webjson;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Auto-generated: 2024-05-27 19:20:41
 *
 * @author lzltool.com
 * @website https://www.lzltool.com/JsonToJava
 */

public class JsonRootBean implements Serializable {

    private String cityid;
    private Date date;
    private String week;
    @JsonProperty("update_time")
    private String updateTime;
    private String city;
    private String cityEn;
    private String country;
    private String countryEn;
    private String wea;
    @JsonProperty("wea_img")
    private String weaImg;
    private String tem;
    private String tem1;
    private String tem2;
    private String win;
    private String win_speed;
    @JsonProperty("win_meter")
    private String winMeter;
    private String humidity;
    private String visibility;
    private String pressure;
    private String air;

    private String air_pm25;
    @JsonProperty("air_level")
    private String airLevel;
    @JsonProperty("air_tips")
    private String airTips;
    private List<Alarm> alarm;
    @JsonProperty("rain_pcpn")
    private String rainPcpn;
    private String uvIndex;
    private String uvDescription;
    @JsonProperty("wea_day")
    private String weaDay;
    @JsonProperty("wea_day_img")
    private String weaDayImg;
    @JsonProperty("wea_night")
    private String weaNight;
    @JsonProperty("wea_night_img")
    private String weaNightImg;
    private String sunrise;
    private String sunset;
    private List<Hours> hours;
    private Aqi aqi;

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }
    public String getCityid() {
        return this.cityid;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return this.date;
    }
    public void setWeek(String week) {
        this.week = week;
    }
    public String getWeek() {
        return this.week;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public String getUpdateTime() {
        return this.updateTime;
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
    public void setWea(String wea) {
        this.wea = wea;
    }
    public String getWea() {
        return this.wea;
    }
    public void setWeaImg(String weaImg) {
        this.weaImg = weaImg;
    }
    public String getWeaImg() {
        return this.weaImg;
    }
    public void setTem(String tem) {
        this.tem = tem;
    }
    public String getTem() {
        return this.tem;
    }
    public void setTem1(String tem1) {
        this.tem1 = tem1;
    }
    public String getTem1() {
        return this.tem1;
    }
    public void setTem2(String tem2) {
        this.tem2 = tem2;
    }
    public String getTem2() {
        return this.tem2;
    }
    public void setWin(String win) {
        this.win = win;
    }
    public String getWin() {
        return this.win;
    }
    public void setWinSpeed(String winSpeed) {
        this.win_speed = winSpeed;
    }
    public String getWinSpeed() {
        return this.win_speed;
    }
    public void setWinMeter(String winMeter) {
        this.winMeter = winMeter;
    }
    public String getWinMeter() {
        return this.winMeter;
    }
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
    public String getHumidity() {
        return this.humidity;
    }
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
    public String getVisibility() {
        return this.visibility;
    }
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }
    public String getPressure() {
        return this.pressure;
    }
    public void setAir(String air) {
        this.air = air;
    }
    public String getAir() {
        return this.air;
    }
    public void setAirPm25(String airPm25) {
        this.air_pm25 = airPm25;
    }
    public String getAirPm25() {
        return this.air_pm25;
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
    public void setAlarm(List<Alarm> alarm) {
        this.alarm = alarm;
    }
    public List<Alarm> getAlarm() {
        return this.alarm;
    }
    public void setRainPcpn(String rainPcpn) {
        this.rainPcpn = rainPcpn;
    }
    public String getRainPcpn() {
        return this.rainPcpn;
    }
    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }
    public String getUvIndex() {
        return this.uvIndex;
    }
    public void setUvDescription(String uvDescription) {
        this.uvDescription = uvDescription;
    }
    public String getUvDescription() {
        return this.uvDescription;
    }
    public void setWeaDay(String weaDay) {
        this.weaDay = weaDay;
    }
    public String getWeaDay() {
        return this.weaDay;
    }
    public void setWeaDayImg(String weaDayImg) {
        this.weaDayImg = weaDayImg;
    }
    public String getWeaDayImg() {
        return this.weaDayImg;
    }
    public void setWeaNight(String weaNight) {
        this.weaNight = weaNight;
    }
    public String getWeaNight() {
        return this.weaNight;
    }
    public void setWeaNightImg(String weaNightImg) {
        this.weaNightImg = weaNightImg;
    }
    public String getWeaNightImg() {
        return this.weaNightImg;
    }
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }
    public String getSunrise() {
        return this.sunrise;
    }
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
    public String getSunset() {
        return this.sunset;
    }
    public void setHours(List<Hours> hours) {
        this.hours = hours;
    }
    public List<Hours> getHours() {
        return this.hours;
    }
    public void setAqi(Aqi aqi) {
        this.aqi = aqi;
    }
    public Aqi getAqi() {
        return this.aqi;
    }
}