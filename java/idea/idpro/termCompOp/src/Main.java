import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
// 28.12.22-08.01.23 добавлено: возможность добавлять операции в стек вместе с аргументами если они у оп есть,
// операцию execute all - выполнить если возможно все действия в стеке
// 18.12.22 терминал Настин - переделано в работу с комплексными числами 18.12.2022
// и выполнение с ними  операций
// мой тренировочный вариант написания такого - вместо работа с мультиплай
// где буквы умножаются на цифры 2* A =2A
abstract class Argument {
    Argument add(Argument secondadd) {
        throw new RuntimeException();
    }

    Argument sub(Argument secondadd) {
        throw new RuntimeException();
    }

    Argument mul(Argument secondadd) {
        throw new RuntimeException();
    }

    Argument div(Argument secondadd) {
        throw new RuntimeException();
    }

    int getValueReal() {
        throw new RuntimeException();
    }

    int getValueImag() {
        throw new RuntimeException();
    }
    String getValueKomanda() {
        throw new RuntimeException();
    }
}

class Complex extends Argument {// класс элементов стека - комплексные числа
    int real;// действительная часть
    int imag;// мнимая часть

    Complex() {
    }//конструктор по умолчанию - если числа записывать не надо

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
            display = display + probel + imag + "i";
        }
        if (real == 0 & imag == 0) {
            display = "" + 0;
        }
        return display;
    }

    public Argument add(Argument sekondAdd) {
        int real, imag;
        real = this.real + sekondAdd.getValueReal();
        imag = this.imag + sekondAdd.getValueImag();
        return new Complex(real, imag);
    }

    public Argument sub(Argument sekondSub) {
        int real, imag;
        real = this.real - sekondSub.getValueReal();
        imag = this.imag - sekondSub.getValueImag();
        return new Complex(real, imag);
    }

    public Argument mul(Argument sekondMul) {
        int a, b, c, d, real, imag;
        a = this.real;
        b = this.imag;
        c = sekondMul.getValueReal();
        d = sekondMul.getValueImag();
        real = a * c - b * d;
        imag = b * c + a * d;
        return new Complex(real, imag);
    }

    public Argument div(Argument sekondDiv) {
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

class Komanda extends Complex {
    String komanda;//для хранения команды
    Boolean isHaveNumber;//признак наличия числа хранящегося вместе с командой

    Komanda(String kom) {
        komanda = kom;
        isHaveNumber = false;
    }

    Komanda(String kom, int real, int imag) {
        super(real, imag);
        komanda = kom;
        isHaveNumber = true;
    }
    String getValueKomanda() {
        return komanda;
    }

    public String toString() {
        return komanda + (isHaveNumber ? " " + super.toString() : "");
    }

}

class Sol {  //здесь собственно главный метод выполнения
    Stack<Argument> stackArgument = new Stack<>();// стек
    Map<String, String> comandy = new HashMap<>();

    // считывание текстового файла и запись его в хешмап
    void FileToHashMap(String nameFile, Map<String, String> hash) {
        String strIzFila;
        int nomerStroki = 0;
        System.out.println("Выполнение действий с числами и комплексными числами");
        System.out.println("  действительная и мнимая часть вводится через пробел");
        System.out.println("  Выход по команде:  quit или q");
        System.out.println("  Допустимы команды и их сокращения и альтернативы:");
        try {
            BufferedReader br = new BufferedReader(new FileReader("nastr.txt"));
            while ((strIzFila = br.readLine()) != null) {
                nomerStroki++;
                System.out.println(strIzFila);
                String[] splited = strIzFila.split(":");//находим разделитель :
                if (splited.length == 2) {
                    String[] splitedKey = splited[1].split(",");// находим по разделителям ,
                    for (String key : splitedKey) {
                        hash.put(key.trim(), splited[0].trim());
                    }
                } else {
                    System.out.println("Ошибка в настройках - нет разделителя  :  , строка " + nomerStroki);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка открытия файла: ***" + nameFile + "*** " + e);
        }
    }

    String zamenaComandy(Map<String, String> spisokComand, String inputString) {
        if (spisokComand.containsKey(inputString)) {
            //System.out.println("ключ есть "+spisokComand.containsKey(inputString));//{
            //System.out.println("значение есть "+spisokComand.containsValue(inputString));//{
            //System.out.println("значение по ключу "+spisokComand.get(inputString));
            return spisokComand.get(inputString);//.toString();
        }
        return inputString;
    }

    public boolean exeInputOrStack(String[] splited) {
        Scanner inY = new Scanner(System.in);// переменная для ввода вопроса Y
        String vvstrY; //строка введенная Y

        if (splited[0].equals("quit")) {
            System.out.println("Выход по комнде quit");
            return false;//break;
        }
        switch (splited[0]) {
            case "push":
                System.out.println("push");
                if (splited.length > 1) {// есть 2-я подстрока во введенных данных
                    int real, imag;
                    try {//проверка можно ли взять число из введенного 1 параметра
                        real = Integer.parseInt(splited[1]);// пытаемся взять число если есть
                    } catch (NumberFormatException e) {// если сюда попали значит не число - а команда
                        if (comandy.containsKey(splited[1])) {// есть ли такая команда в списке
                            if (splited.length == 2) {//ввод команды без числа -параметра
                                Komanda currentKomanda = new Komanda(splited[1]);
                                stackArgument.push(currentKomanda);
                                break;
                            } else { // есть еще данные -возможно команда с числом
                                //есть третья подстрока во введенных данных
                                try {//проверка можно ли взять число из введенного 2 параметра
                                    real = Integer.parseInt(splited[2]);// пытаемся взять число если есть
                                } catch (NumberFormatException ee) {// если сюда попали значит не число -
                                    System.out.println("ошибка: 2-й параметр не число");
                                    break;//выйти мз свитча
                                }
                                if (splited.length > 3) {
                                    try {//проверка можно ли взять число из введенного 3 параметра
                                        imag = Integer.parseInt(splited[3]);// пытаемся взять число если есть
                                    } catch (NumberFormatException ee) {// если сюда попали значит не число
                                        System.out.println("ошибка: 3-й параметр не число");
                                        break;//выйти мз свитча
                                    }
                                } else {
                                    imag = 0;//мнимая часть равна нулю
                                }
                                Komanda currentKomanda = new Komanda(splited[1], real, imag);
                                stackArgument.push(currentKomanda);
                                break;

                            }
                        } else
                            System.out.println("ошибка: 1-й параметр не команда и не число, нечего в стек положить");
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
                    stackArgument.push(currentComplex);
                    // если сюда попали значит  число
                    break;
                } else {
                    System.out.println("Нет данных для занесения в стек");
                    return true;//continue;// продолжить опрос ввода данных
                }
                //break;
            case "print":
                System.out.println("print");
                for (Argument currentComplex : stackArgument) {
                    System.out.println(currentComplex);
                }
                break;
            case "delete":
                System.out.println("delete");
                try {
                    Argument currentComplex = stackArgument.pop();
                    System.out.println(currentComplex + "   удалено из стека");
                } catch (RuntimeException e) {
                    System.out.println("нечего удалять!");
                }
                break;
            case "revers":
                System.out.println("revers");
                Collections.reverse(stackArgument);
                System.out.println("реверс данных в стеке:");
                for (Argument currentComplex : stackArgument) {
                    System.out.println(currentComplex);
                }
                break;
            case "+":
                if (stackArgument.size() >= 2) {
                    Argument ArgumentA = stackArgument.pop();
                    Argument ArgumentB = stackArgument.pop();
                    if ((ArgumentA.getClass() == Komanda.class) | (ArgumentB.getClass() == Komanda.class)) {
                        System.out.println("Выполнять операцию с командой?(Y-да)");
                        vvstrY = inY.nextLine().trim();
                        if (!vvstrY.equals("Y")) {
                            System.out.println("Операция не выполнена");
                            stackArgument.push(ArgumentB);
                            stackArgument.push(ArgumentA);
                            break;
                        }
                    }
                    Argument ArgumentC = ArgumentB.add(ArgumentA);
                    stackArgument.push(ArgumentC);
                    System.out.println(ArgumentB + "+" + ArgumentA + "=" + ArgumentC);
                } else {
                    System.out.println("мало переменных в стеке");
                }
                break;
            case "-":
                if (stackArgument.size() >= 2) {
                    Argument ArgumentA = stackArgument.pop();
                    Argument ArgumentB = stackArgument.pop();
                    if ((ArgumentA.getClass() == Komanda.class) | (ArgumentB.getClass() == Komanda.class)) {
                        System.out.println("Выполнять операцию с командой?(Y-да)");
                        vvstrY = inY.nextLine().trim();
                        if (!vvstrY.equals("Y")) {
                            System.out.println("Операция не выполнена");
                            stackArgument.push(ArgumentB);
                            stackArgument.push(ArgumentA);
                            break;
                        }
                    }
                    Argument ArgumentC = ArgumentB.sub(ArgumentA);
                    stackArgument.push(ArgumentC);
                    System.out.println(ArgumentB + "-" + ArgumentA + "=" + ArgumentC);
                } else {
                    System.out.println("мало переменных в стеке");
                }
                break;
            case "*":
                if (stackArgument.size() >= 2) {
                    Argument ArgumentA = stackArgument.pop();
                    Argument ArgumentB = stackArgument.pop();
                    if ((ArgumentA.getClass() == Komanda.class) | (ArgumentB.getClass() == Komanda.class)) {
                        System.out.println("Выполнять операцию с командой?(Y-да)");
                        vvstrY = inY.nextLine().trim();
                        if (!vvstrY.equals("Y")) {
                            System.out.println("Операция не выполнена");
                            stackArgument.push(ArgumentB);
                            stackArgument.push(ArgumentA);
                            break;
                        }
                    }
                    Argument ArgumentC = ArgumentB.mul(ArgumentA);
                    stackArgument.push(ArgumentC);
                    System.out.println(ArgumentB + " * " + ArgumentA + " = " + ArgumentC);
                } else {
                    System.out.println("мало переменных в стеке");
                }
                break;
            case "/":
                if (stackArgument.size() >= 2) {
                    Argument ArgumentA = stackArgument.pop();
                    Argument ArgumentB = stackArgument.pop();
                    if ((ArgumentA.getClass() == Komanda.class) | (ArgumentB.getClass() == Komanda.class)) {
                        System.out.println("Выполнять операцию с командой?(Y-да)");
                        vvstrY = inY.nextLine().trim();
                        if (!vvstrY.equals("Y")) {
                            System.out.println("Операция не выполнена");
                            stackArgument.push(ArgumentB);
                            stackArgument.push(ArgumentA);
                            break;
                        }
                    }
                    Argument ArgumentC = ArgumentB.div(ArgumentA);
                    stackArgument.push(ArgumentC);
                    System.out.println(ArgumentB + " / " + ArgumentA + " = " + ArgumentC);
                } else {
                    System.out.println("мало переменных в стеке");
                }
                break;
        }
        return true;
    }//exeInputOrStack

    public void work() {//собственно отсюда все работает
        FileToHashMap("nastr.txt", comandy);
        Scanner in = new Scanner(System.in);// переменная для ввода данных
        String vvstr; //строка введенная
        while (true) {// цикл опроса ввода
            vvstr = in.nextLine();
            vvstr = vvstr.trim();//убираем пробелы при вводе
            String[] splited = vvstr.split(" ");//в классе String есть такой
            // метод разбивающий строку на составляющие по разделителю
            // 21.12.22 ниже заменяем введенную команду, если возможно,
            // на нужную которая используется в switch,
            // из списка разрешенных к использованию, содержащихся в файле настроек
            splited[0] = zamenaComandy(comandy, splited[0]);//
            if (splited[0].equals("executeAll")) {
                System.out.println("Выполнение всех команд из стека");
                Stack<Complex> stackComplex = new Stack<>();
                int size_stackArgument = stackArgument.size();
                while (stackArgument.size()!=0) {
                    Argument argument = stackArgument.pop();
                    System.out.println("взяли из стека "+argument);
                    if (argument.getClass() == Complex.class) {// запоминаем числа во временный стек
                        //System.out.println("запомнили во временный " + argument);
                        stackComplex.push((Complex) argument);
                        continue;
                    }
                    vvstr=argument.getValueKomanda()+" "+argument.getValueReal()+" "+argument.getValueImag();
                    splited = vvstr.split(" ");
                    splited[0] = zamenaComandy(comandy, splited[0]);//
                    if (!exeInputOrStack(splited)) {// обработка ввода из стека
                        break;
                    }
                }
                int size_stackComplex = stackComplex.size();
                for (int i = 1; i <= size_stackComplex; i++) {// возвращаем числа из временного стека в постоянный
                    stackArgument.push(stackComplex.pop());
                }
            } else {
                if (!exeInputOrStack(splited)) {// обработка ввода с клавиатуры
                    break;
                }
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