/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Proxy.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 17:22:09 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 18 Feb 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.complex.xml.cfg.defaults;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yang Bin
 *
 */
public class Proxy {

	private List list = new ArrayList();
	private Clazz clazz;

	public Proxy() {

	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public void addEnv(Env env) {
		this.list.add(env);
	}

	public Env[] getEnvs() {
		return (Env[]) this.list.toArray(new Env[0]);
	}
}
