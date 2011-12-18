package com.lexus.util;

public class PageUtil {
	public static Page createPage(Page page,int recordCount)
	{
		return createPage(page.getCurrentPage(),recordCount,page.getPageSize());
	}
	public static Page createPage(int currentPage,int recordCount,int pageSize)
	{
		currentPage=getCurrentPage(currentPage);
		pageSize=getPageSize(pageSize);
		int firstIndex=getFirstIndex(currentPage,pageSize);
		int pageCount=getPageCount(recordCount,pageSize);
		boolean hasPrePage=hasPrePage(currentPage);
		boolean hasNextPage=hasNextPage(currentPage,pageCount);
		return new Page(pageSize,currentPage,pageCount,recordCount,firstIndex,hasPrePage,hasNextPage);
	}
	private static boolean hasNextPage(int currentPage, int pageCount) {
		return currentPage==pageCount || pageCount==0 ? false : true;
	}
	private static boolean hasPrePage(int currentPage) {
		return currentPage==1?false:true;
	}
	private static int getPageCount(int recordCount, int pageSize) {
		int pageCount=0;
		if(recordCount%pageSize==0)
			pageCount=recordCount/pageSize;
		else
			pageCount=recordCount/pageSize+1;
		return pageCount;
	}
	private static int getFirstIndex(int currentPage, int pageSize) {
		return (currentPage-1)*pageSize;
	}
	public static int getCurrentPage(int currentPage)
	{
		return  currentPage==0?1:currentPage;
	}
	public static int getPageSize(int pageSize)
	{
		return pageSize==0?10:pageSize;
	}
}
