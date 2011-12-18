package com.lexus.util;

import junit.framework.TestCase;

public class PathAndFileOperateTest extends TestCase {
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testGetRandomFileName()
	{
		System.out.println("random file name:"+PathAndFileOperate.getRandomFileName("abc.jpg"));
	}

	public void testGetExt() {
		String s="ddd.jpg";
		assertEquals(".jpg",PathAndFileOperate.getExt(s));
	}
	
	public void testGetRandomNumber()
	{
		System.out.print(String.valueOf(PathAndFileOperate.getRandomNumber(5)));
	}
	public void testRight()
	{
		assertEquals("bc", PathAndFileOperate.right("abc", 2));
		assertEquals("abc",PathAndFileOperate.right("abc", 5));
		assertEquals("人民共和国",PathAndFileOperate.right("中华人民共和国", 5));
		assertEquals("中华人民共和国",PathAndFileOperate.right("中华人民共和国", 10));
		assertEquals("共a和b国",PathAndFileOperate.right("中华人民1共a和b国", 5));
		assertEquals("",PathAndFileOperate.right(null, 5));	
	}
	public void testGetYYYYMMDD()
	{
		assertEquals("20070603",PathAndFileOperate.getYYYYMMDD());
	}
	public void testLeft()
	{
//		assertEquals("ab",PathAndFileOperate.left("abc", 2));
//		assertEquals("abc",PathAndFileOperate.left("abc", 5));

		assertEquals("",PathAndFileOperate.left("", 2));
		assertEquals("a",PathAndFileOperate.left("a",2));
		assertEquals("中",PathAndFileOperate.left("中", 2));
		assertEquals("",PathAndFileOperate.left("", 0));
		assertEquals("",PathAndFileOperate.left("a",0));
		assertEquals("",PathAndFileOperate.left("中", 0));
		assertEquals("",PathAndFileOperate.left(null, 0));
		assertEquals("中国人",PathAndFileOperate.left("中国人", 3));
		assertEquals("abc",PathAndFileOperate.left("abc", 3));	
		assertEquals("abc",PathAndFileOperate.left("abcdefg", 3));
		assertEquals("中华人",PathAndFileOperate.left("中华人民共和国", 3));
		assertEquals("中1华",PathAndFileOperate.left("中1华2人3民共和国", 3));
		assertEquals("中1华","中1华2人3民共和国".substring(0,3));
		assertEquals("中1a","中1a华2人3民共和国".substring(0,3));
		assertEquals("中华人","中华人3民共和国".substring(0,3));
		System.out.println("dddd="+"中1华".length());
	
	}
	
//	public void testSubString()
//	{
//		assertEquals("中国",PathAndFileOperate.subString("中2国人", 7));
//		assertEquals("中2",PathAndFileOperate.subString("中2国人", 7));
//		System.out.println("中2国="+String.valueOf("中2国".length()));
//		System.out.println("abc="+String.valueOf("abc".length()));
//		System.out.println("中2国="+String.valueOf("中2国".substring(0,2)));
//		System.out.println("abc="+String.valueOf("abc".substring(0,2)));
//	}
}

