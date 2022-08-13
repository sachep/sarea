class analiz {
    // метод анализирующий строку и выдающий двумерный массив
    int[][] an(String e) {
        int[][] is = new int[e.length() / 2][2];
        char c;
        String s = "";// надо другой строчный тип наверное
        int j = 0;
        for (int i = 1; i <= e.length(); i += 2) {
            j = j + 1;
            c = e.charAt(j + 1);
            s = "" + c;
            // (e.charAt(i)=='0') ? is[i][1]=0 : is[i][1]=1;//почему , какая переменная ожидается?
            if (e.charAt(j) == '0') {
                is[j][0] = 0;
            } else {
                is[j][0] = 1;
            }
            is[j][1] = Integer.parseInt(s);
            System.out.println(e.length());
            System.out.println(i);
        }
        return is;
    }
}


public class mas01_d0 {
    //st_s_povt ee =new st_s_povt(); - непонятно, почему нельзя здесь завести экземпляр объекта?
    public static void main(String[] args) {
        st_s_povt ee = new st_s_povt();
        analiz aa = new analiz();
        int[][] dvm;
        // ee.Ppovt("AAABCCCCKAZZMMMMNNM");
        System.out.println(ee.Ppovt("011110111001101"));
        dvm = aa.an("011110111001101");
        /*for (int ii[] : dvm) {
            for (int i : ii) {
                System.out.print(i);
            }
            System.out.println();
        }
        */
    }
}
