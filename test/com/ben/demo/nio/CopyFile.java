/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: CopyFile.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月29日 上午11:19:43 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月29日     Ben           v1.0.0               修改原因
*/
package com.ben.demo.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Ben
 *
 */
public class CopyFile {

	public static void main(String[] args) throws Exception {
		FileInputStream f1 = null;
		try {
			f1 = new FileInputStream("bin/defaults.xml");
			FileChannel ch = f1.getChannel();
			System.out.println(ch.size());
			ByteBuffer bb = ByteBuffer.allocate((int)ch.size());
			
			while (ch.read(bb) != -1) {
				bb.flip();
				while (bb.hasRemaining()) {
					System.out.print((char)bb.get());
				}
				bb.clear();
			}
			
			System.out.println();
			System.out.println("===========================2");
			
			System.out.println(new String(Files.readAllBytes(Paths.get("bin/defaults.xml"))));
			System.out.println("===========================3");
			List<String> list = Files.readAllLines(Paths.get("bin/defaults.xml"), StandardCharsets.UTF_8);
			StringBuilder sb = new StringBuilder();
			for (String s : list) {
				sb.append(s).append("\n");
			}
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			
		}
	}
	
}
