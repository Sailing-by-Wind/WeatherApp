/**
 * Copyright 2024 lzltool.com
 */

package webjson;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Auto-generated: 2024-06-03 19:09:44
 *
 * @author lzltool.com
 * @website https://www.lzltool.com/JsonToJava
 */

public class DayData {

    private String day;
    private Date date;
    private String week;
    private String wea;
    @JsonProperty("wea_img")
    private String weaImg;
    @JsonProperty("wea_day")
    private String weaDay;
    @JsonProperty("wea_day_img")
    private String weaDayImg;
    @JsonProperty("wea_night")
    private String weaNight;
    @JsonProperty("wea_night_img")
    private String weaNightImg;
    private String tem;
    private String tem1;
    private String tem2;
    private String humidity;
    private String visibility;
    private String pressure;
    private List<String> win;
    @JsonProperty("win_speed")
    private String winSpeed;
    @JsonProperty("win_meter")
    private String winMeter;
    private String sunrise;
    private String sunset;
    private String air;
    @JsonProperty("air_level")
    private String airLevel;
    @JsonProperty("air_tips")
    private String airTips;
    private String phrase;
    private String narrative;
    private String moonrise;
    private String moonset;
    private String moonPhrase;
    private String rain;
    private String uvIndex;
    private String uvDescription;
    @JsonProperty("rain_pcpn")
    private String rainPcpn;
    private List<Alarm> alarm;

    public void setDay(String day) {
        this.day = day;
    }
    public String getDay() {
        return this.day;
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
    public void setWin(List<String> win) {
        this.win = win;
    }
    public List<String> getWin() {
        return this.win;
    }
    public void setWinSpeed(String winSpeed) {
        this.winSpeed = winSpeed;
    }
    public String getWinSpeed() {
        return this.winSpeed;
    }
    public void setWinMeter(String winMeter) {
        this.winMeter = winMeter;
    }
    public String getWinMeter() {
        return this.winMeter;
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
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
    public String getPhrase() {
        return this.phrase;
    }
    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }
    public String getNarrative() {
        return this.narrative;
    }
    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }
    public String getMoonrise() {
        return this.moonrise;
    }
    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }
    public String getMoonset() {
        return this.moonset;
    }
    public void setMoonPhrase(String moonPhrase) {
        this.moonPhrase = moonPhrase;
    }
    public String getMoonPhrase() {
        return this.moonPhrase;
    }
    public void setRain(String rain) {
        this.rain = rain;
    }
    public String getRain() {
        return this.rain;
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
    public void setRainPcpn(String rainPcpn) {
        this.rainPcpn = rainPcpn;
    }
    public String getRainPcpn() {
        return this.rainPcpn;
    }
    public void setAlarm(List<Alarm> alarm) {
        this.alarm = alarm;
    }
    public List<Alarm> getAlarm() {
        return this.alarm;
    }
}