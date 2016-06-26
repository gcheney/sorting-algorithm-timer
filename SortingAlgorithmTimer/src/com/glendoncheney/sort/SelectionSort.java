package com.glendoncheney.sort;

/**
 * This class implements the Selectionsort algorithm
 * @author glen
 *
 * @param <T>
 */
public class SelectionSort<T extends Comparable<? super T>> extends Sort<T> {

	public SelectionSort() {
		super("Selection");
	}

	@Override
	public void sort(T[] a) {
		int len = a.length;
		
		for (int i = 0; i < len-1; i++) {				
			int minIndex = i;	
			
			for (int j = i+1; j < len; j++) {
				if (a[j].compareTo(a[minIndex]) < 0) {
					minIndex = j;
				}
			}
			
			if (minIndex != i) {
				super.swap(a, i, minIndex);
			}
		}

	}

}
