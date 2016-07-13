/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Email.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月5日 下午4:29:51 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月5日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.behavioral.chain;

/**
 * @author Ben
 *
 */
public class Email {

	private String name;
	
	private String title;
	
	private String content;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}
