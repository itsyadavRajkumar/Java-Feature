package com.java.leetcode;

/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int i = 0, j = 0;
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (j < len) {
            if (map.containsKey(s.charAt(j))) {
                res = Math.max(res, j - i);
                while (map.containsKey(s.charAt(j))) {   //dvdf
                    map.remove(s.charAt(i));
                    i++;
                }
            }
            map.put(s.charAt(j), j);
            j++;
            res = Math.max(res, j - i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        LengthOfLongestSubstring ofLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(ofLongestSubstring.lengthOfLongestSubstring(str));
    }
}
