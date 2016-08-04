/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: AbstractLocalDataSourceImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月19日 下午5:31:58 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月19日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.datasource.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.lang.StringUtils;

import com.ben.jupiter.complex.xml.XMLHelper;
import com.ben.jupiter.complex.xml.cfg.defaults.Pool;
import com.ben.jupiter.complex.xml.cfg.defaults.Property;
import com.ben.jupiter.datasource.interfaces.IDataSource;
import com.ben.jupiter.exception.JupiterException;

/**
 * @author Ben
 *
 */
public abstract class AbstractLocalDataSourceImpl implements IDataSource {

	protected static Map<String, DataSource> DATASOURCE_MAP = new HashMap<>();
	
	protected static Map URL_MAP = new HashMap<>();
	
	protected static String PrimaryDataSource = null;
	
	/**
	 * 构造方法
	 */
	public AbstractLocalDataSourceImpl() throws Exception {
		Pool[] pools = XMLHelper.getInstance().getDefaults().getDatasource().getPools();
		List<Pool> left = new ArrayList<>();
		Pool primary = null;
		for (int i = 0; i < pools.length; i++) {
			if (StringUtils.isNotBlank(pools[i].getPrimary()) && "true".equals(pools[i].getPrimary())) {
				if (primary == null) {
					primary = pools[i];
				} else {
					throw new JupiterException("there is already set base pool.");
				}
			} else {
				left.add(pools[i]);
			}
		}
		
		if (primary == null) {
			throw new JupiterException("there is no primary datasource.");
		}
		
		PrimaryDataSource = primary.getName().trim();
		
		// 暂不考虑Prefetch模式
		Properties basePoolProperties = new Properties();
		Property[] ps = primary.getProperties();
		for (int i = 0; i < ps.length; i++) {
			basePoolProperties.setProperty(ps[i].getName(), ps[i].getValue());
		}
		DataSource baseDataSource = BasicDataSourceFactory.createDataSource(k(basePoolProperties));
		DATASOURCE_MAP.put(PrimaryDataSource, baseDataSource);
		
//		String tableName = "cfg_db_acct";
		
		HashMap<Pool, Properties> map = getPoolCompletionInfo(baseDataSource, (Pool[])left.toArray(new Pool[0]));
		Set<Pool> keyset = map.keySet();
		for (Iterator<Pool> it = keyset.iterator(); it.hasNext();) {
			Pool p = it.next();
			try {
				Properties pts = map.get(p);
				DataSource ds = BasicDataSourceFactory.createDataSource(k(pts));
				
				if (StringUtils.isNotBlank(p.getInit()) && "true".equals(p.getInit())) {
					initConnection(ds);
				}
				
				DATASOURCE_MAP.put(p.getName().trim(), ds);
				
			} catch (Exception e) {
				throw new JupiterException("create left datasource error.");
			}
		}
		
	}
	
	/**
	 * 
	 * @Function: AbstractLocalDataSourceImpl.java
	 * @Description: 获取剩余数据源信息
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Ben
	 * @date: 2016年7月21日 上午11:08:54
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 2016年7月21日     Ben           v1.0.0               修改原因
	 */
	private HashMap<Pool, Properties> getPoolCompletionInfo(DataSource baseDataSource, Pool[] pool) throws Exception {
		HashMap<Pool, Properties> rtn = new HashMap<>();
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		for (int i = 0; i < pool.length; i++) {
			try {
				conn = baseDataSource.getConnection();
				ptmt = conn.prepareStatement("select * from cfg_db_acct where db_acct_code = ? and state = 'U'");
				ptmt.setString(1, pool[i].getName().trim());
				rs = ptmt.executeQuery();
				
				int j = 0;
				Properties p = new Properties();
				while (rs.next()) {
					if (j > 0) {
						throw new JupiterException("there is more than one record : [" + pool[i].getName().trim() + "]");
					}
//					String host = rs.getString("HOST");
//					if (host.equals("MYSQL_JDBC")) {
//						p = set(p, rs);
//					} else if (host.equals("DB2_JDBC")) {
//						p = set(p, rs);
//					} else if (host.equals("SYBASE_JDBC")) {
//						p = set(p, rs);
//					} else {
//						
//					}
					p = set(p, rs);
					j++;
				}
				
				// defaults overwrite config
				Property[] property = pool[i].getProperties();
				for (int k = 0; k < property.length; k++) {
					p.put(property[i].getName(), property[i].getValue());
				}
				
				rtn.put(pool[i], p);
				
			} catch (Exception e) {
				throw e;
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (Exception e) {

					}

				}
				if (ptmt != null) {
					try {
						ptmt.close();
					} catch (Exception e) {

					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {

					}
				}
			}
		}
		
		return rtn;
	}
	
	/**
	 * 
	 * @Function: AbstractLocalDataSourceImpl.java
	 * @Description: 初始化数据源连接
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Ben
	 * @date: 2016年7月21日 上午11:15:32
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 2016年7月21日     Ben           v1.0.0               修改原因
	 */
	private void initConnection(DataSource datasource) throws Exception {
		Connection conn = null;
		try {
			conn = datasource.getConnection();
		} catch (Exception e) {
			throw new JupiterException("init connection error.");
		} finally {
			if (conn != null) {
				try {
					if (!conn.isClosed()) {
						conn.close();
					}
				} catch (Exception e) {
					throw new JupiterException("close connection error.");
				}
			}
		}
	}

	/**
	 * 解密
	 * 
	 * @param p Properties
	 * @throws Exception
	 * @return Properties
	 */
	private Properties k(Properties p) throws Exception {

		return p;
	}
	
	/**
	 * 
	 * @Function: AbstractLocalDataSourceImpl.java
	 * @Description: 设置数据源
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Ben
	 * @date: 2016年7月21日 下午2:51:20
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 2016年7月21日     Ben           v1.0.0               修改原因
	 */
	private Properties set(Properties p, ResultSet rs) throws Exception {
		p.put("maxActive", rs.getString("DEFAULT_CONN_MAX"));
	    p.put("initialSize", rs.getString("DEFAULT_CONN_MIN"));
	    p.put("maxIdle", rs.getString("DEFAULT_CONN_MAX"));
	    p.put("username", rs.getString("USERNAME"));
	    p.put("password", rs.getString("PASSWORD"));
	    p.put("url", rs.getString("SID"));
		return p;
	}

}
