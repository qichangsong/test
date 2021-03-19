package com.selenium.www;

import com.google.gson.internal.$Gson$Preconditions;

import java.io.*;

public class Test1 {
    public static void main(String[] args){
        try{
            File file=new File("d:\\a.png");
            if(file.exists()){
             if(file.isFile()){
               file.renameTo(new File("d:\\c.png"));
               System.out.println("文件重命命成功");
             }
             }else {
                System.out.println("文件不存在");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
