/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: UUID.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年6月13日 下午3:42:24 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年6月13日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.util;

import java.net.InetAddress;

/**
 * @author Ben
 *
 */
public class UUID {
	private static final UUID INSTANCE = new UUID();
	private static final String SEP = "";
	private static String formatIp = null;
	private static String formatJvm = null;
	private static String formatHiTime = null;
	private static String formatLoTime = null;
	private static final int IP;
	private static long counter = 0;
	private static final int JVM = (int) (System.currentTimeMillis() >>> 8);
	
	static {
		int ipadd;
		try {
			ipadd = toInt(InetAddress.getLocalHost().getAddress());
		} catch (Exception e) {
			ipadd = 0;
		}
		IP = ipadd;
		formatIp = format(getIP());
		formatJvm = format(getJVM());
		formatHiTime = format(getHiTime());
		formatLoTime = format(getLoTime());
	}

	private UUID() {
	}

	private static int toInt(byte[] bytes) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
		}
		return result;
	}

	private static int getJVM() {
		return JVM;
	}

	private static int getIP() {
		return IP;
	}

	private static short getHiTime() {
		return (short) (System.currentTimeMillis() >>> 32);
	}

	private static int getLoTime() {
		return (int) System.currentTimeMillis();
	}

	private static String format(int intval) {
		String formatted = Integer.toHexString(intval);
		StringBuilder buf = new StringBuilder("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	private static String format(short shortval) {
		String formatted = Integer.toHexString(shortval);
		StringBuilder buf = new StringBuilder("0000");
		buf.replace(4 - formatted.length(), 4, formatted);
		return buf.toString();
	}

	private synchronized long getCount() {
		if (counter < 0)
			counter = 0;
		return counter++;
	}

	private String getUUID() {
		return new StringBuilder(36).append(formatIp).append(SEP)
				.append(formatJvm).append(SEP).append(formatHiTime).append(SEP)
				.append(formatLoTime).append(SEP).append(getCount()).toString();
	}

	public static String getID() {
		return INSTANCE.getUUID();
	}

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			System.out.println(UUID.getID());
		}
		System.out.println("Time cost:" + (System.currentTimeMillis() - start)
				+ ":ms");
	}

}
