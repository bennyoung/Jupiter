/**   
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: DataSource.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Yang Bin
 * @date: 18 Feb 2016 17:20:34 
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
public class DataSource {

	private List list = new ArrayList();
	private Clazz clazz = null;
	private Mapping mapping = null;

	public DataSource() {

	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public void addPool(Pool pool) {
		this.list.add(pool);
	}

	public Pool[] getPools() {
		return (Pool[]) this.list.toArray(new Pool[0]);
	}

	public Mapping getMapping() {
		return mapping;
	}

	public void setMapping(Mapping mapping) {
		this.mapping = mapping;
	}
}
