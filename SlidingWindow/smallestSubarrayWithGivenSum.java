/*Given an array of positive numbers and a positive number ‘S’, 
find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. 
Return 0, if no such subarray exists.*/


class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
      int start = 0;
      int end = 0;
      int sum = 0;
      int min = Integer.MAX_VALUE;
      while(end<arr.length){
        sum = sum + arr[end];
        while(sum >=S){
            min = Math.min(min, end-start+1);
            sum = sum -arr[start];
            start++;
        }
        end++;
      }
      return min;
  }
}