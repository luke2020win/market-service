package com.joiest.market.pay.api.entity.generate;

/**
 * 地区实体类
 * @author zhouchaowei 
 */
public class PayPca {
    private Integer catid;

    private Integer pid;

    private String catpath;

    private String catpathCn;

    private String cat;

    private String code;

    private String postcode;

    private String phonecode;

    private Integer xuhao;

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCatpath() {
        return catpath;
    }

    public void setCatpath(String catpath) {
        this.catpath = catpath == null ? null : catpath.trim();
    }

    public String getCatpathCn() {
        return catpathCn;
    }

    public void setCatpathCn(String catpathCn) {
        this.catpathCn = catpathCn == null ? null : catpathCn.trim();
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat == null ? null : cat.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getPhonecode() {
        return phonecode;
    }

    public void setPhonecode(String phonecode) {
        this.phonecode = phonecode == null ? null : phonecode.trim();
    }

    public Integer getXuhao() {
        return xuhao;
    }

    public void setXuhao(Integer xuhao) {
        this.xuhao = xuhao;
    }
}