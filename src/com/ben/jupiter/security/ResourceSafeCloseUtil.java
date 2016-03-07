/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: ResourceSafeCloseUtil.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 5 Mar 2016 14:37:43 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 5 Mar 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.security;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Yang Bin
 *
 */
public class ResourceSafeCloseUtil {

	private transient static Log log = LogFactory.getLog(ResourceSafeCloseUtil.class);
	

	public static void safeClose(OutputStream os){
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				log.error(e);
			}
		}
	}
	
	public static void safeClose(FileWriter fw) {
		if (fw != null) {
			try {
				fw.close();
			} catch (IOException e) {
				log.error(e);
			}
		}
	}

	public static void safeClose(ObjectOutputStream oos) {
		if (oos != null) {
			try {
				oos.close();
			} catch (IOException e) {
				log.error(e);
			}
		}
	}

	/**
	 * 安全关闭流
	 * 
	 * @param fis
	 */
	public static void safeClose(InputStream fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				log.error(e);
			}
		}
	}

	public static void safeClose(InputStreamReader isr) {
		if (isr != null) {
			try {
				isr.close();
			} catch (IOException e) {
				log.error(e);
			}
		}
	}

	public static void safeClose(Reader fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				log.error(e);
			}
		}
	}

	public static void safeClose(FileOutputStream fops) {
		if (fops != null) {
			try {
				fops.close();
			} catch (IOException e) {
				log.error(e);
			}
		}
	}

	public static void safeClose(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}
	}
	
	public static void safeClose(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}
	}
	
	public static void safeClose(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}
	}
}
