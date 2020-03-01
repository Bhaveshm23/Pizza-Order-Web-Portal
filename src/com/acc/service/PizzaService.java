package com.acc.service;

import java.util.List;
import java.util.Map;

import com.acc.business.bean.PizzaOrderBean;


public interface PizzaService {	
	public List<PizzaOrderBean> getOrderDetails(Double fromBill, Double toBill) throws Exception;
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaBean) throws Exception;
	public Map<Integer,String> findAllPizzaDetails()throws Exception;
	public PizzaOrderBean getPizzaOrderDetails(Integer id) throws Exception;
	public PizzaOrderBean updatePizzaOrder(PizzaOrderBean bean) throws Exception;
	public PizzaOrderBean deleteOrder(PizzaOrderBean bean) throws Exception;
}