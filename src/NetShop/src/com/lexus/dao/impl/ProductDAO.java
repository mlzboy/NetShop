package com.lexus.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.lexus.bean.CategoriesUserType;
import com.lexus.bean.DictionaryLib;
import com.lexus.bean.Product;
import com.lexus.dao.IProductDAO;
import com.lexus.util.Page;

public class ProductDAO extends BaseProductDAO implements IProductDAO {

	public List findByPagination(final Page page) {
		log.debug("执行findByPagination方法");
		return this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql="from Product p order by p.pkProductId desc";
				Query query=session.createQuery(hql).setFirstResult(page.getFirstIndex()).setMaxResults(page.getPageSize());
				List list=query.list();
				return list;
			}});
	}

	public int getCount() {
		log.debug("执行getCount方法");
		return (Integer)this.getHibernateTemplate().execute(new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql="select count(*) from Product";
				return session.createQuery(hql).uniqueResult();
			}
		});
	}

	/* （非 Javadoc）
	 * @see com.lexus.dao.IProductDAO#saveOrUpdate(com.lexus.bean.Product)
	 */
	public void saveOrUpdate(Product transientInstance) {
		log.info("执行saveOrUpdate方法");
		this.getHibernateTemplate().saveOrUpdate(transientInstance);
	}

	public int getSearchResultCount(String fieldName, String keyword) {
		log.info("执行getSearchResultCount方法");
		//String hql="select count(*) from Product p inner join ProductDetail pd on p.pkProductId=pd.pkFkProductId where "+fieldName+" like '%"+keyword+"%'";
		String hql="select count(*) from Product p,ProductDetail pd where p.pkProductId=pd.pkFkProductId and "+fieldName+" like '%"+keyword+"%'";
		return (Integer)this.getSession().createQuery(hql).uniqueResult();
		
	}

	/* （非 Javadoc）
	 * @see com.lexus.dao.IProductDAO#doSearch(com.lexus.util.Page, java.lang.String, java.lang.String)
	 */
	public List doSearch(Page page, String fieldName, String keyword) {
		log.info("执行doSearch方法");
		//String hql="select p.* from Product p inner join ProductDetail pd on p.pkProductId=pd.pkFkProductId where "+fieldName+" like '%"+keyword+"%'";
		String hql="select new Product(p.pkProductId,p.productName,p.productDescription,p.productCategories,p.productAttachments,p.checkinTime,p.updateTime,p.version,p.status,p.productDetail) from Product p,ProductDetail pd where p.pkProductId=pd.pkFkProductId and "+fieldName+" like '%"+keyword+"%'";
		return this.getSession().createQuery(hql).list();
	}

	/* （非 Javadoc）
	 * @see com.lexus.dao.IProductDAO#batchDelete(com.lexus.bean.DictionaryLib[])
	 */
	//该方法已丢弃
	public void batchDelete(DictionaryLib[] arrDictionaryLibs) {
		log.info("执行batchDelete方法");
//		this.getHibernateTemplate().execute(new HibernateCallback(){
//
//			public Object doInHibernate(Session session) throws HibernateException, SQLException {
//				log.info("执行sql1");
//				String sql="delete from product_detail where pk_fk_product_id in (select pk_product_id from product where product_categories in ("+strIDs+"))";
//				log.info("sql1="+sql);
//				int i=session.createSQLQuery(sql).executeUpdate();
//				log.info("影响了"+i+"行");
//				log.info("执行sql2");
//				sql="delete from product where product_categories in ("+strIDs+")";
//				log.info("sql2="+sql);
//				i=session.createSQLQuery(sql).executeUpdate();
//				log.info("影响了"+i+"行");
//				return null;
//			}});
		String hql="delete from ProductDetail where pkFkProductId in (select p.pkProductId from Product p where p.productCategories in (?))";
		this.getSession().createQuery(hql).setParameter(0, arrDictionaryLibs).executeUpdate();
	}

	public List findAll() {
		return this.getHibernateTemplate().find("from Product");
	}
	
	

}
