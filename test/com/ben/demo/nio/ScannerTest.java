/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Scanner.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年6月30日 下午5:10:02 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年6月30日     Ben           v1.0.0               修改原因
*/
package com.ben.demo.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author Ben
 *
 */
public class ScannerTest {

	public static void main(String[] args) throws IOException {
		File file = new File("bin/defaults.xml");
		FileInputStream is = new FileInputStream(file);
		
		Path f = Paths.get("bin/defaults.xml");
		BufferedReader br = Files.newBufferedReader(f);
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.out.println("-------------------------");
		Scanner sc = new Scanner(is);
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			System.out.println(line);
		}
		
		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
		MappedByteBuffer inputBuffer = randomAccessFile
				.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
		byte[] dst = new byte[1024];
		
		
		is.close();
		sc.close();

		System.out.println(1 << 10);
		System.out.println(Integer.toBinaryString(1 << 30));
		
		String s = "sasdfasdf";
		char c[] = s.toCharArray();
		System.out.println(c[0]);
		System.out.println(s.toCharArray());
		
	}
	
}
