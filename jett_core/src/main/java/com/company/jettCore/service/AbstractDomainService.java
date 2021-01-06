package com.company.jettCore.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.jettCore.exceptions.ResourceNotFoundException;
import com.company.jettCore.model.JPAEntity;

public abstract class AbstractDomainService<T extends JPAEntity>{

	protected abstract JpaRepository<T, Long> getRepo();
	
	public void save(T t) {
		getRepo().save(t);
		
	}

	public void delete(T t) throws ResourceNotFoundException {
		if (t != null) {
			getRepo().delete(t);
		}else {
			throw new ResourceNotFoundException("Entity not Found");
		}
		
	}

	public List<T> findAll() {
		return getRepo().findAll();
	}

	public T findById(Long id) {
		return getRepo().findById(id).get();
	}
}

