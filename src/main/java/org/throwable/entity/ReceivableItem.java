package org.throwable.entity;

import java.util.Date;

/**
 * @author zhangjinci
 * @version 2017/2/10 16:41
 * @function
 */
public class ReceivableItem {

    private Long id;
    private String itemName;
    private Double receiveableAmount;
    private Date collecteDate;
    private Double feeRate;
    private Date createTime;
    private Date updateTime;

    public ReceivableItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getReceiveableAmount() {
        return receiveableAmount;
    }

    public void setReceiveableAmount(Double receiveableAmount) {
        this.receiveableAmount = receiveableAmount;
    }

    public Date getCollecteDate() {
        return collecteDate;
    }

    public void setCollecteDate(Date collecteDate) {
        this.collecteDate = collecteDate;
    }

    public Double getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(Double feeRate) {
        this.feeRate = feeRate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
