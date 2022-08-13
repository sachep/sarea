//AbsMinus.java
//класс AbsMinus обеспечивает конкретную реализацию интрефейса
//BinaryFunc . Он возвращает результат abs(a)-abs(b)

package userfuncsimp.binaryfuncsimp;

//import userfuncs.binaryfuncs.BinaryFuncs;
import userfuncs.binaryfuncs.*;

public class AbsMinus implements BinaryFunc {

  //возвращает имя функции
  public String getName(){
    return "absMinus";
  }

  //реализация AbsMinus
  public int func(int a, int b){
    return Math.abs(a)-Math.abs(b);
  }
}

