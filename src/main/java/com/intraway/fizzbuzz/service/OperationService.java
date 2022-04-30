package com.intraway.fizzbuzz.service;

import com.intraway.fizzbuzz.dto.MinMaxDTO;
import com.intraway.fizzbuzz.dto.OperationDTO;

public interface OperationService {

	OperationDTO processFizzBuzz(MinMaxDTO minMaxDTO);
}
