/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: IServiceNameBuilder.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 23 Mar 2016 10:31:09 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 23 Mar 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.service.interfaces;

/**
 * @author Yang Bin
 *
 */
public interface IServiceNameBuilder {

	/**
	 * 
	 * @Function: IServiceNameBuilder.java
	 * @Description: 返回标准的服务实现名称
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 17 May 2016 14:29:11
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 17 May 2016     Yang Bin           v1.0.0               修改原因
	 */
	public String createStandService(String interClass) throws Exception;
	
	/**
	 * 
	 * @Function: IServiceNameBuilder.java
	 * @Description: 返回标准的服务实现名称
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 17 May 2016 14:29:52
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 17 May 2016     Yang Bin           v1.0.0               修改原因
	 */
	public String createStandService(Class interClass) throws Exception;
}
