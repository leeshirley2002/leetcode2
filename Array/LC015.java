/*Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]*/

//two pointers
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length -2; i++){
            //need to remove duplicates for 1st element
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }            
            int start = i+1;
            int end = nums.length -1;
            while(start<end){
                if(nums[i] + nums[start]+nums[end] < 0){
                    start++;
                }else if(nums[i]+nums[start]+nums[end]>0){
                    end--;
                }else{
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[start]);
                    tmp.add(nums[end]);
                    res.add(tmp);
                    //remove duplicates for 2nd and 3rd elements
                    while(start<end && nums[start] == nums[start+1]){
                        start++;
                    }
                    while(start<end && nums[end]==nums[end-1]){
                        end--;
                    }
                    start++;
                    end--;
                }
            }
        }
        return res;
    }
}