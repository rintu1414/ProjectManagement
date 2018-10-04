package com.sra.projectmanagement.controller;


import com.sra.projectmanagement.logic.ProjectManagementDelegate;
import com.sra.projectmanagement.logic.RiskRegisterDelegate;
import com.sra.projectmanagement.model.RiskRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/pmi")
public class ProjectManagementController {

    @Autowired
    ProjectManagementDelegate projectManagementDelegate;

    @Autowired
    RiskRegisterDelegate riskRegisterDelegate;

    @GetMapping("/pm")
    public String getSample() throws IOException, URISyntaxException {
        return projectManagementDelegate.getRiskData();
    }

    @GetMapping("/risk")
    public List<RiskRegister> getRisk() {

        return riskRegisterDelegate.getAllRisks();
    }

    @PostMapping("/addRisk")
    public String createRisk(@Valid @RequestBody RiskRegister[] riskRegister) {
       // return riskRegisterDelegate.createRisk(riskRegister);
        int i=0;
        for(RiskRegister risk: riskRegister) {
            if(risk.getStatus() == "Open"){
                risk.setConvertToIssue("");
                risk.setCost(0);
                risk.setCurrency("");
                risk.setSchedule("");
                risk.setDuration("");
                risk.setImpactDetails("");
            }
            riskRegisterDelegate.createRisk(risk);
            i++;
        }
        return i+" rows succesfully updated";

    }

}
