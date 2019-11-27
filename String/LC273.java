/*Example 3:

Input: 1,234,567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
*/
//Billion,          Million, Thousand, res
//1,000,000,000     1,000,000, 1,000
class Solution {
    public String numberToWords(int num) {
        int[] allparts = new int[4];
        int index = 0;
        String res = "";
        while(num > 0){
            allparts[index] = num%1000;
            num = num/1000;
            index++;
        }
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        if(allparts[3]!=0){
            res = combineThree(allparts[3], map) + " Billion";
        }
        if(allparts[2] != 0){
            if(!res.isEmpty()){
                res = res + " "+combineThree(allparts[2], map) + " Million";
            }else{
                res = combineThree(allparts[2], map) + " Million";
            }
        }
        if(allparts[1] != 0){
            if(!res.isEmpty()){
                res = res + " "+combineThree(allparts[1], map) + " Thousand";
            }else{
                res = combineThree(allparts[1], map) + " Thousand";
            }
        }
        if(allparts[0] != 0){
            if(!res.isEmpty()){
                res = res + " "+combineThree(allparts[0], map);
            }else{
                res = combineThree(allparts[0], map);
            }
        }
        return res;
    }
    private String combineThree(int num, HashMap<Integer, String> map){
        int hundred = num/100;
        int remain = num%100;
        String result = "";

        if(hundred != 0){
            result = map.get(hundred) + " Hundred";
        }
        if(remain != 0){
            if(map.containsKey(remain)){
                if(!result.isEmpty()){
                    result = result + " "+ map.get(remain);
                }else{
                    result = map.get(remain);
                }
            }else{
                int ten = remain/10;
                remain = remain%10;
                if(ten != 0){
                    if(!result.isEmpty()){
                        result = result + " " + map.get(ten*10);
                    }else{
                        result = map.get(ten*10);
                    }
                    
                }
                if(remain != 0){
                    if(!result.isEmpty()){
                        result = result + " "+map.get(remain);
                    }else{
                        result = map.get(remain);
                    }
                }
            }
        }
        return result;
    }
}