/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: ISrvControl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 23 May 2016 15:08:05 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 23 May 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.service.control;

/**
 * @author Yang Bin
 *
 */
public interface ISrvControl {

	/**
	 * 
	 * @Function: ISrvControl.java
	 * @Description: 开始服务控制
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 23 May 2016 15:08:27
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 23 May 2016     Yang Bin           v1.0.0               修改原因
	 */
	public Object startControl(Object serviceObject,String methodName,Object[] objectArray);

	/**
	 * 
	 * @Function: ISrvControl.java
	 * @Description: 结束服务控制
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 23 May 2016 15:08:55
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 23 May 2016     Yang Bin           v1.0.0               修改原因
	 */
	public void endControl(Object controlObject, Object serviceObject, String methodName, Object[] objectArray);

	/**
	 * 
	 * @Function: ISrvControl.java
	 * @Description: 刷新控制数据
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 23 May 2016 15:09:14
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 23 May 2016     Yang Bin           v1.0.0               修改原因
	 */
	public void refreshControlData();
}
