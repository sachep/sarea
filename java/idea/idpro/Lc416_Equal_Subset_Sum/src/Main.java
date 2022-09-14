// «адача 416 из leetcode
// дать ответ можно ли данную последовательность положительных целых
// чисел разделить на две части чтоб сумм этих последовательостей были равны
// например [1,5,11,5] можно  1,5,5  и 11

class Solution {
    public boolean canPartition(int nums[]) {
        int sum = 0;
        for (int a : nums) {
            sum += a;
            System.out.print("       " + a);

        }
        System.out.println();
        System.out.println("Sum =" + sum);
        if (sum % 2 == 1) {
            return false;
        }//если сумма нечетна то разделить нельз€
        sum = sum / 2;
        int n = nums.length;
        boolean[][] bo = new boolean[sum + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            bo[0][i] = true;
        }
        for (int j = 1; j <= sum; j++) {
            bo[j][0] = false;
        }
        /*
        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(bo[i][j] + "  ");
            }
            System.out.println();
        }
        */
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= nums[j - 1]) {
                    bo[i][j] = bo[i][j] || bo[i - nums[j - 1]][j - 1];
                } else {
                    bo[i][j] = bo[i][j - 1];
                }
                //System.out.print(bo[i][j] + "  ");
            }
            //System.out.println();
        }


        System.out.println();
        int c = 0;
        for (boolean[] a : bo) {
            System.out.print(c++);
            for (boolean b : a) {
                System.out.print(" " + b);
            }
            System.out.println();
        }

        return bo[sum][n];
    }
}

public class Main {
    public static void main(String[] args) {
        int[] ar = {1, 5, 11, 5};
        Solution s = new Solution();

        System.out.println(" ћожно разделить на равные по сумме части? ");
        System.out.println(s.canPartition(ar) ? "да" : "нет");
    }
}