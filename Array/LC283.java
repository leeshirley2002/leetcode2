/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]*/

//two pointers

class Solution {
    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]!= 0){
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j++;
            }
        }
    }
}