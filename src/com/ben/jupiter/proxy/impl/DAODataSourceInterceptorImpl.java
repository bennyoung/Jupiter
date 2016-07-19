/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: DAODataSourceInterceptorImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 22 Mar 2016 22:38:59 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 22 Mar 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.proxy.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ben.jupiter.complex.xml.XMLHelper;
import com.ben.jupiter.complex.xml.cfg.defaults.Property;
import com.ben.jupiter.datasource.DataSourceTemplate;
import com.ben.jupiter.datasource.interfaces.IDataSource;
import com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor;
import com.ben.jupiter.util.StringLengthDescComparator;

/**
 * @author Yang Bin
 *
 */
public class DAODataSourceInterceptorImpl implements AroundMethodInterceptor{

	private static transient Log log = LogFactory.getLog(DAODataSourceInterceptorImpl.class);
	
	private static Map<String, String> DAO_SCOPE = new HashMap<>();
	
	private static Map<Class, String> DAO_DATASOURCE_CACHE = new HashMap<>();
	
	private static String[] KEYS = null;
	
	private String previousDataSource = null;
	
	static {
		try {
			Property[] properties = XMLHelper.getInstance().getDefaults().getDatasource().getMapping().getProperties();
			
			List<String> list = new ArrayList<>();
			for (int i = 0; i < properties.length; i++) {
				DAO_SCOPE.put(properties[i].getName().trim(), properties[i].getValue().trim());
				list.add(properties[i].getName().trim());
			}
			
			KEYS = (String[])list.toArray(new String[0]);
			Arrays.sort(KEYS, new StringLengthDescComparator());
			
		} catch (Exception e) {
			throw new RuntimeException("init DAODataSourceInterceptorImpl error.");
		}
	}
	
	public DAODataSourceInterceptorImpl() {
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor#beforeInterceptor(java.lang.Object, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void beforeInterceptor(Object obj, String methodName, Object[] objectArray) throws Exception {
		// TODO:trace
		previousDataSource = IDataSource.CUR_DATASOURCE.get();
		
		String ds = getDsByInfo(obj.getClass());
		if (StringUtils.isNotBlank(ds)) {
			if (StringUtils.contains(ds, DataSourceTemplate.CENTER_FLAG)) {
				// TODO:
			}
			IDataSource.CUR_DATASOURCE.set(ds);
		}
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor#afterInterceptor(java.lang.Object, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void afterInterceptor(Object obj, String methodName, Object[] objectArray) throws Exception {
		IDataSource.CUR_DATASOURCE.set(previousDataSource);
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor#exceptionInterceptor(java.lang.Object, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void exceptionInterceptor(Object obj, String methodName, Object[] objectArray) throws Exception {
		IDataSource.CUR_DATASOURCE.set(previousDataSource);
	}
	
	/**
	 * 
	 * @Function: DAODataSourceInterceptorImpl.java
	 * @Description: 获取DAO对应的数据源
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Ben
	 * @date: 2016年7月19日 下午4:39:29
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 2016年7月19日     Ben           v1.0.0               修改原因
	 */
	private String getDsByInfo(Class clazz) {
		String ds = DAO_DATASOURCE_CACHE.get(clazz);
		if (ds == null) {
			synchronized (DAO_DATASOURCE_CACHE) {
				if (!DAO_DATASOURCE_CACHE.containsKey(clazz)) {
					for (int i = 0; i < KEYS.length; i++) {
						if (clazz.getPackage().getName().indexOf(KEYS[i]) != -1) {
							ds = DAO_DATASOURCE_CACHE.get(KEYS[i]);
							break;
						}
					}
					if (StringUtils.isNotBlank(ds)) {
						DAO_DATASOURCE_CACHE.put(clazz, ds);
					} else {
						DAO_DATASOURCE_CACHE.put(clazz, "NULL");
					}
				}
			}
		}
		
		return ds;
	}

}
