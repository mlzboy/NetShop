package com.lexus.util;

import junit.framework.TestCase;

public class CharacterOperateTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testIsFloat() {
		assertEquals(false,CharacterOperate.isFloat("ddd"));
		assertEquals(false,CharacterOperate.isFloat(""));
		assertEquals(false,CharacterOperate.isFloat("中国"));
		assertEquals(false,CharacterOperate.isFloat(null));
		assertEquals(true,CharacterOperate.isFloat("-22312.2323"));
	}

}
