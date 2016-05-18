/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: TestSVImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 17 May 2016 15:24:45 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 17 May 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.service.impl;

import com.ben.jupiter.service.interfaces.ITestSV;

/**
 * @author Yang Bin
 *
 */
public class TestSVImpl implements ITestSV {

	/* (non-Javadoc)
	 * @see com.ben.jupiter.service.interfaces.ITestSV#test()
	 */
	@Override
	public void test() throws Exception {
		System.out.println("test");
		
	}

}
