//MyModAppDemo.java 
// ������������ ���������� ����������
// sp: ��� ����� � ����������� �����
package appstart.mymodappdemo;
import appfuncs.simplefuncs.SimpleMathFuncs;
 
import java.util.ServiceLoader; //sp
import userfuncs.binaryfuncs.*; //sp

public class MyModAppDemo{
  public static void main(String[] args){
    if(SimpleMathFuncs.isFactor(2,10))
       System.out.println("2 �������� ���������� 10");
    System.out.println("���� � �� 35 � 105 "+SimpleMathFuncs.lcf(35,105));
    System.out.println("���� � �� 35 � 105 "+SimpleMathFuncs.gcf(35,105));
   
    //sp ������ ���������� ���������� �� ������� 
    // ���������������� ��������

    // ��������� ���������� ������ ��� �������� �������
  ServiceLoader<BinFuncProvider> ldr = ServiceLoader.load(BinFuncProvider.class);
    
    BinaryFunc binOp = null;
    //����� ���������� (������ ������� ������ - ���������� ����������)
    // ��� ������� absPlus � ��������� �������
    for( BinFuncProvider bfp: ldr){
      System.out.println();
      if(bfp.get().getName().equals("absPlus")){
         binOp=bfp.get();
         break;
      }
    }
    // ���� �������, ���������� ��������� �������
    if(binOp !=null)
      System.out.println("��������� absPlus: 12, -4 ="+binOp.func(12,-4));
    else
      System.out.println("������� absPlus �� ������� ");

    binOp = null;
    //����� ���������� (������ ������� ������ - ���������� ����������)
    // ��� ������� absMinus � ��������� �������
    for( BinFuncProvider bfp: ldr){
      if(bfp.get().getName().equals("absMinus")){
         binOp=bfp.get();
         break;
      }
    }
    // ���� �������, ���������� ��������� �������
    if(binOp !=null)
      System.out.println("��������� absMinus: 12, -4 ="+binOp.func(12,-4));
    else
      System.out.println("������� absMinus �� ������� ");

  }
}