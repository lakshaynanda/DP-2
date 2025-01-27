// TC: O(mn) where m = no of coins in array, n = amount
// SC: O(mn)
// Solved on LC? Yes
// No Problem faced

class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int dp[][] = new int[m + 1][n + 1];
        
        for(int i = 0; i < m + 1; i++) {
            dp[i][0] = 1;
        }
        
        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < amount + 1; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
                
            }
        }
        return dp[m][n];
    }
}
