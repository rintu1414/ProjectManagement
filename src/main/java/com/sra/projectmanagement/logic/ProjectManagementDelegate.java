package com.sra.projectmanagement.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component

public class ProjectManagementDelegate {

    private ResourceLoader resourceLoader;

    @Autowired
    public ProjectManagementDelegate(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    public String getRiskData() throws IOException, URISyntaxException {
        File file = new ClassPathResource("initialData.json").getFile();
        String fileContents = new String(Files.readAllBytes(Paths.get(file.getPath())));
        return fileContents;
    }
}
