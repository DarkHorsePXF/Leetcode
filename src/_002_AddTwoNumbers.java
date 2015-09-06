
/**
 * Created by feng on 2015/7/23.
 * Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target,

 where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class _002_AddTwoNumbers {
	
	 //Definition for singly-linked list.
	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	 
	public static void main(String[] args) {
		ListNode list1=new ListNode(2);
		ListNode p1=list1;
		for (int i = 0; i < 4; i++) {
			int val=p1.val;
			p1.next=new ListNode(val+1);
			p1=p1.next;
		}
		System.out.print("list1:");
		printList(list1);
		ListNode list2=new ListNode(7);
		ListNode p2=list2;
		for (int i = 0; i < 4; i++) {
			int val=p2.val;
			p2.next=new ListNode(val+1);
			p2=p2.next;
		}
		System.out.print("list2:");
		printList(list2);
		ListNode listNode=addTwoNumbers(list1, list2);
		System.out.print("result:");
		printList(listNode);
		
	}

	private static void printList(ListNode list) {
		while(list!=null){
			System.out.print(list.val+"-");
			list=list.next;
		}
		System.out.println();
	}

	private static ListNode addTwoNumbers(ListNode l1,ListNode l2) {
		if(l1==null&&l2==null){
			return null;
		}
		ListNode result=new ListNode(0);
		ListNode curNode=result;
		int carry=0;
		while(l1!=null||l2!=null){
			int val1=0;
			int val2=0;
			if(l1!=null){
				val1=l1.val;
			}
			if(l2!=null){
				val2=l2.val;
			}
			int sum=val1+val2+carry;
			curNode.next=new ListNode(sum%10);
			carry=sum/10;
			curNode=curNode.next;
			if(l1!=null)
				l1=l1.next;
			if(l2!=null)
				l2=l2.next;
		}
		if(carry==1){
			curNode.next=new ListNode(carry);
		}
		return result.next;
	}
	
	

}
