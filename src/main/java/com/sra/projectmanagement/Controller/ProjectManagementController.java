package com.sra.projectmanagement.Controller;


import com.sra.projectmanagement.logic.ProjectManagementDelegate;
import com.sra.projectmanagement.logic.RiskRegisterDelegate;
import com.sra.projectmanagement.model.RiskRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
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
            riskRegisterDelegate.createRisk(risk);
            i++;
        }
        return i+" rows succesfully updated";

    }

}
