package com.mki.loan.guarantor.db.model;

import com.mki.loan.guarantor.util.EnumUtil;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tx_ledgers")
public class TxLedger {

    @Id
    @Column(name = "tx_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long txId;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "subscriber_id")
    private Long subscriberId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private EnumUtil.EnumVar type;

    @Column(name = "status")
    private String status;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Long getTxId() {
        return txId;
    }

    public void setTxId(Long txId) {
        this.txId = txId;
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

    public EnumUtil.EnumVar getType() {
        return type;
    }

    public void setType(EnumUtil.EnumVar type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
