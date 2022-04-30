package com.intraway.fizzbuzz.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intraway.fizzbuzz.constants.Constants;
import com.intraway.fizzbuzz.dto.OperationDTO;
import com.intraway.fizzbuzz.exception.BadRequestException;

@AutoConfigureMockMvc
@SpringBootTest
public class OperationControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void noMultiple() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/fizzbuzz/1/2");

		MvcResult result = mock.perform(request).andReturn();

		OperationDTO operationDTO = objectMapper
				.readValue(result.getResponse().getContentAsString(StandardCharsets.UTF_8), OperationDTO.class);

		assertEquals(Constants.NO_MULTIPLE, operationDTO.getDescription());
		assertEquals("1, 2", operationDTO.getList());
	}

	@Test
	void hasThreeMultiple() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/fizzbuzz/1/3");

		MvcResult result = mock.perform(request).andReturn();

		OperationDTO operationDTO = objectMapper
				.readValue(result.getResponse().getContentAsString(StandardCharsets.UTF_8), OperationDTO.class);

		assertEquals(Constants.IS_THREE_MULTIPLE, operationDTO.getDescription());
		assertEquals("1, 2, Fizz", operationDTO.getList());
	}

	@Test
	void hasFiveMultiple() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/fizzbuzz/4/5");

		MvcResult result = mock.perform(request).andReturn();

		OperationDTO operationDTO = objectMapper
				.readValue(result.getResponse().getContentAsString(StandardCharsets.UTF_8), OperationDTO.class);

		assertEquals(Constants.IS_FIVE_MULTIPLE, operationDTO.getDescription());
		assertEquals("4, Buzz", operationDTO.getList());
	}

	@Test
	void hasThreeAndFiveMultiple() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/fizzbuzz/1/15");

		MvcResult result = mock.perform(request).andReturn();

		OperationDTO operationDTO = objectMapper
				.readValue(result.getResponse().getContentAsString(StandardCharsets.UTF_8), OperationDTO.class);

		assertEquals(Constants.IS_THREE_AND_FIVE_MULTIPLE, operationDTO.getDescription());
		assertEquals("1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz", operationDTO.getList());
	}

	@Test
	void incorrectParams() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/fizzbuzz/1/0");

		mock.perform(request).andExpect(status().isBadRequest())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof BadRequestException))
				.andExpect(result -> assertEquals(Constants.BAD_REQUEST_INCORRECT_PARAMS,
						result.getResolvedException().getMessage()));
	}
}
