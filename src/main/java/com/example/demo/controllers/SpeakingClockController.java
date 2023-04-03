package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Utils;
import com.example.demo.service.SpeakingClockService;

@RestController
public class SpeakingClockController {
	
	@Autowired
	SpeakingClockService speakingClockService;
	
	@GetMapping("/")
	public ResponseEntity<String> getSpeakingClock(){
		try {
		List<Integer> time = Utils.getTimeHoursAndMinutes();
		return ResponseEntity.ok(speakingClockService.getSpeakingClock(time.get(0),time.get(1)));
		}catch (IllegalArgumentException e) {
			return ResponseEntity.ok(e.getMessage());
		}
		
	}
	
	
	

}
