/*Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false*/

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        if(s.length() != t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int c : count){
            if(c != 0){
                return false;
            }
        }
        return true;
    }
}