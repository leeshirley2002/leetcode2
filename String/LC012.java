/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
Example 1:

Input: 3
Output: "III"

Example 2:

Input: 4
Output: "IV"

Example 3:

Input: 9
Output: "IX"

Example 4:

Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
*/

class Solution {
    public String intToRoman(int num) {
        int[] digits = new int[4];
        int index = 0;
        while(num > 0){
            digits[index] = num%10;
            num = num/10;
            index++;
        }
        return convert(digits[3], "M","","")+convert(digits[2], "C","D","M")+convert(digits[1], "X", "L", "C")+convert(digits[0], "I", "V", "X");
    }
    private String convert(int digit, String one, String five, String ten){
        switch(digit){
            case 0: return "";
            case 1: return one;
            case 2: return one+one;
            case 3: return one+one+one;
            case 4: return one+five;
            case 5: return five;
            case 6: return five + one;
            case 7: return five + one + one;
            case 8: return five + one + one + one;
            case 9: return one + ten;
        }
        return "";
    }
}
