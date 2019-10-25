/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0*/



//Binary Search
//recursive
class Solution {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public int helper(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }
        int mid = (start+end)/2;
        if(nums[mid] > nums[end]){
            return helper(nums, mid+1, end);
            
        }else{
            return helper(nums, start, mid);
        }
    }
}


//interesting thing: the following solution is wrong

class Solution {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public int helper(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }
        int mid = (start+end)/2;
        if(nums[start] > nums[mid]){
            return helper(nums, start, mid);
        }else{
            return helper(nums, mid+1, end);
        }
    }
}
//iterative
class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = (start+end)/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid]< nums[mid-1]){
                return nums[mid];
            }
            
            if(nums[mid] > nums[end]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return -1;
    }
}

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        if(nums[start] < nums[end]){
            return nums[start];
        }
        while(start<end){
            int mid = (start+end)/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid]< nums[mid-1]){
                return nums[mid];
            }
            
            if(nums[start] > nums[mid]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return nums[0];
    }
}