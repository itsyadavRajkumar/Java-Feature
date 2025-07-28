package com.java.leetcode;

public class ReverseString {
    public static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'R', 'a', 'j'};
        reverseString(chars);
        System.out.println(chars);
    }
}
