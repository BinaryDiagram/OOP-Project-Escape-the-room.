/*
 * This is the player class that holds all of the information for the player playing the game.
 */
import java.util.ArrayList;

public class Player {
	int health;
	String name;
	int minItems = 1;
	int maxItems;
	ArrayList <Items> items = new ArrayList <Items>(maxItems);
	int minHealth = 20;
	
	/**
	 * The player constructor.
	 * @param health The players health
	 * @param name The name of the player.
	 * @param maxItems The max number of items the player can hold at one time.
	 */
	Player(int health, String name, int maxItems){
		setHealth(health);
		this.name = name;
		setMaxItems(maxItems);
	}
	/**
	 * This returns the related information as a string.
	 */
	public String toString() {
		return Output.stars() + "\n" +
			   "Player Status:\n" +
//			   "Player health is: " + this.health + "\n" +
			   "Player name is:   " + this.name + "\n" +
			   "Your current items are: " + "\n" +
			   getItems() +
			   Output.stars();
	}
	
	// Getters
	/**
	 * This gets the players health.
	 * @return this.health The players current health.
	 */
	public int getHealth() {
		return this.health;
	}
	/**
	 * This gets the players name.
	 * @return this.name The players name.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * This gets the players maximum amount of items they can carry.
	 * @return this.maxItems The maximum amount of items a player can carry.
	 */
	public int getMaxItems() {
		return this.maxItems;
	}
	/**
	 * Gets the items the player has.
	 * @return items A list of items the player has currently.
	 */
	public String getItems() {
		String items = "You have no items.\n";
		
		if(this.items.size() > 0) {
			items = "";
			for(int i = 0; i < this.items.size(); i++) {
				items = items + this.items.get(i).toString() + "\n";
			}
		}
		return items;
	}
	
	public Items getItemObjectByName(String name) {
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getItemName().equals(name)) {
				return items.get(i);
			}
		}
		
		return null;
	}
	
	// Setters
	/**
	 * Sets the players current health.
	 * @param health The new health of the player.
	 * @return false If the new health is lower than the minimum allowed. True - The new health is above the minimum.
	 */
	public boolean setHealth(int health) {
		if(health < this.minHealth) {
			System.err.println("The players health may not be below " + this.minHealth + ".");
			return false;
		}
		else {
			this.health = health;
			return true;
		}
	}
	/**
	 * Sets the players name.
	 * @param name The new name of the player.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Sets the max amount of items the player can hold.
	 * @param maxItems The new max amount of items.
	 * @return false If the new max items is below the minimum. True - If the new max items is above the minimum.
	 */
	public boolean setMaxItems(int maxItems) {
		if(maxItems < this.minItems) {
			System.err.println("The player must have more items than " + this.minItems + ".");
			return false;
		}
		else {
			this.maxItems = maxItems;
			return true;
		}
	}
	/**
	 * Sets a new item in the players inventory.
	 * @param item The new item to be added to the inventory.
	 */
	public void setItems(Items item) {
		this.items.add(item);
	}
	
	// Remover
	/**
	 * Removes items from the players inventory.
	 * @param name The name of the item to be removed.
	 */
	public void removeItems(String name) {
		for(int i = 0; i < this.items.size(); i++) {
			if(this.items.get(i).getItemName().equals(name)) {
				this.items.remove(i);
			}
		}
	}

}
