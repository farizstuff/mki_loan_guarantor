package com.mki.loan.guarantor.db.repo;

import com.mki.loan.guarantor.db.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
