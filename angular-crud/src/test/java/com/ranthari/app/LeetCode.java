package com.ranthari.app;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author ranthari
 *
 */
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

	public static void canPlaceFlowersMain(String[] args) {
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
				int prev = (k == 0 || arr[k - 1] == 0) ? 0 : 1;
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

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 */
	public static void sqlServerConnectionTest(String[] args) throws ClassNotFoundException {

		Connection conn = null;

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbURL = "jdbc:sqlserver://SQLSERVER;databaseName=SQLDB";
			String user = "user";
			String pass = "password";
			conn = DriverManager.getConnection(dbURL, user, pass);
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * https://leetcode.com/problems/plus-one/
	 * 
	 * @param args
	 */
	public static void plusOneMain(String[] args) {
		int[] arr = { 1, 2, 3 };
		int[] mod = plusOne(arr);
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
				newArr[counter] = num;
			}
			digits = newArr;
		}
		return digits;
	}

}
