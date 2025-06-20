package com.java.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ModifiedList {
    private volatile Map<ListNode, ListNode> listMap = new HashMap<>();
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode temp = head, prev = null;
//        private volatile Map<ListNode, ListNode> listMap = new HashMap<>();
        Map<Integer, Boolean> numsMap = new HashMap<>();
        for (int num:nums) numsMap.put(num, true);
        while (temp != null) {
            if (numsMap.containsKey(temp.val)) listMap.put(temp, prev);
            prev = temp;
            temp = temp.next;
        }
        for (Map.Entry<ListNode, ListNode> it : listMap.entrySet()) {
            System.out.println(it.getKey().val);
            if (it.getValue() != null) {
                ListNode nxt = it.getKey().next;
                ListNode curr = it.getKey();
                while (nxt != null && listMap.containsKey(nxt)) {
                    listMap.remove(curr);
                    curr = nxt;
                    nxt = nxt.next;
                }
                it.getValue().next = nxt;
            }
            if (it.getKey() == head) {
                head = it.getKey().next;
            }
        }
        return head;
    }
}
