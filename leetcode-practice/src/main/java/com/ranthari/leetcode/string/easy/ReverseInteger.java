package com.ranthari.leetcode.string.easy;

/**
 * https://leetcode.com/problems/reverse-integer/
 * 
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-231, 231 - 1], then return 0.
 * 
 * Assume the environment does not allow you to store 64-bit integers (signed or
 * unsigned).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: x = 123 Output: 321 Example 2:
 * 
 * Input: x = -123 Output: -321 Example 3:
 * 
 * Input: x = 120 Output: 21
 * 
 * 
 * Constraints:
 * 
 * -231 <= x <= 231 - 1
 * 
 * @author ranthari
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		int reverse = reverse(-1563847412);
		System.out.println(reverse);
	}

	public static int reverse(int num) {
		long sum = 0;
		while (num != 0) {
			sum = sum * 10 + (num % 10);
			num /= 10;
		}
		return sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE ? 0 : (int) sum;
	}

	public static int reverseMySolution(int x) {
		int num = x;
		if (num < 0) {
			num = num * -1;
		}
		long sum = 0;
		while (num > 0) {
			sum = sum * 10 + (num % 10);
			num /= 10;
		}

		if (x < 0) {
			sum *= -1;
			if (sum < Integer.MIN_VALUE) {
				return 0;
			}
		} else if (sum > Integer.MAX_VALUE) {
			return 0;
		}

		return (int) sum;
	}

}
