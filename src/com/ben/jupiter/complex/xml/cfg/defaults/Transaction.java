/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Transaction.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 17:22:29 
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
public class Transaction {

	private List list = new ArrayList();
	private Clazz clazz = null;
	private Mapping mapping = null;
	private String type = null;
	
	public Transaction() {
		
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public Mapping getMapping() {
		return mapping;
	}

	public void setMapping(Mapping mapping) {
		this.mapping = mapping;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void addListener(Listener listener) {
		list.add(listener);
	}

	public Listener[] getListeners() {
		return (Listener[]) list.toArray(new Listener[0]);
	}
}
