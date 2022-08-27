//LeetCode 541 Reverse String II  25.08.2022
// ���� ������ S � ����� K
// ���� ������������� ������ k �������� ������ � ����� ����� ������ 2k ��������
// ����� ������������� k �������� � ��� ����� ��� ������
// ���� ������� ������ k �� ��� �������������
// ���� ������ k �� ������ 2k �� ���������� �� �������
//
// ��������� LC 1 Two Sum
class sol{ // ��� ����� ��� �������
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
class sol2{  // � ��� ���� �� ����� - ����� ������ � ����� ������������ � �������
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
     //   return new String(a); //�������� ���� ��������� � ���������� String

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