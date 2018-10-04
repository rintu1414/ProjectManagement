package com.sra.projectmanagement.logic;

import com.sra.projectmanagement.model.RiskRegister;
import com.sra.projectmanagement.repository.RiskRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class RiskRegisterDelegateImpl implements RiskRegisterDelegate {

    @Autowired
    private RiskRegisterRepository riskRegisterRepository;

    @Override
    public List getAllRisks() {
        return riskRegisterRepository.findAll();
    }

    @Override
    public String createRisk(RiskRegister[] riskRegister) {
        int i=0;

        Map<String,String> rank = new HashMap<>();
        rank.put("Rare#Insignificant","1");
        rank.put("Unlikely#Insignificant","2");
        rank.put("Possible#Insignificant", "3");
        rank.put("Likely#Insignificant", "4");
        rank.put("Rare#Minor", "5");
        rank.put("Unlikely#Minor", "6");
        rank.put("Certain#Insignificant", "7");
        rank.put("Possible#Minor", "8");
        rank.put("Likely#Minor", "9");
        rank.put("Certain#Minor", "10");
        rank.put("Rare#Moderate", "11");
        rank.put("Rare#Major", "12");
        rank.put("Unlikely#Moderate", "13");
        rank.put("Possible#Moderate", "14");
        rank.put("Likely#Moderate", "15");
        rank.put("Certain#Moderate", "16");
        rank.put("Unlikely#Major", "17");
        rank.put("Possible#Major", "18");
        rank.put("Rare#Catastrophic", "19");
        rank.put("Likely#Major", "20");
        rank.put("Certain#Major", "21");
        rank.put("Unlikely#Catastrophic", "22");
        rank.put("Possible#Catastrophic", "23");
        rank.put("Likely#Catastrophic", "24");
        rank.put("Certain#Catastrophic", "25");


        for(RiskRegister risk: riskRegister) {
            if(rank.containsKey(risk.getLikelihood()+"#"+risk.getSeverity())){
                 risk.setRank(rank.get(risk.getLikelihood()+"#"+risk.getSeverity()));
            }
            if(risk.getStatus() == "Open"){
                risk.setConvertToIssue("");
                risk.setCost(0);
                risk.setCurrency("");
                risk.setSchedule("");
                risk.setDuration("");
                risk.setImpactDetails("");
            }
            riskRegisterRepository.save(risk);
            i++;
        }
        return i+" rows succesfully updated";

    }


}

