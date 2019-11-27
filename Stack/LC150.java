
/*Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6*/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int num1 = 0;
        int num2 = 0;
        for(String t : tokens){
            if(t.equals("+")){
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num1 + num2);
            }else if(t.equals("-")){
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 - num1);
            }else if(t.equals("*")){
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 * num1);
            }else if(t.equals("/")){
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 / num1);
            }else{
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}

