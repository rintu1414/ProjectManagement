package com.sra.projectmanagement.logic;

import com.sra.projectmanagement.model.RiskRegister;
import com.sra.projectmanagement.repository.RiskRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskRegisterDelegateImpl implements RiskRegisterDelegate {

    @Autowired
    private RiskRegisterRepository riskRegisterRepository;

    @Override
    public List getAllRisks() {
        return riskRegisterRepository.findAll();
    }

    @Override
    public RiskRegister createRisk(RiskRegister riskRegister) {
        return riskRegisterRepository.save(riskRegister);
    }
}
