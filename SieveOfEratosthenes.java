/**
 * File name:	SieveOfErotosthenes.java
 * Author: 		Karin Nielsen
 * Course: 		CS3345
 * Date: 		09/12/2020
 * Version:		1.0
 * Copyright:	2020, All Rights Reserved
 * Description: 
 * 				Prompts user for an integer via Scanner package and utilized the Sieve of Eratosthenes 
 * 				algorithm to identify each prime # up to to the user input.
 */

import java.util.Scanner;

public class SieveOfEratosthenes {

	public static void main(String[] args) {

		/* Prompt user for positive integer */ 	
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a positive integer greater than one: \n");
		
		int numInt = 0;
		double numDoub = 0.0;
		boolean isInt = false;
		isInt = scan.hasNextInt();
		
		/**
		 * Control for user input; print error message and gracefully exit program
		 * if user input doesn't fit an integer format or if the input is <= 1
		 */
		if (isInt) {
			
			numInt = scan.nextInt();
			
			if (numInt <= 1) {
				System.err.println("ERROR: User input must be greater than 1.\nExiting program.");
				System.exit(1);
			}
		} else if (!isInt) {
			
			numDoub = scan.nextDouble();
			System.err.println("ERROR: User input must be of the data type INTEGER.");
			
			if (numDoub <= 1.0) {
				System.err.println("ERROR: User input must be greater than 1.\nExiting program.");
				System.exit(1);
			}
			System.exit(1);
		} else { /* should be unreachable */
			System.err.println("ERROR: Undefined issue with user input. \nExiting program");
			System.exit(1);
		}
		
		/** 
		 * Assuming user input meets requirements, run remainder of algorithm.
		 * Create array of input size & set indices to true except 0 & 1.
		 * Find square root of input # & set non-prime numbers in array to false.
		 * */
		boolean[] bool = new boolean[numInt+1];
		for (int i=0; i<=numInt; i++) {
			bool[i] = true;
		}

		bool[0] = bool[1] = false;

		int n = (int) Math.ceil(Math.sqrt(numInt));
		System.out.println("\nList of prime numbers up to " + numInt + " is: ");
		for (int i = 2 ; i <= n ; i++) {
			if (bool[i]) {
				for (int j = i*i , k=1 ; j <= numInt ; j = (i*i+k*i) , k++) {	
					bool[j]=false;
				}
			}
		}

		scan.close();

		/* Print every index set to "true", aka the prime #s */
		for (int i=2 ; i < bool.length ; i++) {
			if (bool[i]==true) {
				System.out.println(i);
			}
		}
	}
}