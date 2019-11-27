/*Input: [[0, 30],[5, 10],[15, 20]]
Output: 2*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0] > o2[0]){
                    return 1;
                }else if(o1[0] < o2[0]){
                    return -1;
                }else{
                    if(o1[1] > o2[1]){
                        return 1;
                    }else if(o1[1] < o2[1]){
                        return -1;
                    }
                }
                return 0;
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] < pq.peek()){
                pq.add(intervals[i][1]);
            }else{
                pq.poll();
                pq.add(intervals[i][1]);
            }
        }
        return pq.size();
    }
}