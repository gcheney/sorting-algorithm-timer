package com.glendoncheney.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * This class allows the user to test various sorting algorithms 
 * speed using user chosen sizes of integer arrays
 * 
 * @author Glendon Cheney
 *
 */
public class SortingAlgorithmTimer {

	/**
	 * The main entry point for the application
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		while (true) {
			System.out.println("Enter one of the following choices of"
					+ " sorts to perform on the random array.\n"
					+ "The sorted final array will be printed to"
					+ " a text file if sorting is successful.\n"
					+ "Please select from the following list:\n"
					+ "1 - Bubble Sort\n"
					+ "2 - Selection Sort\n"
					+ "3 - Insertion Sort\n"
					+ "4 - Shell Sort\n"
					+ "5 - Merge Sort\n"
					+ "6 - Quick Sort\n"
					+ "7 - Heap Sort\n"
					+ "Select 0 or Any other key to quit.");
			
			System.out.print("Your Choice: ");
			char choice = keyboard.next().charAt(0);
			
			if (!Character.isDigit(choice) 
					|| choice == '0' 
					|| choice == '8'
					|| choice == '9') 
			{
				break;
			}
			
			System.out.print("Choose a size for the array (integer): ");
			int size = keyboard.nextInt();
			
			System.out.print("Choose the largest number for the array (integer): ");
			int range = keyboard.nextInt();
			
			//create random array
			Integer [] array = generateRandomArray(size, range);	
			
			//Get the sorting algorithm
			Sort<Integer> sortAlgo = SortingFactory.getSortAlgo(choice);
			
			double time = timeSort(sortAlgo, array);		
			System.out.println("Checking if array is sorted...");
			
			if (sortAlgo.isSorted(array)) {
				System.out.printf("%ssort was successful! It took %f seconds.\n", 
						sortAlgo.getName(), time);
				
				System.out.println("Printing sorted output to a text file.");
				sortAlgo.print(array);
				System.out.println("Done.");
			}
			else {
				System.out.println("An error occured, please try again.");
			}
			
			System.out.print("Would you like to go again? (y/n):");
			choice = keyboard.next().charAt(0);
			
			if (choice == 'n') {
				break;
			}
		}	 
		
		System.out.println("Exiting program.");
		keyboard.close();
		System.exit(0);
	}
	
	/**
	 * This generic method accepts a Sort object and performs 
	 * a basic time test to determine how long it takes to sort an array of
	 * random Integers
	 * @param sortAlgo The type of sorting algorithm
	 * @param arr The array to sort
	 */
	private static <T extends Comparable<T>> double timeSort(Sort<T> sortAlgo, T [] arr) {				
		System.out.printf("Sorting array of size %d using %ssort...\n", 
				arr.length, sortAlgo.getName());
		
		SortTimer time = new SortTimer();
		time.start();
		sortAlgo.sort(arr);
		double totalTime = time.getElapsedTime();
		System.out.println("Done.");
		
		return totalTime;
	}

	/**
	 * This method creates and returns an array of distinct integers
	 * within the size and range constraints. The size may be less than specified
	 * as duplicates are not allowed.
	 * @param size The size of the array
	 * @param range The range of random integers
	 * @return An array of unique random integers
	 */
	private static Integer[] generateRandomArray(int size, int range) {
		System.out.printf("Generating a random array of size %d...\n", size);
		Random random = new Random();
		Integer [] arr = new Integer[size];
		
		for (int i = 0; i < size; i++) {
			arr[i] = random.nextInt(range);
		}
		
		arr = removeDups(arr);
		arr = shuffleArray(arr);		
		return arr;
	}
	
	/**
	 * Removes duplicates from the provided array
	 * @param arr The array to remove duplicates from
	 * @return The array with duplicates removed
	 */
	private static Integer[] removeDups(Integer[] arr) {
		System.out.println("Removing duplicates from the array...");
		Set<Integer> arraySet = new HashSet<Integer>(Arrays.asList(arr));
		return arraySet.toArray(new Integer[0]);
	}
	
	/**
	 * Shuffles the provided array into a random order
	 * @param arr The array to shuffle
	 */
	private static Integer[] shuffleArray(Integer[] arr) {
		System.out.println("Shuffling array...");
		
	    Random rand = new Random();	    
	    for (int i = arr.length - 1; i > 0; i--) {
		  int randIndex = rand.nextInt(i + 1);
		  
		  //perform a simple swap
		  int temp = arr[randIndex];
		  arr[randIndex] = arr[i];
	      arr[i] = temp;
	    }		    
	    
	    return arr;
	}	

}
