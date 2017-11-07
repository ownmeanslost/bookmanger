package com.bookmanger.common.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bookmanger.common.dao.BaseDao;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;

/**
 * 
 * ͨ
 * 
 * @author b
 * 
 * @param <T>
 */
public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements
		BaseDao<T> {

	Class<T> clazy;

	/**
	 * 
	 * 反射机制
	 */
	public BaseDaoImpl() {
		Class<?> thisClass = this.getClass();
		System.out.println("thisClass" + thisClass);
		ParameterizedType type = (ParameterizedType) thisClass
				.getGenericSuperclass();
		System.out.println("type" + type);
		this.clazy = (Class) type.getActualTypeArguments()[0];
		System.out.println("clazy" + clazy);
	}

	public String getTableName() {
		SessionFactory sessionFactory = this.getHibernateTemplate()
				.getSessionFactory();
		AbstractEntityPersister classMetadata = (AbstractEntityPersister) sessionFactory
				.getClassMetadata(clazy);
		String tableName = classMetadata.getTableName();
		return tableName;
	}

	@Override
	public T get(Serializable id) {
		T result = this.getHibernateTemplate().get(clazy, id);
		return result;
	}

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {

		super.setSessionFactory(sessionFactory);
	}

	@Override
	public Serializable save(T entity) {
		Serializable result = this.getHibernateTemplate().save(entity);
		return result;
	}
	@Override
	public void update(T entity) throws DataAccessException {
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);	
	}
	// 分页查找
	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	@Override
	public PaginationResponse<T> getByPage(final int pageNumber,
			final int pageSize, List<QueryCondition> cons) {
		List<T> list = null;
		PaginationResponse<T> result = null;
		try {
			/*
			 * query = getSession().createQuery(cons.toString());
			 * list=query.list();
			 */
			String str = " from " + clazy.getName();
			if (cons.size() > 0) {
				str += " where ";
				for (int i = 0; i < cons.size() - 1; i++) {
					str += cons.get(i).toString() + " and ";
				}
				str += cons.get(cons.size() - 1).toString();
			}

			final String countSql = str;

			// 总数
			int total = this.getHibernateTemplate().find(countSql).size();
			// 分页查询到的集合
			list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						@Override
						public Object doInHibernate(Session arg0)
								throws HibernateException, SQLException {
							Query query = arg0.createQuery(countSql);
							query.setFirstResult(pageNumber);
							query.setMaxResults(pageSize);
							return query.list();
						}
					});

			// 封装PaginationResponse<T>
			result = new PaginationResponse<T>();
			result.setTotal(total);
			result.setRows(list);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return result;

	}
}
