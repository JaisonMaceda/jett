package com.company.jettCore.service;

import java.util.List;

import com.company.jettCore.exceptions.ResourceNotFoundException;
import com.company.jettCore.model.JPAEntity;

public interface DomainService <T extends JPAEntity> {
	void save(T t);
	
	void update(T t);
	
	void delete(T t) throws ResourceNotFoundException;
	
	List<T> findAll();
	
	T findById(Long id);
	
	T findByCode(String code);
}
