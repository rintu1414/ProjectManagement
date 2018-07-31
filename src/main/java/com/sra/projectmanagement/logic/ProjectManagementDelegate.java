package com.sra.projectmanagement.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component

public class ProjectManagementDelegate {
     @Autowired
    private ResourceLoader resourceLoader;


    public String getRiskData() throws IOException, URISyntaxException {
       // File file = new ClassPathResource("static/initialData.json").getFile();
       // String fileContents = new String(Files.readAllBytes(Paths.get(file.getPath())));
        String fileContents = IOUtils.toString(resourceLoader.getResource("classpath:initialData.json").getInputStream());
        return fileContents;
    }
}
