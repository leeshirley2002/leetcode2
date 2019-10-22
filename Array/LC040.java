/*Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> pre = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        helper(candidates, target, 0, pre, res, set);
        return res;
    }
    public void helper(int[] candidates, int target, int index, List<Integer> pre, List<List<Integer>> res, HashSet<List<Integer>> set){
        if(target == 0){
            if(!set.contains(new ArrayList<Integer>(pre))){
                res.add(new ArrayList<Integer>(pre));
                set.add(new ArrayList<Integer>(pre));
            }
        }else if(target>0){
            for(int i=index;i<candidates.length;i++){
                if(candidates[i]>target){
                    continue;
                }

                pre.add(candidates[i]);
                helper(candidates, target- candidates[i], i+1, pre, res, set);
                pre.remove(pre.size()-1);
            }
        }
    }
}
///////////////////get rid of set////////////
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> pre = new ArrayList<>();
        helper(candidates, target, 0, pre, res);
        return res;
    }
    public void helper(int[] candidates, int target, int index, List<Integer> pre, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<Integer>(pre));
        }else if(target>0){
            for(int i=index;i<candidates.length;i++){
                if(i>index && candidates[i] == candidates[i-1]){
                    continue;
                }
                if(candidates[i]>target){
                    continue;
                }
                pre.add(candidates[i]);
                helper(candidates, target- candidates[i], i+1, pre, res);
                pre.remove(pre.size()-1);
            }
        }
    }
}