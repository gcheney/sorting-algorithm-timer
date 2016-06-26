package com.glendoncheney.sort;

/**
 * This class implements the Insertionsort algorithm
 * @author Glendon Cheney
 */
public class InsertionSort<T extends Comparable<? super T>> extends Sort<T> {

	public InsertionSort() {
		super("Insertion");
	}
	
	/*
	 * Avoids constant swapping, just reassigns every item
	 * up one position until insertion point is found
	 */
	@Override
	public void sort(T[] a) {		
		for (int i = 1; i < a.length; i++) {
			T toInsert = a[i];
			int j = i;			
			
			while (j > 0 && a[j-1].compareTo(toInsert) > 0) {
				a[j] = a[j-1];
				j--;
			}
			
			a[j] = toInsert;
		}		
	}
	
	//Somewhat slower version with constant swapping
	public void slowerSort(T[] a) {		
		for (int i = 1; i < a.length; i++) {		
			int j = i;			
			while (j > 0 && a[j-1].compareTo(a[j]) > 0) {
				swap(a, j, j-1);
				j--;
			}
		}
	}
}
