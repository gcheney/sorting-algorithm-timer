package com.glendoncheney.sort;

/**
 * This class implements the Quicksort algorithm
 * @author Glendon Cheney
 */
public class QuickSort<T extends Comparable<? super T>> extends Sort<T> {
	
	public QuickSort() {
		super("Quick");
	}
		
	@Override
	public void sort(T[] a) {
		sort(a, 0, a.length - 1);
	}

	// quicksort the subarray from a[lo] to a[hi]
    private void sort(T [] a, int lo, int hi) { 
        if (hi <= lo) {
        	return;		//sort is finished
        }
        
        //get pivot
        int pivot = partition(a, lo, hi);
        
        //recursivly sort remaining array
        sort(a, lo, pivot-1);
        sort(a, pivot+1, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..h-1] <= a[h] <= a[h+1..hi]
    // and return the index j.
    private int partition(T[] a, int low, int high) {
        int l = low;
        int h = high + 1;
        T pivot = a[low]; //pivot item is first element
        
        while (true) { 
            // find item on low to swap
            while (a[++l].compareTo(pivot) < 0) {
                if (l == high) {
                	break;
                }
            }

            // find item on high to swap
            while (pivot.compareTo(a[--h]) < 0) {
                if (h == low) {
                	break;      
                }
            }

            // check if pointers cross
            if (l >= h) {
            	break;
            }

            //found items that need to be switched
            //swap elements
            super.swap(a, l, h);
        }

        // put partitioning item pivot at a[h]
        super.swap(a, low, h);

        // now, a[low .. h-1] <= a[h] <= a[h+1 .. high]
        return h; //mid index of partition
    }

}
