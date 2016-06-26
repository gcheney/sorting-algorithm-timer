package com.glendoncheney.sort;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class represents a generic abstract class for 
 * creating different types of sorting subclasses
 * @author Glendon Cheney
 *
 * @param <T> A type that extends Comparable
 */
public abstract class Sort<T extends Comparable<? super T>> {
	private String name;
	
	/**
	 * Creates a new Sort class with specified type name
	 * @param type The type of sort
	 */
	public Sort(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name of the sort type
	 * @return The name of the sort type
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sorts the array with the subclasses 
	 * specific sorting algorithm
	 * @param a The array to be sorted
	 */
	public abstract void sort(T[] a);
	
	/**
	 * Swaps two items in the array
	 * @param a The array the items are in 
	 * @param i The index of the first item
	 * @param j The index of the second item
	 */
	protected void swap(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * Test if the array is sorted
	 * @param a The array to test
	 * @return True if the array is sorted, 
	 * false otherwise
	 */
	protected boolean isSorted(T[] a) {
		for (int i = 0; i < a.length-1; i++) {
			if (a[i].compareTo(a[i+1]) > 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Prints out the array to a standard 
	 * text file for easier review of the results
	 * @param a The array to print out
	 */
	protected void print(T[] a) {
		try {
			FileWriter fw = new FileWriter(name + "Sort.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			for (int i = 0; i < a.length; i++) {
				pw.write(a[i] + " ");				
				if (i % 20 == 0) {
					pw.write("\n");
				}
			}
			
			pw.close();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
