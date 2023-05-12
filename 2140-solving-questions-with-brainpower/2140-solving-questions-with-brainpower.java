class Solution {

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];
            long cand = questions[i][0];
            if (i + questions[i][1] + 1 <= n) {
                cand += dp[i + questions[i][1] + 1];
            }
            dp[i] = Math.max(dp[i], cand);
        }
        return dp[0];
    }
}
