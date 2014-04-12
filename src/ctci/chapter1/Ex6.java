package chapter1;

import utils.Matrix;


// Given an image represented by an NxN matrix, where each pixel in the image is 4 
// bytes, write a method to rotate the image by 90 degrees Can you do this in place?
public class Ex6 {
	public static void main(String[] args) throws Exception {
		Matrix matrix = Matrix.getRandomIntMatrix(5, 5);
//		System.out.println(matrix.toString());
//		System.out.println(matrix.rotateLeft().rotateLeft().rotateLeft().rotateLeft().toString());
		System.out.println(matrix);
		System.out.println(matrix.rotateRightInPlace());
	}
}
