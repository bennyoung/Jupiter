/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: ChainTest.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月5日 下午4:40:58 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月5日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.behavioral.chain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Ben
 *
 */
public class ChainTest {

	@Test
	public void searchEmail() {
		List<Email> emails = prepareData();
		NameHandler n = new NameHandler("name1");
		TitleHandler t = new TitleHandler("title1");
		
		n.setHandler(t);
		List<Email> result = n.doSearch(emails);
		
		for (Email e : result) {
			System.out.println("result : " + e.getName());
		}
	}
	
	private List<Email> prepareData() {
		List<Email> list = new ArrayList<Email>();
		Email m = null;
		
		for (int i = 0; i < 10; i++) {
			m = new Email();
			m.setName("name" + i);
			m.setTitle("title" + i);
			m.setContent("content" + i);
			list.add(m);
		}
		
		return list;
	}
	
}
