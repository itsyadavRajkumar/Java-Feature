package com.java.leetcode;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Map<Character, Integer> map = Map.of(
                '(', -3,
                '{', -2,
                '[', -1,
                ')', 3,
                '}', 2,
                ']', 1
        );

        for (char ch:s.toCharArray()) {
            int key = map.get(ch);
            if (key < 0) stack.push(key);
            else {
                if (stack.isEmpty()) return false;
                else if (stack.peek() + key != 0) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
