package com.bitmagic;

public class Bitmagic {

	public int isPowerOfTwo(int n) {

		int count = 0;

		if (n > 0 && (n & (n - 1)) == 0)
			return n;

		while (n > 0) {
			n >>= 1;
			count++;
		}
		return 1 << count;
	}

	public int isDivisibleBy3(int n) {

		int odd = 0;
		int even = 0;

		while (n != 0) {

			if ((n & 1) == 1)
				even++;

			n >>= 1;

			if ((n & 1) == 1)
				odd++;

			n >>= 1;
		}

		return Math.abs(even - odd);
	}

	public boolean getParity(int n) {
		boolean parity = false;

		while (n > 0) {
			parity = !parity;
			n = n & (n - 1);
		}
		return parity;
	}

	public double getFirstSetBit(int n) {

		return Math.log1p(n);
	}

	public double getLog2(int n) {

		return (Math.log(n)/Math.log(2));
	}
}
