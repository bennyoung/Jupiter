/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: TransactionDataSourceInterceptorImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 22 Mar 2016 21:27:38 
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

import com.ben.jupiter.complex.SessionManager;
import com.ben.jupiter.complex.xml.XMLHelper;
import com.ben.jupiter.complex.xml.cfg.defaults.Property;
import com.ben.jupiter.datasource.DataSourceTemplate;
import com.ben.jupiter.datasource.interfaces.IMutilTransactionDatasource;
import com.ben.jupiter.exception.JupiterException;
import com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor;
import com.ben.jupiter.transaction.interfaces.Session;
import com.ben.jupiter.util.StringLengthDescComparator;

/**
 * @author Yang Bin
 *
 */
public class TransactionDataSourceInterceptorImpl implements AroundMethodInterceptor {

	private static transient Log log = LogFactory.getLog(TransactionDataSourceInterceptorImpl.class);
	
	private static final String NULL = "NULL";
	
	private static final HashMap<String, String> SV_SCOPE = new HashMap<>();
	
	private static String[] KEYS = null;
	
	private static String previousDataSourceWithMutilLocalTransaction = null;
	
	private static Map<Class, String> CLAZZ_DATASOURCE_CACHE = new HashMap<>();
	
	static {
		try {
			Property[] property = XMLHelper.getInstance().getDefaults().getTransaction().getMapping().getProperties();
			
			List<String> svList = new ArrayList<>();
			for (int i = 0; i < property.length; i++) {
				SV_SCOPE.put(property[i].getName().trim(), property[i].getValue().trim());
				svList.add(property[i].getName().trim());
			}
			
			KEYS = (String[])svList.toArray(new String[0]);
			Arrays.sort(KEYS, new StringLengthDescComparator());
			
		} catch (Exception e) {
			throw new RuntimeException("init TransactionDatasSourceInterceptorImpl error!", e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor#beforeInterceptor(java.lang.Object, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void beforeInterceptor(Object obj, String methodName, Object[] objectArray) throws Exception {
		if (!SessionManager.getSession().isStartTransaction()) {
			throw new JupiterException("is not start transaction.");
		}
		
		Session session = SessionManager.getSession();
		if (session instanceof IMutilTransactionDatasource) {
			IMutilTransactionDatasource mtds = (IMutilTransactionDatasource)session;
			String previousDs = mtds.getCurDataSource();
			if (StringUtils.isNotBlank(previousDs)) {
				previousDataSourceWithMutilLocalTransaction = previousDs;
			}
			
			String ds = getTsDsByInfo(obj.getClass(), obj.getClass().getName(), methodName);
			if (!StringUtils.isBlank(ds)) {
				mtds.setCurDataSource(ds);
			} else {
				mtds.setCurDataSource(null);
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor#afterInterceptor(java.lang.Object, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void afterInterceptor(Object obj, String methodName, Object[] objectArray) throws Exception {
		Session session = SessionManager.getSession();
		if (session instanceof IMutilTransactionDatasource) {
			IMutilTransactionDatasource mtds = (IMutilTransactionDatasource)session;
			mtds.setCurDataSource(previousDataSourceWithMutilLocalTransaction);
		}
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor#exceptionInterceptor(java.lang.Object, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void exceptionInterceptor(Object obj, String methodName, Object[] objectArray) throws Exception {
		Session session = SessionManager.getSession();
		if (session instanceof IMutilTransactionDatasource) {
			IMutilTransactionDatasource mtds = (IMutilTransactionDatasource)session;
			mtds.setCurDataSource(previousDataSourceWithMutilLocalTransaction);
		}
	}
	
	/**
	 * 
	 * @Function: TransactionDataSourceInterceptorImpl.java
	 * @Description: 根据服务信息获取事务数据源
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Ben
	 * @date: 2016年7月19日 下午3:30:48
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 2016年7月19日     Ben           v1.0.0               修改原因
	 */
	private String getTsDsByInfo(Class clazz, String className, String methodName) {
		String ds = getDataSourceByClass(clazz);
		if (StringUtils.isNotBlank(ds)) {
			if (StringUtils.contains(ds, DataSourceTemplate.CENTER_FLAG)) {
				// TODO:分中心
			}
		}
		return ds;
	}
	
	private String getDataSourceByClass(Class clazz) {
		String ds = CLAZZ_DATASOURCE_CACHE.get(clazz);
		if (ds == null) {
			synchronized (CLAZZ_DATASOURCE_CACHE) {
				if (!CLAZZ_DATASOURCE_CACHE.containsKey(clazz)) {
					for (int i = 0; i < KEYS.length; i++) {
						if (clazz.getPackage().getName().indexOf(KEYS[i]) != -1) {
							ds = SV_SCOPE.get(KEYS[i]);
							break;
						}
					}
					if (StringUtils.isNotBlank(ds)) {
						CLAZZ_DATASOURCE_CACHE.put(clazz, ds);
					} else {
						CLAZZ_DATASOURCE_CACHE.put(clazz, NULL);
					}
				}
			}
		}
		return ds;
	}

}
