package com.ranthari.app;

import java.util.Arrays;

public class LeetCode {

	public static void removeElementMain(String[] args) {
		int[] nums = { 1 };
		int size = removeElement(nums, 1);
		System.out.println(Arrays.toString(nums));
		System.out.println(size);
	}

	public static int removeElement(int[] nums, int val) {
		int length = nums.length;
		for (int k = 0; k < length; k++) {
			if (nums[k] == val) {
				while (k < length) {
					if (nums[length - 1] != val) {
						int temp = nums[k];
						nums[k] = nums[length - 1];
						nums[length - 1] = temp;
						length--;
						break;
					} else {
						length--;
					}
				}
			}
		}
		return length;
	}

	public static void searchInsertMain(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums, 5));
		System.out.println(searchInsert(nums, 2));
		System.out.println(searchInsert(nums, 7));

	}

	public static int searchInsert(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;

		boolean found = false;

		int mid = -1;
		while (l <= r) {
			mid = l + (r - l) / 2;
			int midVal = nums[mid];
			if (midVal == target) {
				found = true;
				break;
			} else if (midVal < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		if (!found) {
			if (nums[mid] < target) {
				mid++;
			}
		}

		return mid;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 0, 0, 0, 1 };
		int n = 3;
		boolean result = canPlaceFlowers(arr, n);
		System.out.println(Arrays.toString(arr));
		System.out.println(result);
	}

	public static boolean canPlaceFlowers(int[] arr, int n) {
		int count = 0;
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] == 0) {
				int prev = (k == 0 || arr[k-1] == 0) ? 0 : 1;
				int next = (k == arr.length - 1 || arr[k + 1] == 0) ? 0 : 1;
				if (prev == 0 && next == 0) {
					count++;
					arr[k] = 1;
				}
			}
			if (count >= n) {
				return true;
			}
		}

		return false;
	}
}
