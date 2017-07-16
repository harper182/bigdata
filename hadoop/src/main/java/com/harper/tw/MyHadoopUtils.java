package com.harper.tw;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.File;
import java.io.IOException;

/**
 * Created by hbowang on 7/16/17.
 */
public class MyHadoopUtils {

    private static String coreSite = "core-site.xml";

    public static void uploadFiles(String src,String dest) throws IOException {
        Configuration configuration = getConfiguration();
        FileSystem fileSystem = FileSystem.get(configuration);
        Path srcPath = new Path(src);
        Path destPath = new Path(dest);
        fileSystem.copyFromLocalFile(srcPath,destPath);
        System.out.println("Upload to "+ configuration.get("fs.default.name"));
        FileStatus[] files = fileSystem.listStatus(destPath);
        for(FileStatus file: files){
            System.out.println(file.getPath());
        }
    }
    public static Configuration getConfiguration(){
        Configuration configuration = new Configuration();
        configuration.addResource(coreSite);
        return configuration;
    }
}
