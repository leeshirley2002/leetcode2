/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String pre = "";
        helper(n, pre, res, 0,0);
        return res;
    }
    public void helper(int n, String pre, List<String> res, int open, int close){
        if(pre.length() == n*2){
            res.add(pre);
            return;
        }
        if(open < n){
            helper(n, pre+"(", res, open+1, close);
        }
        if(close < open){
            helper(n, pre+")", res, open, close+1);
        }
    }
}
