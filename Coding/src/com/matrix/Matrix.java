package com.matrix;

import java.util.Random;

public class Matrix {

	public void fillMatrix(int a[][]) {
		int x=1;
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)
				a[i][j] = x++;// r.nextInt(10);
		}
	}

	public void print(int a[][]) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	public int[][] addMat(int a[][], int b[][]) {
		int c[][] = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)
				c[i][j] = a[i][j] + b[i][j];
		}
		return c;
	}

	public int[][] subtractMat(int a[][], int b[][]) {
		int c[][] = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)
				c[i][j] = a[i][j] - b[i][j];
		}
		return c;
	}

	public boolean areSameMatrix(int a[][], int b[][]) {
		int c[][] = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)
				if (a[i][j] != b[i][j])
					return false;
		}
		return true;
	}

	public void multiplyMat(int a[][], int b[][]) {
		// int c[][] = new int[row][col];
	}

	public void spiral(int a[][]) {

		int m = a.length;
		int n = a[0].length;

		int i = 0, j = 0, k, l;

		while (i < m && j < n) {

			for (l = j; l < n; l++)
				System.out.print(a[i][l] + " , ");
			i++;
			for (k = i; k < m; k++)
				System.out.print(a[k][n-1] + " , ");
			n--;
		}
	}

	public void modifyMatrix(int a[][]) {

		int x[] = new int[a.length];
		int y[] = new int[a[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 1) {
					x[i] = 1;
					y[j] = 1;
				}
			}
		}
	}

	int max(int a, int b, int c) {
		int x = a;

		if (x < b)
			x = b;
		if (x < c)
			x = c;
		return x;
	}

	public void sumMatrix(int a[][]){
		
		int s[][]=new int[a.length][a[0].length];

		for(int i=0;i<a.length;i++)
			s[i][0]=a[i][0];
		
		for(int i=0;i<a.length;i++)
			s[0][i]=a[0][i];
		
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				s[i][j]=a[i][j];
			}
		}
		print(s);
	}
	
	public void test(){
		
		int a[][]=new int[4][];
		System.out.println("row length:-"+a.length+"    column length :"+ a[0].length);
	}
}
