package com.acc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.business.bean.PizzaBean;
import com.acc.business.bean.PizzaOrderBean;
import com.acc.dao.PizzaDAOWrapper;

@Service
public class PizzaServiceImpl implements PizzaService {
	
	@Autowired
	private PizzaDAOWrapper pizzaDAOWrapper;

	@Override
	public List<PizzaOrderBean> getOrderDetails(Double frombill, Double toBill) throws Exception {
		// TODO Auto-generated method stub
		return pizzaDAOWrapper.getOrderDetails(frombill, toBill);
	}

	@Override
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaBean) throws Exception {
			
			
	Double price = pizzaDAOWrapper.getPizzaPrice(pizzaBean.getPizzaId());
	Double total = price * pizzaBean.getNumberOfPiecesOrdered();
	pizzaBean.setBill(total);
	return pizzaDAOWrapper.addPizzaOrderDetails(pizzaBean);
	
	}

	@Override
	public Map<Integer, String> findAllPizzaDetails() throws Exception {
		List<PizzaBean> listBean = pizzaDAOWrapper.findAllPizzaDetails();
		//converting list to map
		Map<Integer, String> map = new HashMap<>();
		
		for(PizzaBean bean : listBean) {
			map.put(bean.getPizzaId(), bean.getPizzaName());
		}
		return map;
	}

	@Override
	public PizzaOrderBean getPizzaOrderDetails(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return pizzaDAOWrapper.getPizzaOrderDetails(id);
	}

	@Override
	public PizzaOrderBean updatePizzaOrder(PizzaOrderBean bean) throws Exception {
		// TODO Auto-generated method stub
		Double price = pizzaDAOWrapper.getPizzaPrice(bean.getPizzaId());
		Double total = price * bean.getNumberOfPiecesOrdered();
		bean.setBill(total);
		return pizzaDAOWrapper.updatePizzaOrder(bean);
	}

	

}
