package com.mki.loan.guarantor.controller;

import com.mki.loan.guarantor.db.model.TxInfo;
import com.mki.loan.guarantor.db.model.TxLedger;
import com.mki.loan.guarantor.db.repo.TxInfoRepo;
import com.mki.loan.guarantor.db.repo.TxLedgerRepo;
import com.mki.loan.guarantor.dto.AppRequest;
import com.mki.loan.guarantor.exception.ValidationException;
import com.mki.loan.guarantor.util.EnumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ledger")
public class LedgerController {
    @PostMapping(value = {"/create"})
    public ResponseEntity<String> createTx(@RequestBody AppRequest request) {
        this.saveTransaction(request);
        return ResponseEntity.ok("Transaction created success");
    }

    @Autowired
    private TxLedgerRepo txLedgerRepo;

    @Autowired
    private TxInfoRepo txInfoRepo;

    @Transactional
    public void saveTransaction(AppRequest request) {
        EnumUtil.EnumVar type = EnumUtil.EnumVar.fromValue(request.getType()).orElseThrow(() -> new ValidationException("Invalid type"));

        TxLedger txLedger = new TxLedger();
        txLedger.setAmount(request.getAmount());
        txLedger.setType(type);
        txLedger.setAccountId(request.getAccountId());
        txLedger.setSubscriberId(request.getSubscriberId());
        txLedger.setStatus(request.getStatus());
        txLedgerRepo.save(txLedger);

        TxInfo txInfo = new TxInfo();
        txInfo.setTxId(txLedger.getTxId());
        txInfo.setMsisdnGuarantor(request.getMsisdnGuarantor());
        txInfo.setMsisdn(request.getMsisdn());
        txInfoRepo.save(txInfo);
    }
}
