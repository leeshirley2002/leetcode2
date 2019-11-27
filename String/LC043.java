/*Input: num1 = "2", num2 = "3"
Output: "6"*/

class Solution {
    public String multiply(String num1, String num2) {
        char[] number1 = num1.toCharArray();
        char[] number2 = num2.toCharArray();
        ArraysUtils.reverse(number1);
        ArraysUtils.reverse(number2);
        int[] res = new int[number1.length + number2.length];
        for(int i=0;i< number1.length;i++){
            for(int j=0;j< number2.length;j++){
                res[i+j] = res[i+j] + (number1[i]-'0')*(number2[j]-'0');
            }
        }
        String res = "";
        int carry = 0;
        for(int i=0;i<res.length;i++){
            res = res + String.valueOf((res[i]+carry)%10);
            carry = (res[i]+carry)/10;
        }
        if(carry!=0){
            res = res + String.valueOf(carry);
        }
        StringBuilder sb = new StringBuilder(res);
        sb.reverse();
        String product = sb.toString();
        System.out.println(product);
        int index = 0;
        while(index<product.length()-1 &&product.charAt(index) == '0'){
            index++;
        }
        return product.substring(index);
    }
}