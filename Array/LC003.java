/*Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
                max = Math.max(max, map.size());
            }else{
                i = map.get(s.charAt(i));
                map.clear();
            }
        }
        return max;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                max = Math.max(i-start +1, max);
            }else{
                set.remove(s.charAt(start));
                start++;
                i--;
            }
        }
        return max;
        
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                start = Math.max(map.get(s.charAt(i))+1, start);
            }
            max = Math.max(i- start+1, max);
            map.put(s.charAt(i), i);
        }
        return max;
    }
}
