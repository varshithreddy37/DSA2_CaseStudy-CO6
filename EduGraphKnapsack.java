public class EduGraphKnapsack {

    public static void main(String[] args) {

        int[] hours = {2, 3, 4, 5};      // Study hours
        int[] value = {3, 4, 5, 8};      // Learning value
        int capacity = 8;

        int n = value.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {

                if (i == 0 || w == 0)
                    dp[i][w] = 0;

                else if (hours[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            value[i - 1] + dp[i - 1][w - hours[i - 1]],
                            dp[i - 1][w]);
                }
                else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Maximum Learning Value = " + dp[n][capacity]);
    }
}