//AbsPlus.java 
//класс AbsPlus обеспечивает конкретную реализацию интрефейса
//BinaryFunc . Он возвращает результат abs(a)+abs(b)

package userfuncsimp.binaryfuncsimp;

import userfuncs.binaryfuncs.BinaryFunc;

public class AbsPlus implements BinaryFunc{

  //возвращает имя функции
  public String getName(){
    return "absPlus";
  }

  //реализация AbsPlus
  public int func(int a, int b){
    return Math.abs(a)+Math.abs(b);
  }
}
