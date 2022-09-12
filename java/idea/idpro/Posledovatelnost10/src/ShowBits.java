// ����������� ��������� ����� ��� �������������
// �������������� ��������

public class ShowBits {
    int numbits;

    ShowBits(int n) {
        numbits = n;
    }

    // ������� ��� � ��������� �������
    int getbit(long val, int bn) {
        long mask = 1;
        mask <<= bn;
        //System.out.println("val== " + val + "  bn " + bn + " mask = " + mask + "  v&m!=0 " + ((val & mask) != 0) + " " + (val & mask));
        //show(val);
        //System.out.println();
        //show(mask);
        //System.out.println();
        return ((val & mask) != 0) ? 1 : 0;
    }

    // ������� ����� ���������� �������������
    void show(long val) {
        long mask = 1;
        // ����� �������� ����� �� ������ �������
        mask <<= (numbits - 1);
        int spacer = 0;
        for (; mask != 0; mask >>>= 1) {   // mask>>>=1  ����� ������ � ���������� ������
            // ������   � � ����������� ���������� ������ ��������
            if ((val & mask) != 0) System.out.print("1");
            else System.out.print("0");
            spacer++;
            if ((spacer % 8) == 0) {
                System.out.print(" ");
                spacer = 0;
            }
        }
        //System.out.println();
    }
}
