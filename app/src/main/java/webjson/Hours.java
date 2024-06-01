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

public class Hours {

    private String hours;
    private String wea;
    @JsonProperty("wea_img")
    private String weaImg;
    private String tem;
    private String win;

    private String win_speed;
    private String vis;
    private String aqinum;
    private String aqi;

    public void setHours(String hours) {
        this.hours = hours;
    }
    public String getHours() {
        return this.hours;
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
    public void setWin(String win) {
        this.win = win;
    }
    public String getWin() {
        return this.win;
    }
    public void setWin_speed(String win_speed) {
        this.win_speed = win_speed;
    }
    public String getWin_speed() {
        return this.win_speed;
    }
    public void setVis(String vis) {
        this.vis = vis;
    }
    public String getVis() {
        return this.vis;
    }
    public void setAqinum(String aqinum) {
        this.aqinum = aqinum;
    }
    public String getAqinum() {
        return this.aqinum;
    }
    public void setAqi(String aqi) {
        this.aqi = aqi;
    }
    public String getAqi() {
        return this.aqi;
    }
}