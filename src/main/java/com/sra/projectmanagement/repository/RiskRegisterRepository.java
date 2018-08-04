package com.sra.projectmanagement.repository;

import com.sra.projectmanagement.model.RiskRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskRegisterRepository extends JpaRepository<RiskRegister,String> {
}
