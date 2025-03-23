package com.mki.loan.guarantor.db.repo;

import com.mki.loan.guarantor.db.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, String> {
    boolean existsByAppId(String appId);
    Optional<Application> findByAppId(String appId);

    List<Application> findAll();
}
