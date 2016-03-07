/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Cache.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 17:38:10 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 18 Feb 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.complex.xml.cfg.caches;

import java.util.ArrayList;
import java.util.List;

import com.ben.jupiter.complex.xml.cfg.defaults.Property;

/**
 * @author Yang Bin
 *
 */
public class Cache {

	private List list = new ArrayList();
	private String id;
	private String init = "true";
	private String accelerate = "false";
	
	public Cache() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInit() {
		return init;
	}

	public void setInit(String init) {
		this.init = init;
	}

	public String getAccelerate() {
		return accelerate;
	}

	public void setAccelerate(String accelerate) {
		this.accelerate = accelerate;
	}

	public void addProperty(Property property) {
		list.add(property);
	}

	public Property[] getPropertys() {
		return (Property[]) list.toArray(new Property[0]);
	}

}
