/*Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false*/
//brute force
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(Math.abs(nums[j] - nums[i])<=t && Math.abs(j-i)<=k){
                    return true;
                }
            }
        }
        return false;
    }
}

//buckets, time complexity: O(n), space complexity: O(min(k, n))
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //Note: convert int to long to get rid of Integer exceeds MAX_VALUE
        //corner case
        if(k <= 0 || t < 0) return false;
        //chose the bucket length, use t+1 in order to avoid the dividor equals zero
        long width = (long)t+1;
        HashMap<Long, Long> map = new HashMap<Long, Long>();
        for(int i=0;i<nums.length;i++){
            long key = nums[i]/width;
            long value = (long) nums[i];
            //corner case, if value less than zero, (-1)/3 =0, it should equal to -1
            if(value < 0) key--;
            //same bucket, less than width
            if(map.containsKey(key)){
                return true;
            }
            //check the adjacent bucket
            if(map.containsKey(key-1) && (value - map.get(key-1))<=t){
                return true;
            }
            if(map.containsKey(key+1) && (map.get(key+1)-value)<=t){
                return true;
            }
            //remove indexes range larger than k
            //question mark: why it's i-k not i-k-1????
            if(i>=k){
                map.remove((long)nums[i-k]/width);
            }
            map.put(key, value);
        }
        return false;
    }
}
//self-balanced tree
//Time Complexity: O(n(lgk)), Space Complexity: O(k)
//in Java TreeSet, find -t<=x-nums[i]<=t ----nums[i]-t<=x && num[i]+t>=x
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k <= 0 || t < 0) return false;
        TreeSet<Long> ts = new TreeSet<Long>();
        for(int i=0;i<nums.length;i++){
            Long x = ts.ceiling((long)nums[i] -t);
            if(x != null && x <= (long)nums[i] + t){
                return true;
            }
            if(i>=k){
                ts.remove((long)nums[i-k]);
            }
            ts.add((long)nums[i]);
        }
        return false;
    }
}
