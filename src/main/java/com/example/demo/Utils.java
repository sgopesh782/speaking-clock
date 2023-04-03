package com.example.demo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Utils {
	
	   public static List<Integer> getTimeHoursAndMinutes() {
		    LocalTime time = LocalTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	        String timeString = time.format(formatter);
	        String[] parts = timeString.split(":");
	        int hour = Integer.parseInt(parts[0]);
	        int minute = Integer.parseInt(parts[1]);
	        return Arrays.asList(hour,minute);
	        
	}

}
