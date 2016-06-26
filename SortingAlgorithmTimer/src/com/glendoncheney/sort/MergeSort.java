package com.glendoncheney.sort;

/**
 * This class implements the Mergesort algorithm
 * @author Glendon Cheney
 */
public class MergeSort<E extends Comparable<? super E>> extends Sort<E> {
	private E [] tempArray;
	
	public MergeSort() {
		super("Merge");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sort(E [] a) {
        int len = a.length;
        tempArray = (E[]) new Comparable[len];
        mergeSort(a, 0, len - 1);
    }
 
    private void mergeSort(E[] a, int low, int high) {  
        if (low < high) {
        	//Find the middle
            int middle = low + (high - low) / 2;
            
            // Sort the left side of the array
            mergeSort(a, low, middle);
            
            // Sort the right side of the array
            mergeSort(a, middle + 1, high);
            
            // Now merge both sides
            merge(a, low, middle, high);
        }
    }
 
    private void merge(E[] a, int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempArray[i] = a[i];
        }
        
        //Assign positions
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        
        while (i <= middle && j <= higherIndex) {
            if (tempArray[i].compareTo(tempArray[j]) <= 0) {
                a[k++] = tempArray[i++];
            } 
            else {
                a[k++] = tempArray[j++];
            }
        }       
        while (i <= middle) {
            a[k++] = tempArray[i++];
        }
    }
}
