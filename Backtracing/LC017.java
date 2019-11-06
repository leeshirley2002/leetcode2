/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].*/

class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<String>();
        if(digits== null || digits.length()<1){
            return res;
        }
        String pre = "";
        helper(digits, res, pre, 0, map);
        return res;
    }
    public void helper(String digits, List<String> res, String pre, int start, HashMap<Character, String> map){
        if(pre.length() == digits.length()){
            res.add(pre);
            return;
        }
        String template = map.get(digits.charAt(start));
        for(int i=0; i<template.length();i++){
            pre = pre + template.charAt(i);
            helper(digits, res, pre,start+1,map);
            pre = pre.substring(0, pre.length()-1);
        }
    }
}