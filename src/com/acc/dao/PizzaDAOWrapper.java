package com.acc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acc.business.bean.PizzaBean;
import com.acc.business.bean.PizzaOrderBean;
import com.acc.entity.PizzaEntity;
import com.acc.entity.PizzaOrderEntity;

@Repository
@Transactional(value = "txManager")
public class PizzaDAOWrapper{
	
	@Autowired
	private PizzaDAO pizzaDAO;
	
	@Autowired
	private PizzaOrderDAO pizzaOrderDAO;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<PizzaBean> findAllPizzaDetails(){
		List<PizzaEntity> listEntity = pizzaDAO.findAllPizzaDetails();
		List<PizzaBean> pizzaBean = new ArrayList<>();
		for(PizzaEntity pizzaEntity : listEntity) {
			PizzaBean bean = convertEntityToBean(pizzaEntity);
			pizzaBean.add(bean);
		}
		
		return pizzaBean;
	
	}
	
	public Double getPizzaPrice(Integer pizzaId) {
		
		Double price =0.0;
		//find the pizza
		PizzaEntity entity = entityManager.find(PizzaEntity.class, pizzaId);
		if(entity!=null) {
			price = entity.getPrice();
		}
		return price;
		
	}
	
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean) {
		
		PizzaOrderEntity entity = convertOrderBeanToEntity(pizzaOrderBean);
		PizzaOrderBean bean = convertOrderEntityToBean(pizzaOrderDAO.save(entity));
		return bean;
	}
	
	
	public List<PizzaOrderBean> getOrderDetails(Double fromBill, Double toBill){
		String s = "select p from PizzaOrderEntity p where p.bill>=?1 and p.bill<=?2";
		Query q = entityManager.createQuery(s);
		q.setParameter(1, fromBill);
		q.setParameter(2, toBill);
		List<PizzaOrderEntity> pizzaOrderEntities =q.getResultList();
		
		List<PizzaOrderBean> bean = new ArrayList<PizzaOrderBean>();
		for(PizzaOrderEntity entity : pizzaOrderEntities) {
			bean.add(convertOrderEntityToBean(entity));
		}
		return bean;
	}
	
	
	//get all order details
	
	public PizzaOrderBean getPizzaOrderDetails(Integer id){
		PizzaOrderBean  bean = null;
		try {
			PizzaOrderEntity entity = entityManager.find(PizzaOrderEntity.class, id);

			if(entity!=null) {
				 bean = convertOrderEntityToBean(entity);

			}
		}catch(Exception exception){
			throw exception;
		}
		return bean;
	}
	
	
	//updating order
	
	public PizzaOrderBean updatePizzaOrder(PizzaOrderBean bean) {
		PizzaOrderBean pizzaOrderBean2 = null;
		try {
			
			PizzaOrderEntity  entity = (PizzaOrderEntity) entityManager.find(PizzaOrderEntity.class, bean.getOrderId());
			System.out.println("DAO entity: "+entity);
			if(entity!=null) {
				entity.setBill(bean.getBill());
				entity.setContactNumber(bean.getContactNumber());
				entity.setCustomerName(bean.getCustomerName());
				entity.setNumberOfPiecesOrdered(bean.getNumberOfPiecesOrdered());
				entity.setPizzaId(bean.getPizzaId());
				pizzaOrderBean2 =convertOrderEntityToBean(entity);
			}
			
		}catch(Exception e) {
			throw e;
		}
		System.out.println("DAO bean: "+pizzaOrderBean2);
		return pizzaOrderBean2;
		
	}
	
	
	
	
	//Utility methods
	
	public static PizzaBean convertEntityToBean(PizzaEntity pizzaEntity) {
		PizzaBean pizzaBean = new PizzaBean();
		BeanUtils.copyProperties(pizzaEntity, pizzaBean);
		return pizzaBean;
	}
	
	public static PizzaEntity convertBeanToEntity(PizzaBean pizzaBean) {
		PizzaEntity  pizzaEntity = new PizzaEntity();
		BeanUtils.copyProperties(pizzaBean, pizzaEntity);
		return pizzaEntity;
	}
	
	public static PizzaOrderBean convertOrderEntityToBean(PizzaOrderEntity pizzaEntity) {
		PizzaOrderBean pizzaBean = new PizzaOrderBean();
		BeanUtils.copyProperties(pizzaEntity, pizzaBean);
		return pizzaBean;
	}
	
	public static PizzaOrderEntity convertOrderBeanToEntity(PizzaOrderBean pizzaBean) {
		PizzaOrderEntity  pizzaEntity = new PizzaOrderEntity();
		BeanUtils.copyProperties(pizzaBean, pizzaEntity);
		return pizzaEntity;
	}
}