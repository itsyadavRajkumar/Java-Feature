package com.java.leetcode;

public class KthCharacter {
    public static char kthCharacter(int k) {
        StringBuilder stringBuilder = new StringBuilder("a");
        while (stringBuilder.length() < k) {
            int len = stringBuilder.length();
            for (int i = 0; i < len && stringBuilder.length() < k; i++) {
                char ch = stringBuilder.charAt(i);
                char newChar = ch == 'z' ? 'a' : (char) (ch + 1);
                stringBuilder.append(newChar);
            }
        }
        return stringBuilder.charAt(k - 1);
    }

    public static void main(String[] args) {
        int k = 10;
        System.out.println(kthCharacter(k));
    }
}
