package com.larrex.large;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class Util {


    public static final String uploadUniversalPath = "C:/Users/E.F.Lhomes/Desktop/springuploads/";
    public static final String downloadUniversalPath = "http://localhost:8080/image/";

    public static String createFile(MultipartFile multipartFile) throws IOException {
        String imageName = String.valueOf(System.currentTimeMillis() + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")));

        File file = new File(Util.uploadUniversalPath, imageName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return imageName;
    }

    public static byte[] downloadImage(String filename) {
        String filepath = Util.uploadUniversalPath + filename;
        byte[] imageByte;
        try {
            imageByte = Files.readAllBytes(new File(filepath).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return imageByte;
    }
}
