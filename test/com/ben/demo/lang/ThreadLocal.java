/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: ThreadLocal.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年8月1日 下午5:16:15 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年8月1日     Ben           v1.0.0               修改原因
*/
package com.ben.demo.lang;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Ben
 *
 */
public class ThreadLocal<T> {

	private ConcurrentMap<Thread, T> map = new ConcurrentHashMap<>();
	
	public void set(T t) {
		map.put(Thread.currentThread(), t);
	}
	
	public T initialValue() {
		return null;
	}
	
	public T get() {
		Thread t = Thread.currentThread();
//		if (map.containsKey(t)) {
//			T temp = map.get(t);
//			
//		} else {
//			
//		}
		T temp = map.get(t);
		if (temp == null && map.containsKey(t)) {
			temp = initialValue();
			map.put(t, temp);
		}
		return temp;
	}
	
	public void remove() {
		Thread t = Thread.currentThread();
		map.remove(t);
	}
	
	public static void main(String[] args) {
		ThreadLocal<Integer> t = new ThreadLocal<Integer>() {
			public Integer initialValue() {
				return 0;
			}
		};
		
		
	}
	
}
