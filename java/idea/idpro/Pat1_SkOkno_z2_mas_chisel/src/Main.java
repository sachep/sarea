// �������� - ���������� ����
// ��� 2 ���� ������ ������� ����� � ������� ����� S
// ����� ������ ����������� ������������ ���������� ����� ��������
// ����� ��� ������ ����� S
// ����������  0 ���� ������ ���������� �� ����������
class Solution {

    // ��� �������
    int sol(int[] ar, int s) {
        int dm = 0;//������� ��������� ����������� ������ ����������
        // ����� �������� ����� ��� ������ s
        int dl = 0; // ��� �� ����������  �������
        int na = 0; // ������� ����� ������ ���������������������
        int ts = 0; // ����� ������ �����
        for (int i = 0; i <= ar.length - 1; i++) { // ���� �� ������� �� ������ � �� �����
            ts += ar[i];
            dl++;
            while (ts >= s) {
                if (dm == 0) {
                    dm = dl;
                    System.out.println("��� ��� �� ���������� = " + dm);
                } // ����������� ������ ��� �� � ��� �� �������
                if (dl < dm & dl != 0) {// ��������� ������� ����������� ������ ����������
                    dm = dl;
                    System.out.println("��� ��� �� ���������� = " + dm);
                }
                // ��������� ��������� �����
                ts -= ar[na]; // ��������� ����� ��  ������� ����� �������
                na++; // ��������� ��� ������ ����������
                dl--;
            }
        }
        return dm;
    }
}
// ������� �� ��� - �� �����
    class MinSizeSubArraySum {
        public static int findMinSubArray(int S, int[] arr) {
            int windowSum = 0, minLength = Integer.MAX_VALUE;
            int windowStart = 0;
            for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
                windowSum += arr[windowEnd]; // add the next element
                // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
                while (windowSum >= S) {
                    minLength = Math.min(minLength, windowEnd - windowStart + 1);
                    windowSum -= arr[windowStart]; // subtract the element going out
                    windowStart++; // slide the window ahead
                }
            }

            return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }


}


public class Main {
    public static void main(String[] args) {
        int[] ar ={2,3,5,2,3,7,5};
        int s=12;
        Solution r=new Solution();
        System.out.println("��� ���: �� ���������� = "+r.sol(ar,s));
        System.out.println("� �����: �� ���������� = "+MinSizeSubArraySum.findMinSubArray(s,ar));

    }
}