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
package com.ben.jupiter.service.interfaces;

/**
 * @author Yang Bin
 *
 */
public interface IServiceInvoke {

	/**
	 * getService
	 * @Function: IServiceInvoke.java
	 * @Description: 根据类型获取服务实例
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
	 * @Description: 根据全包名获取服务实例
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
	
	/**
	 * 
	 * @Function: IServiceInvoke.java
	 * @Description: 获取跨中心的服务实例
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 3 Aug 2015 15:55:43
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 3 Aug 2015     Yang Bin           v1.0.0               修改原因
	 */
	public Object getCrossCenterService(Class interfaceClass);
	
	/**
	 * 
	 * @Function: IServiceInvoke.java
	 * @Description: 根据全包名获取跨中心的服务实例
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 3 Aug 2015 15:56:34
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 3 Aug 2015     Yang Bin           v1.0.0               修改原因
	 */
	public Object getCrossCenterService(String interfaceClass);
	
}
