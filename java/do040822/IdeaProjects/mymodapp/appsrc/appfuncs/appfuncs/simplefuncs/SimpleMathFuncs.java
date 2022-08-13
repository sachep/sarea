//SimpleMathFuncs.java 
// Несколько простых ма тематиче ских функций
package appfuncs.simplefuncs ; 
public class SimpleMathFuncs{

  // определить является ли a множителем b
  public static boolean isFactor(int a, int b){
    if((b%a) ==0) return true;
    return false;
  }

  // вернуть наименьший положительный
  // общий множитель для a и b
  public static int lcf(int a, int b){
    // вычисление множителя на основе положительных значений
    a = Math.abs(a); a = Math.abs(b);
    int min =a<b ? a: b;
    for( int i=2;i<=min/2;i++){
       if(isFactor(i,a) && isFactor(i,b))   //укороченное И
           return i;                     //если в первом ложь
    }                                 //то второе не вычисляется
    return 1;
  }

   // вернуть наибольший общий множитель для a и b
  public static int gcf(int a, int b){
    // вычисление множителя на основе положительных значений
    a = Math.abs(a); a = Math.abs(b);
    int min =a<b ? a: b;
    for( int i=min/2;i>=2;i--){
       if(isFactor(i,a) && isFactor(i,b))
           return i;
    }
    return 1;
  }
      
}                                                                           