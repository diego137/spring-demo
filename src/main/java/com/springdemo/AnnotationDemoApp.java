package com.springdemo;



import com.fasterxml.jackson.annotation.JsonTypeId;

import java.util.*;
import java.util.stream.Collectors;

public class AnnotationDemoApp {


	public static int addAndFloor(double num1, double num2) {
		double sum = num1 + num2;
		int floorSum = (int) sum;
		return floorSum;
	}


	public static void fizzBuzz (int limit) {
		for(int i = 1; i <= limit; i++){
			if(i%3 == 0 && i%5 == 0){
				System.out.println("FizzBuzz");
			}
			else if(i%3 == 0){
				System.out.println("Fizz");
			}
			else if (i%5 == 0){
				System.out.println("Buzz");
			}
			else System.out.println(i);
		}
	}




	public static String posibleCombinations (char[] items) {
		List<String> result = new ArrayList<>();
		char[] charArray = new char[3];
		for(int i=0; i < items.length; i++){
			for(int j=i+1; j < items.length; j++){
				for(int k=i+2; k < items.length; k++){
					if(items[i] != items[j] && items[j] != items[k]){
						charArray[0] = items[i];
						charArray[1] = items[j];
						charArray[2] = items[k];
						result.add(Arrays.toString(charArray));

					}


				}

			}

		}
		return result.toString();
	}

	public static String reverseString (String str){
		String result = "";
		char[] charArray = str.toCharArray();
		for (int i = charArray.length -1; i >=0 ; i--){
			result = result + charArray[i];
		}
		return result;
	}

	public static String reverseString2 (String str){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(str);
		stringBuilder.reverse();
		return stringBuilder.toString();
	}




	public static int duplicateCounterInt (int[] numbers){
		int counter = 0;
		for(int i = 0; i< numbers.length; i++){
			for(int j = i+1; j< numbers.length; j++){
				if(numbers[i] == numbers[j]){
					counter ++;
				}
			}
		}
		return counter;
	}



	public static int[] targetIndex (int target, int[] array){

		for(int i=0; i < array.length -1; i++){
			for(int j=i+1; j < array.length; j++){
				if(array[i] + array[j] == target){
					return new int[]{i,j};
				}

			}
		}

		return new int[]{-1,-1};
	}

	public static int[] sum (){
		int [] numeros = {6, 4, 3, 9, 5};
		int target = 15;

		Map <Integer,Integer> map = new HashMap <>();
		//iterate over the array to add key(array element) and value (index of array)
		for (int i=0 ; i < numeros.length; i ++){
			int complement = target - numeros[i];
			//if map contains the complement return the value( value is the index previously stored in the map) and the actual index position of the array
			if(map.containsKey(complement)){
				return new int[]{map.get(complement), i};
			}
			//if map doesnt contain the complement add the array value and the actual index in the map
			else {
				map.put(numeros[i], i);
			}
		}
		return new int[]{-1, -1};
	}

	//int[] original = new int[] { 1, 4, 3, 2 };
	//int[] desired = new int[] { 1, 2, 4, 3 };

	public static int getCount(boolean[][] matrix) {
		int n = matrix.length;
		boolean[] visited = new boolean[n];
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(matrix, visited, i);
				count++;
			}
		}

		// The number of new flight connections needed is count - 1
		// because each connected component will require one less connection than the number of airports in it.
		return count - 1;
	}

	private static void dfs(boolean[][] matrix, boolean[] visited, int airport) {
		visited[airport] = true;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[airport][i] && !visited[i]) {
				dfs(matrix, visited, i);
			}
		}
	}






	public static Map<String,Integer> duplicateCounter (String sentence ){

		List<String> myList ;
		Map <String,Integer> myMap = new HashMap<>();

		String [] myStringArray = sentence.split(" ");
		int size = myStringArray.length;
		myList = Arrays.stream(myStringArray).collect(Collectors.toList());
		int a;
		for (String word: myList)
		{
			 a = Collections.frequency(myList,word);
			if(a > 0){
				myMap.put(word,a);
			}

		}
		return myMap;
	}

	/*Anagram checker
	An Anagram is a word, phrase, or name formed by rearranging the letters of another one
			(if both have same length and also have the exact same count of characters).

	Input Format
	The first line contains a string.
	The second line contains a string.
	Returns
	boolean: If both strings are anagrams, return true. Otherwise, return false.*/

	public static boolean anagramChecker (String word1, String word2){

		if(word1.length() != word2.length()){
			return false;
		}
		char[] wordArray1 = word1.toCharArray();
		char[] wordArray2 = word2.toCharArray();
		Arrays.sort(wordArray1);
		Arrays.sort(wordArray2);
		return Arrays.equals(wordArray1,wordArray2);



	}

	public static boolean anagramCheckerMap (String word1, String word2){

		if(word1.length() != word2.length()){
			return false;
		}
		char[] wordArray1 = word1.toCharArray();
		char[] wordArray2 = word2.toCharArray();
		HashMap<Character,Integer> map1 = new HashMap<>();
		HashMap<Character,Integer> map2 = new HashMap<>();

		for(int i = 0; i < word1.length(); i++){
			//check if the map contains a letter if not added
			if(map1.get(wordArray1[i]) == null){
				map1.put(wordArray1[i], 1);

			}
			// if the map contains already the letter get the frequency and added 1
			else {
				Integer c = map1.get(wordArray1[i]);
				map1.put(wordArray1[i], ++c);
			}
		}

		for(int i = 0; i < word2.length(); i++){
			//check if the map contains a letter if not added
			if(map2.get(wordArray2[i]) == null){
				map2.put(wordArray2[i], 1);

			}
			else {
				Integer c = map2.get(wordArray2[i]);
				map2.put(wordArray2[i], ++c);
			}
		}

		return map1.equals(map2);



	}

	public static List<Integer> findDuplicatesIntegers(int[]array1, int[]array2){
		List<Integer> result = new ArrayList<>();
		for (int i=0; i < array1.length; i++){
			for (int j=0; j < array2.length; j++){
				if(array1[i] == array2[j]){
					result.add(array1[i]);
				}
			}
		}
		return result;

	}

	//SELECT *maxSalary as salary from Employees WHERE salaray < (SELECT (salary) from Employees)

	//Write a lambda function to filter the strings with length > 4 from list of strings.

	/*public List<String> filterString (List<String> stringList){

		stringList.stream().filter(str -> str.length() > 4).collect(Collectors.toList());

	}*/

	public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
		List<String> list = Arrays.asList(names);
		return list.stream().filter(str -> str.length() > 5).mapToInt(String::length).sum();

	}


//Given an n x n matrix and an integer x, find the position of x in the matrix if it is present. Otherwise, print “Element not found”. Every row and column of the matrix is sorted in increasing order.
//x = 29

public static int[][] findInteger (){
		int x = 29;
		int [][] mat = {
				{10, 20, 30, 40},
				{15, 25, 35, 45},
				{27, 29, 37, 48},
				{32, 33, 39, 50}};
		for(int i=0; i < mat.length; i++ ){
			for(int j=0; j < mat.length; j++ ){
				if(mat[i][j] == x){
					System.out.println(i+" "+j);
					return new int[i][j];
				}
			}
		}
	System.out.println("Element Not Found");
	return null;

}






	public static void main(String[] args) {
		System.out.println(AnnotationDemoApp.getTotalNumberOfLettersOfNamesLongerThanFive("william", "jones", "aaron", "seppe", "frank", "gilliam"));


	}








}


