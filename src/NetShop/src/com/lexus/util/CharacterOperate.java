package com.lexus.util;

public class CharacterOperate {
	/**
	 * @param str
	 * @return 返回true表示原始字符串为数字
	 */
	public static boolean isFloat(String str)
	{
		boolean flag=true;
		try
		{
			Float.parseFloat(str);
		}
		catch(NumberFormatException ex)
		{
			flag=false;
		}
		catch(NullPointerException ex)
		{
			flag=false;
		}
		return flag;
	}

}
