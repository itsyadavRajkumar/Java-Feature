package com.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RemoveZeroSumSublists {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


//    private List<Integer> solve(List<Integer> nums) {
//        int n = nums.size();
//
//    }

    public ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            nums.add(curr.val);
            curr = curr.next;
        }

        return curr;
    }
}
