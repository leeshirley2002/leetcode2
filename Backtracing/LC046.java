/*Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, pre, res, visited);
        return res;
    }
    public void helper(int[] nums, List<Integer> pre, List<List<Integer>> res, boolean[] visited){
        if(pre.size() == nums.length){
            res.add(new ArrayList<>(pre));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                pre.add(nums[i]);
                visited[i] = true;
                helper(nums, pre, res, visited);
                visited[i] = false;
                pre.remove(pre.size()-1);
            }
        }
    }
}