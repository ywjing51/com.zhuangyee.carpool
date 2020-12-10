package com.zhuangyee.parse.ddl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 输出文本文件
 * @author zhuangyee jinfengYang
 *
 */
public class SaveDataToFile {
	 public void appendFile(String fileName, String sql ) {
	 File file=new File("D:\\sqlfile");
	//如果文件夹不存在
     if(!file.exists()){
    	//创建文件夹
         file.mkdir();
     }

     try{//异常处理

         //如果file文件夹下没有.txt就会创建该文件

         BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\sqlfile\\"+fileName+".txt"));
       //在创建好的文件中写入sql
         bw.write(sql);
       //关闭文件
         bw.close();

     }catch(IOException e){

         e.printStackTrace();

     }
	 }

}
