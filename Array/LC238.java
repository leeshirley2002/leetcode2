/*Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Note: Please solve it without division and in O(n).*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];
        int[] res = new int[nums.length];
        arr1[0] = 1;
        arr2[nums.length-1] =1;
        //from left to right
        for(int i=1;i<nums.length;i++){
            arr1[i] = arr1[i-1]*nums[i-1];
        }
        for(int i=nums.length-2;i<=0;i--){
            arr2[i] = arr2[i+1]*nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            res[i] = arr1[i] * arr2[i];
        }
        return res;
    }
}


