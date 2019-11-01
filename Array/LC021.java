/*Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4*/


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode p3 = dummy;
        while(p1 != null && p2!= null){
            if(p1.val < p2.val){
                p3.next = new ListNode(p1.val);
                p1 = p1.next;
                p3 = p3.next;
            }else{
                p3.next = new ListNode(p2.val);
                p2 = p2.next;
                p3 = p3.next;
            }
        }
        if(p2 != null){
            p3.next = p2;
        }
        if(p1!= null){
            p3.next = p1;
        }
        return dummy.next;
    }
}