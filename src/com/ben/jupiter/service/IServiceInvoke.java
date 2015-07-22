/**   
* Copyright: Copyright (c) 2015 Asiainfo
* 
* @ClassName: IServiceInvoke.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 22 Jul 2015 19:25:28 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 22 Jul 2015     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.service;

/**
 * @author Yang Bin
 *
 */
public interface IServiceInvoke {

	/**
	 * getService
	 * @Function: IServiceInvoke.java
	 * @Description: 该函数的功能描述
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 22 Jul 2015 19:25:58
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 22 Jul 2015     Yang Bin           v1.0.0               修改原因
	 */
	public Object getService(Class interfaceClass);
	
	/**
	 * 
	 * @Function: IServiceInvoke.java
	 * @Description: 该函数的功能描述
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 22 Jul 2015 19:35:04
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 22 Jul 2015     Yang Bin           v1.0.0               修改原因
	 */
	public Object getService(String interfaceClass);
	
}
