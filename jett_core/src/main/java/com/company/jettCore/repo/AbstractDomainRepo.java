package com.company.jettCore.repo;

import java.util.List;

import com.company.jettCore.model.JPAEntity;

public abstract class AbstractDomainRepo <T extends JPAEntity> {
	
	public void create(T t) {
		
	}
	
	public void update(T t) {
		
	}
	
	public void delete(T t) {
		
	}
	
	public abstract List<T> findAll();
	
	public abstract T findById(Long id);
	
	
}
