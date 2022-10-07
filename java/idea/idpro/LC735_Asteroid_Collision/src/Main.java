import java.util.Arrays;
import java.util.Stack;

// LC735 �������� ����������
// ���� ������ ����� ����� , ������������� � �������������
// ���� ��������� �� ����������� �������� ����� - �����, ���� - ������
// ���������� ��������  - ������ ��������� , ��� ���  ����� ���������� ��������
// ��� ������� ������ �� ����� ������� ��������, ���� ������� ��������� - �������� ���
// ���������� ����� �� ���������������
// ������� ��� ��������� ����� ���� ��������������
class Sol {
    // ������� ��  iOi 1 ��� 2022  ��:�� ����� ��� ������ ������� ���� �����������
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> q = new Stack<>();
        for (int a : asteroids) {
            if (a > 0) q.push(a);
            else {
                while (!q.isEmpty() && q.peek() > 0 && q.peek() < -a) q.pop();
                if (q.isEmpty() || q.peek() < 0) q.push(a);
                else if (q.peek() == -a) q.pop();
            }
        }

        int[] result = new int[q.size()];
        for (int i = q.size() - 1; i >= 0; i--) result[i] = q.pop();
        return result;
    }

    // ������� ���
    public int[] astCol(int[] as) {
        int size = as.length;
        int uk = 0;
        Stack<Integer> st = new Stack<Integer>();
        while (uk < size) {//���� �� �������
            if (as[uk] < 0) { //������ �������������
                while (!st.empty() && as[uk] < 0) {  // � ����� ���-�� ���� � ������� ����� �������� ���
                    if (Math.abs(as[st.peek()]) < Math.abs(as[uk])) {//������� ������ ��� �������������
                        as[st.pop()] = 0;//����� ������� � ������� �� �����
                    } else {
                        if (Math.abs(as[st.peek()]) == Math.abs(as[uk])) {//�����
                            as[uk] = 0;//����� �������
                            as[st.pop()] = 0;//����� ������� � ������� �� �����
                        } else {// ������� ������ ��� �������������
                            as[uk] = 0;//����� �������
                        }
                    }
                }
            } else { //������ �������������
                st.push(uk);
            }
            uk++;
        }
        int i = 0;
        for (int a : as) {
            i = (a != 0) ? ++i : i;
        }
        int[] b = new int[i];
        i = 0;
        for (int a : as) {
            if (a != 0) {
                b[i++] = a;
            }
        }
        return b;
    }
}


public class Main {
    public static void main(String[] args) {
        int[] ast = {-5, -6, 3, 5, -4, -8, 6, -3, -4, 5, -5};// iOi -8 ��������
        //int[] ast = {6, 3, 5, -4, -8, 6, -3, -4, -75, 5};// iOi ������ �����������!!!!-75 ��������
// �������� ������ ��� ������ ���������� �� ������! �.�. �� ��� ������� ���������� ����������
        Sol so = new Sol();
        System.out.println("����    : " + Arrays.toString(ast));
        System.out.println("��������: " + Arrays.toString(so.astCol(ast)));
        System.out.println("��� iOi : " + Arrays.toString(so.asteroidCollision(ast)));

    }
}