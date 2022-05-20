package com.ranthari.leetcode.arrays.easy;

public class MergeSortedArray {

	public static void main(String[] args) {

		int[] nums1 = new int[] { 1, 5, 6 , 0, 0, 0 };
		int[] nums2 = new int[] { 2, 2, 3 };
		int m = 3;
		int n = 2;

	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
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

	}
}
