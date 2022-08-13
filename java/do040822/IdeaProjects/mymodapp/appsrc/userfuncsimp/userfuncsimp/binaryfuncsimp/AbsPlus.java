//AbsPlus.java 
//����� AbsPlus ������������ ���������� ���������� ����������
//BinaryFunc . �� ���������� ��������� abs(a)+abs(b)

package userfuncsimp.binaryfuncsimp;

import userfuncs.binaryfuncs.BinaryFunc;

public class AbsPlus implements BinaryFunc{

  //���������� ��� �������
  public String getName(){
    return "absPlus";
  }

  //���������� AbsPlus
  public int func(int a, int b){
    return Math.abs(a)+Math.abs(b);
  }
}
