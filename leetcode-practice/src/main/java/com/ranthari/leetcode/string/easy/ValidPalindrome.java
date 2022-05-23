package com.ranthari.leetcode.string.easy;

public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome("0P"));
	}

	public static boolean isPalindrome(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "");
		s = s.toLowerCase();
		int length = s.length();
		int halfLength = length / 2;
		for (int i = 0; i < halfLength; i++) {
			if (s.charAt(i) != s.charAt(length - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPalindromeUsingLoop(String s) {
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isAlphabetic(ch)) {
				buff.append(Character.toLowerCase(ch));
			} else if (Character.isDigit(ch)) {
				buff.append(ch);
			}
		}
		return buff.toString().equals(buff.reverse().toString());
	}
}
