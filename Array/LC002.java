/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode p3 = dummy;
        int carry = 0;
        while(p1!= null && p2!=null){
            int value = (p1.val + p2.val + carry)%10;
            carry = (p1.val + p2.val + carry)/10;
            p3.next = new ListNode(value);
            p3 = p3.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 != null){
            while(p1 != null){
                int value = (p1.val + carry)%10;
                carry = (p1.val + carry)/10;
                p3.next = new ListNode(value);
                p3 = p3.next;
                p1 = p1.next;
            }
        }
        if(p2 != null){
            while(p2 != null){
                int value = (p2.val + carry)%10;
                carry = (p2.val + carry)/10;
                p3.next = new ListNode(value);
                p3 = p3.next;
                p2 = p2.next;
            }
        }
        if(carry!=0){
            p3.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
