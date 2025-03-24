package com.mki.loan.guarantor.dto;

import java.util.Map;

public class AppRequest {
    private String appId;
    private String name;
    private String status;
    private Integer page;
    private Integer size;
    private String sortDirection;
    private String sortField;
    private Long amount;
    private Long accountId;
    private Long subscriberId;
    private String type;
    private String msisdn;
    private String msisdnGuarantor;
    private String paymentTransactionId;
    private String paymentTimestamp;
    private String paymentAmount;
    private String loanTrxId;
    private String loanTimestamp;
    private String loanAmount;
    private Float outstanding;
    private Map<String, Object> others;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMsisdnGuarantor() {
        return msisdnGuarantor;
    }

    public void setMsisdnGuarantor(String msisdnGuarantor) {
        this.msisdnGuarantor = msisdnGuarantor;
    }

    public String getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public void setPaymentTransactionId(String paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

    public String getPaymentTimestamp() {
        return paymentTimestamp;
    }

    public void setPaymentTimestamp(String paymentTimestamp) {
        this.paymentTimestamp = paymentTimestamp;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getLoanTrxId() {
        return loanTrxId;
    }

    public void setLoanTrxId(String loanTrxId) {
        this.loanTrxId = loanTrxId;
    }

    public String getLoanTimestamp() {
        return loanTimestamp;
    }

    public void setLoanTimestamp(String loanTimestamp) {
        this.loanTimestamp = loanTimestamp;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Float getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(Float outstanding) {
        this.outstanding = outstanding;
    }

    public Map<String, Object> getOthers() {
        return others;
    }

    public void setOthers(Map<String, Object> others) {
        this.others = others;
    }
}
