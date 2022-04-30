package com.intraway.fizzbuzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.intraway.fizzbuzz.constants.Constants;
import com.intraway.fizzbuzz.dto.MinMaxDTO;
import com.intraway.fizzbuzz.dto.OperationDTO;
import com.intraway.fizzbuzz.exception.BadRequestException;
import com.intraway.fizzbuzz.service.OperationService;

@CrossOrigin(origins = "*")
@RestController
public class OperationController {
	@Autowired
	OperationService service;

	@GetMapping(value = "fizzbuzz/{min}/{max}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OperationDTO fizzbuzz(@PathVariable("min") int min, @PathVariable("max") int max) {

		MinMaxDTO minMaxDTO = new MinMaxDTO().setMin(min).setMax(max);
		return service.processFizzBuzz(minMaxDTO);
	}

}
