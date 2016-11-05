
public class BagelModel {	
	
	// The following constants are used to indicate
	// the cost of coffee.
	public final double NO_COFFEE = 0.0;
	public final double REGULAR_COFFEE = 1.25;
	public final double DECAF_COFFEE = 1.25;
	public final double CAPPUCCINO = 2.00;

	public final double WHITE_BAGEL = 1.25;
	public final double WHEAT_BAGEL = 1.50;

	// The following constants are used to indicate
	// the cost of toppings.
	public final double CREAM_CHEESE = 0.50;
	public final double BUTTER = 0.25;
	public final double PEACH_JELLY = 0.75;
	public final double BLUEBERRY_JAM = 0.75;

	private final double TAX_RATE = 0.06; // Sales tax rate
	
	String bagelType;
	boolean[] toppingType;
	int coffeeType;
	
	public BagelModel(String bagel, boolean[] topping, int coffee)
	{
		bagelType = bagel;
		toppingType = topping;
		coffeeType = coffee;
	}
	
	public double getBagelCost()
	{
		double bagelCost = 0.0;

		if (bagelType.equals("white"))
			bagelCost = WHITE_BAGEL;
		else if (bagelType.equals("wheat"))
			bagelCost = WHEAT_BAGEL;
		else
			bagelCost = 0.0;

		return bagelCost;
	}

	public double getCoffeeCost()
	{
		double coffeeCost = 0.0;

		if (coffeeType==0)
			coffeeCost = NO_COFFEE;
		else if (coffeeType==1)
			coffeeCost = REGULAR_COFFEE;
		else if (coffeeType==2)
			coffeeCost = DECAF_COFFEE;
		else if (coffeeType==3)
			coffeeCost = CAPPUCCINO;
		else
			coffeeCost = 0.0;

		return coffeeCost;
	}

	public double getToppingCost()
	{
		double toppingCost = 0.0;

		if (toppingType[0])
			toppingCost += CREAM_CHEESE;
		if (toppingType[1])
			toppingCost += BUTTER;
		if (toppingType[2])
			toppingCost += PEACH_JELLY;
		if (toppingType[3])
			toppingCost += BLUEBERRY_JAM;

		return toppingCost;
	}
	
	public double[] gettheBill()
	{
		double bill[] = new double[3];
		double subTotal = getCoffeeCost() + getBagelCost() + getToppingCost();
		double total = (subTotal * TAX_RATE) + subTotal;
		
		bill[0]= subTotal;
		bill[1] = TAX_RATE;
		bill[2]  = total;

		return bill;
	}


}
