//LC738
// числовая послед наз монотонной если все для всех рядом стоящих чисел верно ,
// что предыдущее меньше или равно последующему
// для заданного N найти наибольшее или равное ему число,
// цифры которого  являются монотонной последовательность

import java.util.Arrays;

class Solution {
    public int monotoneIncreasingDigits(int n) {
        // преобразуем число в массив цифр и еще добавляем ведущий и заключительные нули
        // т.е. само число начинется с 1 индекса и заканчивается длинной массива +1,
        // т.е. последний 0 он служебный и к числу не относится
        // и таблицу делаем сразу двумерной - вторая строка для результата
        String sn=String.valueOf(n);
        int dlnp2=2+sn.length();
        Integer[][] mn=new Integer[dlnp2][2];
        mn[0][0]=0;
        for (int i=0;i<sn.length();i++){
           mn[i+1][0]=Integer.valueOf(sn.substring(i,i+1));
           // System.out.println(Integer.valueOf( sn.substring(i,i+1)));
        }
        mn[1+sn.length()][0]=0;
        // решение
        // находим первый слева разрыв -т.е. уменьшение цифры,не монотонность
        int r=0;// сначала положение разрыва до первой цифры
        for(int i=1;i<dlnp2;i++){
            r++;
           if(mn[i][0]>mn[i+1][0]) {
              break;
           }
        }
        if(r==dlnp2-2){// если само число монотонное
            return n;
        }
        for(int i=r+1;i<dlnp2-1;i++){// заполнение 9-ками начиная с меньшего т.е. с разрыва
           mn[i][1] =9;
        }
        for(int i=r;i>0;i--){// заполнение до разрыва монотонности
           if(mn[i][0]-1<mn[i-1][0]){
              mn[i][1] =9;
           } else {
               mn[i][1]=mn[i][0]-1;}
        }
        System.out.println(r);
    return n+9999;
    }
}

public class Main {
    public static void main(String[] args) {
        int n=33332;
        Solution m=new Solution();
        System.out.println("Число дано: "+n);
        System.out.println("Монотонное: "+m.monotoneIncreasingDigits(n));
    }
}