package com.example.qiulin.traffic.beans;

/**
 * Created by qiulin on 2015/1/21 0021.
 */
public class Alarm {
    private Long id;
    private String alarmStart;
    private String type;
    private String name;
    private Integer sex;
    private String tel;
    private String address;
    private String content;
    private String status;
    private String instructions;
    private String feedback;
    private String police;
    private String alarmEnd;
    private String weather;
    private String accident;
    private String reason;
    private String pavement;
    private String carType;
    private String createTime;
    private Integer isDel;
    private Long creater;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlarmStart() {
        return alarmStart;
    }

    public void setAlarmStart(String alarmStart) {
        this.alarmStart = alarmStart;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getPolice() {
        return police;
    }

    public void setPolice(String police) {
        this.police = police;
    }

    public String getAlarmEnd() {
        return alarmEnd;
    }

    public void setAlarmEnd(String alarmEnd) {
        this.alarmEnd = alarmEnd;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getAccident() {
        return accident;
    }

    public void setAccident(String accident) {
        this.accident = accident;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPavement() {
        return pavement;
    }

    public void setPavement(String pavement) {
        this.pavement = pavement;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "id=" + id +
                ", alarmStart='" + alarmStart + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", instructions='" + instructions + '\'' +
                ", feedback='" + feedback + '\'' +
                ", police='" + police + '\'' +
                ", alarmEnd='" + alarmEnd + '\'' +
                ", weather='" + weather + '\'' +
                ", accident='" + accident + '\'' +
                ", reason='" + reason + '\'' +
                ", pavement='" + pavement + '\'' +
                ", carType='" + carType + '\'' +
                ", createTime='" + createTime + '\'' +
                ", isDel=" + isDel +
                ", creater=" + creater +
                '}';
    }
}
