package com.java.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinimumDeleteSumOfAscii {
    public int minimumDeleteSum(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (char ch : s1.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        for (char ch : s2.toCharArray()) {
            boolean check = map.containsKey(ch);
            if (check) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            } else {
                res += (int) ch;
            }
        }

        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> entry = it.next();
            res += entry.getKey();
            entry.setValue(entry.getValue() - 1);
            if (entry.getValue() == 0) {
                it.remove();
            }
        }
        return res;
    }
}
