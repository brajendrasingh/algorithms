package com.sugya;

import com.sugya.stream.JavaObjectStream;
import com.sugya.stream.JavaStringStream;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("---------------------------------------------------");
        //int x = (Integer) null; //NullPointerException
//        new JavaNumericStream().updateArray();
//        new JavaStringStream().capitalizeFirstLetter();
        new JavaObjectStream().sortingByNameAndCity();
        System.out.println("---------------------------------------------------");
    }

    public static void bits() {
        System.out.println("********************************Bits************************************");
        com.sugya.bitmagic.Bitmagic bit = new com.sugya.bitmagic.Bitmagic();
        Random r = new Random();
        int a = r.nextInt(30);
        int b = r.nextInt(10);

        System.out.println("Next 2's Power of " + a + " is :  " + bit.isPowerOfTwo(a));

        if (bit.isDivisibleBy3(a) % 3 == 0)
            System.out.println(a + " is Divisible by 3 ");
        else
            System.out.println(a + " is not Divisible by 3 ");

        if (bit.getParity(a))
            System.out.println(a + " has odd parity");
        else
            System.out.println(a + " has even parity");

        System.out.println("Log(" + a + ") is  " + bit.getFirstSetBit(a));
        System.out.println("Log2(" + a + ") is  " + bit.getLog2(a));

    }

    public static void array() {
        System.out.println("*********************************Arrays***********************************");
        Random r = new Random();
        int x = r.nextInt(30);
        int y = r.nextInt(10);

        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = r.nextInt(50);

        com.sugya.array.Array a = new com.sugya.array.Array();
        /*
         * System.out.println(Arrays.toString(arr)+" Sum of array's elements  "+a
         * .sumOfArray(arr));
         * System.out.println("Greatest No. "+Arrays.toString(
         * arr)+" is  "+a.getLargest(arr)); //System.out.print("Pair is : ");
         * a.getPair(arr,50); System.out.println("Odd Occurrence is :"+
         * a.getOddOccurrence(new int[] { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2,4, 4, 2
         * }));
         */
        System.out.println("==========>" + Arrays.toString(arr));
        a.reverseArray(arr);
        System.out.println("Reversed==>" + Arrays.toString(arr));
    }

    public static void pattern() {
        System.out
                .println("******************************Pattern**************************************");
        com.sugya.pattern.Pattern p = new com.sugya.pattern.Pattern();
        p.printStar(5);
        p.printTriangle(5);
    }

    public static void string() {
        System.out.println("**********************String***************************");
        com.sugya.string.StringCode s = new com.sugya.string.StringCode();
        String[] names = new String[]{"Tree", "Apple", "Van", "Cat"};
        /*
         * // System.out.println("Names are  " + Arrays.asList(names)); //
         * s.sortNames(names);
         * System.out.println("Sorted Names are  " + Arrays.toString(names));
         */
/*		String x=null;
		int a=10;
		while(a-->0){
		x=new Scanner(System.in).next();

		System.out.println("Palindrom: "+ s.isPalindrome(x));
		}
*/		/*String a="abcd";String b="wxyz";
		System.out.println("A: "+a+"   B: "+b);
		s.swapString(a, b);
		System.out.println("A: "+a+"   B: "+b);

		System.out.println("Max Occurring Character: "+s.maxOccuringChar("CCCBBAD"));
		*/
        //s.swapString();
        //System.out.println("Are Rotation: "+s.areRotation("test","estt"));
        String x = null;
        int a = 10;
        while (a-- > 0) {
            x = new Scanner(System.in).next();
            System.out.println("==> " + s.reverseVowels(x));
        }
    }

    public static void matrix() {

        com.sugya.matrix.Matrix m = new com.sugya.matrix.Matrix();
        Scanner sc = new Scanner(System.in);
        int a[][];
        int b[][];
        int row = 3;
        int col = 3;
        a = new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        b = new int[row][col];

        // m.fillMatrix(a);
        // m.fillMatrix(b);

        // System.out.println("Arrays are:");
        // m.print(a);
        /*
         * m.print(b); int c[][]=m.addMat(a, b); m.print(c);
         * c=m.subtractMat(a,b); m.print(c);
         *
         * if(m.areSameMatrix(a,b)) System.out.println("Both matrix are same");
         * else System.out.println("Matrix are Not Same");
         */
        // m.spiral(a);
        // m.sumMatrix(a);
        m.test();
        sc.close();
    }

    public static void thread() {
        com.sugya.thread.Threads th = new com.sugya.thread.Threads();
        Thread t = new Thread(th);
        t.start();
        System.out.println("===============");
        t.run();
    }

}
