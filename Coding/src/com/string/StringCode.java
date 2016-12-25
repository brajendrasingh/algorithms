package com.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringCode {

	String x = "a for apple";
	String y = "b for ball";
	String t;

	public String reverseString(String str) {
		return "str";
	}

	public void sortNames(String[] names) {
		Arrays.sort(names);
	}

	public boolean isPalindrome(String str) {

		// char[] s = str.toCharArray();

		int l = 0, r = str.length() - 1;

		while (l < r) {
			if (str.charAt(l++) != str.charAt(r--))
				return false;
		}
		return true;
	}

	// It's not possible in java
	public void swapString(String a, String b) {
		String temp;
		temp = a;
		a = b;
		b = temp;
	}

	public void swapString() {
		System.out.println("A: " + x + "   B: " + y);
		t = x;
		x = y;
		y = t;
		System.out.println("A: " + x + "   B: " + y);
	}

	public char maxOccuringChar(String str) {

		Map<Integer, Character> m = new HashMap<Integer, Character>();
		m.put(1, str.charAt(0));

		return 'a';
	}

	public boolean areRotation(String a, String b) {

		StringBuilder sb = new StringBuilder(a).append(a);
		System.out.println(sb);

		return (sb.indexOf(b) != -1);
	}

	public String reverseVowels(String s) {
		List<Character> v = new ArrayList<Character>();
		v.add('a');
		v.add('A');
		v.add('e');
		v.add('E');
		v.add('i');
		v.add('I');
		v.add('o');
		v.add('O');
		v.add('u');
		v.add('U');

		char a[] = s.toLowerCase().toCharArray();

		int l = 0, r = a.length - 1;
		char t = 0;

		while (l < r) {
			if (v.contains(a[l]))
				t = a[l];
			else
				l++;
			if (v.contains(a[r])) {
				a[l] = a[r];
				a[r] = t;
			} else
				r--;
		}
		return new String(a);
	}
	boolean isValid(String a) 
	{
	   char[] s=a.toCharArray();
	   char []str=new char[a.length()];
	   int top=0;
	   for(int i=0;i<s.length;i++)
	   {
	        switch(s[i])
	        {
	            case '(': case '{':case '[':
	              str[top++]=s[i];
	              break;
	              
	            case ')':if(str[top-1]=='(')
	                       top--;
	                      else
	                         return false;
	               break;
	            case '}':if(str[top-1]=='{')
	                       top--;
	                      else
	                         return false;
	               break;
	            case ']':if(str[top-1]=='[')
	                       top--;
	                      else
	                         return false;
	               break;
	        }
	   }
	 return top==0;
	}
	
	public String frequencySort(String s) {
		
		if (s == null || s.length() == 0)
			return "";
		int[][] map = new int[256][2];
		for (int i = 0; i < 256; ++i) {
			map[i][0] = i;
		}
		
		for (char c : s.toCharArray()) {
			map[c][1] += 1;
		}
		
		Arrays.sort(map, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg1[1] - arg0[1];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 256; ++i) {
			for (int j = 0; j < map[i][1]; ++j) {
				sb.append((char) map[i][0]);
			}
		}
		return sb.toString();
	}
}
