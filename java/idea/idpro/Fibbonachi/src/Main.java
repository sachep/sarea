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
// ���������� ���������� ����� ���������
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
    //for (int i=0;i<100;i++){};
    int F(int n,int[] A){
        System.out.println("A["+n+"]="+A[n]);
        if (A[n] !=-1) {
            System.out.println("Return A["+n+"]= "+A[n]);
            return A[n];
        }
        if (n<2) {
            System.out.println("Return n<2 n="+n+" �������=1");
            return 1;
        }
        else{
            A[n]=F(n-1,A)+F(n-2,A);
            System.out.println("������ � Return A["+n+"]= "+A[n]);
            return A[n];
        }
    }
}

public class Main {
    public static void main(String[] args) {

        /*
        Fibbon fi=new Fibbon();//��������
        int n=40;//����� ����� ���������
        System.out.println("����� ��������� � "+n+" =  "+fi.F(n));
        /*/
        /*
        Faktorial fa=new Faktorial();
        int n=4;//����� ����������
        System.out.println("��������� "+n+" =  "+fa.R(n));
        */
        // �������� � ������������ ���� �����������
        Fib_mem fm=new Fib_mem();
        for(int i=0;i<100;i++){fm.A[i]=-1;};
        int n=4;
        System.out.println("����� ��������� � "+n+" =  "+fm.F(n,fm.A));

    }
}