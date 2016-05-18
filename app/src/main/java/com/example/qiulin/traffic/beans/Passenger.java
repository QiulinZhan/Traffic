package com.example.qiulin.traffic.beans;

/**
 * Created by zhanq on 2016/5/18.
 */
public class Passenger {
    private Long id;
    //检查时间
    private String jcsj;
    //行驶证条形码
    private String xsztxm;

    //车号
    private String ch;
    //驾驶人驾驶证号
    private String jsrjszh;
    //驾驶人姓名
    private String jsrxm;
    //驾驶人驾驶证条形码
    private String jsrjsztxm;
    //驾驶人电话
    private String jsrdh;
    //驾驶人下次体检日期
    private String jsrxctjrq;
    //驾驶人资质检查
    private String jsrzzjc;
    //性质类别
    private String xzlb;
    //核定载客
    private String hdzk;
    //实际载客
    private String sjzk;
    //车辆下次检验日期
    private String cjrq;
    //轮胎磨损
    private String ltms;
    //安全设施
    private String aqss;
    //违法记录
    private String wfjl;
    //处置情况
    private String czqk;
    //连续驾驶时间
    private String lxjssj;

    //登记民警
    private String djmj;
    //源头管理民警
    private String ytglmj;
    //备注
    private String bz;
    private String createTime;
    private Integer isDel;
    private Long creater;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getJcsj() {
        return jcsj;
    }
    public void setJcsj(String jcsj) {
        this.jcsj = jcsj;
    }
    public String getXsztxm() {
        return xsztxm;
    }
    public void setXsztxm(String xsztxm) {
        this.xsztxm = xsztxm;
    }
    public String getCh() {
        return ch;
    }
    public void setCh(String ch) {
        this.ch = ch;
    }
    public String getJsrjszh() {
        return jsrjszh;
    }
    public void setJsrjszh(String jsrjszh) {
        this.jsrjszh = jsrjszh;
    }
    public String getJsrxm() {
        return jsrxm;
    }
    public void setJsrxm(String jsrxm) {
        this.jsrxm = jsrxm;
    }
    public String getJsrjsztxm() {
        return jsrjsztxm;
    }
    public void setJsrjsztxm(String jsrjsztxm) {
        this.jsrjsztxm = jsrjsztxm;
    }
    public String getJsrdh() {
        return jsrdh;
    }
    public void setJsrdh(String jsrdh) {
        this.jsrdh = jsrdh;
    }
    public String getJsrxctjrq() {
        return jsrxctjrq;
    }
    public void setJsrxctjrq(String jsrxctjrq) {
        this.jsrxctjrq = jsrxctjrq;
    }
    public String getJsrzzjc() {
        return jsrzzjc;
    }
    public void setJsrzzjc(String jsrzzjc) {
        this.jsrzzjc = jsrzzjc;
    }
    public String getXzlb() {
        return xzlb;
    }
    public void setXzlb(String xzlb) {
        this.xzlb = xzlb;
    }
    public String getHdzk() {
        return hdzk;
    }
    public void setHdzk(String hdzk) {
        this.hdzk = hdzk;
    }
    public String getSjzk() {
        return sjzk;
    }
    public void setSjzk(String sjzk) {
        this.sjzk = sjzk;
    }
    public String getCjrq() {
        return cjrq;
    }
    public void setCjrq(String cjrq) {
        this.cjrq = cjrq;
    }
    public String getLtms() {
        return ltms;
    }
    public void setLtms(String ltms) {
        this.ltms = ltms;
    }
    public String getAqss() {
        return aqss;
    }
    public void setAqss(String aqss) {
        this.aqss = aqss;
    }
    public String getWfjl() {
        return wfjl;
    }
    public void setWfjl(String wfjl) {
        this.wfjl = wfjl;
    }
    public String getCzqk() {
        return czqk;
    }
    public void setCzqk(String czqk) {
        this.czqk = czqk;
    }
    public String getLxjssj() {
        return lxjssj;
    }
    public void setLxjssj(String lxjssj) {
        this.lxjssj = lxjssj;
    }
    public String getDjmj() {
        return djmj;
    }
    public void setDjmj(String djmj) {
        this.djmj = djmj;
    }
    public String getYtglmj() {
        return ytglmj;
    }
    public void setYtglmj(String ytglmj) {
        this.ytglmj = ytglmj;
    }
    public String getBz() {
        return bz;
    }
    public void setBz(String bz) {
        this.bz = bz;
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
        return "Passenger{" +
                "id=" + id +
                ", jcsj='" + jcsj + '\'' +
                ", xsztxm='" + xsztxm + '\'' +
                ", ch='" + ch + '\'' +
                ", jsrjszh='" + jsrjszh + '\'' +
                ", jsrxm='" + jsrxm + '\'' +
                ", jsrjsztxm='" + jsrjsztxm + '\'' +
                ", jsrdh='" + jsrdh + '\'' +
                ", jsrxctjrq='" + jsrxctjrq + '\'' +
                ", jsrzzjc='" + jsrzzjc + '\'' +
                ", xzlb='" + xzlb + '\'' +
                ", hdzk='" + hdzk + '\'' +
                ", sjzk='" + sjzk + '\'' +
                ", cjrq='" + cjrq + '\'' +
                ", ltms='" + ltms + '\'' +
                ", aqss='" + aqss + '\'' +
                ", wfjl='" + wfjl + '\'' +
                ", czqk='" + czqk + '\'' +
                ", lxjssj='" + lxjssj + '\'' +
                ", djmj='" + djmj + '\'' +
                ", ytglmj='" + ytglmj + '\'' +
                ", bz='" + bz + '\'' +
                ", createTime='" + createTime + '\'' +
                ", isDel=" + isDel +
                ", creater=" + creater +
                '}';
    }
}
