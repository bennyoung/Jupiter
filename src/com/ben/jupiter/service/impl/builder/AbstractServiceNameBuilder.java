/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: AbstractServiceNameBuilder.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 17 May 2016 14:58:52 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 17 May 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.service.impl.builder;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

import com.ben.jupiter.service.interfaces.IServiceNameBuilder;

/**
 * @author Yang Bin
 *
 */
public class AbstractServiceNameBuilder implements IServiceNameBuilder {

	/* (non-Javadoc)
	 * @see com.ben.jupiter.service.interfaces.IServiceNameBuilder#createStandService(java.lang.String)
	 */
	@Override
	public String createStandService(String interClassName) throws Exception {
		String[] tmp = StringUtils.split(interClassName, ".");
		String[] packageTmp = new String[tmp.length - 1];
		System.arraycopy(tmp, 0, packageTmp, 0, tmp.length - 1);

		String packageName = StringUtils.replace(StringUtils.join(packageTmp, "."), "interfaces","impl");
		char[] className = (tmp[tmp.length - 1] + "Impl").toCharArray();
		String clName = packageName + "."+ new String(className, 1, className.length - 1);
		return clName;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.service.interfaces.IServiceNameBuilder#createStandService(java.lang.Class)
	 */
	@Override
	public String createStandService(Class interClass) throws Exception {
		//标准服务
		String clazzName=null;
		String packageName = StringUtils.replace(ClassUtils.getPackageName(interClass), "interfaces", "impl");
		char[] className = (ClassUtils.getShortClassName(interClass) + "Impl").toCharArray();
		clazzName = packageName + "." + new String(className, 1, className.length - 1);
		return clazzName;
	}

}
