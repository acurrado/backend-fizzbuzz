package com.intraway.fizzbuzz.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
public class FizzBuzzDTO {
	private String list;
	private boolean isThreeMultiple;
	private boolean isFiveMultiple;

}
