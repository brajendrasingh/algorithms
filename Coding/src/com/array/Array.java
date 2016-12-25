package com.array;

import java.util.Arrays;


public class Array {

	public int sumOfArray(int[] a) {
		int sum = 0;

		for (int i : a)
			sum += i;

	 return sum;
	}
	
	public int  getLargest(int[] a ){
		int max=a[0];
		
		for(int i:a){
			if(i>max)
				max=i;
		}
	
		return max;
	}
	public void getPair(int a[],int x){
	
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
				if(a[i]+a[j]==x)
					System.out.println(a[i]+"  "+a[j]);
			}
		}
	}
	
	public int getOddOccurrence(int a[]) {
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		int res = 0;

		for (int i : a)
			res ^= i;
		
		return res;
	}
	
	public int maxOf(int a, int b) {
		return a > b ? a : b;
	}

	public int maxSubArraySum(int[] a) {

		int curr_max = a[0];
		int max_so_far = a[0];

		for (int i = 1; i < a.length; i++) {
			curr_max = maxOf(a[i], curr_max + a[i]);
			max_so_far = maxOf(curr_max, max_so_far);
		}
		
	return max_so_far;
	}
	
	public void reverseArray(int a[]) {

		int l = 0;
		int r = a.length - 1;
		int tmp;
		while (l < r) {
			tmp = a[l];
			a[l] = a[r];
			a[r] = tmp;
			l++;
			r--;
		}
	}
}
