/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Quartz.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 17:38:28 
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
public class Quartz {

	private List list = new ArrayList();

	public Quartz() {

	}

	public void addProperty(Property property) {
		list.add(property);
	}

	public Property[] getPropertys() {
		return (Property[]) list.toArray(new Property[0]);
	}
}
