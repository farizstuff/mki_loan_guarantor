package com.mki.loan.guarantor.service;

import com.mki.loan.guarantor.db.model.TxInfo;
import com.mki.loan.guarantor.db.model.TxLedger;
import com.mki.loan.guarantor.db.repo.TxInfoRepo;
import com.mki.loan.guarantor.db.repo.TxLedgerRepo;
import com.mki.loan.guarantor.dto.AppRequest;
import com.mki.loan.guarantor.exception.ValidationException;
import com.mki.loan.guarantor.util.EnumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreLedgerSvc {
    @Autowired
    private TxLedgerRepo txLedgerRepo;

    @Autowired
    private TxInfoRepo txInfoRepo;

    @Transactional(rollbackFor = Exception.class)
    public void saveTransaction(AppRequest request) {
        EnumUtil.EnumVar type = EnumUtil.EnumVar.fromValue(request.getType()).orElseThrow(() -> new ValidationException("Invalid type"));

        TxLedger txLedger = new TxLedger();
        txLedger.setAmount(request.getAmount());
        txLedger.setType(type);
        txLedger.setAccountId(request.getAccountId());
        txLedger.setSubscriberId(request.getSubscriberId());
        txLedger.setStatus(request.getStatus());
        txLedgerRepo.save(txLedger);

        TxInfo txInfo = getTxInfo(request, txLedger);
        txInfoRepo.save(txInfo);
    }

    private static TxInfo getTxInfo(AppRequest request, TxLedger txLedger) {
        TxInfo txInfo = new TxInfo();
        txInfo.setTxId(txLedger.getTxId());
        txInfo.setMsisdnGuarantor(request.getMsisdnGuarantor());
        txInfo.setMsisdn(request.getMsisdn());
        txInfo.setPaymentTransactionId(request.getPaymentTransactionId());
        txInfo.setPaymentTimestamp(request.getPaymentTimestamp());
        txInfo.setPaymentAmount(request.getPaymentAmount());
        txInfo.setLoanTrxId(request.getLoanTrxId());
        txInfo.setLoanTimestamp(request.getLoanTimestamp());
        txInfo.setLoanAmount(request.getLoanAmount());
        txInfo.setOutstanding(request.getOutstanding());
        txInfo.setOthers(request.getOthers());
        return txInfo;
    }
}
