/*Write a program to find the node at which the intersection of two singly linked lists begins.*/


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int lengthA = 0;
        int lengthB = 0;
        while(p1 != null){
            lengthA++;
            p1 = p1.next;
        }
        while(p2 != null){
            lengthB++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        if(lengthA > lengthB){
            int delta = lengthA - lengthB;
            while(delta > 0){
                p1 = p1.next;
                delta--;
            }
        }else if(lengthB > lengthA){
            int delta = lengthB - lengthA;
            while(delta > 0){
                p2 = p2.next;
                delta--;
            }
        }
        while(p1 != null){
            if(p1 == p2){
                return p1; 
            }
            p1 = p1.next;
            p2=  p2.next;
        }
        return null;
    }
}