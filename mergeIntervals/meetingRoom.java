class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
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
        if(intervals.length == 0 || intervals[0].length <= 1){
            return true;
        }
        int[] pre = new int[2];
        pre[0] = intervals[0][0];
        pre[1] = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] < pre[1]){
                return false;
            }
            pre[0] = intervals[i][0];
            pre[1] = intervals[i][1];
        }
        return true;
    }
}