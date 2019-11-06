/*Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> pre = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<>();
        helper(pre, res, k, n, 1);
        return res;
    }
    public void helper(List<Integer> pre, List<List<Integer>> res, int k, int n, int start){
        if(pre.size() == k){
            res.add(new ArrayList<>(pre));
            return;
        }
        for(int i=start;i<=n;i++){
            pre.add(i);
            helper(pre, res, k, n, i+1);
            pre.remove(pre.size()-1);
        }

    }
}