package com.selenium.www;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 创建文件并写入内容
 */
public class FileCreate {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\1.txt");
        FileWriter fileWriter;
        fileWriter=new FileWriter(file);
        if(!file.exists()){
            System.out.println("文件不存在");
            fileWriter.append("文字");
            fileWriter.flush();
        }else{
            for(int i=1;i<=10000;i++){

                fileWriter.append("10001"+i+"\n");

            }
              fileWriter.flush();
        }
    }
}
