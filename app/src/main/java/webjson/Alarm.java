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

public class Alarm {

    @JsonProperty("alarm_type")
    private String alarmType;
    @JsonProperty("alarm_level")
    private String alarmLevel;
    @JsonProperty("alarm_title")
    private String alarmTitle;
    @JsonProperty("alarm_content")
    private String alarmContent;

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }
    public String getAlarmType() {
        return this.alarmType;
    }
    public void setAlarmLevel(String alarmLevel) {
        this.alarmLevel = alarmLevel;
    }
    public String getAlarmLevel() {
        return this.alarmLevel;
    }
    public void setAlarmTitle(String alarmTitle) {
        this.alarmTitle = alarmTitle;
    }
    public String getAlarmTitle() {
        return this.alarmTitle;
    }
    public void setAlarmContent(String alarmContent) {
        this.alarmContent = alarmContent;
    }
    public String getAlarmContent() {
        return this.alarmContent;
    }
}