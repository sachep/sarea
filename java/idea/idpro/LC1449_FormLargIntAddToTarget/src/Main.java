import java.util.Arrays;

class Solution {
    public String largestNumber(int[] cost, int target) {
        int[][] dp = new int[10][10];//5001
        Arrays.fill(dp[0], -1);

        for (int i = 1; i <= cost.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (cost[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    /*int temp = (dp[i - 1][j - cost[i - 1]] == -1) ? -1 : 1 + dp[i - 1][j - cost[i - 1]];
                    int t = (dp[i][j - cost[i - 1]] == -1) ? -1 : 1 + dp[i][j - cost[i - 1]];*/
                    int temp,t;
                    if(dp[i - 1][j - cost[i - 1]] == -1)  temp=-1;
                                                    else  temp = 1 + dp[i - 1][j - cost[i - 1]];
                    if(dp[i][j - cost[i - 1]] == -1)       t =-1;
                                                    else   t = 1 + dp[i][j - cost[i - 1]];


                    if (t == -1)     temp = temp;
                    else     if (temp == -1) temp = t;
                             else            temp = temp;

                    if (dp[i - 1][j] == -1)   dp[i][j] = temp;
                    else if (temp == -1)      dp[i][j] = dp[i - 1][j];
                         else   if (temp >= dp[i - 1][j])  dp[i][j] = temp;
                                else                       dp[i][j] = dp[i - 1][j];
                    /*temp = (t == -1) ? temp : (temp == -1) ? t : (t >= temp)? t:temp;
                    dp[i][j] = (dp[i-1][j] == -1) ? temp : (temp == -1) ? dp[i-1][j]
                            :(temp >= dp[i-1][j])?temp : dp[i-1][j];*/
                }
            }
        }
        if (dp[9][target] == -1) return "0";
        int i = 9, j = target;
        StringBuilder result = new StringBuilder();
        while (target > 0) {

            if (target - cost[i - 1] >= 0 && dp[i][target - cost[i - 1]] + 1 == dp[i][target]) {
                result.append(i);
                target -= cost[i - 1];
            } else if (target - cost[i - 1] >= 0 && dp[i - 1][target - cost[i - 1]] + 1 == dp[i][target]) {
                result.append(i);
                target -= cost[i - 1];
            } else i--;
        }

        return result.toString();

    }
}


public class Main {
    public static void main(String[] args) {
        //int ta = 50;
        //int[] co = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        int ta = 9;
        int[] co = {4,3,2,5,6,7,2,5,5};
        Solution so = new Solution();

        System.out.println("Решение: " + so.largestNumber(co, ta));
    }
}