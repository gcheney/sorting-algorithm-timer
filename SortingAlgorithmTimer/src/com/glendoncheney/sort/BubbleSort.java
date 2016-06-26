package com.glendoncheney.sort;

/**
 * This class implements the Bubblesort algorithm
 * @author Glendon Cheney
 *
 * @param <T> The type to sort
 */
public class BubbleSort<T extends Comparable<? super T>> extends Sort<T> {
	
	public BubbleSort() {
		super("Bubble");
	}

	//optimized version of Bubble Sort
	@Override
	public void sort(T[] a) {
		boolean swapped;		
	    do {
	       swapped = false;
	       for (int i = 0; i < a.length-1; i++) {
	           if (a[i].compareTo(a[i+1]) > 0) {
	        	    super.swap(a, i, i+1);
	                swapped = true;
	            }
	        }
	    } while (swapped);
	}
	
	//Much less optimized version
	public void slowerSort(T[] a) {
		for (int i = a.length-1; i > 1; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j].compareTo(a[j+1]) > 0) {
					super.swap(a, j, j+1);
				}
			}
		}
	}
}
