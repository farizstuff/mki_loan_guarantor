package com.mki.loan.guarantor.controller;

import com.mki.loan.guarantor.db.model.TxInfo;
import com.mki.loan.guarantor.db.model.TxLedger;
import com.mki.loan.guarantor.db.repo.TxInfoRepo;
import com.mki.loan.guarantor.db.repo.TxLedgerRepo;
import com.mki.loan.guarantor.dto.AppRequest;
import com.mki.loan.guarantor.exception.ValidationException;
import com.mki.loan.guarantor.service.StoreLedgerSvc;
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
    @Autowired
    private StoreLedgerSvc storeLedgerSvc;
    @PostMapping(value = {"/create"})
    public ResponseEntity<String> createTx(@RequestBody AppRequest request) {
        storeLedgerSvc.saveTransaction(request);
        return ResponseEntity.ok("Transaction created success");
    }
}
