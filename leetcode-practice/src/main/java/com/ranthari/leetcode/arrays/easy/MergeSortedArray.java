package com.ranthari.leetcode.arrays.easy;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {

		int[] nums1 = new int[] { 0 };
		int[] nums2 = new int[] { 6 };
		int m = 0;
		int n = 1;
		merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int numLength = nums1.length - 1;
		// Compare last elements of array and push to last index of num1
		while (i >= 0 && j >= 0) {
			if (nums1[i] >= nums2[j]) {
				nums1[numLength] = nums1[i--];
			} else {
				nums1[numLength] = nums2[j--];
			}
			numLength--;
		}
		
		while ( j > i && numLength >= 0) {
			nums1[numLength--] = nums2[j--];
		}

	}

	public static void mergeMine(int[] nums1, int m, int[] nums2, int n) {
		if (n == 0) {
			return;
		}
		int oneIndex = 0;
		int twoIndex = 0;
		while (oneIndex < m) {
			if (nums1[oneIndex] <= nums2[0]) {
				oneIndex++;
				continue;
			}
			if (nums1[oneIndex] > nums2[0]) {
				int temp = nums1[oneIndex];
				nums1[oneIndex] = nums2[0];
				nums2[twoIndex] = temp;
				oneIndex++;
				continue;
			}
		}

		for (int i = 0; i < n; i++) {
			nums1[m + i] = nums2[i];
		}

	}
}
