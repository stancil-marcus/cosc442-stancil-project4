package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InventoryTest extends TestCase{
	Inventory inv;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * This method initializes the inventory variable
	 */
	@Before
	public void setUp() throws Exception {
		inv = new Inventory();
	}
	
	/**
	 * This tests in the getChocolate() method returns the correct amount of chocolate
	 */
	public void testGetChocolate()
	{
		assertEquals(15, inv.getChocolate(), 0.1000);
	}
	
	/**
	 * This tests in the getSugar() method returns the correct amount of sugar
	 */
	public void testGetSugar()
	{
		assertEquals(15, inv.getSugar(), 0.100);
	}
	
	/**
	 * This tests in the getMilk() method returns the correct amount of milk
	 */
	public void testGetMilk()
	{
		assertEquals(15, inv.getMilk(), 0.100);
	}
	
	/**
	 * This tests in the getCoffee() method returns the correct amount of coffee
	 */
	public void testGetCofee()
	{
		assertEquals(15, inv.getCoffee(), 0.100);
	}
	
	/**
	 * This tests if the user can set the correct amount of chocolate
	 */
	public void testSetChocolate1()
	{
		inv.setChocolate(16);
		assertEquals(16, inv.getChocolate(), 0.1000);
	}
	
	/**
	 * This tests if the user can't amount of chocolate is the set value is less than 0
	 */
	public void testSetChocolate2()
	{
		inv.setChocolate(-1);
		assertEquals(0, inv.getChocolate(), 0.1000);
	}
	
	/**
	 * This tests if the user can set the correct amount of sugar
	 */
	public void testSetSugar1()
	{
		inv.setSugar(16);
		assertEquals(16, inv.getSugar(), 0.1000);
	}
	
	/**
	 * This tests if the user can't amount of sugar is the set value is less than 0
	 */
	public void testSetSugar2()
	{
		inv.setSugar(-1);
		assertEquals(0, inv.getSugar(), 0.1000);
	}
	
	/**
	 * This tests if the user can set the correct amount of milk
	 */
	public void testSetMilk1()
	{
		inv.setMilk(16);
		assertEquals(16, inv.getMilk(), 0.1000);
	}
	
	/**
	 * This tests if the user can't amount of milk is the set value is less than 0
	 */
	public void testSetMilk2()
	{
		inv.setMilk(-1);
		assertEquals(0, inv.getMilk(), 0.1000);
	}
	
	/**
	 * This tests if the user can set the correct amount of coffee
	 */
	public void testSetCoffee1()
	{
		inv.setCoffee(16);
		assertEquals(16, inv.getCoffee(), 0.1000);
	}
	
	/**
	 * This tests if the user can't amount of coffee is the set value is less than 0
	 */
	public void testSetCoffee2()
	{
		inv.setCoffee(-1);
		assertEquals(0, inv.getCoffee(), 0.1000);
	}
	
	/**
	 * This tests if the enoughIngredients method returns true if there indeed is enough ingredients
	 */
	public void testEnoughIngredients1()
	{
		Recipe r2 = new Recipe();
		
		r2.setName("Coffee1");
		r2.setPrice(15);
		r2.setAmtCoffee(15);
		r2.setAmtMilk(15);
		r2.setAmtSugar(15);
		r2.setAmtChocolate(15);
		
		assertTrue(inv.enoughIngredients(r2));
	}
	
	/**
	 * This tests if the enoughIngredients method returns false if there isn't enough ingredients
	 */
	public void testEnoughIngredients2()
	{
		Recipe r2 = new Recipe();
		
		r2.setName("Coffee1");
		r2.setPrice(50);
		r2.setAmtCoffee(50);
		r2.setAmtMilk(200);
		r2.setAmtSugar(1000);
		r2.setAmtChocolate(50);
		
		assertFalse(inv.enoughIngredients(r2));
	}
	/**
	 * This tests if the enoughIngredients method returns false if there isn't enough ingredients
	 */
	public void testEnoughIngredients3()
	{
		Recipe r2 = new Recipe();
		
		r2.setName("Coffee1");
		r2.setPrice(50);
		r2.setAmtCoffee(100);
		r2.setAmtMilk(50);
		r2.setAmtSugar(15);
		r2.setAmtChocolate(50);
		
		assertFalse(inv.enoughIngredients(r2));
	}
	
	/**
	 * Tests if the toString() method returns the correct string
	 */
	public void testToString() {
		
		assertEquals("Coffee: " + inv.getCoffee() + System.lineSeparator() +
				"Milk: " + inv.getMilk() + System.lineSeparator() +
				"Sugar: " + inv.getSugar() + System.lineSeparator() +
				"Chocolate: " + inv.getChocolate() + System.lineSeparator(), inv.toString());
	}
	

	@After
	public void tearDown() throws Exception {
	}

	

}
