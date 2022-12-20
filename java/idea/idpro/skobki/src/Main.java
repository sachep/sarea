import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

class sol {
    Stack<Integer> st = new Stack<Integer>();

    public void vvod() {
        Scanner in = new Scanner(System.in);
        String vvstroka = " ";

        while (true) {
            vvstroka = in.nextLine();
            if (Objects.equals(vvstroka, "-1")) {
                break;
            }
            String[] splited = vvstroka.split(" ");
            if (splited.length == 0) {
                System.out.println("Ошибка ввода");
                continue;
            }
            switch (splited[0]) {
                case "push":
                    System.out.println("push");
                    if (splited.length == 2) {
                        Integer n;
                        try {
                            n = Integer.parseInt(splited[1]);
                        } catch (NumberFormatException e) {
                            System.out.println("не число");
                            break;
                        }
                        st.push(n);
                    } else {
                        System.out.println("ошибка ввода");
                    }
                    break;
                case "print":
                    System.out.println("print");
                    for (Integer n : st) {
                        System.out.println(n);
                    }
                    break;
                case "reverse":
                    System.out.println("reverse");
                    for (Integer n : st) {
                        System.out.println(n);
                    }
                    break;
                case "+":
                    System.out.println("+");
                    if (st.size() >= 2) {
                        int a = st.pop();
                        int b = st.pop();
                        int c = a + b;
                        st.push(c);
                        System.out.println(a + "+" + b + "=" + c);
                    } else {
                        System.out.println("мало чисел");
                    }
                    break;
                case "-":
                    System.out.println("-");
                    if (st.size() >= 2) {
                        int a = st.pop();
                        int b = st.pop();
                        int c = a - b;
                        st.push(c);
                        System.out.println(a + "-" + b + "=" + c);
                    } else {
                        System.out.println("мало чисел");
                    }
                    break;
                case "*":
                    System.out.println("*");
                    if (st.size() >= 2) {
                        int a = st.pop();
                        int b = st.pop();
                        int c = a * b;
                        st.push(c);
                        System.out.println(a + "*" + b + "=" + c);
                    } else {
                        System.out.println("мало чисел");
                    }
                    break;
            }
        }
    }
}

abstract class Argument {
    Argument add(Argument secondadd) {
        throw new RuntimeException();
    }

    int getIntValue() {
        throw new RuntimeException();
    }
}

class ArgumentInteger extends Argument {
    int value;

    ArgumentInteger(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    Argument add(Argument secondadd) {
        int newValue = value + secondadd.getIntValue();
        return new ArgumentInteger(newValue);
    }

    int getIntValue() {
        return value;
    }
}

class ArgumentString extends Argument {
    String value;

    ArgumentString(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}

//  реализовать мультиплай: умножение буквs на число
//  должно храниться количество букв данного вида
//  и доделать: 1 операцию минус
// 2 реверс стека
// 3 поп- убрать последнее из стека
class sol2 {
    Stack<Argument> st = new Stack<Argument>();

    public void vvod() {
        Scanner in = new Scanner(System.in);
        String vvstroka;

        while (true) {
            vvstroka = in.nextLine();
            if (Objects.equals(vvstroka, "-1")) {
                break;
            }
            String[] splited = vvstroka.split(" ");
            if (splited.length == 0) {
                System.out.println("Ошибка ввода");
                continue;
            }
            switch (splited[0]) {
                case "push":
                    System.out.println("push");
                    if (splited.length == 2) {
                        Integer n;
                        try {
                            n = Integer.parseInt(splited[1]);
                        } catch (NumberFormatException e) {
                            System.out.println("не число");
                            ArgumentString stroka = new ArgumentString(splited[1]);
                            st.push(stroka);
                            break;
                        }
                        ArgumentInteger number = new ArgumentInteger(n);
                        st.push(number);
                    } else {
                        System.out.println("ошибка ввода");
                    }
                    break;
                case "print":
                    System.out.println("print");
                    for (Argument n : st) {
                        System.out.println(n);
                    }
                    break;
                case "+":
                    System.out.println("+");
                    if (st.size() >= 2) {
                        Argument a = st.pop();
                        Argument b = st.pop();
                        Argument c;
                        try {
                            c = a.add(b);
                        } catch (RuntimeException e) {
                            st.push(b);
                            st.push(a);
                            System.out.println("не возможно выполнить операцию");
                            break;
                        }
                        st.push(c);
                        System.out.println(a + "+" + b + "=" + c);
                    } else {
                        System.out.println("мало чисел в стеке");
                    }
                    break;
//                case "-":
//                    System.out.println("-");
//                    if (st.size() >= 2) {
//                        int a = st.pop();
//                        int b = st.pop();
//                        int c = a - b;
//                        st.push(c);
//                        System.out.println(a + "-" + b + "=" + c);
//                    } else {
//                        System.out.println("мало чисел");
//                    }
//                    break;
//                case "*":
//                    System.out.println("*");
//                    if (st.size() >= 2) {
//                        int a = st.pop();
//                        int b = st.pop();
//                        int c = a * b;
//                        st.push(c);
//                        System.out.println(a + "*" + b + "=" + c);
//                    } else {
//                        System.out.println("мало чисел");
//                    }
//                    break;
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        sol2 s2 = new sol2();
        s2.vvod();
        System.out.println("Hello world!");
    }
}