// ƒл€ заданной строки найти длинну самой длинной
// подстроки состо€щей не более чем из   различных символов
// "araaci" k=2  ответ  =4
//
class Solution{
    int sol(String ds, int k){
        int dmax=0;//длинна максимальна€ подстроки
        int dt=0;//текуща€ дл подстроки
        int begw=0;//координата начала окна
        StringBuffer sbf=new StringBuffer("");
        sbf.

        for (int endw=0;endw<ds.length();endw++ ){ // endw координата конца окна
            //System.out.println(ds.charAt(endw));



        }


        return dmax;
    }
}


public class Main {
    public static void main(String[] args) {
        String ds="araaci";
        int k=2;
        Solution s=new Solution();
        System.out.println("ћое р: сама€ дл подстрока из "+k+" симв = "+s.sol(ds,k));
    }
}