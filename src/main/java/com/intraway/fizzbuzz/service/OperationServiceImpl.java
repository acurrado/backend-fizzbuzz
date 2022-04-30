package com.intraway.fizzbuzz.service;

import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intraway.fizzbuzz.constants.Constants;
import com.intraway.fizzbuzz.dao.OperationDao;
import com.intraway.fizzbuzz.dto.FizzBuzzDTO;
import com.intraway.fizzbuzz.dto.MinMaxDTO;
import com.intraway.fizzbuzz.dto.OperationDTO;
import com.intraway.fizzbuzz.dto.mapper.OperationMapper;
import com.intraway.fizzbuzz.exception.BadRequestException;
import com.intraway.fizzbuzz.model.Operation;
import com.intraway.fizzbuzz.util.DateUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OperationServiceImpl implements OperationService {

	@Autowired
	OperationDao dao;

	@Override
	public OperationDTO processFizzBuzz(MinMaxDTO minMaxDTO) {

		if (isValid(minMaxDTO)) {

			FizzBuzzDTO fizzBuzzDTO = this.printFizzBuzz(minMaxDTO);

			Operation operation = new Operation().setMinValue(minMaxDTO.getMin()).setMaxValue(minMaxDTO.getMax())
					.setHasFiveMultiple(fizzBuzzDTO.isFiveMultiple()).setHasThreeMultiple(fizzBuzzDTO.isThreeMultiple())
					.setList(fizzBuzzDTO.getList()).setTimestamp(DateUtil.getTimestamp());

			try {
				operation = dao.saveOperation(operation);
			} catch (Exception ex) {
				log.error("Ocurrió un error inesperado al guardar en la base de datos", ex);
			}

			return OperationMapper.toOperationDTO(operation);
		} else {
			throw new BadRequestException(Constants.BAD_REQUEST_INCORRECT_PARAMS);
		}
	}

	private boolean isValid(MinMaxDTO minMaxDTO) {
		if (minMaxDTO.getMin() < -50 || minMaxDTO.getMax() > 50) {
			return false;
		}

		if (minMaxDTO.getMin() > minMaxDTO.getMax()) {
			return false;
		}

		return true;
	}

	private FizzBuzzDTO printFizzBuzz(MinMaxDTO minMaxDTO) {

		FizzBuzzDTO fizzBuzzDTO = new FizzBuzzDTO();
		boolean isThreeMultiple = false;
		boolean isFiveMultiple = false;

		int min = minMaxDTO.getMin();
		int max = minMaxDTO.getMax();

		StringJoiner sj = new StringJoiner(", ");

		for (int i = min; i <= max; i++) {
			// Si es múltiplo de 3 y 5 se imprime FizzBuzz
			if (i % 15 == 0) {

				sj.add("FizzBuzz");
				isThreeMultiple = true;
				isFiveMultiple = true;
			} else if (i % 5 == 0) {
				// Si solo es múltiplo de 5 se imprime Buzz
				isFiveMultiple = true;
				sj.add("Buzz");
			} else if (i % 3 == 0) {
				// Si solo es múltiplo de 3 se imprime Fizz
				sj.add("Fizz");
				isThreeMultiple = true;
			} else {
				sj.add(Integer.toString(i));
			}
		}

		fizzBuzzDTO.setList(sj.toString());
		fizzBuzzDTO.setFiveMultiple(isFiveMultiple);
		fizzBuzzDTO.setThreeMultiple(isThreeMultiple);

		return fizzBuzzDTO;
	}

}
