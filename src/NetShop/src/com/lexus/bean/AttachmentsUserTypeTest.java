package com.lexus.bean;

import junit.framework.TestCase;

public class AttachmentsUserTypeTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testParse() {
		String str="3,4";
		String[] arrStrs=org.apache.commons.lang.StringUtils.split(str,',');
		for(int i=0;i<arrStrs.length;i++)
		{
			if(i==0)
				assertEquals("3",arrStrs[i]);
			if(i==1)
				assertEquals("4",arrStrs[i]);
		}
		str="3";
		arrStrs=org.apache.commons.lang.StringUtils.split(str,',');
		for(int i=0;i<arrStrs.length;i++)
		{
			assertEquals("3",arrStrs[i]);
		}
	}

//	public void testAssembleList() {
//		fail("尚未实现");
//	}

}
