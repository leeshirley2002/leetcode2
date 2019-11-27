class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        for(int i=0;i<=nums.length-1;i++){
            sum = sum + nums[i];
            if(i>=k-1){
                max = Math.max(max, sum);
                sum = sum - nums[start];
                start++;
            }
        }
        return (double) max/k;
    }
}