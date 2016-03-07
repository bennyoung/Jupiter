/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Accelerate.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 17:37:35 
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
public class Accelerate {

	private List list = new ArrayList();
	private String enable = "false";
	private String match = null;
	
	public Accelerate() {
		
	}
	
	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public void addProperty(Property property) {
		list.add(property);
	}

	public Property[] getPropertys() {
		return (Property[]) list.toArray(new Property[0]);
	}
	
}
