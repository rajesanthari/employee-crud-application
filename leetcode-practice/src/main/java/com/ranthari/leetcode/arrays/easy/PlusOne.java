package com.ranthari.leetcode.arrays.easy;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/plus-one/
 * 
 * You are given a large integer represented as an integer array digits, where
 * each digits[i] is the ith digit of the integer. The digits are ordered from
 * most significant to least significant in left-to-right order. The large
 * integer does not contain any leading 0's. Increment the large integer by one
 * and return the resulting array of digits.
 * 
 * 
 * @author ranthari
 *
 */
public class PlusOne {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int[] mod = plusOne(arr);
		System.out.println(Arrays.toString(mod));
		arr = new int[] { 9, 9, 9 };
		mod = plusOne(arr);
		System.out.println(Arrays.toString(mod));

	}

	public static int[] plusOne(int[] digits) {
		int car = 1;

		for (int k = digits.length - 1; k >= 0; k--) {
			int sum = digits[k] + car;
			car = 0;
			if (sum > 9) {
				car = 1;
				sum = sum % 10;
			}
			digits[k] = sum;
		}

		return addCar(digits, car);
	}

	public static int[] addCar(int[] digits, int car) {

		if (car == 1) {

			int[] newArr = new int[digits.length + 1];
			newArr[0] = car;
			int counter = 1;
			for (int num : digits) {
				newArr[counter++] = num;
			}
			digits = newArr;
		}
		return digits;
	}
}
