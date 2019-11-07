/*Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1*/
class Solution {
    public int strStr(String haystack, String needle) {
        int index1 = 0;
        while(index1<haystack.length()){
            if(haystack.charAt(index1) == needle.charAt(0)){
                int i = index1;
                int j = 0;
                while(i<haystack.length() && j<needle.length() && haystack.charAt(i) == needle.charAt(j)){
                    i++;
                    j++;
                }
                if(j==needle.length()){
                    return true;
                }else{
                    index1++;
                }
            }else{
                index1++;
            }
        }
        return false;
    }
}