package chapter1;

import utils.Matrix;

// Write an algorithm such that if an element in an MxN matrix is 0, its entire row and 
// column is set to 0

public class Ex7 {
	public static void main(String[] args) throws Exception {
		int[][] matrix = {{1,0,1},{1,1,1},{0,1,1}};
		Matrix m = new Matrix(matrix);
		System.out.println(m);
		setZerosInPlace(m.getMatrix());
		System.out.println(m);
	}
	
	public static void setZeros(int[][] matrix) {
	}
	
	public static void setZerosInPlace(int[][] matrix) {
		if (matrix == null) return;
		int nRows = matrix.length;
		if (nRows == 0) return;
		int nCols = matrix[0].length;
		
		boolean nextZero = false;
		boolean thisZero = false;
		for (int i = 0; i < nRows; i++) { 
			// check if next line has zero
			if (i < nRows - 1) { 
				for (int n : matrix[i + 1]) {
					if (n == 0) {
						nextZero = true;
					}
				}
			}

			if (i != 0 && !thisZero) continue;

			for (int j = 0; j < nCols; j++) { 
				if (matrix[i][j] == 0) {
					thisZero = true;
					if (!nextZero && i < nRows - 1) {
						matrix[i + 1][j] = 0;
					}
				}
			}
			if (thisZero) {
				for (int j = 0; j < nCols; j++) { 
					matrix[i][j] = 0;
				}
			}
			thisZero = nextZero;
			nextZero = false;
		}
	}
}
