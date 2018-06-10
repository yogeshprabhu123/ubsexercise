package com.ubs.opsit.interviews;

import java.util.Arrays;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeConverterImpl implements TimeConverter {

	private static final Logger LOG = LoggerFactory.getLogger(TimeConverterImpl.class);
	
	@Override
	public String convertTime(String inputTime) {
		if (null != inputTime) {
			String[] hms = inputTime.split(":", 3);

			if (hms.length != 3) {
				LOG.warn("Please provide input time in valid format HH:MM:SS");
				return null;
			}

			int hrs = 0;
			int mins = 0;
			int secs = 0;

			try {
				hrs = Integer.parseInt(hms[0]);
				mins = Integer.parseInt(hms[1]);
				secs = Integer.parseInt(hms[2]);
			} catch (NumberFormatException e) {
				LOG.warn("Non-numeric input time");
				return null;
			}

			if (!validateTime(hrs, mins, secs))
				return null;

			String secondsLamp = (secs % 2 == 0) ? "Y" : "O";
			String fiveHourLamp = createRow(hrs / 5, 4, "R");
			String oneHourLamp = createRow(hrs % 5, 4, "R");
			String fiveMinutesLamp = createRow(mins / 5, 11, "Y").replaceAll("YYY", "YYR");
			String oneMinuteLamp = createRow(secs % 5, 4, "Y");

			return String.join("\n",
					Arrays.asList(secondsLamp, fiveHourLamp, oneHourLamp, fiveMinutesLamp, oneMinuteLamp));
		} else {
			LOG.warn("Please provide input time");
			return null;
		}
	}

	private String createRow(int onlights, int totalLights, String lampIndicator) {

		int offLights = totalLights - onlights;
		String row = String.join("", Collections.nCopies(onlights, lampIndicator))
				+ String.join("", Collections.nCopies(offLights, "O"));
		return row;
	}

	private boolean validateTime(int hrs, int mins, int secs) {
		if (hrs < 0 || hrs > 23) {
			LOG.warn("Hours should be between 0 & 23");
			return false;
		}
		if (mins < 0 || mins > 59) {
			LOG.warn("Minutes should be between 0 & 59");
			return false;
		}
		if (secs < 0 || secs > 59) {
			LOG.warn("Seconds should be between 0 & 59");
			return false;
		}
		return true;
	}

}
