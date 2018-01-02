package com.file;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class FileList1 {
	public FileList1(File file) {
		
		if(file.isDirectory()) {//给出一个路径
			File result [] =file.listFiles();
			for(int x=0;x<result.length;x++) {
				System.out.println(result[x].getName()+"\t\t\t\t"+
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(result[x].lastModified()))
			+"\t\t\t\t"+(result[x].isDirectory()?"文件夹":"文件")
			+"\t\t\t\t"+(result[x].isFile()?(new BigDecimal((double)result[x].length()/1024/1024)
					.divide(new BigDecimal(1),2,BigDecimal.ROUND_HALF_UP))+"M":"")
						);
			}
		}
	}
}
