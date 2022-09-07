//  классическая двумерная динамика
//  есть массив m на n , игрок вначале находится в верхней левой клетке,
//  ходить ему можно или вниз или вправо
//  посчитать сколько вариантов маршрутов у него в правую нижнюю клетку
// и сделал ВЫВОД всех маршрутов

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
                System.out.format("%6d", a[i - 1][j - 1]);
            }
            System.out.println();
        }
//*
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                poi[i][j] = new Object[a[i - 1][j - 1] + 1];
                //System.out.println(i + "." + j);
                //for (int k = 1; k < a[i - 1][j - 1] + 1; k++) {
                // самый ЛЕВЫЙ ВЕРХНИЙ
                if (i == 1 & j == 1) {
                   // poi[i][j][1] = i + "." + j + "-" + 1 + "a ";
                    poi[i][j][1] = i + "." + j + "-    ";
                    //System.out.println(i + "-"+j + "+1  =  " + poi[i][j][1].toString());
                    continue;
                }
                // ВЕРХНЯЯ СТРОЧКА
                if (i == 1) {
                    int k = 1;
                    //System.out.println(a[i-1][j-2]+" aaaa ");

                    while (k <= a[i - 1][j - 2]) {
                        //System.out.println("aaaa ");
                        //System.out.println("." + k);
                       // poi[i][j][k] = poi[i][j - 1][k].toString() + i + "." + j + "-" + k + "b ";
                        poi[i][j][k] = poi[i][j - 1][k].toString() + i + "." + j + "-    " ;
                        //System.out.println(i + "-" + j+"-"+k+"  =  " + poi[i][j][k].toString());
                        k++;
                    }
                    continue;
                }
                //ЛЕВАЯ СТРОЧКА
                if (j == 1) {
                    int k = 1;
                    while (k <= a[i - 2][j - 1]) {
                        //System.out.println("." + k);
                      //  poi[i][j][k] = poi[i - 1][j][k].toString() + i + "." + j + "-" + k + "c ";
                        poi[i][j][k] = poi[i - 1][j][k].toString() + i + "." + j + "-    " ;
                      //  System.out.println(i + "-" + j+"-"+k+"  =  " + poi[i][j][k].toString());
                        k++;
                    }
                    continue;
                }
                // СРЕДИННЫЕ
                // if (i != 1 & j != 1) {
                int k = 1;
                int l = 1;
                while (k <= a[i - 2][j - 1]) {
                    //System.out.println("." + k);
                   // poi[i][j][k] = poi[i - 1][j][k].toString() + i + "." + j + "-" + k + "d ";
                    poi[i][j][k] = poi[i - 1][j][k].toString() + i + "." + j + "-    ";
                    //System.out.println(i + "-" + j+"-"+k+"  =  " + poi[i][j][k].toString());

                    k++;
                    l++;
                }
                k = 1;
                while (k <= a[i - 1][j - 2]) {
                    //System.out.println("aaaa ");
                    //System.out.println("." + l);
                   // poi[i][j][l] = poi[i][j - 1][k].toString() + i + "." + j + "-" + k + "e ";
                    poi[i][j][l] = poi[i][j - 1][k].toString() + i + "." + j + "-    ";
                    //System.out.println(i + "-" + j+"-"+l+"  =  " + poi[i][j][l].toString());
                    l++;
                    k++;
                }

            }
        }

        System.out.println("Список маршрутов:");

        //for (int i = 1; i <= n; i++) {
          //  for (int j = 1; j <= m; j++) {
                for (int k = 1; k < a[n - 1][m - 1] + 1; k++) {
                    System.out.println(poi[n][m][k].toString() + " ");
                }
           // }
           // System.out.println();
        //}
//*/
        return a[n - 1][m - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution f = new Solution();
        int n = 4;
        int m = 4;
        int kol = f.MN(n, m);
        System.out.println("Количество маршрутов для " + n + "  " + m + " = " + kol);
    }
}