import common.ListNode;
import util.ListUtil;

/**
 * Created by feng on 2015/8/12.
 */
public class _024_SwapNodesInPairs {
    private final static int NODE_COUNT = 2;
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node=head;
        for (int i = 2; i <= NODE_COUNT; i++) {
            ListNode newNode=new ListNode(i);
            node.next = newNode;
            node = node.next;
        }
        System.out.println("before swap:");
        ListUtil.printList(head);
        ListNode newHead = swapPairs(head);
        System.out.println("after swap:");
        ListUtil.printList(newHead);
    }

    public static ListNode swapPairs(ListNode head){
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode oldListCurNode=head.next.next;
        ListNode newHead=head.next;
        newHead.next=head;
        ListNode newListCurNode=newHead.next;
        while (oldListCurNode!=null){
            ListNode first=oldListCurNode;
            ListNode second=oldListCurNode.next;
            if (second!=null){
                oldListCurNode=oldListCurNode.next.next;
                newListCurNode.next=second;
                newListCurNode=newListCurNode.next;
                newListCurNode.next=first;
                newListCurNode=newListCurNode.next;
            }else {
                newListCurNode.next=first;
                newListCurNode=newListCurNode.next;
                break;
            }
        }
        newListCurNode.next=null;
        return newHead;
    }



}
