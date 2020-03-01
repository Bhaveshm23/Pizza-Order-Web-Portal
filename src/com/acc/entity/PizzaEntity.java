package com.acc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pizza")
public class PizzaEntity {

	@Id
	private Integer pizzaId;
	private String pizzaName;
	private Double price;
	public PizzaEntity() {}
	public PizzaEntity(Integer pizzaId, String pizzaName, Double price) {
		super();
		this.pizzaId = pizzaId;
		this.pizzaName = pizzaName;
		this.price = price;
	}
	public Integer getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "PizzaEntity [pizzaId=" + pizzaId + ", pizzaName=" + pizzaName + ", price=" + price + "]";
	}
	
	
}
