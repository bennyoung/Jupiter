/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Pool.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 17:21:52 
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
public class Pool {

	private List list = new ArrayList();
	private String name = null;
	private String type = null;
	private String db = null;
	private String primary;
	private String init;
	private String template = null;
	private String isAdvanceUrl;

	public Pool() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getPrimary() {
		return primary;
	}

	public void setPrimary(String primary) {
		this.primary = primary;
	}

	public String getInit() {
		return init;
	}

	public void setInit(String init) {
		this.init = init;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getIsAdvanceUrl() {
		return isAdvanceUrl;
	}

	public void setIsAdvanceUrl(String isAdvanceUrl) {
		this.isAdvanceUrl = isAdvanceUrl;
	}

	public void addProperty(Property property) {
		this.list.add(property);
	}

	public Property[] getProperties() {
		return (Property[]) this.list.toArray(new Property[0]);
	}
}
