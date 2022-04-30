package com.intraway.fizzbuzz.dto.mapper;

import com.intraway.fizzbuzz.dto.OperationDTO;
import com.intraway.fizzbuzz.model.Operation;
import com.intraway.fizzbuzz.util.DescriptionUtil;

public class OperationMapper {
	public static OperationDTO toOperationDTO(Operation operation) {
		OperationDTO operationDTO = new OperationDTO().setCode(Integer.toString(operation.getOperationId()))
				.setList(operation.getList()).setTimestamp(operation.getTimestamp())
				.setDescription(DescriptionUtil.getOperationDescription(operation));

		return operationDTO;
	}
}
