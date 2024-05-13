package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;


	/*public TennisCoach (FortuneService theFortuneService){
		System.out.println("Inside Constructor");
		fortuneService = theFortuneService;
	}*/


	/*public void SetFortuneService (FortuneService theFortuneService){
		System.out.println("Inside setter");
		fortuneService = theFortuneService;
	}*/

	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
