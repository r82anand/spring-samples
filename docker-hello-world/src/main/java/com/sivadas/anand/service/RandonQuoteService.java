package com.sivadas.anand.service;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandonQuoteService {
	
	private final static String[] QUOTES_OF_THE_DAY = {"With the new day comes new strength and new thoughts - Elanor Roosevelt",
						"The greatest remedy for anger is delay. - Lucius Annaeus",
						"Nobody can hurt me without my permission.- Mahatma Gandhi",
						"Art is man's expression of his joy in labor. - Henry Kissinger", 
						"The art of communication is the language of leadership. - James Humes",
						"You will not be punished for your anger, you will be punished by your anger. - Budhdha",
						"We boil at different degrees. - Client Eastwood",
						"Silence is one of the hardest arguments to refute. - Josh Billings", 
						"First they ignore you, then they laugh at you, then they fight you, then you win. - Mahatma Gandhi",
						"A nation's culture resides in the hearts and in the soul of its people. - Mahatma Gandhi"};
	
	
	public static String getRandomQuoteOfTheDay() {
		
		Random random = new Random();
		int index = random.nextInt(10);
		return QUOTES_OF_THE_DAY[index];
	}

}
