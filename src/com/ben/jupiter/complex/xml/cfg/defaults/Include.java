/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Include.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 17:20:59 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 18 Feb 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.complex.xml.cfg.defaults;

/**
 * @author Yang Bin
 *
 */
public class Include {

	private String classpath;
	private String type;

	public Include() {
		
	}

	public String getClasspath() {
		return classpath;
	}

	public void setClasspath(String classpath) {
		this.classpath = classpath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
