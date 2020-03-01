package com.acc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.acc.entity.PizzaEntity;



@RepositoryDefinition(idClass = Integer.class, domainClass = PizzaEntity.class)
@Transactional(value = "txManager")
// name of TransactionManger can be any thing
public interface PizzaDAO {
	@Query(name = "findAllPizzaDetails")
	List<PizzaEntity> findAllPizzaDetails();
	
}