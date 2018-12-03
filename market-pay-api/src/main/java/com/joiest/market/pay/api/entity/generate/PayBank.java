package com.joiest.market.pay.api.entity.generate;

import java.util.Date;

/**
 * 银行类型实体
 * @author zhouchaowei 
 */
public class PayBank {
    private Long id;

    private String paybankname;

    private String tpid;

    private String bankcode;

    private Date created;

    private Date updated;

    private Boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaybankname() {
        return paybankname;
    }

    public void setPaybankname(String paybankname) {
        this.paybankname = paybankname == null ? null : paybankname.trim();
    }

    public String getTpid() {
        return tpid;
    }

    public void setTpid(String tpid) {
        this.tpid = tpid == null ? null : tpid.trim();
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode == null ? null : bankcode.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}