/*Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]*/

//DFS
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        List<Integer> pre = new ArrayList<Integer>();
        dfs(candidates, 0 , pre, res, target);
        return result;
    }
    public void dfs(int[] candidates, int index, ArrayList<Integer> pre, List<List<Integer>> res, int target){
        for(int i=index;i<candidates.length;i++){
            int remain = target - candidates[i];
            pre.add(candidates[i]);
            if(remain == 0){
                res.add(new ArrayList<Integer>(pre));
            }else if(remain > 0){
                dfs(candidates, i, pre, res, remain);
            }
            pre.remove(pre.size() -1);
        }
    }
}
///////////////////////////////////////////////////////////backtracking/////////////////
/*recursive*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        List<Integer> pre = new ArrayList<Integer>();
        helper(result, 0, candidates, target, pre);
        return result;
    }
    public void helper(List<List<Integer>> res, int index, int[] candidates, int target, List<Integer> pre){
        if(target>0){
            for(int i=index;i<candidates.length;i++){
                if(candidates[i]>target){
                    continue;
                }
                pre.add(candidates[i]);
                helper(res, i, candidates, target-candidates[i], pre);
                pre.remove(pre.size()-1);
            }
        }else if(target == 0){
            res.add(new ArrayList<Integer>(pre));
        }
    }
}