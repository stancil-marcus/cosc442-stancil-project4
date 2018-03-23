package edu.towson.cis.cosc442.project4.coffeemaker;

import junit.framework.TestCase;

/**
 *
 */
public class CoffeeMakerTest extends TestCase {
	private CoffeeMaker cm;
	private Inventory i;
	private Recipe r1;
/**
 * This method initializes the coffee maker and a recipe for use
 */
	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();

		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(2);
		r1.setAmtCoffee(3);
		r1.setAmtMilk(3);
		r1.setAmtSugar(3);
		r1.setAmtChocolate(3);
	}

	/**
	 * This method tests if the user can add a recipe to the coffee maker successfully
	 */
	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}
	
	/**
	 * This method tests if the user can't add a recipe when all the recipe slots are full
	 */
	public void testAddRecipe2()
	{
		Recipe r2 = new Recipe();
		Recipe r3 = new Recipe();
		Recipe r4 = new Recipe();
		Recipe r5 = new Recipe();
		
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		
		assertFalse(cm.addRecipe(r5));
	}

	/**
	 * This method tests if a users can successfully delete the recipe created in setUp()
	 */
	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}
	
	/**
	 * This method tests if the user can't delete a recipe that hasn't been added to the coffee maker
	 */
	public void testDeleteRecipe2()
	{
		Recipe r2 = new Recipe();
		assertFalse(cm.deleteRecipe(r2));
	}
	
	public void testCanAddRecipe1()
	{
		Recipe r2 = new Recipe();
		r2.setName("toast");
		r2.setPrice(2);
		r2.setAmtCoffee(3);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(0);
		
		assertTrue(cm.canAddRecipe(r2));
	}
	
	public void testCanAddRecipe2()
	{
		Recipe r2 = new Recipe();
		r2.setName("Coffee");
		r2.setPrice(50);
		r2.setAmtCoffee(16);
		r2.setAmtMilk(16);
		r2.setAmtSugar(16);
		r2.setAmtChocolate(16);
		
		cm.addRecipe(r1);
		
		assertFalse(cm.canAddRecipe(r2));
	}

	/**
	 * Tests if the user can edit a recipe's amount of sugar that has been added to the coffee maker
	 */
	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	
	/**
	 * Tests if the user can edit a recipe's amount of coffee that has been added to the coffee maker
	 */
	public void testEditRecipe2() {
		Recipe r2 = new Recipe();
		
		r2.setName("Coffee");
		r2.setPrice(50);
		r2.setAmtCoffee(3);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(0);
		
		cm.addRecipe(r2);
		Recipe newRecipe = new Recipe();
		newRecipe = r2;
		newRecipe.setAmtCoffee(2);
		assertTrue(cm.editRecipe(r2, newRecipe));
	}
	
	/**
	 * Tests if the user can edit a recipe's amount of milk that has been added to the coffee maker
	 */
	public void testEditRecipe3() {
		Recipe r3 = new Recipe();
		
		r3.setName("Coffee");
		r3.setPrice(50);
		r3.setAmtCoffee(3);
		r3.setAmtMilk(1);
		r3.setAmtSugar(1);
		r3.setAmtChocolate(0);
		
		cm.addRecipe(r3);
		Recipe newRecipe = new Recipe();
		newRecipe = r3;
		newRecipe.setAmtMilk(2);
		assertTrue(cm.editRecipe(r3, newRecipe));
	}
	
	/**
	 * Tests if the user can edit a recipe's amount of chocolate that has been added to the coffee maker
	 */
	public void testEditRecipe4() {
		Recipe r4 = new Recipe();
		
		r4.setName("Coffee");
		r4.setPrice(50);
		r4.setAmtCoffee(3);
		r4.setAmtMilk(1);
		r4.setAmtSugar(1);
		r4.setAmtChocolate(0);
		
		cm.addRecipe(r4);
		Recipe newRecipe = new Recipe();
		newRecipe = r4;
		newRecipe.setAmtChocolate(2);
		assertTrue(cm.editRecipe(r4, newRecipe));
	}
	
	/**
	 * Tests if the user can edit a recipe that hasn't been initialized
	 */
	public void testEditRecipe5() {
		Recipe r5 = new Recipe();
		
		cm.addRecipe(r5);
		Recipe newRecipe = new Recipe();
		newRecipe = r5;
		newRecipe.setAmtChocolate(2);
		assertFalse(cm.editRecipe(r5, newRecipe));
	}
	
	/**
	 * Tests if the user can make a purchase when they can afford the drink they want
	 */
	public void testMakePurchase1()
	{
		cm.addRecipe(r1);
		assertEquals(0, cm.makeCoffee(r1, 2), .100);
	}
	
	/**
	 *Tests if a user will get their money back if they try to buy a drink the can't afford 
	 */
	public void testMakePurchase2()
	{
		cm.addRecipe(r1);
		assertEquals(1, cm.makeCoffee(r1, 1), .100);
	}
	/**
	 * Tests if inventory decreases after making a purchase
	 */
	public void testMakePurchase3()
	{
		cm.makeCoffee(r1, 2);
		assertSame(12, cm.checkInventory().getCoffee());
		assertSame(12, cm.checkInventory().getMilk());
		assertSame(12, cm.checkInventory().getSugar());
		assertSame(12, cm.checkInventory().getCoffee());
	}
	
	/**
	 * Tests the getRecipeForName() method to see if you can find a recipe based on it's name
	 */
	public void testGetRecipeForName1() {
		cm.addRecipe(r1);
		assertSame(r1,cm.getRecipeForName("Coffee"));
		
	}
	
	/**
	 * Tests if the getRecipeForName() method can't find the method if the user enters a name 
	 * for a drink that does not exist
	 */
	public void testGetRecipeForName2() {
		cm.addRecipe(r1);
		assertNotSame(r1,cm.getRecipeForName("Cofee"));
		
	}
	
	/**
	 * Tests if you can get the correct recipe array by comparing each element of the 
	 * recipes
	 */
	public void testGetRecipes1()
	{
		Recipe r2 = new Recipe();
		
		r2.setName("Coffee1");
		r2.setPrice(50);
		r2.setAmtCoffee(3);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(0);
		
		Recipe r3 = new Recipe();
		
		r3.setName("Coffee2");
		r3.setPrice(50);
		r3.setAmtCoffee(3);
		r3.setAmtMilk(1);
		r3.setAmtSugar(1);
		r3.setAmtChocolate(0);
		
		Recipe r4 = new Recipe();
		
		r4.setName("Coffee3");
		r4.setPrice(50);
		r4.setAmtCoffee(3);
		r4.setAmtMilk(1);
		r4.setAmtSugar(1);
		r4.setAmtChocolate(0);	
		
		Recipe [] r = new Recipe[] {r4, r3, r2, r1};
		
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);

		assertSame(r[0].getName(), cm.getRecipes()[0].getName());
		assertSame(r[0].getPrice(), cm.getRecipes()[0].getPrice());
		assertSame(r[0].getAmtCoffee(), cm.getRecipes()[0].getAmtCoffee());
		assertSame(r[0].getAmtMilk(), cm.getRecipes()[0].getAmtMilk());
		assertSame(r[0].getAmtSugar(), cm.getRecipes()[0].getAmtSugar());
		assertSame(r[0].getAmtChocolate(), cm.getRecipes()[0].getAmtChocolate());
		
		assertSame(r[1].getName(), cm.getRecipes()[1].getName());
		assertSame(r[1].getPrice(), cm.getRecipes()[1].getPrice());
		assertSame(r[1].getAmtCoffee(), cm.getRecipes()[1].getAmtCoffee());
		assertSame(r[1].getAmtMilk(), cm.getRecipes()[1].getAmtMilk());
		assertSame(r[1].getAmtSugar(), cm.getRecipes()[1].getAmtSugar());
		assertSame(r[1].getAmtChocolate(), cm.getRecipes()[1].getAmtChocolate());
		
		assertSame(r[2].getName(), cm.getRecipes()[2].getName());
		assertSame(r[2].getPrice(), cm.getRecipes()[2].getPrice());
		assertSame(r[2].getAmtCoffee(), cm.getRecipes()[2].getAmtCoffee());
		assertSame(r[2].getAmtMilk(), cm.getRecipes()[2].getAmtMilk());
		assertSame(r[2].getAmtSugar(), cm.getRecipes()[2].getAmtSugar());
		assertSame(r[2].getAmtChocolate(), cm.getRecipes()[2].getAmtChocolate());
		
		assertSame(r[3].getName(), cm.getRecipes()[3].getName());
		assertSame(r[3].getPrice(), cm.getRecipes()[3].getPrice());
		assertSame(r[3].getAmtCoffee(), cm.getRecipes()[3].getAmtCoffee());
		assertSame(r[3].getAmtMilk(), cm.getRecipes()[3].getAmtMilk());
		assertSame(r[3].getAmtSugar(), cm.getRecipes()[3].getAmtSugar());
		assertSame(r[3].getAmtChocolate(), cm.getRecipes()[3].getAmtChocolate());
	}
	
	/**
	 * Tests if the getRecipe() returns false if when compared with an array with a null recipe
	 */
	public void testGetRecipes2()
	{
		Recipe r2 = new Recipe();
		
		r2.setName("Coffee1");
		r2.setPrice(50);
		r2.setAmtCoffee(3);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(0);
		
		Recipe r3 = new Recipe();
		
		r3.setName("Coffee2");
		r3.setPrice(50);
		r3.setAmtCoffee(3);
		r3.setAmtMilk(1);
		r3.setAmtSugar(1);
		r3.setAmtChocolate(0);
		
		Recipe r4 = new Recipe();
		
		r4.setName("Coffee3");
		r4.setPrice(50);
		r4.setAmtCoffee(3);
		r4.setAmtMilk(1);
		r4.setAmtSugar(1);
		r4.setAmtChocolate(0);	
		
		Recipe [] r = new Recipe[] {r4, r3, null, r1};
		
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);

		assertNotSame(r, cm.getRecipes());
		
	}
	
	/**
	 * Tests if you can add a recipe when there is no sugar.
	 */
	public void testAddInventory1()
	{
		assertTrue(cm.addInventory(16, 16, 16, 16));
		
		assertSame(31, cm.checkInventory().getChocolate());
		assertSame(31, cm.checkInventory().getMilk());
		assertSame(31, cm.checkInventory().getSugar());
		assertSame(31, cm.checkInventory().getCoffee());
	}
	
	/**
	 * Tests if you can add sugar when their is a sugarS
	 */
	public void testAddInventory2()
	{
		assertFalse(cm.addInventory(-1, -1, -1, -1));
	}
	
	/**
	 * Tests if you can add a recipe when there is no sugar.
	 */
	public void testAddInventory3()
	{
		assertTrue(cm.addInventory(1, 1, 0, 0));
	}
	
	/**
	 * Tests if you can add a recipe when there is no sugar.
	 */
	public void testAddInventory4()
	{
		assertTrue(cm.addInventory(0, 0, 0, 0));
	}
}
