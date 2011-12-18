package com.lexus.util;

public class Page {
	private int pageSize;

	private int currentPage;

	private int pageCount;

	private int recordCount;

	private int firstIndex;
	private boolean hasPrePage;
	private boolean hasNextPage;



	/**
	 * @param pageSize
	 * @param currentPage
	 * @param pageCount
	 * @param recordCount
	 * @param firstIndex
	 * @param hasPrePage
	 * @param hasNextPage
	 */
	public Page(int pageSize, int currentPage, int pageCount, int recordCount, int firstIndex, boolean hasPrePage, boolean hasNextPage) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.pageCount = pageCount;
		this.recordCount = recordCount;
		this.firstIndex = firstIndex;
		this.hasPrePage = hasPrePage;
		this.hasNextPage = hasNextPage;
	}
	/**
	 * @return hasNextPage
	 */
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	/**
	 * @param hasNextPage 要设置的 hasNextPage
	 */
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	/**
	 * @return hasPrePage
	 */
	public boolean isHasPrePage() {
		return hasPrePage;
	}
	/**
	 * @param hasPrePage 要设置的 hasPrePage
	 */
	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}
	/**
	 * 
	 */
	public Page() {
		super();
		// TODO 自动生成构造函数存根
	}
	/**
	 * @param pageSize
	 */
	public Page(int pageSize) {
		super();
		this.pageSize = pageSize;
	}
	/**
	 * @param pageSize
	 * @param currentPage
	 * @param pageCount
	 * @param recordCount
	 * @param firstIndex
	 */

	/**
	 * @param pageSize
	 * @param currentPage
	 */
	public Page(int pageSize, int currentPage) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}



	/**
	 * @return currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage
	 *            要设置的 currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount
	 *            要设置的 pageCount
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            要设置的 pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return recordCount
	 */
	public int getRecordCount() {
		return recordCount;
	}

	/**
	 * @param recordCount
	 *            要设置的 recordCount
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	/**
	 * @return firstIndex
	 */
	public int getFirstIndex() {
		return firstIndex;
	}

	/**
	 * @param firstIndex
	 *            要设置的 firstIndex
	 */
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
}
