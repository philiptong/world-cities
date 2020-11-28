package com.ptong.worldcities.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class FileUtils {

    private static final Charset CHARSET = Charset.forName("UTF-8");
    private static final String RESOURCE_FOLDER = "src/test/resources";

    public static String getResourcesFolder() {
        File file = new File(RESOURCE_FOLDER);
        String absolutePath = file.getAbsolutePath();
        return absolutePath;
    }

    public static String getResourcesFolder(String countryCode) {
        String path = RESOURCE_FOLDER + File.separator + countryCode;
        File file = new File(path);
        String absolutePath = file.getAbsolutePath() + File.separator;
        return absolutePath;
    }

    public static void writeToFile(String filePath, String content) throws IOException {
        OutputStreamWriter osw = null;
        File file = new File(filePath);
        BufferedWriter bufw = null;
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        if (!file.exists()) {
            file.createNewFile();
        }
        osw = new OutputStreamWriter(new FileOutputStream(file, false), CHARSET);
        bufw = new BufferedWriter(osw);
        bufw.write(content);
        bufw.flush();
        bufw.close();
    }

    public static String readFile(String filePath) throws IOException {
        StringBuffer sb = new StringBuffer();
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), CHARSET));
        String str;
        while ((str = in.readLine()) != null) {
            sb.append(str + System.lineSeparator());
        }
        in.close();
        return sb.toString();
    }
}