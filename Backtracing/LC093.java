/*Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]*/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() < 4 || s.length() >12){
            return res;
        }
        helper(res, s, 0, "");
        return res;
    }
    public void helper(List<String> res, String s, int count, String pre){
        if(count==3 && isValid(s)){
            res.add(pre+s);
            return;
        }
        for(int i=0;i<3 && i<s.length();i++){
            String tmp = s.substring(0, i+1);
            if(isValid(tmp)){
                helper(res, s.substring(i+1), count+1, pre+tmp+".");
            }
        }

    }
    public boolean isValid(String s){
        if(s.length()==0){
            return false;
        }
        if(s.charAt(0) == '0'){
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        if(num >0 && num <=255){
            return true;
        }else{
            return false;
        }
    }
}