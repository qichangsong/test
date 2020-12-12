package com.selenium.www;
/*
读取本地文件的内容
 */
import java.io.*;

public class FileRead {
    public static void main(String[] args) throws IOException {
        File file=new File("E:\\物流SDK.postman_collection.json");
        File file1=new File("e:\\a.txt");
        InputStream in=new FileInputStream(file);
        FileWriter ft=new FileWriter(file1);
        try{
            Reader reader=new InputStreamReader(in,"utf-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String lineText;
            while((lineText=bufferedReader.readLine())!=null){
                ft.append(lineText);
                ft.flush();
                System.out.println(lineText);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
