import java.util.HashMap;
import java.util.Map;

// ������ ������ -������ �������
class Sol{
    public int[]  solution(int[] nums,int target){
        //int[] a;
        //a =new int[2];//������ ��� ��������� ���� �������� - �������
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                LC1_Two_Sum.kol_op++;
                if(nums[i]+nums[j]==target){
                   // a[0]=i;
                   // a[1]=j;
                    return new int[]{i,j};//��� ���, �����, ������� ������ ������� �� ����
                }
            }
        }
        //return a;
        return null;
    }

}
//������ ������ � ������������� ��� �������
class Sol2HashT{
    public int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}

public class LC1_Two_Sum {
    static int kol_op;//��� �������� ���������� ��������

    //��� �������� ���������� ����������� ������ ���������� � �����-�� ������
    public static long mem() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
    public static void main(String[] args) {
        int target;
        target=900000;
        int[] nu={2,7,11,15};//��������� ������ ��� ������
        int[] nums =new int[100000000];// ������� ������ ��� �������������
        for(int i=0;i<nums.length;i++){
            nums[i]=(int) (Math.random()*100000);
        }
        //nums=nu;
        int[] b;//��� �������
        //Sol s = new Sol();//������ ������
        Sol2HashT s=new Sol2HashT(); //������ �������
        kol_op=0;
        long time = System.currentTimeMillis();//������ ����������
        long befo=mem();// ������ ������
        b=s.solution(nums,target);
        System.out.println(System.currentTimeMillis()-time+" �� �����������");// ����� ����������
        System.out.println(mem()-befo+" ������ ������");// ����� ���������� ������
        System.out.print(kol_op+" ���������� ��������� ");
        //for (int a:nums){
          //  System.out.print(a+" ");
        //}
        if (b!=null) {
            System.out.println();
            System.out.println(b[0] + " " + b[1] + " " + nums[b[0]] + "+" + nums[b[1]] + "=" + target);
        }
        else {
            System.out.println("������� ��� !");

        }
    }
}
