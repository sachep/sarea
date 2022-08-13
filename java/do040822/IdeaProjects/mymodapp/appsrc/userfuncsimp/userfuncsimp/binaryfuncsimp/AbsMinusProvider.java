//AbsMinusProvider.java
// провайдер для функции AbsMinus

package userfuncsimp.binaryfuncsimp;

import userfuncs.binaryfuncs.*;

public class AbsMinusProvider implements BinFuncProvider{
  // предоставляет объект AbsMinus
  public BinaryFunc get() {
     return new AbsMinus();
  }
}
