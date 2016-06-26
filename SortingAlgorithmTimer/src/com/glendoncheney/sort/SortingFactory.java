package com.glendoncheney.sort;

/**
 * @author Glendon Cheney
 *
 */
public class SortingFactory {
	
	//private constructor so class cannot be instantiated
	private SortingFactory(){ }
	
	/**
	 * Provides the appropriate Sort subclass based on the provider choice
	 * @param choice The character entered
	 * @return The sorting algorithm class
	 */
	public static <T extends Comparable<? super T>> Sort <T> getSortAlgo(char choice) {
		Sort<T> sortAlgo = null;
		
		switch(choice) {
			case '1':
				sortAlgo = new BubbleSort<T>();
				break;
			case '2':
				sortAlgo = new SelectionSort<T>();
				break;
			case '3':
				sortAlgo = new InsertionSort<T>();
				break;
			case '4':
				sortAlgo = new ShellSort<T>();
				break;
			case '5':
				sortAlgo = new MergeSort<T>();
				break;
			case '6':
				sortAlgo = new QuickSort<T>();	
				break;
			case '7':
				sortAlgo = new HeapSort<T>();;	
				break;
			default:
				sortAlgo = null; 
				break;
		}
		
		return sortAlgo;
	}

}
