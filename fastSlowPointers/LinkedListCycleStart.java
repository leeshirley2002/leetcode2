public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int circleLength = 0;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                circleLength = calLength(slow);
                break;
            }
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while(circleLength>0){
            p1 = p1.next;
            circleLength--;
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
    private int calLength(ListNode head){
        ListNode node = head;
        int count = 0;
        while(true){
            node = node.next;
            count++;
            if(node == head){
                break;
            }
        }
        return count;
    }
}