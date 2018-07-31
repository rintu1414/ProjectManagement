package com.sra.projectmanagement.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
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

    public String getRiskData() throws IOException, URISyntaxException {
       URI e =ProjectManagementDelegate.class.getClassLoader().getResource("initialData.json").toURI();
      String fileContents = new String(Files.readAllBytes(Paths.get(e)));
        return fileContents;
    }
}
