package utils;

import java.util.Random;

public class Matrix {
	private int[][] matrix = null;
	private int num_rows = 0;
	private int num_cols = 0;

	public Matrix() {}
	public Matrix(int[][] matrix) {
		this.matrix = matrix;
		this.num_rows = matrix.length;
		this.num_cols = matrix[0].length;
	}
	
	public int[][] getMatrix() {
		return matrix;
	}

	public static Matrix getRandomIntMatrix(int row, int col) {
		Random rand = new Random();
		int[][] matrix = new int[row][col];
		for (int i = 0; i < row; i++) {
			int[] r = matrix[i];
			for (int j = 0; j < col; j++) {
				r[j] = rand.nextInt();
			}
		}
		Matrix m = new Matrix();
		m.matrix = matrix;
		m.num_cols = col;
		m.num_rows = row;
		return m;
	}
	
	public Matrix rotateRightInPlace() throws Exception {
		int[][] m = this.matrix;
		if (m == null) return this;
		if (this.num_cols != this.num_rows)
			throw new Exception("Must be a square matrix!");

		int mid = m.length / 2;
		for (int i = 0; i < mid; i++) {
			int last = m.length - i - 1;
			for (int j = i; j < last; j++) {
				int offset = j - i;
				int top = m[i][j];
				m[i][j] = m[last - offset][i]; // left to top
				m[last - offset][i] = m[last][last - offset]; // bottom to left 
				m[last][last - offset] = m[j][last]; // right to bottom
				m[j][last] = top; // top to right
			}
		}
		return this;
	}
	
	public Matrix rotateRight() {
		if (this.matrix == null) return this;
		int[][] new_matrix = new int[this.num_cols][this.num_rows];
		for (int i = 0; i < this.num_rows; i++) {
			int[] row = this.matrix[i];
			for (int j = 0; j < this.num_cols; j++) {
				new_matrix[j][this.num_rows - i - 1] = row[j];
			}
		}
		this.matrix = new_matrix;
		this.num_cols = this.num_rows;
		this.num_rows = new_matrix.length;
		return this;
	}
	
	public Matrix rotateLeft() {
		if (this.matrix == null) return this;
		int[][] new_matrix = new int[this.num_cols][this.num_rows];
		for (int i = 0; i < this.num_rows; i++) {
			int[] row = this.matrix[i];
			for (int j = 0; j < this.num_cols; j++) {
				new_matrix[this.num_cols - j - 1][i] = row[j];
			}
		}
		this.matrix = new_matrix;
		this.num_cols = this.num_rows;
		this.num_rows = new_matrix.length;
		return this;
	}

	public String toString() {
		int[][] m = this.matrix;
		if (m == null) return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.num_rows; i++) {
			int[] row = m[i];
			for (int j = 0; j < this.num_cols; j++) {
				sb.append(row[j]);
				if (j != this.num_cols - 1) {
					sb.append(' ');
				}
			}
			sb.append('\n');
		}
		return sb.toString();
	}
}
