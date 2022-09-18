// «адача 416 из leetcode
// дать ответ можно ли данную последовательность положительных целых
// чисел разделить на две части чтоб сумм этих последовательостей были равны
// например [1,5,11,5] можно  1,5,5  и 11

class Solution {
    public boolean canPartition(int nums[]) {
        int sum = 0;
        for (int a : nums) {
            sum += a;
<<<<<<< HEAD
            System.out.print("      "+a);
=======
            System.out.print("       " + a);

>>>>>>> 04e6fe2bb01951dc9c57d92783cfd8ee08f0e6aa
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
<<<<<<< HEAD
                    bo[i][j] = bo[i][j-1] || bo[i - nums[j - 1]][j - 1];
=======
                    bo[i][j] = bo[i][j] || bo[i - nums[j - 1]][j - 1];
>>>>>>> 04e6fe2bb01951dc9c57d92783cfd8ee08f0e6aa
                } else {
                    bo[i][j] = bo[i][j - 1];
                }
                //System.out.print(bo[i][j] + "  ");
            }
            //System.out.println();
        }


        System.out.println();
<<<<<<< HEAD
        int c=0;
        for (boolean[] a : bo) {
            System.out.print(c+" ");
=======
        int c = 0;
        for (boolean[] a : bo) {
            System.out.print(c++);
>>>>>>> 04e6fe2bb01951dc9c57d92783cfd8ee08f0e6aa
            for (boolean b : a) {
                System.out.print(" " + b);
            }
            c++;
            System.out.println();
        }

        return bo[sum][n];
    }
}

public class Main {
    public static void main(String[] args) {
        ///int[] ar = {2, 5, 10, 5};
        int[] ar = {1, 2, 3,4};
        //int[] ar = {1, 2, 1, 6};
        ///int[] ar = {1, 2,3, 11, 5};
        ///int[] ar = {3, 1,1,2,2,1};

        Solution s = new Solution();

        System.out.println(" ћожно разделить на равные по сумме части? ");
        System.out.println(s.canPartition(ar) ? "да" : "нет");
    }
}