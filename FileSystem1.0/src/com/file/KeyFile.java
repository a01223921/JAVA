package com.file;

import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.security.Key;  
import java.security.SecureRandom;  
  
import javax.crypto.Cipher;  
import javax.crypto.CipherInputStream;  
import javax.crypto.CipherOutputStream;  
import javax.crypto.KeyGenerator;  
  
public class KeyFile{   
  Key key;   
  public KeyFile(String str) {   
    getKey(str);//生成密匙   
  }   
   
  //根据参数生成KEY  
     
  public void getKey(String strKey) {   
    try {   
        KeyGenerator _generator = KeyGenerator.getInstance("DES");   
        _generator.init(new SecureRandom(strKey.getBytes()));   
        this.key = _generator.generateKey();   
        _generator = null;   
    } catch (Exception e) {   
        throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);   
    }   
  }   
  
	/*文件进行加密并保存目标文件keyFile中    
	要加密的文件 如c:/test/srcFile.txt  
	加密后存放的文件名 如c:/加密后文件.txt  
	 */  
  public void encrypt(String file, String destFile) throws Exception {   
	  long start = System.currentTimeMillis();
	  Cipher cipher = Cipher.getInstance("DES");   
    // cipher.init(Cipher.ENCRYPT_MODE, getKey());   
	  cipher.init(Cipher.ENCRYPT_MODE, this.key);   
    
	  InputStream is = new FileInputStream(file);   
	  OutputStream out = new FileOutputStream(destFile);   
    
	  CipherInputStream cis = new CipherInputStream(is, cipher);   
	 
    
	  int r;    //每次读取的个数 
	  byte[] buffer = new byte[2048];  //每次读取2048个字节
	  while ((r = cis.read(buffer)) > 0) {  
		//将每次读取进来的数据保存在字节数组里面，并且返回读取的个数
        out.write(buffer, 0, r);   //输出数组
    }   
    
	  cis.close();   //关闭通道 
	  is.close();   
	  out.close();   
	  long end = System.currentTimeMillis();
	  System.out.println("加密完成！"+"加密所花费时间："+(end-start)+"ms");
  }   
	/*文件采用DES算法解密文件   
	已加密的文件 如c:/加密后文件.txt  
	解密后存放的文件名 如c:/ test/解密后文件.txt  
	 */    
  public void decrypt(String file, String dest) throws Exception {   
	  long start = System.currentTimeMillis();
	  Cipher cipher = Cipher.getInstance("DES");   
	  cipher.init(Cipher.DECRYPT_MODE, this.key);   
    
	  InputStream is = new FileInputStream(file);   
	  OutputStream out = new FileOutputStream(dest);   
   
	  CipherOutputStream cos = new CipherOutputStream(out, cipher);   
	  byte[] buffer = new byte[2048];   
    
	  int r;   
	  while ((r = is.read(buffer)) >= 0) {   
		  System.out.println();  
		  cos.write(buffer, 0, r);   
    }   
	  cos.close();   //关闭通道
	  out.close();   
	  is.close();   
    long end = System.currentTimeMillis();
   	System.out.println("加密完成！"+"加密所花费时间："+(end-start)+"ms");
  }   
  
}  