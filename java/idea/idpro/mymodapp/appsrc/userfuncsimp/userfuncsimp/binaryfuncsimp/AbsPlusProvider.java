//AbsPlusProvider.java
// ��������� ��� ������� AbsPlus

package userfuncsimp.binaryfuncsimp;

import userfuncs.binaryfuncs.*;

public class AbsPlusProvider implements BinFuncProvider{
  // ������������� ������ AbsPlus
  public BinaryFunc get() {
     return new AbsPlus();
  }
}
