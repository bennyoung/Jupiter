/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Center.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 17:20:13 
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
public class Center {

	private List list = new ArrayList();

	public Center() {
		
	}

	public void addProperty(Property property) {
		this.list.add(property);
	}

	public Property[] getProperties() {
		return (Property[]) this.list.toArray(new Property[0]);
	}
}
