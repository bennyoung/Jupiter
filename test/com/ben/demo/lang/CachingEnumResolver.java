/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: CachingEumRsovler.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年8月3日 上午11:11:05 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年8月3日     Ben           v1.0.0               修改原因
*/
package com.ben.demo.lang;

/**
 * @author Ben
 *
 */
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CachingEnumResolver {
	//单态实例　一切问题皆由此行引起
	private static final CachingEnumResolver SINGLE_ENUM_RESOLVER = new CachingEnumResolver();
	/*MSGCODE->Category内存索引*/
	private static Map CODE_MAP_CACHE;
	static {
		CODE_MAP_CACHE = new HashMap();
		//为了说明问题,我在这里初始化一条数据
		CODE_MAP_CACHE.put("0","北京市");
	}
	
	//private, for single instance
	private CachingEnumResolver() {
		//初始化加载数据  引起问题，该方法也要负点责任
		initEnums();
	}
	
	/**
	 * 初始化所有的枚举类型
	 */
	public static void initEnums() {
		// ~~~~~~~~~问题从这里开始暴露 ~~~~~~~~~~~//
		if (null == CODE_MAP_CACHE) {
			System.out.println("CODE_MAP_CACHE为空,问题在这里开始暴露.");
			CODE_MAP_CACHE = new HashMap();
		}
		CODE_MAP_CACHE.put("1", "北京市");
		CODE_MAP_CACHE.put("2", "云南省");
		
		//..... other code...
		System.out.println(CODE_MAP_CACHE);
	}
	
	public Map getCache() {
		return Collections.unmodifiableMap(CODE_MAP_CACHE);
	}
	
	/**
	 * 获取单态实例
	 * 
	 * @return
	 */
	public static CachingEnumResolver getInstance() {
		return SINGLE_ENUM_RESOLVER;
	}
	
	public static void main(String[] args) {
		System.out.println(CachingEnumResolver.getInstance().getCache());
	}
}
