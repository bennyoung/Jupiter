/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: NameHandler.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月5日 下午4:28:35 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月5日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.behavioral.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ben
 *
 */
public class NameHandler extends Handler {
	
	private String name = null;
	
	public NameHandler(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.designpattern.behavioral.chain.Handler#doSearch(java.util.List)
	 */
	@Override
	public List<Email> doSearch(List<Email> list) {
		String ename = null;
		List<Email> result = new ArrayList<Email>();
		if (name == null || name.length() == 0) {
			return list;
		}
		for (Email email : list) {
			ename = email.getName();
			if (ename.indexOf(name) >= 0) {
				result.add(email);
				System.out.println("NameHandler : " + email.getName());
			}
		}
		
		if (getHandler() != null) {
			result = getHandler().doSearch(result);
		}
		
		return result;
	}

}
