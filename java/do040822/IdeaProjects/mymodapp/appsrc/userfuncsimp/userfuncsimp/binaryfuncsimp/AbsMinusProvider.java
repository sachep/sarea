//AbsMinusProvider.java
// ��������� ��� ������� AbsMinus

package userfuncsimp.binaryfuncsimp;

import userfuncs.binaryfuncs.*;

public class AbsMinusProvider implements BinFuncProvider{
  // ������������� ������ AbsMinus
  public BinaryFunc get() {
     return new AbsMinus();
  }
}
