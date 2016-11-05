import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BagelController {
	
	String bagelType;
	boolean[] toppingType;
	int coffeeType;
	BagelModel mod;
	

	public BagelController(String bagel, boolean[] topping, int coffee)
	{
		System.out.println("Bagel: " + bagel);
		System.out.println("Topping:");
		for(int i = 0; i < 4; i++)
		{
			System.out.println(topping[i]);
		}
		
		System.out.println("Coffee: " + coffee);
		
		bagelType = bagel;
		toppingType = topping;
		coffeeType = coffee;
		toModel();
	}
	
	public void toModel()
	{
		mod = new BagelModel(bagelType, toppingType, coffeeType);		
	}
	
	public double[] toView()
	{
		return mod.gettheBill();
	}
	
	
}
