import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

// терминал Настин - переделано в работу с комплексными числами 18.12.2022
// и выполнение с ними  операций
// мой тренировочный вариант написания такого - вместо работа с мультиплай
// где буквы умножаются на цифры 2* A =2A
class Complex {// класс элементов стека - комплексные числа
    int real;// действительная часть
    int imag;// мнимая часть

    Complex(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    int getValueReal() {
        return real;
    }

    int getValueImag() {
        return imag;
    }

    public String toString() {
        String display = "";
        if (real != 0) {
            display = "" + real;
        }
        if (imag != 0) {
            String probel = "";
            if (imag > 0) {
                probel = "+";
            }
            ;
            display = display + probel + imag + "i";
        }
        if (real == 0 & imag == 0) {
            display = "" + 0;
        }
        return display;
    }

    public Complex add(Complex sekondAdd) {
        int real, imag;
        real = this.real + sekondAdd.getValueReal();
        imag = this.imag + sekondAdd.getValueImag();
        return new Complex(real, imag);
    }

    public Complex sub(Complex sekondSub) {
        int real, imag;
        real = this.real - sekondSub.getValueReal();
        imag = this.imag - sekondSub.getValueImag();
        return new Complex(real, imag);
    }

    public Complex mul(Complex sekondMul) {
        int a, b, c, d, real, imag;
        a = this.real;
        b = this.imag;
        c = sekondMul.getValueReal();
        d = sekondMul.getValueImag();
        real = a * c - b * d;
        imag = b * c + a * d;
        return new Complex(real, imag);
    }

    public Complex div(Complex sekondDiv) {
        int a, b, c, d, real, imag;
        a = this.real;
        b = this.imag;
        c = sekondDiv.getValueReal();
        d = sekondDiv.getValueImag();
        real = (a * c + b * d) / (c * c + d * d);
        imag = (b * c - a * d) / (c * c + d * d);
        return new Complex(real, imag);
    }

}

class Sol {  //здесь собственно главный метод выполнения
    Stack<Complex> stackComplex = new Stack<Complex>();// стек

    public void work() {//собственно отсюда все работает
        Scanner in = new Scanner(System.in);// переменная для ввода данных
        String vvstr; //строка введенная
        while (true) {// цикл опроса ввода
            vvstr = in.nextLine();
            if (Objects.equals(vvstr, "-1")) {//выход из цикла опроса
                System.out.println("Выход по команде -1 ");
                break;
            }
            String[] splited = vvstr.split(" ");//в классе String есть такой
            // метод разбивающий строку на составляющие по разделителю
            switch (splited[0]) {
                case "push":
                    System.out.println("Push");
                    if (splited.length > 1) {// есть 2-я подстрока во введенных данных
                        int real, imag;
                        try {//проверка можно ли взять число из введенного 1 параметра
                            real = Integer.parseInt(splited[1]);// пытаемся взять число если есть
                        } catch (NumberFormatException e) {// если сюда попали значит не число
                            System.out.println("ошибка: 1-й параметр не число");
                            break;//выйти мз свитча
                        }
                        if (splited.length > 2) {
                            try {//проверка можно ли взять число из введенного 2 параметра
                                imag = Integer.parseInt(splited[2]);// пытаемся взять число если есть
                            } catch (NumberFormatException e) {// если сюда попали значит не число
                                System.out.println("ошибка: 2-й параметр не число");
                                break;//выйти мз свитча
                            }
                        } else {
                            imag = 0;//мнимая часть равна нулю
                        }
                        Complex currentComplex;
                        currentComplex = new Complex(real, imag);
                        stackComplex.push(currentComplex);
                        // если сюда попали значит  число
                        break;
                    } else {
                        System.out.println("Нет данных для занесения в стек");
                        continue;// продолжить опрос ввода данных
                    }
                    //break;
                case "print":
                    System.out.println("print");
                    for (Complex currentComplex : stackComplex) {
                        System.out.println(currentComplex);
                    }
                    break;
                case "del":
                    System.out.println("del");
                    try {
                        Complex currentComplex = stackComplex.pop();
                        System.out.println(currentComplex + "   удалено из стека");
                    } catch (RuntimeException e) {
                        System.out.println("нечего удалять!");
                    }
                    break;
                case "rev":
                    System.out.println("rev");
                    Collections.reverse(stackComplex);
                    System.out.println("реверс данных в стеке:");
                    for (Complex currentComplex : stackComplex) {
                        System.out.println(currentComplex);
                    }
                    break;
                case "+":
                    if (stackComplex.size() >= 2) {
                        Complex ArgumentA = stackComplex.pop();
                        Complex ArgumentB = stackComplex.pop();
                        Complex ArgumentC = ArgumentB.add(ArgumentA);
                        stackComplex.push(ArgumentC);
                        System.out.println(ArgumentB + "+" + ArgumentA + "=" + ArgumentC);

                    } else {
                        System.out.println("мало переменных в стеке");
                    }
                    break;
                case "-":
                    if (stackComplex.size() >= 2) {
                        Complex ArgumentA = stackComplex.pop();
                        Complex ArgumentB = stackComplex.pop();
                        Complex ArgumentC = ArgumentB.sub(ArgumentA);
                        stackComplex.push(ArgumentC);
                        System.out.println(ArgumentB + "-" + ArgumentA + "=" + ArgumentC);
                    } else {
                        System.out.println("мало переменных в стеке");
                    }
                    break;
                case "*":
                    if (stackComplex.size() >= 2) {
                        Complex ArgumentA = stackComplex.pop();
                        Complex ArgumentB = stackComplex.pop();
                        Complex ArgumentC = ArgumentB.mul(ArgumentA);
                        stackComplex.push(ArgumentC);
                        System.out.println(ArgumentB + " * " + ArgumentA + " = " + ArgumentC);
                    } else {
                        System.out.println("мало переменных в стеке");
                    }
                    break;
                case "/":
                    if (stackComplex.size() >= 2) {
                        Complex ArgumentA = stackComplex.pop();
                        Complex ArgumentB = stackComplex.pop();
                        Complex ArgumentC = ArgumentB.div(ArgumentA);
                        stackComplex.push(ArgumentC);
                        System.out.println(ArgumentB + " / " + ArgumentA + " = " + ArgumentC);
                    } else {
                        System.out.println("мало переменных в стеке");
                    }
                    break;

            }

        }
    }
}

public class Main {
    public static void main(String[] args) {
        Sol s = new Sol();
        s.work();
        System.out.println("Hello world!");
    }
}