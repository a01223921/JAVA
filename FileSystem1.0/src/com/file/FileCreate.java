package com.file;

import java.io.File;
import java.io.IOException;

public class FileCreate {
	public static  boolean fileCreate(String fileName) throws IOException {//直接抛出异常
		//设置文件的路径 
		//File.separator表示分隔符，便于不同操作系统部署出现bug时解决问题
		File file = new File (fileName);
		if(!file.getParentFile().exists()) {//如果父路径(目录)不存在
			file.getParentFile().mkdirs();//创建目录
		}
		if(file.exists()){//文件存在
			file.delete();
		}else {//文件不存在
			System.out.println(file.createNewFile());
		}
		return false;
	}
}
