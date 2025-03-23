package com.mki.loan.guarantor.db.model;

import com.mki.loan.guarantor.util.EnumUtil;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "app_id")
    private String appId;

    @Column(name = "msisdn")
    private String msisdn;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EnumUtil.EnumVar status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Account() {}

    public Account(Long accountId, String appId, EnumUtil.EnumVar status) {
        this.accountId = accountId;
        this.appId = appId;
        this.status = status;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public EnumUtil.EnumVar getStatus() { return status; }

    public void setStatus(EnumUtil.EnumVar status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Anotasi untuk mengisi created_at sebelum entitas disimpan
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Anotasi untuk mengisi updated_at sebelum entitas diperbarui
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
