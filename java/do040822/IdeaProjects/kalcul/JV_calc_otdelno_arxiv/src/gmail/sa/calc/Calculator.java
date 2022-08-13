package gmail.sa.calc;
	 
import gmail.sa.calc.op.Adder;
	 
public class Calculator
{
	public int sum(int... a)
	{
		Adder adder=new Adder();
		for(int i:a)
		{
			adder.add(i);
		}
		return adder.getSum();
	}
}