/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: SubjectSVImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月8日 上午11:22:38 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月8日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.behavioral.proxy.examlpe2;

/**
 * @author Ben
 *
 */
public class SubjectSVImpl implements ISubjectSV {

	/* (non-Javadoc)
	 * @see com.ben.jupiter.designpattern.behavioral.proxy.examlpe2.ISubjectSV#request()
	 */
	@Override
	public void request() {
		System.out.println("do request.....");
	}

}
