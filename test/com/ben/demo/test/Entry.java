/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Entry.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月18日 上午10:04:05 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月18日     Ben           v1.0.0               修改原因
*/
package com.ben.demo.test;

/**
 * @author Ben
 *
 */
public class Entry<K, V> {

	K k;
	V v;
	Entry<K,V> next;
	
	public Entry(K k, V v, Entry<K,V> n) {
		this.k = k;
		this.v = v;
		this.next = n;
	}
}
