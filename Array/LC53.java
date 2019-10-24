/*Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.*/

//Greedy
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int current = 0;
        if(nums == null || nums.length == 0){
            return 0;
        }
        for(int i=0;i<nums.length;i++){
            current = current + nums[i];
            if(nums[i]>current){
                current = nums[i];
            }
            if(current>max){
                max = current;
            }
            
        }
        return max;
    }
}

//divide and conquer?

//Dynamic Programming
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]<0){
                dp[i] = nums[i];
            }else{
                dp[i] = dp[i-1]+nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}