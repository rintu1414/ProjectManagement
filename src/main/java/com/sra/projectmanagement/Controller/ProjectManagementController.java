package com.sra.projectmanagement.Controller;

import com.sra.projectmanagement.ProjectmanagementApplication;
import com.sra.projectmanagement.logic.ProjectManagementDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class ProjectManagementController {

    ProjectManagementDelegate projectManagementDelegate;

    @Autowired
    public ProjectManagementController(ProjectManagementDelegate projectManagementDelegate){
        this.projectManagementDelegate = projectManagementDelegate;
    }

    @RequestMapping(value="/pm",
    method= RequestMethod.GET)

    public String getRisk() throws IOException, URISyntaxException {
        return projectManagementDelegate.getRiskData();
    }
}
