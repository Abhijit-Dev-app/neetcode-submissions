// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */

// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//         ListNode Rl1 = ReverseLink(l1);
//         ListNode Rl2 = ReverseLink(l2);

//         ListNode dummy = new ListNode();
//         ListNode sum = dummy;

//         int carry = 0;

//         while (Rl1 != null || Rl2 != null) {

//             int val1 = (Rl1 != null) ? Rl1.val : 0;
//             int val2 = (Rl2 != null) ? Rl2.val : 0;

//             int res = val1 + val2 + carry;

//             carry = res / 10;

//             sum.next = new ListNode(res % 10);
//             sum = sum.next;

//             if (Rl1 != null) Rl1 = Rl1.next;
//             if (Rl2 != null) Rl2 = Rl2.next;
//         }

//         if (carry != 0) {
//             sum.next = new ListNode(carry);
//         }
//         // if(l1.next == null && l2.next == null && carry != 0){
//         //     return dummy.next;
//         // }

//         return ReverseLink(dummy.next);
//     }

//     public ListNode ReverseLink(ListNode head) {

//         ListNode prev = null;

//         while (head != null) {
//             ListNode next = head.next;
//             head.next = prev;
//             prev = head;
//             head = next;
//         }

//         return prev;
//     }
// }

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}