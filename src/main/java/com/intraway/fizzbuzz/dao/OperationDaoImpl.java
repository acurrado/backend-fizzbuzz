package com.intraway.fizzbuzz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intraway.fizzbuzz.model.Operation;

@Repository
public class OperationDaoImpl implements OperationDao {

	@Autowired
	OperationJpaSpring operations;

	@Override
	public Operation saveOperation(Operation operation) {
		return operations.save(operation);

	}

}
