/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: ReadFile.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 28 Apr 2016 09:09:22 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 28 Apr 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.demo.nio;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import sun.nio.ByteBuffered;

/**
 * @author Yang Bin
 *
 */
public class ReadFile {

	public static void main(String[] args) {
		int x = 0b11011011;
		System.out.println(x);
		
		ReadFile readFile = new ReadFile();
		URL url = readFile.getClass().getResource("/");
		System.out.println(url.toString());
		
//		Path file = Paths.get("/Users/admin/Asiainfo/github/Jupiter/config/defaults.xml");
		Path file = Paths.get("bin/defaults.xml");
//		System.out.println(file1.toAbsolutePath());
		
		try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
			String line = null;
			while ( (line = reader.readLine()) != null ) {
				System.out.println(line);
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void method1() {
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream("bin/defaults.xml"));
			
			byte[] buf = new byte[1024];
			int bytesRead = in.read(buf);
			while (bytesRead != -1) {
				for (int i = 0; i < bytesRead; i++) {
					System.out.print((char)buf[i]);
				}
				bytesRead = in.read(buf);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void method2() {
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile("bin/defaults.xml", "rw");
			FileChannel fc = file.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			int bytesRead = fc.read(buf);
			System.out.println(bytesRead);
			
			while (bytesRead != -1) {
				buf.flip();
				while (buf.hasRemaining()) {
					System.out.print((char)buf.get());
				}
				buf.compact();
				bytesRead = fc.read(buf);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (file != null) {
					file.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
