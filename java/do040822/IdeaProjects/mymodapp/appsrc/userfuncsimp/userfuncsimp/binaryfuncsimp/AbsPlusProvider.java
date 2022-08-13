//AbsPlusProvider.java
// провайдер для функции AbsPlus

package userfuncsimp.binaryfuncsimp;

import userfuncs.binaryfuncs.*;

public class AbsPlusProvider implements BinFuncProvider{
  // предоставляет объект AbsPlus
  public BinaryFunc get() {
     return new AbsPlus();
  }
}
