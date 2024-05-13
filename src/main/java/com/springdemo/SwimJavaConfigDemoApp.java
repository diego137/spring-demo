package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SwimJavaConfigDemoApp {


	public boolean anagramChecker(String word1, String word2){
		if(word1.length() != word2.length()){
			return false;
		}
		 char[] wordArray1 = word1.toCharArray();
		 char[] wordArray2 = word2.toCharArray();

		Arrays.sort(wordArray1);
		Arrays.sort(wordArray2);

		return Arrays.equals(wordArray1,wordArray2);

	}

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		

		
	}

}


