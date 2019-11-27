class AverageOfSubarrayOfSizeK{
    public static double[] findAverages(int K, int[] arr){
        double[] res = new double[arr.length -K];
        int sum = 0;
        for(int i=0;i<K;i++){
            sum = sum + arr[i];
        }
        res[0] = sum/K;
        for(int i=1;i<arr.length - K;i++){
            res[i] = (double) (res[i-1]*K-arr[i-1]+arr[i+K-1])/5;
        }
        return res
    }
}