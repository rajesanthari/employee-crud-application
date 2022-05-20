package com.ranthari.leetcode.string.easy;

/**
 * 
 * https://leetcode.com/problems/excel-sheet-column-number/
 * 
 * Given a string columnTitle that represents the column title as appears in an
 * Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ...
 * 
 * 
 * Example 1:
 * 
 * Input: columnTitle = "A" Output: 1 Example 2:
 * 
 * Input: columnTitle = "AB" Output: 28 Example 3:
 * 
 * Input: columnTitle = "ZY" Output: 701
 * 
 * 
 * Constraints:
 * 
 * 1 <= columnTitle.length <= 7 columnTitle consists only of uppercase English
 * letters. columnTitle is in the range ["A", "FXSHRXW"].
 * 
 * @author ranthari
 *
 */
public class ExcelColumnNumber {

	public static void main(String[] args) {
		String colu = "AMA";
		int titleToNumber = titleToNumber(colu);
		System.out.println(titleToNumber);
	}

	public static int titleToNumber(String columnTitle) {
		int sum = 0;
		int chLength = columnTitle.length();
		for (int ch = 0; ch < chLength; ch++) {
			sum = sum * 26 + (columnTitle.charAt(ch) - 64);
		}
		return sum;
	}

	public static int titleToNumberWithReverse(String columnTitle) {
		int sum = 0;
		int chLength = columnTitle.length() - 1;
		for (int ch = chLength; ch >= 0; ch--) {
			sum += (columnTitle.charAt(ch) - 64) * Math.pow(26, chLength - ch);
		}
		return sum;
	}
}
