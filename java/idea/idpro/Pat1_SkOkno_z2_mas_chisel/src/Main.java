// Паттерны - Скользящее окно
// зад 2 есть массив положит чисел и положит число S
// найти длинну наименьшего непрерывного подмассива сумма которого
// равно или больше числа S
// возвратить  0 если такого подмассива не существует
class Solution {

    // мое решение
    int sol(int[] ar, int s) {
        int dm = 0;//текущая найденная минимальная длинна подмассива
        // сумма которого равна или больше s
        int dl = 0; // тек дл найденного  массива
        int na = 0; // текущий номер начала подпоследовательности
        int ts = 0; // текущ накопл сумма
        for (int i = 0; i <= ar.length - 1; i++) { // идем по массиву от начала и до конца
            ts += ar[i];
            dl++;
            while (ts >= s) {
                if (dm == 0) {
                    dm = dl;
                    System.out.println("тек мин дл подмассива = " + dm);
                } // запоминание первый раз дл и мин дл массива
                if (dl < dm & dl != 0) {// запомнили текущий минимальный размер подмассива
                    dm = dl;
                    System.out.println("тек мин дл подмассива = " + dm);
                }
                // уменьшаем подмассив слева
                ts -= ar[na]; // уменьшили сумму на  крайний слева элемент
                na++; // увеличили тек начало подмассива
                dl--;
            }
        }
        return dm;
    }
}
// решение не мое - из сайта
    class MinSizeSubArraySum {
        public static int findMinSubArray(int S, int[] arr) {
            int windowSum = 0, minLength = Integer.MAX_VALUE;
            int windowStart = 0;
            for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
                windowSum += arr[windowEnd]; // add the next element
                // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
                while (windowSum >= S) {
                    minLength = Math.min(minLength, windowEnd - windowStart + 1);
                    windowSum -= arr[windowStart]; // subtract the element going out
                    windowStart++; // slide the window ahead
                }
            }

            return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }


}


public class Main {
    public static void main(String[] args) {
        int[] ar ={2,3,5,2,3,7,5};
        int s=12;
        Solution r=new Solution();
        System.out.println("Мое реш: дл подмассива = "+r.sol(ar,s));
        System.out.println("С сайта: дл подмассива = "+MinSizeSubArraySum.findMinSubArray(s,ar));

    }
}