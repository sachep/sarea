//MyModAppDemo.java 
// демонстрация модульного приложения
// sp: для служб и провайдеров служб
package appstart.mymodappdemo;
import appfuncs.simplefuncs.SimpleMathFuncs;
 
import java.util.ServiceLoader; //sp
import userfuncs.binaryfuncs.*; //sp

public class MyModAppDemo{
  public static void main(String[] args){
    if(SimpleMathFuncs.isFactor(2,10))
       System.out.println("2 является множителем 10");
    System.out.println("наим о мн 35 и 105 "+SimpleMathFuncs.lcf(35,105));
    System.out.println("наиб о мн 35 и 105 "+SimpleMathFuncs.gcf(35,105));
   
    //sp теперь используем основанные на службах 
    // пользовательские операции

    // получение загрузчика службы для бинарных функций
  ServiceLoader<BinFuncProvider> ldr = ServiceLoader.load(BinFuncProvider.class);
    
    BinaryFunc binOp = null;
    //поиск провайдера (другми словами метода - реализации интерфейса)
    // для функции absPlus и получение функции
    for( BinFuncProvider bfp: ldr){
      System.out.println();
      if(bfp.get().getName().equals("absPlus")){
         binOp=bfp.get();
         break;
      }
    }
    // если найдена, используем найденную функцию
    if(binOp !=null)
      System.out.println("результат absPlus: 12, -4 ="+binOp.func(12,-4));
    else
      System.out.println("Функция absPlus не найдена ");

    binOp = null;
    //поиск провайдера (другми словами метода - реализации интерфейса)
    // для функции absMinus и получение функции
    for( BinFuncProvider bfp: ldr){
      if(bfp.get().getName().equals("absMinus")){
         binOp=bfp.get();
         break;
      }
    }
    // если найдена, используем найденную функцию
    if(binOp !=null)
      System.out.println("результат absMinus: 12, -4 ="+binOp.func(12,-4));
    else
      System.out.println("Функция absMinus не найдена ");

  }
}