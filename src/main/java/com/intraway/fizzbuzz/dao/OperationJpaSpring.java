package com.intraway.fizzbuzz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intraway.fizzbuzz.model.Operation;

public interface OperationJpaSpring extends JpaRepository<Operation, Integer> {

}
