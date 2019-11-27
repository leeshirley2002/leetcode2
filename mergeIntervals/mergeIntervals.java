class Solution {
    public int[][] merge(int[][] intervals) {
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
        ArrayList<int[]> res = new ArrayList<>();
        int[] current = new int[2];
        if(intervals.length == 0 || intervals[0].length < 1){
            int[][] empty = new int[0][0];
            return empty;
        }
        current[0] = intervals[0][0];
        current[1] = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] <= current[1]){
                current[1] = Math.max(intervals[i][1], current[1]);
            }else{
                int[] tmp = new int[2];
                tmp[0] = current[0];
                tmp[1] = current[1];
                res.add(tmp);
                current[0] = intervals[i][0];
                current[1] = intervals[i][1];
            }
        }
        res.add(current);
        int[][] result = new int[res.size()][2];
        for(int i=0;i<result.length;i++){
            result[i] = res.get(i);
        }
        return result;
    }
}