package com.lexus.util;

import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lexus
 *
 */
public class PathAndFileOperate {
	
	/**
	 * @param request
	 * @return 返回程序的绝对路径
	 */
	public static String getRealPath(HttpServletRequest request)
	{
		return request.getSession().getServletContext().getRealPath("")+"\\";
	}
	
	/**
	 * @param fileName
	 * @return 返回文件的扩展名,形式为".jpg"
	 */
	public static String getExt(String fileName)
	{
		return fileName.substring(fileName.lastIndexOf("."));
	}
	
	/**
	 * @param fileName
	 * @return 返回当前日期加5位随机数的文件名
	 */
	public static String getRandomFileName(String fileName)
	{
		return getYYYYMMDD()+getRandomNumber(5)+getExt(fileName);
	}
	
	/**
	 * @return 返回一个n位的随机数
	 */
	public static int getRandomNumber(int n)
	{
		Random rnd=new Random();
		return rnd.nextInt((int)Math.pow(10, n));
	}
	public static String getYYYYMMDD()
	{
		Calendar cal=Calendar.getInstance();
		String year=String.valueOf(cal.get(Calendar.YEAR));
		String month=String.valueOf(cal.get(Calendar.MONTH)+1);
		month=right("00"+month,2);
		String day=String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		day=right("00"+day,2);
		return year+month+day;
	}
	public static String right(String str,int n)
	{
		if(str==null)
		{
			return "";
		}
		if(str.length()<n)
		{
			n=str.length();
		}
		return str.substring(str.length()-n);
	}
	public static String left(String str,int n)
	{
		//返回所有字符串的情况
		if(str==null||str.equals("")||n<1)
		{
			return "";
		}
		int len=str.length();
		if(len<=n)
		{
			return str;
		}
		else
		{
			if(len>2*n)
			{
				//若原始字符串的长度比2倍的欲截取的字符串长度还大，则截取2n的长度作为下面操作的原始字符串
				str=str.substring(0,2*n);
				len=str.length();
			}
			char[] arrChars=str.toCharArray();
			int strNum=0,strGBKNum=0;
			for(int i=0;i<len;i++)
			{
				strNum++;
				if(arrChars[i]>=0xa1)
				{//若为汉字
					strNum++;
					strGBKNum++;
				}
				if(strGBKNum!=0&&(strNum==2*n||strNum==2*n-1))
				{
					break;
				}
				if(strGBKNum==0&&strNum==n)
				{
					break;
				}
			}
			return str.substring(0,strNum-strGBKNum);
		}
	}
	//该方法已丢弃
	 private static String subString(String sourceString , int maxLength)
	 {
	  String resultString = "";
	  if(sourceString==null||sourceString.equals("")||maxLength<1)
	  {
	   return resultString;
	  }
	  else if(sourceString.length()<=maxLength)
	  {
	   return sourceString;
	  }
	  else if(sourceString.length()>2*maxLength)
	  {
	   sourceString = sourceString.substring(0,2*maxLength);
	  }

	 
	 if (sourceString.length()>maxLength)
	 {
	  char[] chr = sourceString.toCharArray();   
	  int strNum=0;
	  int strGBKNum=0;
	  boolean isHaveDot =false;
	  
	  for(int i=0;i<sourceString.length();i++)
	  {
	   if(chr[i]>=0xa1) //0xa1汉字最小位开始
	   {
	    strNum=strNum+2;
	    strGBKNum++;
	   }
	   else
	   { 
	    strNum++;
	   }
	   
	   if(strNum==2*maxLength||strNum==2*maxLength+1)
	   {
	    if(i+1<sourceString.length())
	    {
	     isHaveDot=true;
	    }    

	    break;
	   }
	  }

	  resultString = sourceString.substring(0, strNum-strGBKNum);
	  if(!isHaveDot)
	  {
	   resultString=resultString+"...";
	  }
	 }
	 
	 return resultString;
	}

}
