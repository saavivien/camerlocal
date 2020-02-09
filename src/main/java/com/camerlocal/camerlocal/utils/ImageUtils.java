/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camerlocal.camerlocal.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Vivien SA'A
 */
public class ImageUtils {

    public static String saveImage(String path, MultipartFile file) {
        File folder = new File(path);
        boolean exist = folder.exists();
        if (!exist) {
            folder.mkdir();
        }
        String filename = file.getOriginalFilename();
        String modifiedFileName = FilenameUtils.getBaseName(filename)
                + "_" + System.currentTimeMillis() + "." + FilenameUtils.getExtension(filename);
        File fileToStore = new File(path + File.separator + modifiedFileName);

        try {
            FileUtils.writeByteArrayToFile(fileToStore, file.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return modifiedFileName;
    }
}
