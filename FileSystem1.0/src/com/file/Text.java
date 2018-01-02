package com.file;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Text {

	public static void main(String[] args) throws Exception {
		//创建文件及目录
		String fileName ="D:"+File.separator+"安顺学院"+File.separator+
				File.separator+"电子与信息工程学院"+File.separator+
				"2015级电子信息工程班"+File.separator+"王晓健.txt";
		FileCreate.fileCreate(fileName);
		System.out.println("文件创建完成!");
		System.out.println("***********************************");
       
		//拷贝文件及目录
	
		 // 创建目标文件夹 
	    // 源文件夹 
	    String url1 = "D:/work";
	    // 目标文件夹 
	    String url2 = "E:/work";
        (new File(url2)).mkdirs();
        // 获取源文件夹当前下的文件或目录 
        File[] file = (new File(url1)).listFiles();
        CopyText c=new CopyText();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                // 复制文件 
                c.copyFile(file[i],new File(url2+file[i].getName()));
            }
            if (file[i].isDirectory()) {
                // 复制目录 
                String sourceDir=url1+File.separator+file[i].getName();
                String targetDir=url2+File.separator+file[i].getName();
                c.copyDirectiory(sourceDir, targetDir);
            }
        }
		
		System.out.println("文件拷贝完成!");
		System.out.println("***********************************");
		
		//文件加密解密
		
        KeyFile td = new KeyFile("0x99");   
        td.encrypt("D:"+File.separator+"安顺学院"+File.separator+
				File.separator+"电子与信息工程学院"+File.separator+
				"2015级电子信息工程班"+File.separator+"王晓健.txt", 
				"E:/王晓健加密1.txt"); //加密   
        System.out.println("加密文件在E:/下");  
        td.decrypt("E:/王晓健加密1.txt", 
				"E:/王晓健解密1.txt"); //解密   
        System.out.println("解密文件在E:/下");
		System.out.println("***********************************");   
        
		//文件罗列(还能删除)
		File file2 = new File("D:"+File.separator);
		File file3 = new File("D:"+File.separator);	
			//盘符罗列(还能删除)
			System.out.println(new FileList1(file2));
			System.out.println("***********************************");
//			//给定文件夹罗列(还能删除)
//	
//			System.out.println(new FileList(file3));
//			System.out.println("***********************************");
			

	}

}
