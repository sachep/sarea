// BinFuncProvider.java 
//этот интерфейс определ€ет структуру провайдера службы,
// который возвращает экземпл€ры BinaryFunc
package userfuncs.binaryfuncs;

import  userfuncs.binaryfuncs.BinaryFunc;

public interface BinFuncProvider{
  //получение экземпл€ра BinaryFunc
  public BinaryFunc get();
}
