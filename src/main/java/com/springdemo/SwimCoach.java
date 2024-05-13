package com.springdemo;

public class SwimCoach implements Coach{

    private FortuneService fortuneService;

    public  SwimCoach (FortuneService theFortuneService){
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "swim 100 meters";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
