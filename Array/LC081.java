/*
follow up for search in rotated sorted array
contains duplicates

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
*/

class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[start] == target){
                return true;
            }
            if(nums[end] ==target){
                return true;
            }
            if(nums[start]< nums[mid]){
                if(target < nums[mid] && target>nums[start]){
                    end = mid -1;
                }else{
                    start = mid +1;
                }
            }else if(nums[start]>nums[mid]){
                if(target>nums[mid] && target<nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }else{
                start++;
            }
        }
        return false;
    }
}