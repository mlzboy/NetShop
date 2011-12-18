package com.lexus.util;

import java.util.List;

public class PageResult {
	private Page page;
	private List list;
	/**
	 * 
	 */
	public PageResult() {
		super();
		// TODO 自动生成构造函数存根
	}
	/**
	 * @param page
	 * @param list
	 */
	public PageResult(Page page, List list) {
		super();
		this.page = page;
		this.list = list;
	}
	/**
	 * @return list
	 */
	public List getList() {
		return list;
	}
	/**
	 * @param list 要设置的 list
	 */
	public void setList(List list) {
		this.list = list;
	}
	/**
	 * @return page
	 */
	public Page getPage() {
		return page;
	}
	/**
	 * @param page 要设置的 page
	 */
	public void setPage(Page page) {
		this.page = page;
	}
}
