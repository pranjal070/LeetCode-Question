class Solution {
    public int diagonalSum(int[][] mat) {
        int sum1 = 0;
        int sum2 = 0;
        int total;
        int n = mat.length;
        
        for(int i = 0; i < n; i++){
            int k = i;
            sum1 += mat[i][k];
        }
        for(int i = 0; i < n; i++){
            int k = n - 1 - i;
            sum2 += mat[i][k];
        }
        total = sum1 + sum2;

        if(n % 2 == 1){
            total = total - mat[n/2][n/2];
        }

        return total;
    }
}