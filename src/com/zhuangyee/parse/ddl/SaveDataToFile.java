package com.zhuangyee.parse.ddl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ����ı��ļ�
 * @author zhuangyee jinfengYang
 *
 */
public class SaveDataToFile {
	 public void appendFile(String fileName, String sql ) {
	 File file=new File("D:\\sqlfile");
	//����ļ��в�����
     if(!file.exists()){
    	//�����ļ���
         file.mkdir();
     }

     try{//�쳣����

         //���file�ļ�����û��.txt�ͻᴴ�����ļ�

         BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\sqlfile\\"+fileName+".txt"));
       //�ڴ����õ��ļ���д��sql
         bw.write(sql);
       //�ر��ļ�
         bw.close();

     }catch(IOException e){

         e.printStackTrace();

     }
	 }

}
