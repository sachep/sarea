//BinaryFunc.java 
//данный интерфейс определяет функцию которая имеет
//два аргумента типа int и возвращает результат типа int
//это может быть любая бинарная операция с двумя аргументами
//типа int которая возвращает тип int

package userfuncs.binaryfuncs;

public interface BinaryFunc{
  // определение имени функции
  public String getName();

  //это выполняемая функция она будет 
  //обеспечена конкретными реализациями
  public int func(int a, int b);
}

