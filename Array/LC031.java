/*Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2 - 213, 231, 312, 321, 
3,2,1 → 1,2,3
1,1,5 → 1,5,1

1,5,8,4,7,6,5,3,1
1,5,8,5,7,6,4,3,1
*/


class Solution {
    public void nextPermutation(int[] nums) {
        int start = nums.length -1;
        while(start>0){
            if(nums[start] > nums[start-1]){
                break;
            }
            start--;
        }
        if(start == 0){
            reverse(nums, 0, nums.length-1);
        }else{
            int index = nums.length-1;
            while(index>=0){
                if(nums[index]>nums[start-1]){
                    int tmp = nums[start-1];
                    nums[start-1] = nums[index];
                    nums[index] = tmp;
                    break;
                }
                index--;
            }
            reverse(nums, start, nums.length-1);
        }
    }
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}