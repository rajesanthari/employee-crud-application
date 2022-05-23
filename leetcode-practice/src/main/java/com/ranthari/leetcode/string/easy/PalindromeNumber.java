package com.ranthari.leetcode.string.easy;

/**
 * https://leetcode.com/problems/palindrome-number/
 * 
 * @author ranthari
 *
 */
public class PalindromeNumber {
	
	
	public enum Animals {
		DOC, CAT,LION
	}

	public static void main(String[] args) {
		//System.out.println(isPalindrome(123454321));
		Animals[] values = Animals.values();
		System.out.println(values[1]);
		System.out.println("Final output --> " + isPalindrome());
	}

	public static Object isPalindrome() {
		int result = 100;
		try {

			int x = 10 / 0;
			return x;
		} catch (ArithmeticException e) {

			return result;
		} finally {
			result = 120;
			System.out.println("Result in final " + result);
			return result;
		}
	}

	public static boolean isPalindrome(int x) {
		if (x < 0 || (x > 0 && x % 10 == 0)) {
			return false;
		}

		int sum = 0;
		while (x > sum) {
			sum = sum * 10 + x % 10;
			x /= 10;
		}

		return x == sum || x == sum / 10;
	}
}
