//LC738
// �������� ������ ��� ���������� ���� ��� ��� ���� ����� ������� ����� ����� ,
// ��� ���������� ������ ��� ����� ������������
// ��� ��������� N ����� ���������� ��� ������ ��� �����,
// ����� ��������  �������� ���������� ������������������

import java.util.Arrays;

class Solution {
    public int monotoneIncreasingDigits(int n) {
        // ����������� ����� � ������ ���� � ��� ��������� ������� � �������������� ����
        // �.�. ���� ����� ��������� � 1 ������� � ������������� ������� ������� +1,
        // �.�. ��������� 0 �� ��������� � � ����� �� ���������
        // � ������� ������ ����� ��������� - ������ ������ ��� ����������
        String sn=String.valueOf(n);
        int dlnp2=2+sn.length();
        Integer[][] mn=new Integer[dlnp2][2];
        mn[0][0]=0;
        for (int i=0;i<sn.length();i++){
           mn[i+1][0]=Integer.valueOf(sn.substring(i,i+1));
           // System.out.println(Integer.valueOf( sn.substring(i,i+1)));
        }
        mn[1+sn.length()][0]=0;
        // �������
        // ������� ������ ����� ������ -�.�. ���������� �����,�� ������������
        int r=0;// ������� ��������� ������� �� ������ �����
        for(int i=1;i<dlnp2;i++){
            r++;
           if(mn[i][0]>mn[i+1][0]) {
              break;
           }
        }
        if(r==dlnp2-2){// ���� ���� ����� ����������
            return n;
        }
        for(int i=r+1;i<dlnp2-1;i++){// ���������� 9-���� ������� � �������� �.�. � �������
           mn[i][1] =9;
        }
        for(int i=r;i>0;i--){// ���������� �� ������� ������������
           if(mn[i][0]-1<mn[i-1][0]){
              mn[i][1] =9;
           } else {
               mn[i][1]=mn[i][0]-1;}
        }
        System.out.println(r);
    return n+9999;
    }
}

public class Main {
    public static void main(String[] args) {
        int n=33332;
        Solution m=new Solution();
        System.out.println("����� ����: "+n);
        System.out.println("����������: "+m.monotoneIncreasingDigits(n));
    }
}