class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] arr = new double[401];
        arr[0] = k;
        int temp = k;
        int n = -1;
        int index = 0;
        
        while (true) {
            if (temp==1) {
                n = index;
                break;
            }
            
            index++;
            if (temp%2==0) {
                temp /= 2;
                arr[index] = temp;
            } else {
                temp = temp*3 + 1;
                arr[index] = temp;
            }
            
        }
        double[] answer = new double[ranges.length];
        for (int i=0; i<ranges.length; i++) {
            if (ranges[i][0] < n+ranges[i][1]) {
                for (int j=ranges[i][0]; j<n+ranges[i][1]; j++) {
                    answer[i] += (arr[j]+arr[j+1])/2;
                }
            } else if (ranges[i][0] == n+ranges[i][1]) {
                answer[i] = 0;
            } else {
                answer[i] = -1;
            }
            
        }
        
        
        return answer;
    }
}