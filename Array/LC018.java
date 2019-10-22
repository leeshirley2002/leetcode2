/*Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	Arrays.sort(nums);
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-3;i++){
        	if(i>0 && nums[i] == nums[i-1]){
        		continue;
        	}
        	for(int j=i+1;j<nums.length-2;j++){
        		if(j>i+1 && nums[j] == nums[j-1]){
        			continue;
        		}
        		int start = j+1;
        		int end = nums.length-1;
        		while(start < end){
        			if(nums[i]+nums[j]+nums[start]+nums[end]<target){
        				start++;
        			}else if(nums[i]+nums[j]+nums[start]+nums[end]<target){
        				end--;
        			}else{
        				ArrayList<Integer> tmp = new ArrayList<>();
        				tmp.add(nums[i]);
        				tmp.add(nums[j]);
        				tmp.add(nums[start]);
        				tmp.add(nums[end]);
        				res.add(tmp);
        				while(start< end && nums[start]==nums[start+1]){
        					start++;
        				}
        				while(start<end && nums[end] == nums[end-1]){
        					end--;
        				}
        				start++;
        				end--;
        			}
        		}
        	}
        }
        return res;
    }
}