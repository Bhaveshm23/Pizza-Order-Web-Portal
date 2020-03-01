package com.acc.web.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.acc.business.bean.PizzaOrderBean;
import com.acc.service.PizzaService;

@Controller
@SessionAttributes({"pizzaOrderObject","pizzaOrderObject2"})
public class PizzaOrderController {

@Autowired
private PizzaService pizzaService;

	@RequestMapping("/loadPizzaOrder.html")
	public ModelAndView loadSavePizza() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("PizzaOrder");
		mv.addObject("pizzaOrderObject",new PizzaOrderBean());
		return mv;
	}
	
	//To load select items
	@ModelAttribute("pizzaNamesAndId")
	public Map<Integer,String>populatePizzaNames() throws Exception {
		return pizzaService.findAllPizzaDetails();
	}
	
	
	
	@RequestMapping("/SavePizzaOrder.html")
	public ModelAndView addPizzaOrderDetails( @Valid @ModelAttribute("pizzaOrderObject") PizzaOrderBean pizzaOrderBean ,BindingResult bindingResult) throws Exception {
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mv.setViewName("PizzaOrder");
		}else {
			PizzaOrderBean bean= pizzaService.addPizzaOrderDetails(pizzaOrderBean);
			System.out.println("Controller bean: "+bean);
			mv.setViewName("PizzaOrderSuccess");
			mv.addObject("message","Hi: "+ bean.getCustomerName()+", your order is placed with order id: "+bean.getOrderId()+", Bill to be paid is: "+bean.getBill());
		}
			return mv;
		
	}
	
	//update order
	
	@RequestMapping("/loadUpdateOrder.html")
	public ModelAndView loadUpdateOrder1() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("UpdatePizzaOrder");
		mv.addObject("pizzaOrderObject", new PizzaOrderBean());
		return mv;
	}
	
	@RequestMapping("/loadUpdateOrder2.html")
	public ModelAndView loadUpdateOrder2(@ModelAttribute("pizzaOrderObject") PizzaOrderBean pizzaOrderBean) throws Exception {
		ModelAndView mv = new ModelAndView();
		PizzaOrderBean pizza2 = pizzaService.getPizzaOrderDetails(pizzaOrderBean.getOrderId());
		mv.setViewName("UpdatePizzaOrder");
		mv.addObject("pizzaOrderObject2", pizza2);
		return mv;
	}
	
	@RequestMapping("/UpdatePizzaOrder.html")
	public ModelAndView updateOrder(@ModelAttribute("pizzaOrderObject2") PizzaOrderBean pizzaOrderBean) throws Exception {
		System.out.println("Controller");
		ModelAndView mv = new ModelAndView();
		PizzaOrderBean bean= pizzaService.updatePizzaOrder(pizzaOrderBean);
		mv.setViewName("UpdateOrderSuccess");
	    mv.addObject("updateOrderMessage", "Updated order with order id: "+bean.getOrderId());
		return mv;
	
	}
	
	
	//delete order
	
	@RequestMapping("/loadDeleteOrder.html")
	public ModelAndView loadDeleteOrder() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("DeletePizzaOrder");
		mv.addObject("pizzaOrderObject",new PizzaOrderBean());
		return mv;
	}
	
	@RequestMapping("/deletePizzaOrder.html")
	public ModelAndView deleteOrder(@ModelAttribute("pizzaOrderObject") PizzaOrderBean pizzaOrderBean) throws Exception {
		ModelAndView mv = new ModelAndView();
		PizzaOrderBean bean = pizzaService.deleteOrder(pizzaOrderBean);
		mv.setViewName("DeleteOrderSuccess");
		mv.addObject("deleteOrderMessage","Deleted order with order id: "+bean.getOrderId());
		return mv;
		
	}
	  //Error Handler:
	  
	  @ExceptionHandler(value=Exception.class) 
	  public ModelAndView handleAllExceptions(Exception exception){ 
        ModelAndView modelAndView = new ModelAndView(); 
        modelAndView.setViewName("GeneralizedExceptionHandlerPage");
	    modelAndView.addObject("message", exception.getMessage());
	    modelAndView.addObject("exception", exception); return modelAndView; 
	  }
	 
	
}
