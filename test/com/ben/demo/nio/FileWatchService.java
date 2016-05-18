/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: FileWatchService.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 28 Apr 2016 10:37:06 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 28 Apr 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.demo.nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * @author Yang Bin
 *
 */
public class FileWatchService {

	public static void main(String[] args) {
		try {
			WatchService watcher = FileSystems.getDefault().newWatchService();
			Path dir = FileSystems.getDefault().getPath("bin/com/ben/demo/nio/");
			WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
			
			while(true) {
				key = watcher.take();
				for (WatchEvent<?> event : key.pollEvents()) {
					if (event.kind() == ENTRY_MODIFY) {
						System.out.println("-------------------");
					}
				}
			}
			
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
}
