package com.glendoncheney.sort;

/**
 * Small Time keeping class for measuring how long 
 * a process takes (in seconds)
 * @author Glendon Cheney
 *
 */
public class SortTimer { 

    private long start;
    
    /**
     * Starts the timer
     */
    public void start() {
    	start = System.currentTimeMillis();
    }
	
	/**
     * Returns the elapsed time (in seconds) 
     * since this object was created.
     */
    public double getElapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

} 
