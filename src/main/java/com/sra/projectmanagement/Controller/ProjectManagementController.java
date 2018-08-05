package com.sra.projectmanagement.Controller;

import com.sra.projectmanagement.ProjectmanagementApplication;
import com.sra.projectmanagement.logic.ProjectManagementDelegate;
import com.sra.projectmanagement.logic.RiskRegisterDelegateImpl;
import com.sra.projectmanagement.model.RiskRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ProjectManagementController {

    @Autowired
    ProjectManagementDelegate projectManagementDelegate;

    @Autowired
    RiskRegisterDelegateImpl riskRegisterDelegate;

    @GetMapping("/pm")
    public String getSample() throws IOException, URISyntaxException {
        return projectManagementDelegate.getRiskData();
    }

    @GetMapping("/risk")
    public List<RiskRegister> getRisk() {

        return riskRegisterDelegate.getAllRisks();
    }

}
