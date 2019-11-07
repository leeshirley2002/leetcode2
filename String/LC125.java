/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false*/

class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        s = s.toLowerCase();
        while(start<end){
            while(start<end && (s.charAt(start)>'z' || s.charAt(start)<'a') && (s.charAt(start)>'9' || s.charAt(start)<'0')){
                start++;
            }
            while(start<end &&(s.charAt(end)>'z' || s.charAt(end)<'a') && (s.charAt(end)>'9' || s.charAt(end)<'0')){
                end--;
            }
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
}