/*Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
          char[] tmp = str.toCharArray();
          Arrays.sort(tmp);
          String key = new String(tmp);
          if(!map.containsKey(key)){
            map.put(key, new ArrayList<String>());
          }
          List<String> value = map.get(key);
          value.add(str);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for(String key : map.keySet()){
          res.add(map.get(key));
        }
        return res;
    }
}