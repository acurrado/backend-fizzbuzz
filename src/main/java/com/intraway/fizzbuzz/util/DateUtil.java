package com.intraway.fizzbuzz.util;

import java.sql.Timestamp;
import java.util.Date;

public class DateUtil {

	public static Timestamp getTimestamp() {
		Date date = new Date();

		Timestamp timestamp = new Timestamp(date.getTime());

		return timestamp;
	}

}
