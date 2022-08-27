//LeetCode 541 Reverse String II  25.08.2022
// Дано строка S и целое K
// надо реверсировать первые k символов строки и затем через каждые 2k символов
// опять реверсировать k символов и так далее всю строку
// если сиволов меньше k то все реверсировать
// если больше k но меньше 2k то оставшиеся не трогать
//
// следующая LC 1 Two Sum
class sol{ // это чисто мое решение
    String solution(String s,int k){
        String prs="",prr="";
         int prk=k,prk2=k;
          for(int i=0;i<s.length();i++){
            if (prk>0){
                prr=s.charAt(i)+prr;
                prk--;
            }
            else {
                if (prr!=""){
                    prs=prs+prr;
                    prr="";
                }
                if (prk2>0){
                    prs=prs+s.charAt(i);
                    prk2--;
                }
            }
            if (prk==0 & prk2==0){
               prk=k;
               prk2=k;
            }

          }
        if (prr!=""){
            prs=prs+prr;
        }

    return prs;
    }
}
class sol2{  // а это было на сайте - через массив и потом перестановки в массиве
    String solution(String s, int k){
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
     //   return new String(a); //попробую ниже сохранить в переменную String

        String ss= new String(a);
        return ss;
    }
}

public class LC541_Reverse_StringII{

    public static void main(String[] args) {
        String s;
        int k;
        //s="abcdEFGHabcd1234abcd";
        //k=4;
        s="abcdEFG";
        k=8;
        sol r = new sol();
        System.out.println(s);
        System.out.println(r.solution(s,k));
        sol2 r2 = new sol2();
        System.out.println(s);
        System.out.println(r2.solution(s,k));

    }



}