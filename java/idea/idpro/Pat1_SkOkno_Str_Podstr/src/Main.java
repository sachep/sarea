// ��� �������� ������ ����� ������ ����� �������
// ��������� ��������� �� ����� ��� �� � ��������� ��������
// "araaci" k=2  �����  =4
//
class Solution{
    int sol(String ds, int k){
        int dmax=0;//������ ������������ ���������
        int dt=0;//������� �� ���������
        int begw=0;//���������� ������ ����
        StringBuffer sbf=new StringBuffer("");
        sbf.

        for (int endw=0;endw<ds.length();endw++ ){ // endw ���������� ����� ����
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
        System.out.println("��� �: ����� �� ��������� �� "+k+" ���� = "+s.sol(ds,k));
    }
}