package com.glendoncheney.sort;

/**
 * This class implements the Shellsort algorithm
 * @author glen
 *
 * @param <T>
 */
public class ShellSort<T extends Comparable<? super T>> extends Sort<T> {

	public ShellSort() {
		super("Shell");
	}

	@Override
	public void sort(T[] a) {
		int j, i;
        T temp;
        int len = a.length;
        
        //find initial value of h - the interval
        int h = 1;
        while (h <= len / 3) {
          h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)
        }

        while (h > 0) // decreasing h, until h=1, then is insertion sort
        {
          for (i = h; i < len; i++) {
            temp = a[i];
            j = i;
            
            // one subpass (eg 0, 4, 8)
            while (j > h - 1 && a[j - h].compareTo(temp) >= 0) {
              a[j] = a[j - h];
              j -= h;
            }
            
            a[j] = temp;
          }
          
          h = (h - 1) / 3; // decrease h
        }
	}

}
