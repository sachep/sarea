//AbsMinus.java
//����� AbsMinus ������������ ���������� ���������� ����������
//BinaryFunc . �� ���������� ��������� abs(a)-abs(b)

package userfuncsimp.binaryfuncsimp;

//import userfuncs.binaryfuncs.BinaryFuncs;
import userfuncs.binaryfuncs.*;

public class AbsMinus implements BinaryFunc {

  //���������� ��� �������
  public String getName(){
    return "absMinus";
  }

  //���������� AbsMinus
  public int func(int a, int b){
    return Math.abs(a)-Math.abs(b);
  }
}

