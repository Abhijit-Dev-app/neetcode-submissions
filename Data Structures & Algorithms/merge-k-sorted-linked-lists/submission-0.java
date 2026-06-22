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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            ListNode node = lists[0];
            return node;
        }
        int size = lists.length;
        ListNode head1 = lists[0];
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for(int i = 1;i < size; i++){
            ListNode head2 = lists[i];
            
            while(head1 != null && head2 != null){
                if(head1.val < head2.val){
                    temp.next = new ListNode(head1.val);
                    head1 = head1.next;
                    temp = temp.next;
                }else if(head1.val > head2.val){
                    temp.next = new ListNode(head2.val);
                    temp = temp.next;
                    head2 = head2.next;
                }else{
                    temp.next = new ListNode(head1.val);
                    head1 = head1.next;
                    temp = temp.next;
                }
            }
            while(head1 != null){
                temp.next = new ListNode(head1.val);
                temp = temp.next;
                head1 = head1.next;
            }
            while(head2 != null){
                temp.next = new ListNode(head2.val);
                temp = temp.next;
                head2 = head2.next;
            }
            temp.next = null;
            head1 = dummy.next;
            temp = dummy;
        }
        return head1;
    }
}
