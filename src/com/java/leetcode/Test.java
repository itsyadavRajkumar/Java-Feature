package com.java.leetcode;

class Test {
    public String removeSubstring(String s, int k) {
        StringBuilder res = new StringBuilder();
        int[] nums = new int[s.length()];
        for (char c : s.toCharArray()) {
            res.append(c);
            int n = res.length();
            if (c == '(') {
                char ch = res.charAt(n - 2);
                if (n >= 2 && ch == '(') nums[n - 1] = nums[n - 2] + 1;
                else nums[n - 1] = 1;
            } else {
                if (n >= 2 * k && nums[n - k - 1] == k)
                    res.setLength(n - 2 * k);
                else nums[n - 1] = 0;
            }
        }
        return res.toString();
    }
}
