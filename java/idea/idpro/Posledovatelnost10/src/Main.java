// ������������������ 0 � 1 ��������� ��������� �������:
// ������ ����� 1, ��� ��������� �������� ��������� �������:
// �� ��������� �������� ������� ��� ���������� ����� ������������������
// ������������� � ��� �� ����������� ��������� �������������� ������
// � ��� ������������, ��������:
// 1 0 01 0110 01101001 0110100110010110 � ��
// ����� ���� ����� n-� ���� ������������������

// Solution -������ ����� ����� - �.�. �� 4 ����� ! ����������
class Solution{
    int s(int dl,int no){
        int otv=1;
        // ���������� ������������ ���������� ��������
        // ���������� ������������������
        // � ����������� �� ������ , ���� ������ ��������
        int i=dl;//������ ����� ������������������
        int it=0;//��� ��������� ��� ���������� ������������������
        int dli=0;//�������� ������ ������������������ ��� ����� ���������;
        int st=0;// ������� �������� ������� ����� 2
        while(i>0){
            st=(int)Math.pow(2,it);
            dli=dli+st;
            i=i-st;
            it++;
           // System.out.println(Math.pow(2,it-1)+" "+i+"  �� "+it);
        }
        it--;
        dli=dli+1-st;//(int)Math.pow(2,it);
        int[] adl=new int[dli];// �������� ������� ������ ������
        adl[0]=1; // ������ ���� ������������������
        int t=1;//������� ����� ������ �������� ��������� ���������
        int n;//
        for (int j=1;j<=it;j++){
            n=t; // ��������� ������� �����
            for(int m=0;m<n;m++){
                adl[t]=adl[m]==1 ? 0:1;
                //System.out.print(adl[t]+" ");
                t++;
            }
            //System.out.println();
        }
        //for (int a:adl){
        //    System.out.print(a+" ");
        //}
        System.out.println("��� �� "+dl+" ��� ������ ���� "+dli+" ������  "+it);
        return adl[no];
    }
}

public class Main {
    public static void main(String[] args) {
        int dl=110000000;//������ ������������������ � ������ ����� ������ ���
        // - ������ ���������� � +1 ������
        int no=33554431;//������� �����
        Solution s=new Solution();
        //s.s(100,no);

        System.out.println(no+" � �����  ������ ����� "+s.s(dl,no));
        //for (int w=1;w>0;){     }
    }
}