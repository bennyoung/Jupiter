package com.ben.jupiter.util;

import org.apache.commons.lang.StringUtils;

public class StringUtilsTest {
	
	private static String getSpecialServiceImpl(String implClassName,String tenantId) throws Exception{
		String result = null;
		String[] tmp = StringUtils.split(implClassName, ".");
		String implName = tmp[tmp.length - 1];
		String prefix=StringUtils.substringBefore(implClassName, ".service.impl");
		result = prefix + ".tenant" + tenantId + ".service.impl." + implName;
		return result;
	}
	
	private static String getSpecialService(String interClassName,String tenantId) throws Exception{
		String result = null;
		String[] tmp = StringUtils.split(interClassName, ".");
		String[] packageTmp = new String[tmp.length - 1];
		System.arraycopy(tmp, 0, packageTmp, 0, tmp.length - 1);
		String packageName = StringUtils.replace(StringUtils.join(packageTmp, "."), "interfaces","impl");
		String prefix=StringUtils.substringBefore(packageName, ".service.impl");
		char[] className = (tmp[tmp.length - 1]+ "Impl").toCharArray();
		String servSimpleClassName=new String(className, 1, className.length - 1); 
		result = prefix+".tenant"+tenantId+".service.impl."+servSimpleClassName;
			
		return result;
	}
	
	private static String getStandardFlyingPackage(String interfaceName, String implName) throws Exception{
    	String tmpPackage=null;
		if(interfaceName.contains(".service.interfaces.")){
			//正常路径的服务
			tmpPackage = interfaceName.replaceAll(".interfaces.",".flying.");
			tmpPackage = tmpPackage.substring(0, tmpPackage.lastIndexOf('.'));
		}else if(interfaceName.contains(".interfaces.")){
			tmpPackage = interfaceName.replaceAll(".interfaces.",".service.flying.");
			tmpPackage = tmpPackage.substring(0, tmpPackage.lastIndexOf('.'));
		}else if(interfaceName.contains(".service.")){
			tmpPackage = interfaceName.replaceAll(".service.",".service.flying.");
			tmpPackage = tmpPackage.substring(0, tmpPackage.lastIndexOf('.'));
		}else{
			//非正常路径的服务
			tmpPackage = interfaceName.substring(0, interfaceName.lastIndexOf('.'));
			tmpPackage = tmpPackage + ".service.flying";
		}
			//多租户
		String tenant = null;
		if(implName.contains(".tenant")){
			String[] temps = StringUtils.split(implName, ".");
			for(String str:temps){
				if(str.startsWith("tenant") && str.length() >= 7){
					//以tenant开头，后面加两位租户id
					tenant = str;
					break;
				}
			}
			
			if(StringUtils.isNotBlank(tenant)){
				StringBuilder sb = new StringBuilder();
		        sb.append(StringUtils.substringBefore(tmpPackage,".service."));
		        sb.append(".").append(tenant);
		        sb.append(tmpPackage.substring(tmpPackage.indexOf(".service.")));
		        tmpPackage = sb.toString();
			}
		}
		return tmpPackage;
	}
	
	public static void main(String[] args) throws Exception {
		String implName = "com.ai.omframe.order.tenant0.service.impl.TestNoItfs";
		String interfaceName = "com.ai.omframe.service.order.NoItfs";
		
		System.out.println(StringUtilsTest.getStandardFlyingPackage(interfaceName, implName));
//		System.out.println(StringUtils.replace(interfacename, "interfaces", "flying")+ "FlyingClient");
//		
//		String tmpPackage = implName.replaceAll(".impl.",".flying.");
//		tmpPackage = tmpPackage.substring(0, tmpPackage.lastIndexOf('.'));
//		
//		System.out.println(tmpPackage);
		
//		String ss = implName.substring(0, implName.lastIndexOf(".")) + ".flying";
//		System.out.println(ss);
//		String s = StringUtilsTest.getSpecialService("com.ailk.veriscrm.paas.customer.service.interfaces.ITestForSVOverSV", "0");
//		System.out.println(s);
	}
	
}

