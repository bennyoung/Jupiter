/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: TitleHandler.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月5日 下午4:38:43 
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
public class TitleHandler extends Handler {
	
	private String title = null;
	
	public TitleHandler(String title) {
		this.title = title;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.designpattern.behavioral.chain.Handler#doSearch(java.util.List)
	 */
	@Override
	public List<Email> doSearch(List<Email> list) {
		String etitle = null;
		List<Email> result = new ArrayList<Email>();
		if (title == null || title.length() == 0) {
			return list;
		}
		for (Email email : list) {
			etitle = email.getTitle();
			if (etitle.indexOf(title) >= 0) {
				result.add(email);
				System.out.println("TitleHandler: " + email.getTitle());
			}
		}
		
		if (getHandler() != null) {
			getHandler().doSearch(result);
		}
		
		return result;
	}

}
