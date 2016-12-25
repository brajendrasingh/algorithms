package com.testcase;

import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class TestCase {

	public static int gcd(int c, int b) {
		if (b == 0) {
			return c;
		} else {
			return gcd(b, c % b);
		}
	}

	public static void lifeUniverse() {

		int n;
		s = new Scanner(System.in);
		while (true) {
			n = s.nextInt();
			if (n == 42)
				break;
			System.out.println(n);
		}
	}

	public static void freq(String s) {

		Map<Character, Integer> m = new HashMap<Character, Integer>();
		char[] a = s.toCharArray();

		for (int i = 0; i < a.length; i++) {
			if (m.containsKey(a[i]))
				m.put(a[i], m.get(a[i]) + 1);
			else
				m.put(a[i], 1);
		}

		// for(Map.Entry<Character, Integer> entry: m)
		System.out.println("==>" + m);
	}

	public static void freq2(String s) {

		int count[] = new int[256];
		char[] a = s.toCharArray();
		for (int i = 0; i < a.length; i++) {
			count[a[i]]++;
		}
		System.out.println("a: " + count['a'] + " \nb: " + count['b']
				+ " \nc: " + count['c'] + " \nd: " + count['d'] + " \ne: "
				+ count['e'] + " \nf: " + count['f']);
	}

	public static void writeToFile() {
		try {
			PrintStream o = new PrintStream(new File("test.text"));
			System.setOut(o);
			System.out.println("This is going to a file");
			System.out.println("This is going to a file");
			System.out.println("This is going to a file");

		} catch (Exception e) {
		}
	}

	public static void toggle() {
		String s = "zZ";
		char a[] = s.toCharArray();
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= 65 && a[i] <= 90)
				a[i] = (char) (a[i] + 32);
			else if (a[i] >= 97 && a[i] <= 121)
				a[i] = (char) (a[i] - 32);
		}

		System.out.println((int) 'z' + "==>" + new String(a));
	}

	public static boolean fun(String str) {

		int l = 0, r = str.length() - 1;
		while (l < r) {
			if (str.charAt(l++) != str.charAt(r--)) {
				return false;
			}
		}
		return true;
	}

	public static void mainMax(){

	}
	public static void war(String s){
		char[] a=s.toCharArray();

		if(a[0]=='B')
			a[1]='X';
		if(a[0]=='B')
			a[1]='X';
		if(a[0]=='B')
			a[1]='X';
		if(a[0]=='B')
			a[1]='X';

		for(int i=2;i<a.length-2;i++){
			if(a[i]=='B' && a[i]!='X')
				a[i-1]=a[i-2]=a[i+1]=a[i+2]='X';
		}
	}
	private static Scanner s;
	
	public static void main(String[] args) throws Exception {

		s = new Scanner(System.in);
		System.out.println("Enter no of testcase");
		byte t = s.nextByte();
		System.out.println("Enter ");
		while (t-- > 0) {
			int x=0,y=0;
			String str=s.next();
			for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='L')
				x--;
			if(str.charAt(i)=='R')
				x++;
			if(str.charAt(i)=='D')
				y--;
			if(str.charAt(i)=='U')
				y++;
				}
			System.out.println(x+"  "+y);
		}
		Hashtable m=new Hashtable();
		m.put(null, "");
	}
}

class TestCase1 extends TestCase {
}