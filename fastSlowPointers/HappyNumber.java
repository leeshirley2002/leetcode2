class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(true){
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
            if(slow == 1 || fast==1){
                return true;
            }else if(slow == fast){
                break;
            }
        }
        return false;
    }
    private int squareSum(int n){
        int res = 0;
        while(n>0){
            int tmp = n%10;
            res = res + tmp*tmp;
            n = n/10;
        }
        return res;
    }
}