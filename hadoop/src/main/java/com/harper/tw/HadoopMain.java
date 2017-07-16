package com.harper.tw;

import java.io.IOException;

/**
 * Created by hbowang on 7/16/17.
 */
public class HadoopMain {
    public static void main(String[] args) throws IOException {
        MyHadoopUtils.uploadFiles("/Users/hbowang/git/bigdata/hadoop/test.txt","/data");
    }
}
