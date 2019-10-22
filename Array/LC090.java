/*Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> pre = new ArrayList<Integer>();
        for(int i=0;i<=nums.length;i++){
            helper(res, pre, 0, nums, i);    
        }
        return res;
    }
    public void helper(List<List<Integer>> res, ArrayList<Integer> pre, int index,int[] nums, int length){
        if(pre.size() == length){
            res.add(new ArrayList<Integer>(pre));
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i] == nums[i-1]){
                continue;
            }
            pre.add(nums[i]);
            helper(res, pre, i+1, nums, length);
            pre.remove(pre.size()-1);
        }
    }
}