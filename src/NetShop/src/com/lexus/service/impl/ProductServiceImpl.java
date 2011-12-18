package com.lexus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lexus.bean.DictionaryLib;
import com.lexus.bean.Product;
import com.lexus.service.IProductService;
import com.lexus.util.Page;
import com.lexus.util.PageResult;
import com.lexus.util.PageUtil;

public class ProductServiceImpl extends BaseProductServiceImpl implements
		IProductService {
	/**
	 * Logger for this class
	 */
	private static final Log log = LogFactory.getLog(ProductServiceImpl.class);
	public PageResult findByPagination(Page page) {
		log.info("执行findByPagination(Page page)方法");
		int recordCount=this.getProductDAO().getCount();
		page=PageUtil.createPage(page, recordCount);
		List list=this.getProductDAO().findByPagination(page);
		return new PageResult(page,list);
	}

	public void saveOrUpdate(Product transientInstance) {
		this.getProductDAO().saveOrUpdate(transientInstance);
	}

	public PageResult doSearch(Page page, String fieldName, String keyword) {
		int recordCount=this.getProductDAO().getSearchResultCount(fieldName,keyword);
		page=PageUtil.createPage(page, recordCount);
		List list=this.getProductDAO().doSearch(page,fieldName,keyword);
		return new PageResult(page,list);
		
	}

	public void batchDelete(DictionaryLib[] arrDictionaryLibs) {
		this.getProductDAO().batchDelete(arrDictionaryLibs);
	}

	public List findAll() {
		return this.getProductDAO().findAll();
	}

	/* （非 Javadoc）
	 * @see com.lexus.service.IProductService#findByPagination(com.lexus.util.Page, int)
	 */
	public PageResult findByPagination(Page page, int categoryId) {
		log.info("执行findByPagination(Page page, int categoryId)方法");
		DictionaryLib dictionaryLib=this.getDictionaryLibDAO().findById(categoryId);
		if(dictionaryLib==null)
		{//若参数不正确，则返加所有产品的分页列表
			return this.findByPagination(page);
		}
		else
		{
			//获得该categoryId下类及其所有子类的DictionaryLib对象，并将这些对象组成一个DictionaryLib对象数组
			log.info("深度遍历开始");
			//			深度遍历获取该分类及其下所有子类
			
			ArrayList<DictionaryLib> al=new ArrayList<DictionaryLib>();
			//添加节点自身
			al.add(dictionaryLib);
			//创建堆栈
			Stack<Integer> myStack=new Stack<Integer>();
			//压入堆栈
			this.doPush(myStack, dictionaryLib);
			while(!myStack.empty())
			{
				int i=myStack.pop();
				al.add(this.getDictionaryLibDAO().findById(i));
				this.doPush(myStack,this.getDictionaryLibDAO().findById(i));
			}
			DictionaryLib[] arrDictionaryLibs=(DictionaryLib[])al.toArray(new DictionaryLib[al.size()]);
			//遍历产品主表
			//设置判断该产品是否在categoryId所在分类或其子类下，若在则为True,否认为false
			boolean isConstains=false;
			log.info("遍历产品主表开始");
			List aList=this.getProductDAO().findAll();
			int aSize=aList.size();
			log.info("产品表累计共有" +aSize+"个产品");
			List bList=null;
			int bSize=0;
			Product product;
			for(int i=aSize;i>0;i--)
			{
				log.info("当前在产品表的第"+ aSize + "个产品上进行操作");
				//取得该产品
				product=(Product)aList.get(i-1);
				//取得该产品所属的所有分类列表
				bList=product.getProductCategories();
				//取得产品所属分类的个数
				bSize=bList.size();
				log.info("该产品上共" +
						bSize+"有个分类");
				for(int j=0;j<bSize;j++)
				{
					log.info("当前在该产品分类的第" +
							j+"个分类上进行操作");
					if(org.apache.commons.lang.ArrayUtils.contains(arrDictionaryLibs, (DictionaryLib)bList.get(j)))
					{
						//置isConstains为true表示，该产品是需返回的产品
						isConstains=true;
						//退出该产品分类的循环
						break;
					}
				}
				if(isConstains)
				{
					//重置标记
					isConstains=false;
				}
				else
				{
					//该产品不是需要返回的记录，从记录列表中移除
					aList.remove(i-1);
				}
			}
			//对筛选后的记录列表aList，按照所需要的分页，有选择性的返回
			log.info("进行分页处理");
			int recordCount=aList.size();
			log.info("recordCount="+recordCount);
			page=PageUtil.createPage(page, recordCount);
			log.info("fromIndex="+page.getFirstIndex());
			log.info("toIndex="+(page.getFirstIndex()+page.getPageSize()));
			int fromIndex=page.getFirstIndex();
			int toIndex=(recordCount-fromIndex)<page.getPageSize()?recordCount:fromIndex+page.getPageSize();
			log.info("fromIndex="+fromIndex);
			log.info("toIndex="+toIndex);		
			List list=aList.subList(fromIndex, toIndex);
			return new PageResult(page,list);
		}
	}
	private void doPush(Stack<Integer> myStack,DictionaryLib dictionaryLib) {
		if(dictionaryLib.getDictionaryLibs().size()>0)
		{
			Iterator it=dictionaryLib.getDictionaryLibs().iterator();
			while(it.hasNext())
			{
				myStack.push(((DictionaryLib)it.next()).getPkDictionaryLibId());
			}
		}
	}
	

}
