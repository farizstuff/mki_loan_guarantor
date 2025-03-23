package com.mki.loan.guarantor.db.repo;

import com.mki.loan.guarantor.db.model.TxInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxInfoRepo extends JpaRepository<TxInfo, Long> {
}
