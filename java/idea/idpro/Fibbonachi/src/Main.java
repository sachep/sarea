class Fibbon{

    int F(int n){
        System.out.print("n= "+n+"   ");
        if(n<2) return 1;
        else {
            int r=F(n-1)+F(n-2);
            System.out.println(" Fib "+n+" = "+r);
            return r;
        }
    }
}
// нахождение факториала числа рекурсией
class Faktorial{
    int r;
    int R(int n){
        System.out.print("n= "+n+"   ");
        if (n<2) {
            r=1;
            System.out.println(" R "+n+"! = "+r);
            return r;}
        else {
            //n=n-1;
            r=R(n-1)*n;
            System.out.println(" R "+n+"! = "+r);
            return r;
        }
    }
}
class Fib_mem{
    int[] A=new int[100];
    int v=0;
    //for (int i=0;i<100;i++){};
    int F(int n,int ch1,int ch2){
        v++;ch1++;ch2++;
        //if (ch1!=0) ch1++;
        //if (ch2!=0) ch2++;

        System.out.println("O="+v+" "+ch1+" "+ch2+" "+"НФ A["+n+"]="+A[n]);
        if (A[n] !=-1) {
            System.out.println("a="+v+" "+ch1+" "+ch2+" "+" n="+n+" A["+n+"]="+A[n]+" if A[n]!=-1 True Вычислено уже");
            return A[n];
        }
        if (n<2) {
            System.out.println("b="+v+" "+ch1+" "+ch2+"  n="+n+" if n<2 True За-Re A["+n+"]=1");
            A[n]=1;
            return 1;
        }
        else{
            A[n]=F(n-1,ch1,0)+F(n-2,0,ch2);
            System.out.println("c="+(v-ch1-ch2)+" "+ch1+" "+ch2+" "+"n<2 else Су-За-Re A["+n+"]=A["+(n-2)+"]+A["+(n-1)+"]="+A[n-2]+"+"+A[n-1]+"= "+A[n]);
            return A[n];
        }
    }
}

public class Main {
    public static void main(String[] args) {
        /*
        Fibbon fi=new Fibbon();//рекурсия
        int n=40;//номер числа фиббоначи
        System.out.println("Число фиббоначи № "+n+" =  "+fi.F(n));
        /*/
        /*
        Faktorial fa=new Faktorial();
        int n=4;//номер факториала
        System.out.println("факториал "+n+" =  "+fa.R(n));
        */
        // рекурсия с запоминанием пром результатов
        Fib_mem fm=new Fib_mem();
        for(int i=0;i<100;i++){fm.A[i]=-1;};
        int n=6;
        System.out.println("НАЧАЛО Число фиббоначи № "+n+" =  "+fm.F(n,0,0));

    }
}