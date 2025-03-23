package com.mki.loan.guarantor.db.repo;

import com.mki.loan.guarantor.db.model.TxLedger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxLedgerRepo extends JpaRepository<TxLedger, Long> {
}
