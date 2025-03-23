package com.mki.loan.guarantor.db.model;

import com.mki.loan.guarantor.util.MapToJsonConverter;
import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "tx_infos")
public class TxInfo {

    @Id
    @Column(name = "tx_id", nullable = false)
    private Long txId;

    @Column(name = "msisdn_guarantor")
    private String msisdnGuarantor;

    @Column(name = "msisdn")
    private String msisdn;

    @Column(name = "payment_transactionid")
    private String paymentTransactionId;

    @Column(name = "payment_timestamp")
    private String paymentTimestamp;

    @Column(name = "payment_amount")
    private String paymentAmount;

    @Column(name = "loan_trxId")
    private String loanTrxId;

    @Column(name = "loan_timestamp")
    private String loanTimestamp;

    @Column(name = "loan_amount")
    private String loanAmount;

    @Column(name = "outstanding")
    private Float outstanding;

    @Column(name = "others", columnDefinition = "JSON")
    @Convert(converter = MapToJsonConverter.class)
    private Map<String, Object> others;

    public Long getTxId() {
        return txId;
    }

    public void setTxId(Long txId) {
        this.txId = txId;
    }

    public String getMsisdnGuarantor() {
        return msisdnGuarantor;
    }

    public void setMsisdnGuarantor(String msisdnGuarantor) {
        this.msisdnGuarantor = msisdnGuarantor;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
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
