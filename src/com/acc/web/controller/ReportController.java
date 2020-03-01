package com.acc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.acc.business.bean.BillRangeBean;
import com.acc.business.bean.PizzaOrderBean;
import com.acc.service.PizzaService;

@Controller
public class ReportController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@RequestMapping("/loadBillRangeReport.html")
	public ModelAndView loadDateRangeReport() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("OrderReport");
		mv.addObject("billRangeObj",new BillRangeBean());
		return mv;
		
	}
	
	@RequestMapping("/FetchDetails.html")
	public ModelAndView getOrderDetails(@ModelAttribute("billRangeObj")BillRangeBean billRangeBean) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<PizzaOrderBean> pizzaBeanList = pizzaService.getOrderDetails(billRangeBean.getFromPrice(), billRangeBean.getToPrice());
		mv.setViewName("OrderReport");
		mv.addObject("pizzaOrderList", pizzaBeanList);
		return mv;
	}

}
