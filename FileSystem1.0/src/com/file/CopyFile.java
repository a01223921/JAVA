package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class CopyFile {
	public static void main(String[] args) throws Exception{//正常工作不能throw 需要 try
		long start = System.currentTimeMillis();
		if (args.length !=2) {//初始化参数不足2位
			System.out.println("命令执行错误！");
			System.exit(1);//程序退出执行
		}
		//如果输入参数正确，进行文件验证
		File inFile = new File(args [0]);//第一个为源文件路径
		if(!inFile.exists()) {//源文件不存在
			System.out.println("源文件不存在,请确认执行路径。");
			System.exit(1);//程序退出
		}
		//如果此时源文件正确，需要定义输出文件，同时考虑输出文件是否有目录
		File outFile = new File(args[1]);
		if(!outFile.getParentFile().exists()) {//输出文件路径不存在
			outFile.getParentFile().mkdirs();//创建目录
		}
		//实现文件内容的copy
		InputStream input = new FileInputStream(inFile);
		OutputStream output = new FileOutputStream(outFile);
		//实现文件copy
		int temp = 0;//每次读取的个数
		byte data [] = new byte[2048];//每次读取2048个字节
		//将每次读取进来的数据保存在字节数组里面，并且返回读取的个数
		while((temp = input.read(data))!=-1) {
			output.write(data,0,temp);//输出数组
		}
		input.close();
		output.close();
		long end = System.currentTimeMillis();
		System.out.println("拷贝完成！"+"拷贝所花费时间："+(end-start)+"ms");
	}
}
