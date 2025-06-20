package com.java.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveNodes {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode rev(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode restNode = rev(head.next);
        head.next.next = head;
        head.next = null;
        return restNode;
    }

    // head =
    // head.next =
    // restNode = 8->3->13->2->5->null

    private void print(ListNode head) {
        if (head == null) return;
        System.out.println(head.val);
        print(head.next);
    }

    public ListNode removeNodes(ListNode head) {
        Map<ListNode, Boolean> map = new LinkedHashMap<>();
        head = rev(head);
        ListNode curr = head;
        print(curr);
        while (curr != null) {
            ListNode temp = curr;
            while (temp != null && temp.val <= curr.val) {
                temp = temp.next;
            }
            if (temp != null) {
                map.put(temp, true);
            }

            curr = temp;
        }
        System.out.println(map.size());

//        ArrayList<Map.Entry<ListNode, Boolean>> entries = new ArrayList<>(map.entrySet());
//        Collections.reverse(entries);
        ListNode newNode = new ListNode(-1);
        head = newNode;
        map.entrySet().stream().forEach(System.out::println);
        for (Map.Entry<ListNode, Boolean> it : map.entrySet()) {
            newNode.next = it.getKey();
            System.out.println("it: " + it.getKey().val);
            newNode = newNode.next;
        }
        return head.next;
    }
}
