//  классическая двумерная динамика
//  есть массив m на n , игрок вначале находится в верхней левой клетке,
//  ходить ему можно или вниз или вправо
//  посчитать сколько вариантов маршрутов у него в правую нижнюю клетку

class Solution {
    int MN(int n, int m) {
        int[][] a = new int[n][m];
       Object poi[][][] = new Object[n + 1][m + 1][];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = a[i - 1][j] + a[i][j - 1];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                poi[i][j]=new Object[a[i - 1][j - 1]+1];
                for (int k = 1; k < a[i - 1][j - 1] + 1; k++) {
                    //String s = new String();
                    poi[i][j][k] = i + "" + j + "" + k + "с";
                }
            }
        }

        for (int aa[] : a) {
            for (int aaa : aa) {
                System.out.format("%6d", aaa);
            }

            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k < a[i - 1][j - 1] + 1; k++) {
                   System.out.print(poi[i][j][k].toString() + " ");
                }
            }
            System.out.println();
        }
        return a[n - 1][m - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution f=new Solution();
        int n=3;
        int m=3;
        int kol=f.MN(n,m);
        System.out.println("Количество маршрутов для "+n+"  "+m+" = "+kol);
    }
}