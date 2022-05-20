package com.ranthari.leetcode.string.easy;

/**
 * 
 * https://leetcode.com/problems/excel-sheet-column-title/
 * 
 * Given an integer columnNumber, return its corresponding column title as it
 * appears in an Excel sheet.
 * 
 * For example:
 * 
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ...
 * 
 * 
 * Example 1:
 * 
 * Input: columnNumber = 1 Output: "A" Example 2:
 * 
 * Input: columnNumber = 28 Output: "AB" Example 3:
 * 
 * Input: columnNumber = 701 Output: "ZY"
 * 
 * 
 * Constraints:
 * 
 * 1 <= columnNumber <= 231 - 1
 * 
 * @author ranthari
 *
 */
public class ExcelColumnTitle {

	public static void main(String[] args) {
		int columnNumber = 1014;
		String convertToTitle = convertToTitle(columnNumber);
		System.out.println(convertToTitle);
	}

	public static String convertToTitle(int columnNumber) {
		int temp = 0;
		StringBuffer sb = new StringBuffer();
		int alphaConst = 26;
		while (columnNumber > 0) {
			temp = columnNumber % alphaConst;
			columnNumber = columnNumber / alphaConst;
			if (temp == 0) {
				temp = alphaConst;
				columnNumber -= 1;
			}
			sb.append((char) (temp + 64));
		}
		return sb.reverse().toString();
	}
}
