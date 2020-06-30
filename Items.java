/*
 * This is the items super class, it holds all the regular values for items.
 */
public class Items {
	public final static String KEY = "key";
	public final static int SINGLEUSE = 1;
	public static final String LIGHTBULB = "lightbulb";
	
	public final static String [] QUICKCHOOSEPOSSIBLEITEMS = {"k", "l"};
	
	String name;
	int numberOfUses;
	int compatibility;
	
	/**
	 * The items constructor
	 * @param name The name of the item.
	 * @param numberOfUses The number of times an item can be used.
	 * @param compatibility What the item is compatible with.
	 */
	Items(String name, int numberOfUses, int compatibility){
		this.name = name;
		this.numberOfUses = numberOfUses;
		this.compatibility = compatibility;
	}
	
	public String toString() {
		return "Item: " + this.name + "\n" +
	           "      Number of uses: " + this.numberOfUses + "\n";
	}
	
	// Getters
	/**
	 * Gets the items name
	 * @return this.name The name of the item
	 */
	public String getItemName() {
		return this.name;
	}
	/**
	 * Gets the number of times an item can be used.
	 * @return this.numberOfUses The current number of uses for an item.
	 */
	public int getNumberOfUses() {
		return this.numberOfUses;
	}
	/**
	 * Gets what an item is compatible with.
	 * @return this.compatibility The things this item is compatible with.
	 */
	public int getCompatibility() {
		return this.compatibility;
	}
	
	// Setters
	/**
	 * Sets the name of the item.
	 * @param name The new name of the item.
	 */
	public void setItemName(String name) {
		this.name = name;
	}
	/**
	 * Sets the number of uses for an item.
	 * @param number The new number of uses of an item.
	 */
	public void setNumberOfUses(int number) {
		this.numberOfUses = number;
	}
	/**
	 * Sets what an item is compatible with.
	 * @param compatibility The new compatibility of the item.
	 */
	public void setCompatibility(int compatibility) {
		this.compatibility = compatibility;
	}

}
