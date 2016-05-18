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

import java.io.BufferedReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
		
		Path file = Paths.get("/Users/Ben/Asiainfo/github/Jupiter/config/defaults.xml");
		Path file1 = Paths.get("bin/defaults.xml");
		System.out.println(file1.toAbsolutePath());
		
		try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
			String line = null;
			while ( (line = reader.readLine()) != null ) {
				System.out.println(line);
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
}
