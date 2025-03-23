package com.mki.loan.guarantor.db.repo;

import com.mki.loan.guarantor.db.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepo extends JpaRepository<Subscriber, Long> {
}
