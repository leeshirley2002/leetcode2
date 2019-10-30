/*Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"*/

class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String longest="";
        if(s.length() <= 1){
            return s;
        }
        for(int i=1;i<s.length();i++){
            String str1 = helper(i, i,s);
            String str2 = helper(i-1, i, s);
            if(str1.length() > max){
                max = str1.length();
                longest = str1;
            }
            if(str2.length() > max){
                max = str2.length();
                longest = str2;
            }
        }
        return longest;
    }
    public String helper(int start, int end, String s){
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1, end);
    }
}