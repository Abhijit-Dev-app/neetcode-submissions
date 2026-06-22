/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        // ListNode temp = dummy;
        dummy.next = head;
        ListNode groupPrev = dummy;
        while(true){
            ListNode kth = groupPrev;
            for(int i = 0;i < k && kth != null;i++){
                kth = kth.next;
            }
            if(kth == null){
                break;
            }
            ListNode nextGroupStart = kth.next;
            ListNode prev = nextGroupStart;
            ListNode curr = groupPrev.next;
            while(curr != nextGroupStart){
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            ListNode temp = groupPrev.next; //which will point to 1 in the example
            groupPrev.next = kth;
            groupPrev = temp; //
        }
        return dummy.next;
    }
}
