import common.ListNode;
import util.ListUtil;

/**
 * Created by feng on 2015/9/8.
 */
public class _234_PalindromeLinkedList {
    public static void main(String[] args) {
        int[] nums = {1};
        ListNode text = ListUtil.createList(nums);
        ListUtil.printList(text);
        System.out.println(isPalindrome(text));
    }

    public static boolean isPalindrome(ListNode head){
        if (head==null){
            return true;
        }
        ListNode right = reserveList(getMiddleNode(head));
        ListUtil.printList(head);
        ListNode cur = head;
        while (right!=null){
            if (right.val!=cur.val){
                return false;
            }
            cur = cur.next;
            right = right.next;
        }
        return true;
    }

    private static ListNode reserveList(ListNode node) {
        if (node==null){
            return null;
        }else if (node.next==null){
            return node;
        }
        ListNode head = node;
        head.next = node.next;
        ListNode temp = node.next;
        ListNode p = null;

        while (temp.next!=null){
            p = temp.next;
            temp.next = p.next;
            p.next = head.next;
            head.next = p;
            ListUtil.printList(head.next);
        }

        return head.next;
    }

    private static ListNode getMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast.next!=null&&fast.next.next!=null){
            low = low.next;
            fast = fast.next.next;
        }
        return low;
    }
}
