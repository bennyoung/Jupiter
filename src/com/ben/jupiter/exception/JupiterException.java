/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: JupiterException.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 4 Mar 2016 21:03:27 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 4 Mar 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.exception;

/**
 * @author Yang Bin
 *
 */
public class JupiterException extends Exception {

	public JupiterException(String msg) {
		super(msg);
	}
	
	public JupiterException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
