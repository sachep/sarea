import java.util.Arrays;
import java.util.Stack;

// LC735 Коллизии астероидов
// есть массив целых чисел , положительных и отрицательных
// знак указывает на направление движения минус - влево, плюс - вправо
// абсолютное значение  - размер астероида , все они  имеют одинаковую скорость
// при встрече разных по знаку меньший исчезает, если размеры одинаковы - исчезают оба
// одинкаовые знаки не взаимодействуют
// вывести что останется после всех взаимодействий
class Sol {
    // решение от  iOi 1 окт 2022  СА:по моему это крутое решение надо разобраться
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> q = new Stack<>();
        for (int a : asteroids) {
            if (a > 0) q.push(a);
            else {
                while (!q.isEmpty() && q.peek() > 0 && q.peek() < -a) q.pop();
                if (q.isEmpty() || q.peek() < 0) q.push(a);
                else if (q.peek() == -a) q.pop();
            }
        }

        int[] result = new int[q.size()];
        for (int i = q.size() - 1; i >= 0; i--) result[i] = q.pop();
        return result;
    }

    // решение мое
    public int[] astCol(int[] as) {
        int size = as.length;
        int uk = 0;
        Stack<Integer> st = new Stack<Integer>();
        while (uk < size) {//идем по массиву
            if (as[uk] < 0) { //найден отрицательный
                while (!st.empty() && as[uk] < 0) {  // в стеке что-то есть и текущий отриц астероид жив
                    if (Math.abs(as[st.peek()]) < Math.abs(as[uk])) {//положит меньше чем отрицательный
                        as[st.pop()] = 0;//полож аннигил и удалили из стека
                    } else {
                        if (Math.abs(as[st.peek()]) == Math.abs(as[uk])) {//равны
                            as[uk] = 0;//отриц аннигил
                            as[st.pop()] = 0;//полож аннигил и удалили из стека
                        } else {// положит больше чем отрицательный
                            as[uk] = 0;//отриц аннигил
                        }
                    }
                }
            } else { //найден положительный
                st.push(uk);
            }
            uk++;
        }
        int i = 0;
        for (int a : as) {
            i = (a != 0) ? ++i : i;
        }
        int[] b = new int[i];
        i = 0;
        for (int a : as) {
            if (a != 0) {
                b[i++] = a;
            }
        }
        return b;
    }
}


public class Main {
    public static void main(String[] args) {
        int[] ast = {-5, -6, 3, 5, -4, -8, 6, -3, -4, 5, -5};// iOi -8 исчезает
        //int[] ast = {6, 3, 5, -4, -8, 6, -3, -4, -75, 5};// iOi решает неправильно!!!!-75 исчезает
// исчезает потому что массив передается по ссылке! т.е. он уже изменен предыдущим алгоритмом
        Sol so = new Sol();
        System.out.println("Были    : " + Arrays.toString(ast));
        System.out.println("Остались: " + Arrays.toString(so.astCol(ast)));
        System.out.println("Ост iOi : " + Arrays.toString(so.asteroidCollision(ast)));

    }
}