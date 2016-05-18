/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Env.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 17:20:44 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 18 Feb 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.complex.xml.cfg.defaults;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * @author Yang Bin
 *
 */
public class Env {

	public static final String CROSS_CENTER = "0";
	private List list = new ArrayList();
	private String name;
	private String center;
	private String group;
	private String bigdistrict;

	public Env() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getBigdistrict() {
		return bigdistrict;
	}

	public void setBigdistrict(String bigdistrict) {
		this.bigdistrict = bigdistrict;
	}

	public void addProperty(Property property) {
		this.list.add(property);
	}

	public Property[] getProperties() {
		return (Property[]) this.list.toArray(new Property[0]);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (StringUtils.isBlank(this.bigdistrict)) {
			sb.append("<env name=\"" + name + "\" center=\"" + center + "\" group=\"" + group + "\">\n");
		} else {
			sb.append("<env name=\"" + name + "\" center=\"" + center + "\" bigdistrict=\"" + bigdistrict + "\" group=\"" + group + "\">\n");
		}

		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Property item = (Property) iter.next();
			if (StringUtils.isBlank(item.getType())) {
				sb.append("<property name=\"" + item.getName() + "\" value=\"" + item.getValue() + "\"/>\n");
			} else {
				sb.append("<property name=\"" + item.getName() + "\" type=\"" + item.getType() + "\" value=\"" + item.getValue() + "\"/>\n");
			}
		}
		sb.append("</env>\n");
		return sb.toString();
	}

}
