package com.rormation.gs.dao.implimentation;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

import com.rormation.gs.dao.GenericDao;
import com.rormation.gs.utils.HibernateUtil;

public class GenericDaoImpl <T,K extends Serializable>implements GenericDao<T, K>{
    
	
	protected Session hibrenateSession ;
	private Transaction tx ; 
	private Class<T> clazz ;
	
	public GenericDaoImpl() {
		clazz= (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	
	protected void startOperation() {
		
		hibrenateSession= HibernateUtil.getInstance().getSessionFactory().openSession();
		tx=hibrenateSession.beginTransaction();
		
	}
	
    protected void endOperation() {
		tx.commit();//valide des transa
		hibrenateSession.close();
	}
	@Override
	public void save(T entity) throws Exception {
		startOperation();
		hibrenateSession.save(entity);//.save methode distribuee par hibernate (jdbc deja ma5douma)
		endOperation();
		
		
	}

	@Override
	public void update(T entity) throws Exception {
		
		startOperation();
		hibrenateSession.update(entity);//.save methode distribuee par hibernate (jdbc deja ma5douma)
		endOperation();
		
	}

	@Override
	public void delete(T entity) throws Exception {
		startOperation();
		hibrenateSession.delete(entity);//.save methode distribuee par hibernate (jdbc deja ma5douma)
		endOperation();
		
		
	}

	@Override
	public T findById(K id) throws Exception {
		startOperation();
		T entity= (T) hibrenateSession.get(clazz,id);
		hibrenateSession.close();
		return entity;
	}

	@Override
	public List<T> findAll() throws Exception {
		 
		startOperation();
		List<T> list = hibrenateSession.createCriteria(clazz).list();
		hibrenateSession.close();
		return list ;
	}

	@Override
	public List<T> findByCriteria(Criterion crit) throws Exception {
		startOperation();
		List<T> list = hibrenateSession.createCriteria(clazz).add(crit).list();
		hibrenateSession.close();
		return list ;
	}

}
