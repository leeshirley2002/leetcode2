/*
the sky is blue
blue is sky the
eulb si yks eht
*/

class Solution {
    public void reverseWords(char[] s) {
        int start = 0;
        for(int i=0;i<s.length();i++){
            if(s[i] == ' '){
                reverse(s, start, i-1);
                start = i+1;
            }
        }
        reverse(s, 0, s.length);
    }
    public void reverse(char[] s, int start, int end){
        while(start < end){
            int tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}