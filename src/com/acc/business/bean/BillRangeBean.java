package com.acc.business.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BillRangeBean {

	@NotNull(message="From Price can't be empty")
	@Min(value=200,message="Minimum value of from price should be 200")
	private Double fromPrice;
	
	@NotNull(message="To Price can't be empty")
	@Min(value=200,message="Minimum value of to price should be 200")
	private Double toPrice;
	
	public BillRangeBean() {}
	public BillRangeBean(Double fromPrice, Double toPrice) {
		super();
		this.fromPrice = fromPrice;
		this.toPrice = toPrice;
	}
	public Double getFromPrice() {
		return fromPrice;
	}
	public void setFromPrice(Double fromPrice) {
		this.fromPrice = fromPrice;
	}
	public Double getToPrice() {
		return toPrice;
	}
	public void setToPrice(Double toPrice) {
		this.toPrice = toPrice;
	}
	@Override
	public String toString() {
		return "BillRangeBean [fromPrice=" + fromPrice + ", toPrice=" + toPrice + "]";
	}
	
	
	
}
