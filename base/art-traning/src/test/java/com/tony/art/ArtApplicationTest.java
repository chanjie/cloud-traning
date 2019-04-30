package com.tony.art;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jfrog.artifactory.client.Artifactory;
import org.jfrog.artifactory.client.ArtifactoryClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author tony
 * 2019/4/26-14:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ArtApplicationTest {

    public static final String BASE_URL = "http://192.168.100.110:8081/artifactory";

    @Test
    public void deploy() {
        Artifactory artifactory = ArtifactoryClientBuilder.create()
                .setUrl(BASE_URL)
                .setUsername("tonychen")
                .setPassword("616410_1")
                .build();

        File file = new File("C:\\windows-version.txt");
        org.jfrog.artifactory.client.model.File artFile = artifactory.repository("generic-local")
                .upload("windows/version/windows-version.txt", file)
                .doUpload();
        System.out.println(artFile);
    }

    @Test
    public void createDir() {
        Artifactory artifactory = ArtifactoryClientBuilder.create()
                .setUrl(BASE_URL)
                .setUsername("tonychen")
                .setPassword("616410_1")
                .build();

    }

    @Test
    public void download() {
        Artifactory artifactory = ArtifactoryClientBuilder.create()
                .setUrl(BASE_URL)
                .setUsername("tonychen")
                .setPassword("616410_1")
                .build();

        try (InputStream inputStream = artifactory.repository("generic-local")
                .download("windows-version.txt")
                .doDownload()) {

            byte[] bytes = new byte[1024];

            FileOutputStream fileOutputStream = new FileOutputStream("D:\\windows-version.txt");

            while (inputStream.read(bytes) != -1) {
                fileOutputStream.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close stream
        }
    }
}
