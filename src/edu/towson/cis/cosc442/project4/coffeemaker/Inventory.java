package edu.towson.cis.cosc442.project4.coffeemaker;

/**
 * Inventory for the coffee maker
 * @author Josh
 * @version $Revision: 1.0 $
 */
public class Inventory {
    
    private static int coffee;
    private static int milk;
    private static int sugar;
    private static int chocolate;
    
    public Inventory() {
    	setCoffee(15);
    	setMilk(15);
    	setSugar(15);
    	setChocolate(15);
    }
    
    /**
     * Method getChocolate.
     * @return int
     */
    public int getChocolate() {
        return chocolate;
    }
    /**
     * Method setChocolate.
     * @param chocolate int
     */
    public void setChocolate(int chocolate) {
    	if(chocolate > -1) {
    		Inventory.chocolate = chocolate;
    	}
    	else {
    		Inventory.chocolate = 0;
    	}
        
    }
    /**
     * Method getCoffee.
     * @return int
     */
    public int getCoffee() {
        return coffee;
    }
    /**
     * Method setCoffee.
     * @param coffee int
     */
    public void setCoffee(int coffee) {
    	if(coffee > -1) {
    		Inventory.coffee = coffee;
    	}
    	else {
    		Inventory.coffee = 0;
    	}
    }
    /**
     * Method getMilk.
     * @return int
     */
    public int getMilk() {
        return milk;
    }
    /**
     * Method setMilk.
     * @param milk int
     */
    public void setMilk(int milk) {
    	if(milk > -1) {
    		Inventory.milk = milk;
    	}
    	else {
    		Inventory.milk = 0;
    	}
    }
    /**
     * Method getSugar.
     * @return int
     */
    public int getSugar() {
        return sugar;
    }
    /**
     * Method setSugar.
     * @param sugar int
     */
    public void setSugar(int sugar) {
    	if(sugar > -1) {
    		Inventory.sugar = sugar;
    	}
    	else {
    		Inventory.sugar = 0;
    	}
    }
    
    /**
     * Returns true if there are enough ingredients to make
     * the beverage.
     * @param r
    
     * @return boolean */
    public boolean enoughIngredients(Recipe r) {
        boolean isEnough = false;
        
        if((Inventory.coffee >= r.getAmtCoffee()) && (Inventory.milk >= r.getAmtMilk()) && (Inventory.sugar >= r.getAmtSugar()) && (Inventory.chocolate >= r.getAmtChocolate())){
            isEnough = true;
        }
        return isEnough;
    }
    
    /**
     * Method toString.
     * @return String
     */
    public String toString() {
    	return "Coffee: " + getCoffee() + System.lineSeparator() +
			"Milk: " + getMilk() + System.lineSeparator() +
			"Sugar: " + getSugar() + System.lineSeparator() +
			"Chocolate: " + getChocolate() + System.lineSeparator();
    }
}
