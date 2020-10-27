package com.selenium.www;
/*
读取本地文件的内容
 */
import java.io.*;

public class FileRead {
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("E:\\物流SDK.postman_collection.json");
        InputStream in=new FileInputStream(file);
        try{
            Reader reader=new InputStreamReader(in,"utf-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String lineText;
            while((lineText=bufferedReader.readLine())!=null){
                System.out.println(lineText);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
