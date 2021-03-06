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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="*", maxAge=3600)
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
       return riskRegisterDelegate.createRisk(riskRegister);

}}
