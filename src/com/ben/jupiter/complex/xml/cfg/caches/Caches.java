/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Caches.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 17:38:15 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 18 Feb 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.complex.xml.cfg.caches;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yang Bin
 *
 */
public class Caches {

	private List list = new ArrayList();
	private Quartz quartz;
	private Accelerate accelerate;
	
	public Caches() {
		
	}
	
	public Quartz getQuartz() {
		return quartz;
	}

	public void setQuartz(Quartz quartz) {
		this.quartz = quartz;
	}

	public Accelerate getAccelerate() {
		return accelerate;
	}

	public void setAccelerate(Accelerate accelerate) {
		this.accelerate = accelerate;
	}

	public void addCache(Cache cache) {
		this.list.add(cache);
	}

	public Cache[] getCaches() {
		return (Cache[]) this.list.toArray(new Cache[0]);
	}
}
