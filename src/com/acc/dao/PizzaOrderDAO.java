package com.acc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.acc.entity.PizzaOrderEntity;



@RepositoryDefinition(idClass = Integer.class, domainClass = PizzaOrderEntity.class)
@Transactional
public interface PizzaOrderDAO extends CrudRepository<PizzaOrderEntity, Integer>{

	PizzaOrderEntity save(PizzaOrderEntity entity);
	
	
}
 