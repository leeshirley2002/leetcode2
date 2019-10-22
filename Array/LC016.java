/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res;
        for(int i=0;i<nums.length-2;i++){
	    	if(i>0 && nums[i] == nums[i-1]){
	    		continue;
	    	}
	    	int start = i+1;
	    	int end = nums.length -1;
	    	while(start < end){
	    		if(nums[i]+nums[start]+nums[end]-target>0){
	    			if(nums[i]+nums[start]+nums[end]-target<min){
	    				min = nums[i]+nums[start]+nums[end]-target;
	    				res = nums[i]+nums[start]+nums[end];
	    			}
	    			end--;
	    		}else if(nums[i]+nums[start]+nums[end] - target < 0){
	    			if(target - (nums[i]+nums[start]+nums[end])<min){
	    				min = target - (nums[i]+nums[start]+nums[end]);
	    				res = nums[i]+nums[start]+nums[end];
	    			}
	    			start++;
	    		}else{
	    			return target;
	    		}
	    	}
        }
        return res;
    }
}