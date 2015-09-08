package util;

import common.ListNode;

import java.util.Random;

/**
 * Created by feng on 2015/8/12.
 */
public class ListUtil {

    public static void printList(ListNode node){
        StringBuilder sb=new StringBuilder();
        while (node!=null){
            sb.append(node.val);
            if (node.next==null){
                break;
            }
            sb.append("->");
            node=node.next;
        }
        System.out.println(sb.toString());
    }

    public static ListNode createRandomList(int length){
        if (length<=0){
            throw new IllegalArgumentException();
        }
        Random random = new Random(10);
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 0; i < length; i++) {
            int val = random.nextInt(10)+1;
            node.next = new ListNode(val);
            node = node.next;
        }
        return head.next;
    }

    public static ListNode createList(int[] nums){
        if (nums==null||nums.length==0){
            return null;
        }
        int length = nums.length;
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 0; i < length; i++) {
            int val = nums[i];
            node.next = new ListNode(val);
            node = node.next;
        }
        return head.next;
    }
}
