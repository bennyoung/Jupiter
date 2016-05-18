/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: TransactionIntercepter.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 17:22:43 
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
public class TransactionInterceptor {

	private List list = new ArrayList();

	public TransactionInterceptor() {
		
	}

	public void addClazz(Clazz clazz) {
		this.list.add(clazz);
	}

	public Clazz[] getClazzs() {
		return (Clazz[]) this.list.toArray(new Clazz[0]);
	}

}
