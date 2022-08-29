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


public class LC1_Two_Sum {
    static int kol_op;
    public static void main(String[] args) {
        int target;
        target=9000;
        int[] nu={2,7,11,15};
        int[] nums =new int[100000];// большой массив для экспериментов
        for(int i=0;i<nums.length;i++){
            nums[i]=(int) (Math.random()*100000);
        }
        //nums=nu;
        int[] b;//для решения
        Sol s = new Sol();
        kol_op=0;
        b=s.solution(nums,target);
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
