class Sol{
    public int[]  solution(int nums[],int target){
        //int[] a;
        //a =new int[2];//массив для занесения туда индексов - ответов
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
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
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target;
        target=9;
        int[] b;//для решения
        Sol s = new Sol();
        b=s.solution(nums,target);
        for (int a:nums){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println(b[0]+" "+b[1]+" "+nums[b[0]]+"+"+nums[b[1]]+"="+target);
    }
}
