/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: AsynFileChannel.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 28 Apr 2016 14:30:19 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 28 Apr 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.demo.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Yang Bin
 *
 */
public class AsynFileChannel {

	public static void main(String[] args) {
		try {
			Path file = Paths.get("bin/defaults.xml");
			AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);
			
			ByteBuffer buffer = ByteBuffer.allocate(100_000);
			Future<Integer> result = channel.read(buffer, 0);
			int i = 0;
			while(!result.isDone()) {
				Thread.sleep(1000);
				System.out.println("--------------" + i);
				i++;
			}
			
			Integer bytesRead = result.get();
			System.out.println("Bytes read [" + bytesRead +"]");
			
			channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
				public void completed(Integer result, ByteBuffer attachment) {
					System.out.println("Bytes read [" + result +"]");
				}
				
				public void failed(Throwable exception, ByteBuffer attachment) {
					System.out.println(exception.getMessage());
				}
			});
			
		} catch (IOException | ExecutionException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
