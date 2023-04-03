package com.example.demo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Test {

	        public static void main(String[] args) {
	        LocalTime time = LocalTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	        String timeString = time.format(formatter);
	        String[] parts = timeString.split(":");
	        int hour = Integer.parseInt(parts[0]);
	        int minute = Integer.parseInt(parts[1]);
	        String timeInWords = "";

	        if (hour == 0 && minute == 0) {
	            timeInWords = "It's Midnight";
	        } else if (hour == 12 && minute == 0) {
	            timeInWords = "It's Midday";
	        } else {
	            timeInWords = getTimeInWords(hour, minute);
	        }

	        System.out.println(timeInWords);
	    }

	    public static String getTimeInWords(int hour, int minute) {
	        String[] hourWords = {"Midnight", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Midday"};
	        String[] tensWords = {"", "", "Twenty", "Thirty", "Forty", "Fifty"};
	        String[] unitWords = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

	        String timeInWords = "It's ";

	        if (hour == 0) {
	            timeInWords += hourWords[0] + " ";
	        } else if (hour == 12) {
	            timeInWords += hourWords[hour] + " ";
	        } else {
	            timeInWords += hourWords[hour % 12] + " ";
	        }

	        if (minute == 0) {
	            timeInWords += "o'clock";
	        } else if (minute < 20) {
	            timeInWords += unitWords[minute] + " ";
	        } else {
	            timeInWords += tensWords[minute / 10] + " ";
	            if (minute % 10 != 0) {
	                timeInWords += unitWords[minute % 10] + " ";
	            }
	        }

	        return timeInWords;
	    }
	}

