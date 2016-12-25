package com.pattern;

public class Pattern {

	public void printStar(int n) {

		int i, j, k, l;
		for (i = 0; i < n; i++) {

			for (j = 0; j <= i; j++)
				System.out.print("*");

			System.out.println();
		}
	}

	public void printTriangle(int n) {

		int i, j, k, l;
		for (i = 0; i < n; i++) {

			for (j = 0; j < n-i; j++)
				System.out.print(" ");

			for (k = 0; k <= 2*i; k++)
				System.out.print("*");


			System.out.println();
		}
		for ( i = 1; i < n; i++) {

			for (l = 0; l <= i; l++)
				System.out.print(" ");

			for (int m = 0; m < 2*n-i-1; m++)
				System.out.print("*");

			System.out.println();
		}

	}

}
