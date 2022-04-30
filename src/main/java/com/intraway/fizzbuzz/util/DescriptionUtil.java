package com.intraway.fizzbuzz.util;

import com.intraway.fizzbuzz.constants.Constants;
import com.intraway.fizzbuzz.model.Operation;

public class DescriptionUtil {
	public static String getOperationDescription(Operation operation) {

		if (operation.getHasFiveMultiple() && operation.getHasThreeMultiple()) {
			return Constants.IS_THREE_AND_FIVE_MULTIPLE;
		} else if (operation.getHasFiveMultiple()) {
			return Constants.IS_FIVE_MULTIPLE;
		} else if (operation.getHasThreeMultiple()) {
			return Constants.IS_THREE_MULTIPLE;
		} else {
			return Constants.NO_MULTIPLE;
		}

	}
}
