package com.glendoncheney.sort;

/**
 * This class implements the Heapsort algorithm
 * @author Glendon Cheney
 */
public class HeapSort<T extends Comparable<? super T>> extends Sort<T> {
	
	public HeapSort() {
		super("Heap");
	}

	@Override
	public void sort(T[] a) {
        int len = a.length;
        for (int k = len/2; k >= 1; k--) {
            sink(a, k, len);
        }
        while (len > 1) {
            swap(a, 1, len--);
            sink(a, 1, len);
        }
    }

   /***********************************************************************
    * Helper functions to restore the heap invariant.
    **********************************************************************/

    private void sink(T[] a, int parent, int size) {
        while (2*parent <= size) {
            int leftChild = 2*parent;
            if (leftChild < size && less(a, leftChild, leftChild+1)){
            	leftChild++;
            }
            if (!less(a, parent, leftChild)) {
            	break;
            }
            swap(a, parent, leftChild);
            parent = leftChild;
        }
    }

   /***********************************************************************
    * Helper functions for comparisons and swaps.
    * Indices are "off-by-one" to support 1-based indexing.
    **********************************************************************/
    private boolean less(T[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    @Override
    protected void swap(T[] pq, int i, int j) {
        T swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

}
