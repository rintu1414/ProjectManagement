package com.sra.projectmanagement.logic;

import com.sra.projectmanagement.model.RiskRegister;

import java.util.List;

public interface RiskRegisterDelegate {

    List getAllRisks();
    RiskRegister createRisk(RiskRegister riskRegister);


}
