package com.example.qiulin.traffic.beans;

/**
 * Created by zhanqiulin on 2016/2/3.
 */
public class Dangerous {
    private Long id;
    //检查时间
    private String jcsj;
    //是否为挂车
    private Integer sfgc;
    //通行证编号
    private String txzbh;
    //行驶证条形码
    private String xsztxm;
    //驾驶人驾驶证号
    private String jsrjszh;
    //驾驶人姓名
    private String jsrxm;
    //驾驶人下次体检日期
    private String jsrxctjrq;
    //驾驶人驾驶证条形码
    private String jsrjsztxm;
    //驾驶人驾驶资格
    private String jsrjszg;
    //押运员姓名
    private String yyyxm;
    //押运员押运证
    private String yyyyyz;
    //押运员电话
    private String yyydh;
    //供货厂家名称
    private String ghcjmc;
    //供货厂家联系人
    private String ghcjlxr;
    //供货厂家电话
    private String ghcjdh;
    //核载质量
    private String hzzl;
    //实载质量
    private String szzl;
    //企业等级
    private String qydj;
    //货物性质
    private String hwxz;
    //车辆下次检验日期
    private String cjrq;
    //安全设施
    private String aqss;
    //轮胎磨损
    private String ltms;
    //违法记录
    private String wfjl;
    //登记民警
    private String djmj;
    //源头管理民警
    private String ytglmj;
    //应急处理办法
    private String yjclbf;
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
    public Integer getSfgc() {
        return sfgc;
    }
    public void setSfgc(Integer sfgc) {
        this.sfgc = sfgc;
    }
    public String getTxzbh() {
        return txzbh;
    }
    public void setTxzbh(String txzbh) {
        this.txzbh = txzbh;
    }
    public String getXsztxm() {
        return xsztxm;
    }
    public void setXsztxm(String xsztxm) {
        this.xsztxm = xsztxm;
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
    public String getJsrxctjrq() {
        return jsrxctjrq;
    }
    public void setJsrxctjrq(String jsrxctjrq) {
        this.jsrxctjrq = jsrxctjrq;
    }
    public String getJsrjsztxm() {
        return jsrjsztxm;
    }
    public void setJsrjsztxm(String jsrjsztxm) {
        this.jsrjsztxm = jsrjsztxm;
    }
    public String getJsrjszg() {
        return jsrjszg;
    }
    public void setJsrjszg(String jsrjszg) {
        this.jsrjszg = jsrjszg;
    }
    public String getYyyxm() {
        return yyyxm;
    }
    public void setYyyxm(String yyyxm) {
        this.yyyxm = yyyxm;
    }
    public String getYyyyyz() {
        return yyyyyz;
    }
    public void setYyyyyz(String yyyyyz) {
        this.yyyyyz = yyyyyz;
    }
    public String getYyydh() {
        return yyydh;
    }
    public void setYyydh(String yyydh) {
        this.yyydh = yyydh;
    }
    public String getGhcjmc() {
        return ghcjmc;
    }
    public void setGhcjmc(String ghcjmc) {
        this.ghcjmc = ghcjmc;
    }
    public String getGhcjlxr() {
        return ghcjlxr;
    }
    public void setGhcjlxr(String ghcjlxr) {
        this.ghcjlxr = ghcjlxr;
    }
    public String getGhcjdh() {
        return ghcjdh;
    }
    public void setGhcjdh(String ghcjdh) {
        this.ghcjdh = ghcjdh;
    }
    public String getHzzl() {
        return hzzl;
    }
    public void setHzzl(String hzzl) {
        this.hzzl = hzzl;
    }
    public String getSzzl() {
        return szzl;
    }
    public void setSzzl(String szzl) {
        this.szzl = szzl;
    }
    public String getQydj() {
        return qydj;
    }
    public void setQydj(String qydj) {
        this.qydj = qydj;
    }
    public String getHwxz() {
        return hwxz;
    }
    public void setHwxz(String hwxz) {
        this.hwxz = hwxz;
    }
    public String getCjrq() {
        return cjrq;
    }
    public void setCjrq(String cjrq) {
        this.cjrq = cjrq;
    }
    public String getAqss() {
        return aqss;
    }
    public void setAqss(String aqss) {
        this.aqss = aqss;
    }
    public String getLtms() {
        return ltms;
    }
    public void setLtms(String ltms) {
        this.ltms = ltms;
    }
    public String getWfjl() {
        return wfjl;
    }
    public void setWfjl(String wfjl) {
        this.wfjl = wfjl;
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
    public String getYjclbf() {
        return yjclbf;
    }
    public void setYjclbf(String yjclbf) {
        this.yjclbf = yjclbf;
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
        return "Dangerous{" +
                "id=" + id +
                ", jcsj='" + jcsj + '\'' +
                ", sfgc=" + sfgc +
                ", txzbh='" + txzbh + '\'' +
                ", xsztxm='" + xsztxm + '\'' +
                ", jsrjszh='" + jsrjszh + '\'' +
                ", jsrxm='" + jsrxm + '\'' +
                ", jsrxctjrq='" + jsrxctjrq + '\'' +
                ", jsrjsztxm='" + jsrjsztxm + '\'' +
                ", jsrjszg='" + jsrjszg + '\'' +
                ", yyyxm='" + yyyxm + '\'' +
                ", yyyyyz='" + yyyyyz + '\'' +
                ", yyydh='" + yyydh + '\'' +
                ", ghcjmc='" + ghcjmc + '\'' +
                ", ghcjlxr='" + ghcjlxr + '\'' +
                ", ghcjdh='" + ghcjdh + '\'' +
                ", hzzl='" + hzzl + '\'' +
                ", szzl='" + szzl + '\'' +
                ", qydj='" + qydj + '\'' +
                ", hwxz='" + hwxz + '\'' +
                ", cjrq='" + cjrq + '\'' +
                ", aqss='" + aqss + '\'' +
                ", ltms='" + ltms + '\'' +
                ", wfjl='" + wfjl + '\'' +
                ", djmj='" + djmj + '\'' +
                ", ytglmj='" + ytglmj + '\'' +
                ", yjclbf='" + yjclbf + '\'' +
                ", bz='" + bz + '\'' +
                ", createTime='" + createTime + '\'' +
                ", isDel=" + isDel +
                ", creater=" + creater +
                '}';
    }
}
