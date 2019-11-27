class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<>();
        while(fast!= null && fast.next!=null){
            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null && !stack.isEmpty()){
            slow = slow.next;
        }
        while(slow != null){
            if(stack.isEmpty()){
                return false;
            }else{
                if(stack.pop() != slow.val){
                    return false;
                }
            }
            slow = slow.next;
        }
        if(stack.size() == 0){
            return true;
        }else{
            return false;
        }

    }
}
