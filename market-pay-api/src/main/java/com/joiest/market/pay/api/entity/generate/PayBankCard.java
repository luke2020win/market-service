package com.joiest.market.pay.api.entity.generate;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 银行卡操作实体类
 * @author zhouchaowei 
 */
public class PayBankCard {
    private Integer id;

    private String bankname;

    private String title;

    private String code;

    private String cardname;

    private String isatm;

    private String ispos;

    private String cardlen;

    private String cardpre;

    private String cardprelen;

    private String type;

    private Boolean status;

    private Date createtime;

    private String findcode;

    private BigDecimal singlelimit;

    private BigDecimal dailylimit;

    private BigDecimal monthlyquota;

    private String sort;

    private String source;

    private String images;

    private String smalimages;

    private String yftcode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname == null ? null : cardname.trim();
    }

    public String getIsatm() {
        return isatm;
    }

    public void setIsatm(String isatm) {
        this.isatm = isatm == null ? null : isatm.trim();
    }

    public String getIspos() {
        return ispos;
    }

    public void setIspos(String ispos) {
        this.ispos = ispos == null ? null : ispos.trim();
    }

    public String getCardlen() {
        return cardlen;
    }

    public void setCardlen(String cardlen) {
        this.cardlen = cardlen == null ? null : cardlen.trim();
    }

    public String getCardpre() {
        return cardpre;
    }

    public void setCardpre(String cardpre) {
        this.cardpre = cardpre == null ? null : cardpre.trim();
    }

    public String getCardprelen() {
        return cardprelen;
    }

    public void setCardprelen(String cardprelen) {
        this.cardprelen = cardprelen == null ? null : cardprelen.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getFindcode() {
        return findcode;
    }

    public void setFindcode(String findcode) {
        this.findcode = findcode == null ? null : findcode.trim();
    }

    public BigDecimal getSinglelimit() {
        return singlelimit;
    }

    public void setSinglelimit(BigDecimal singlelimit) {
        this.singlelimit = singlelimit;
    }

    public BigDecimal getDailylimit() {
        return dailylimit;
    }

    public void setDailylimit(BigDecimal dailylimit) {
        this.dailylimit = dailylimit;
    }

    public BigDecimal getMonthlyquota() {
        return monthlyquota;
    }

    public void setMonthlyquota(BigDecimal monthlyquota) {
        this.monthlyquota = monthlyquota;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    public String getSmalimages() {
        return smalimages;
    }

    public void setSmalimages(String smalimages) {
        this.smalimages = smalimages == null ? null : smalimages.trim();
    }

    public String getYftcode() {
        return yftcode;
    }

    public void setYftcode(String yftcode) {
        this.yftcode = yftcode == null ? null : yftcode.trim();
    }
}