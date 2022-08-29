import java.util.HashMap;
import java.util.Map;

// первый подход -прямой перебор
class Sol{
    public int[]  solution(int[] nums,int target){
        //int[] a;
        //a =new int[2];//массив для занесения туда индексов - ответов
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                LC1_Two_Sum.kol_op++;
                if(nums[i]+nums[j]==target){
                   // a[0]=i;
                   // a[1]=j;
                    return new int[]{i,j};//вот так, сразу, возврат нового массива со знач
                }
            }
        }
        //return a;
        return null;
    }

}
//второй подход с использование хэш таблицы
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
    static int kol_op;//для подсчета количества операций

    //для подсчета количества оперативной памяти занимаемым в какой-то момент
    public static long mem() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
    public static void main(String[] args) {
        int target;
        target=900000;
        int[] nu={2,7,11,15};//маленький массив для начала
        int[] nums =new int[100000000];// большой массив для экспериментов
        for(int i=0;i<nums.length;i++){
            nums[i]=(int) (Math.random()*100000);
        }
        //nums=nu;
        int[] b;//для решения
        //Sol s = new Sol();//первый подход
        Sol2HashT s=new Sol2HashT(); //второе решение
        kol_op=0;
        long time = System.currentTimeMillis();//начало выполнения
        long befo=mem();// начало память
        b=s.solution(nums,target);
        System.out.println(System.currentTimeMillis()-time+" мс выполнялось");// конец выполнения
        System.out.println(mem()-befo+" памяти заняло");// конец выполнения память
        System.out.print(kol_op+" количество сравнений ");
        //for (int a:nums){
          //  System.out.print(a+" ");
        //}
        if (b!=null) {
            System.out.println();
            System.out.println(b[0] + " " + b[1] + " " + nums[b[0]] + "+" + nums[b[1]] + "=" + target);
        }
        else {
            System.out.println("решения нет !");

        }
    }
}
