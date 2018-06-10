package com.ubs.opsit.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BerlinClockMain {

	private static final Logger LOG = LoggerFactory.getLogger(TimeConverterImpl.class);

	public static void main(String[] args) {
		LOG.info("*****Inut Time*****: " + args[0]);
		TimeConverter berlinClockService = new TimeConverterImpl();
		String berlinClock = berlinClockService.convertTime(args[0]);
		LOG.info("*****Berlin Clock****: \n" + berlinClock);
	}
}
