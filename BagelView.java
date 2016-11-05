import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class BagelView extends JFrame {

	//Button panel
	JButton calcButton;    // To calculate the cost
	JButton exitButton;    // To exit the application

	//Greeting panel
	private JLabel greeting; // To display a greeting

	//Bagel panel
	JRadioButton whiteBagel;  // To select white
	JRadioButton wheatBagel;  // To select wheat
	ButtonGroup bg1;           // Radio button group

	//Toppings panel
	JCheckBox creamCheese;  // To select cream cheese
	JCheckBox butter;       // To select butter
	JCheckBox peachJelly;   // To select peach jelly
	JCheckBox blueberryJam; // To select blueberry jam

	//Coffee panel
	JRadioButton noCoffee;      // To select no coffee
	JRadioButton regularCoffee; // To select regular coffee
	JRadioButton decafCoffee;   // To select decaf
	JRadioButton cappuccino;    // To select cappuccino
	ButtonGroup bg2;             // Radio button group
	
	BagelController cont;
	double bills[] = new double[3];



	public BagelView()
	{
		// Display a title.
		setTitle("Order Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		createButton();
		createGreetingPanel();
		createBagelPanel();
		createToppingsPanel();
		createCoffeePanel();
		//setRadioButton(wheatBagel);

		pack();
		setVisible(true);   		   
	}
	
	private void createButton()
	{
		JPanel panel = new JPanel();

		calcButton = new JButton("Calculate");
		exitButton = new JButton("Exit");
		
		panel.add(calcButton);
		panel.add(exitButton);
		
		calcButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcButtonAction();				
			}
		});
		
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);				
			}
		});
		add(panel, BorderLayout.SOUTH);
	}

	private void createGreetingPanel()
	{
		JPanel panel = new JPanel();

		// Create the label.
		greeting = new JLabel("Welcome to Brandi's Bagel House");

		// Add the label to this panel.
		panel.add(greeting);
		add(panel, BorderLayout.NORTH);
	}

	private void createBagelPanel()
	{
		JPanel panel = new JPanel();

		// Create a GridLayout manager with 
		// two rows and one column.	   	  
		panel.setLayout(new GridLayout(2, 1));

		// Create the radio buttons.
		whiteBagel = new JRadioButton("White");
		wheatBagel = new JRadioButton("Wheat");

		// Group the radio buttons.
		bg1 = new ButtonGroup();
		bg1.add(whiteBagel);
		bg1.add(wheatBagel);

		// Add a border around the panel.
		panel.setBorder(BorderFactory.createTitledBorder("Bagel"));

		// Add the radio buttons to the panel.
		panel.add(whiteBagel);
		panel.add(wheatBagel);
		add(panel, BorderLayout.WEST);
	}

	private void createToppingsPanel()
	{
		JPanel panel = new JPanel();

		// Create a GridLayout manager with 
		// four rows and one column.		  
		panel.setLayout(new GridLayout(4, 1));

		// Create the check boxes.
		creamCheese = new JCheckBox("Cream cheese");
		butter = new JCheckBox("Butter");
		peachJelly = new JCheckBox("Peach jelly");
		blueberryJam = new JCheckBox("Blueberry jam");

		// Add a border around the panel.
		panel.setBorder(BorderFactory.createTitledBorder("Toppings"));

		// Add the check boxes to the panel.
		panel.add(creamCheese);
		panel.add(butter);
		panel.add(peachJelly);
		panel.add(blueberryJam);
		add(panel, BorderLayout.CENTER);
	}

	private void createCoffeePanel()
	{	
		JPanel panel = new JPanel();

		// Create a GridLayout manager with 
		// four rows and one column.		  
		panel.setLayout(new GridLayout(4, 1));

		// Create the radio buttons.
		noCoffee = new JRadioButton("None");
		regularCoffee = new JRadioButton("Regular coffee");
		decafCoffee = new JRadioButton("Decaf coffee");
		cappuccino = new JRadioButton("Cappuccino");

		// Group the radio buttons.
		bg2 = new ButtonGroup();
		bg2.add(noCoffee);
		bg2.add(regularCoffee);
		bg2.add(decafCoffee);
		bg2.add(cappuccino);

		// Add a border around the panel.
		panel.setBorder(BorderFactory.createTitledBorder("Coffee"));

		// Add the radio buttons to the panel.
		panel.add(noCoffee);
		panel.add(regularCoffee);
		panel.add(decafCoffee);
		panel.add(cappuccino);
		add(panel, BorderLayout.EAST);
	}
	
	public void calcButtonAction()
	{
		cont = new BagelController(getBagel(), getTopping(), getCoffee());
		
		bills = cont.toView();
		
		for(int i = 0; i < 3; i++)
		{
			System.out.println(bills[i]);
		}

		// Create a DecimalFormat object to format output.
		DecimalFormat dollar = new DecimalFormat("0.00");

		// Display the charges.
		JOptionPane.showMessageDialog(null, "Subtotal: $" +
				dollar.format(bills[0]) + "\n" +
				"Tax: $" + dollar.format(bills[1]) + "\n" +
				"Total: $" + dollar.format(bills[2]));
	}
	
	public void setRadioButton(JRadioButton button)
	{
		if(button!=null)
		button.setEnabled(true);
	}
	
	public String getBagel()
	{
		if(whiteBagel.isSelected())
			return "white";
		else if(wheatBagel.isSelected())
			return "wheat";
		else
			return "none";
	}
	
	public int getCoffee()
	{
		int type;

		if(noCoffee.isSelected())
			type = 0;
		else if(regularCoffee.isSelected())
			type = 1;
		else if(decafCoffee.isSelected())
			type = 2;
		else if(cappuccino.isSelected())
			type = 3;
		else
			type = 4;


		return type;
	}
	
	public boolean[] getTopping()
	{
		boolean[] topping = new boolean[4];
		
		for(int i=0; i < topping.length; i++ )
			topping[i]=false;

		if(creamCheese.isSelected())
			topping[0]=true;
		if(butter.isSelected())
			topping[1]=true;
		if(peachJelly.isSelected())
			topping[2]=true;
		if(blueberryJam.isSelected())
			topping[3]=true;

		return topping;
	}
	
	
	

}



