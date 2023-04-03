package com.example.demo.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpeakingClockServiceImplTest {

	@Autowired
	SpeakingClockServiceImpl SpeakingClockService;
	@Test
	void testGetSpeakingClock() {
		String timeInWords = SpeakingClockService.getSpeakingClock(11, 30);
        assertEquals("half past eleven", timeInWords);
	}
	

}
