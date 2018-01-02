package com.file;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class FileList {
	
	public FileList(File file) {
		if(file.isDirectory()) { //如果给定一个路径
			File result []=file.listFiles();//列出子目录
			if(result!=null) {//已经可以列出的目录
			for(int x=0;x<result.length;x++) {
				new FileList(result[x]);//继续列出
				} 
			}
		}
		System.out.println(file);
		//严重警告不能全删盘数据
		//file.delete();
	}

}
