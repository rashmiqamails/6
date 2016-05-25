package com.comcast.csvtest.question.six;

import java.util.Arrays;

public class MaximumYield {

	public int findMaximumYield(int[] squares) {
		
		int[] optimalSquares = findOptimalSquares(squares);
		
		int maximumYield = 0 ;
		
		int index = 0;
		for(int square : optimalSquares) {
			if(square == 1) {
				maximumYield = maximumYield + squares[index];
			}
			index++;
		}
		
		return maximumYield;
	}
	
	private int[] findOptimalSquares(int[] squares) {
		int optimalSquares[] = new int[squares.length];
		Arrays.fill(optimalSquares, 0);
		optimalSquares[0] = 1;
		int lastSelectedIndex = 0;
		
		for(int i = 1; i < squares.length; i++) {
			if(lastSelectedIndex == i-1) {
				if(squares[i] > squares[i-1]) {
					lastSelectedIndex = i;
					optimalSquares[i] = 1;
					optimalSquares[i-1] = 0;
					if(i != 1) {
						int toptimalSquares[] = findOptimalSquares(Arrays.copyOf(squares, i-1));
						for(int j = 1; j < toptimalSquares.length; j++) {
							optimalSquares[j] = toptimalSquares[j];
						}
					}
				}
			} else {
				lastSelectedIndex = i;
				optimalSquares[i] = 1;
			}
		}
		return optimalSquares;
	}

	
}
