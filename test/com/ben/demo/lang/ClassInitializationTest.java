/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Test.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年8月4日 上午10:42:44 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年8月4日     Ben           v1.0.0               修改原因
*/
package com.ben.demo.lang;

/**
 * @author Ben
 *
 */
public class ClassInitializationTest {

	public static void main(String args[]) throws Exception {
		
		//this class is not used, should not be initialized
		NotUsed o = null;
		System.out.println(NotUsed.s);
		
		//initializing sub class, should trigger super class initialization
		Child t = new Child();
		
  		System.out.println((Object)o == (Object)t);
	}
}

/**
 * Super class to demonstrate that Super class is loaded and initialized before Subclass.
 */
class Parent {
	static {
		System.out.println("static block of Super class is initialized");
	}
	{
		System.out.println("non static blocks in super class is initialized");
	}
	public Parent() {
		System.out.println("parent constructor is initialized");
	}
}

/**
 * Java class which is not used in this program, consequently not loaded by JVM
 */
class NotUsed {
	public static String s = "s";
	static {
		System.out.println("static NotUsed Class is initialized ");
	}
	{
		System.out.println("NotUsed Class is initialized");
	}
	public NotUsed() {
		System.out.println("NotUsed constructor is initialized");
	}
}

/**
 * Sub class of Parent, demonstrate when exactly sub class loading and initialization occurs.
 */
class Child extends Parent {
	static {
		System.out.println("static block of Sub class is initialized in Java ");
	}
	{
		System.out.println("non static blocks in sub class is initialized");
	}
	public Child() {
		System.out.println("child constructor is initialized");
	}
}
