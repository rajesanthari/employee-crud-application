package com.ranthari.leetcode.string.easy;

/**
 * 
 * https://leetcode.com/problems/longest-common-prefix/ Write a function to find
 * the longest common prefix string amongst an array of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: strs = ["flower","flow","flight"] Output: "fl" Example 2:
 * 
 * Input: strs = ["dog","racecar","car"] Output: "" Explanation: There is no
 * common prefix among the input strings.
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 200 0 <= strs[i].length <= 200 strs[i] consists of only
 * lower-case English letters.
 * 
 * @author ranthari
 *
 */
public class LongestCommonPrefix {
	public static void main(String[] args) {
		String longStr = longestCommonPrefix(new String[] { "flower", "flow", "flight" });
		System.out.println(longStr);
	}

	public static String longestCommonPrefix(String[] strs) {

		// Find min length from array string
		int minLength = Integer.MAX_VALUE;
		for (String str : strs) {
			int length = str.length();
			if (length == 0) {
				return "";
			}
			if (length < minLength) {
				minLength = length;
			}
		}

		StringBuffer buf = new StringBuffer(minLength);
		for (int j = 0; j < minLength; j++) {
			char ch = strs[0].charAt(j);
			boolean isfailed = false;
			for (int i = 1; i < strs.length; i++) {
				if (ch != strs[i].charAt(j)) {
					isfailed = true;
					break;
				}
			}
			if (isfailed) {
				break;
			} else {
				buf.append(ch);
			}
		}

		return buf.toString();
	}
}
