/*Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        while(n>0){
            p1 = p1.next;
            n--;
        }
        if(p1 == null){
            return head.next;
        }
        ListNode p2 = head;
        while(p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println(p2.val);
        p2.next = p2.next.next;
        return head;
    }
}
