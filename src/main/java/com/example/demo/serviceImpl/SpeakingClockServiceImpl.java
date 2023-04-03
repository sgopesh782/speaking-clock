package com.example.demo.serviceImpl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Utils;
import com.example.demo.service.SpeakingClockService;

@Service
public class SpeakingClockServiceImpl implements SpeakingClockService{

	@Override
	public String getSpeakingClock(int hour,int minute) {
		String[] hourWords = {"Midnight", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Midday"};
        String[] tensWords = {"", "", "Twenty", "Thirty", "Forty", "Fifty"};
        String[] unitWords = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        List<Integer> time = Utils.getTimeHoursAndMinutes();
	        String timeInWords = "";
	        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
	            throw new IllegalArgumentException("Invalid time format");
	        }
	        if (hour == 0 && minute == 0) {
	            timeInWords = "It's Midnight";
	            return timeInWords;
	        } else if (hour == 12 && minute == 0) {
	            timeInWords = "It's Midday";
	            return timeInWords;
	        } else {
	        	
	        	String timeInWordselse = "It's ";
	        	 if (hour == 0) {
	        		 timeInWordselse += hourWords[0] + " ";
	 	        } else if (hour == 12) {
	 	        	timeInWordselse += hourWords[hour] + " ";
	 	        } else {
	 	        	timeInWordselse += hourWords[hour % 12] + " ";
	 	        }

	 	        if (minute == 0) {
	 	        	timeInWordselse += "o'clock";
	 	        } else if (minute < 20) {
	 	        	timeInWordselse += unitWords[minute] + " ";
	 	        } else {
	 	        	timeInWordselse += tensWords[minute / 10] + " ";
	 	            if (minute % 10 != 0) {
	 	            	timeInWordselse += unitWords[minute % 10] + " ";
	 	            }
	 	        }
	 	       return timeInWordselse;
	        }
	        
	       
	}

}
