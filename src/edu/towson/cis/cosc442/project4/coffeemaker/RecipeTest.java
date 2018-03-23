package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class RecipeTest extends TestCase{
	Recipe rec;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	
	/**
	 *Creates a recipe for the test
	 */
	@Before
	public void setUp() throws Exception {
		rec = new Recipe();
	}
	
	/**
	 * Tests if the user can successfully set the amount of chocolate
	 */
	@Test
	public void testSetAmtChocolate1()
	{
		rec.setAmtChocolate(100);
		assertSame(100, rec.getAmtChocolate());
		
	}
	
	/**
	 * Tests if the user can't set the amount of chocolate if the set amount is less than 0
	 */
	@Test
	public void testSetAmtChocolate2()
	{
		rec.setAmtChocolate(-1);
		assertSame(0, rec.getAmtChocolate());
		
	}
	
	/**
	 * Tests if you can add a recipe when there is no sugar.
	 */
	@Test
	public void testSetAmtChocolate3()
	{
		rec.setAmtChocolate(-1000000);
		assertSame(0, rec.getAmtChocolate());
		
		rec.setAmtChocolate(0);
		assertSame(0, rec.getAmtChocolate());
		
		rec.setAmtChocolate(-100);
		assertSame(0, rec.getAmtChocolate());
		
		rec.setAmtChocolate(-100);
		assertNotSame(100, rec.getAmtChocolate());
		
	}
	
	

	
	
	
	/**
	 * Tests if the user can successfully set the amount of sugar
	 */
	public void testSetAmtSugar1()
	{
		rec.setAmtSugar(1);
		assertEquals(1, rec.getAmtSugar(), 0.1000);
	}
	
	/**
	 * Tests if the user can't set the amount of sugar if the set amount is less than 0
	 */
	public void testSetAmtSugar2()
	{
		rec.setAmtSugar(-1);
		assertEquals(0, rec.getAmtSugar(), 0.1000);
	}
	
	/**
	 * Tests if the user can successfully set the amount of sugar
	 */
	public void testSetAmtSugar3()
	{
		rec.setAmtSugar(0);
		assertEquals(0, rec.getAmtSugar(), 0.1000);
	}
	
	/**
	 * Tests if the user can successfully set the amount of coffee
	 */
	public void testSetAmtCoffee1()
	{
		rec.setAmtCoffee(1);
		assertEquals(1, rec.getAmtCoffee(), 0.1000);
	}
	
	/**
	 * Tests if the user can't set the amount of coffee if the set amount is less than 0
	 */
	public void testSetAmtCoffee2()
	{
		rec.setAmtCoffee(-1);
		assertEquals(0, rec.getAmtCoffee(), 0.1000);
	}
	
	public void testSetAmtCoffee3()
	{
		rec.setAmtCoffee(0);
		assertEquals(0, rec.getAmtCoffee(), 0.1000);
	}
	
	/**
	 * Tests if the user can set the correct amount of milk
	 */
	public void testSetAmtMilk1()
	{
		rec.setAmtMilk(1);
		assertEquals(1, rec.getAmtMilk(), 0.1000);
	}
	
	/**
	 * Tests if the user can't set the amount of milk if the set amount is less than 0
	 */
	public void testSetAmtMilk2()
	{
		rec.setAmtMilk(-1);
		assertEquals(0, rec.getAmtMilk(), 0.1000);
	}
	
	/**
	 * Tests if the user can set the correct amount of milk
	 */
	public void testSetAmtMilk3()
	{
		rec.setAmtMilk(0);
		assertEquals(0, rec.getAmtMilk(), 0.1000);
	}
	
	/**
	 * Tests if recipes toString method works (it only prints the names of recipes)
	 */
	public void testToString()
	{
		rec.setName("Coffee");
		assertSame("Coffee", rec.toString());
	}

	/**
	 * Tests if the user can set the recipe price correctly
	 */
	public void testSetPrice1()
	{
		rec.setPrice(10);
		assertSame(10, rec.getPrice());
	}
	
	/**
	 * Tests if the user sets the recipe price at a negative value, the price of 
	 * the recipe is 0
	 */
	public void testSetPrice2()
	{
		rec.setPrice(-1);
		assertSame(0, rec.getPrice());
	}
	
	/**
	 * Tests if the user can set the correct amount of milk
	 */
	public void testSetPrice3()
	{
		rec.setPrice(0);
		assertSame(0, rec.getPrice());
	}
	
	
	@After
	public void tearDown() throws Exception {
	}


}
