/*Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23*/

class Solution {
    public int calculate(String s) {
        int sign = 1;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                continue;
            }else if(Character.isDigit(s.charAt(i))){
                num = num*10 + (s.charAt(i) -'0');
            }else if(s.charAt(i) == '+'){
                res = res + num*sign;
                sign = 1;
                num = 0;
            }else if(s.charAt(i) == '-'){
                res = res + num*sign;
                sign = -1;
                num = 0;
            }else if(s.charAt(i) == '('){
                stack.push(res);
                stack.push(sign);
                res = 0;
                num = 0;
                sign = 1;
            }else if(s.charAt(i) == ')'){
                res = res + num*sign;
                int tmp = 0;
                int tmp_sign = 1;
                if(!stack.isEmpty()){
                    tmp_sign = stack.pop();
                    tmp = stack.pop();
                }
                res = res*tmp_sign + tmp;
            }
        }
        res = res + num*sign;
        return res;
    }
}