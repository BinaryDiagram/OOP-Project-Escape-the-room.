/*
 * This is the furniture super class, it holds all the regular values for furniture.
 */
import java.util.ArrayList;

public class Furniture {
	public final static String DOOR = "door";
	public final static String TABLE = "table";
	public final static String CHAIR = "chair";
	public final static String CEILINGFAN = "ceiling fan";
	public final static String DESK = "desk";
	public final static String WINDOW = "window";
	
	public final static int NOITEMS = 0;
	public final static int ANITEM = 1;
	public final static int SOMEITEMS = 2;
	
	public final static boolean EXIT = true;
	public final static boolean NONEXIT = false;
	public final static boolean TRIGGER = true;
	public final static boolean NONTRIGGER = false;
	public final static boolean SEARCHED = true;
	public final static boolean NOTSEARCHED = false;
	public static final String[] QUCKCHOOSEFURNITURE = {"d", "t", "c", "ce", "de", "w"};
	
	//TODO finish the multi stage trigger system
	public final static int NOTRIGGER = 0;
	public final static int OPENEXIT = 1;
	public final static int ADDKEY = 2;
	public final static int ADDLIGHTBULB = 3;
	
	int maxItems;
	String name;
	boolean searched;
	boolean exit;
	boolean exitOpen;
	boolean isTrigger;
	boolean triggerable;
	int compatibility;
	int triggerType;
	public ArrayList <Items> items = new ArrayList <Items>(maxItems);
	
	/**
	 * The furniture constructor.
	 * @param name The name of the furniture.
	 * @param maxItems The max number of items the furniture can have in it.
	 * @param compatibility What the furniture is compatible with. 
	 * @param exit Wither or not the furniture is an exit to the room.
	 * @param exitOpen Wither or not the exit to the room is open.
	 * @param isTrigger Wither or not this piece of furniture can trigger something else in the room.
	 * @param triggerable Can something else in the room trigger this piece of furniture to do something.
	 */
	Furniture(String name, int maxItems, int compatibility, boolean exit, boolean exitOpen, boolean isTrigger, boolean triggerable, int triggerType){
		this.maxItems = maxItems;
		this.name = name;
		this.searched = false;
		this.compatibility = compatibility;
		this.exit = exit;
		this.exitOpen = exitOpen;
		this.isTrigger = isTrigger;
		this.triggerable = triggerable;
		this.triggerType = triggerType;
	}
	/**
	 * This returns the name of the furniture.
	 * @return this.name The name of the furniture.
	 */
	public String toString() {
		return this.name;
	}
	
	// Getters
	/**
	 * Gets the max number of items allowed in the furniture.
	 * @return this.maxItems The max number of items allowed in the furniture.
	 */
	public int getMaxItems() {
		return this.maxItems;
	}
	/**
	 * Gets the name of the furniture.
	 * @return this.name The name of the furniture.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Gets wither or not the furniture has been searched.
	 * @return this.searched If the furniture has been searched.
	 */
	public boolean getSearched() {
		return this.searched;
	}
	/**
	 * Gets wither or not a piece of furniture is an exit to the room or not.
	 * @return this.exit Returns true or false based on wither or not the furniture is an exit or not.
	 */
	public boolean getExit() {
		return this.exit;
	}
	/**
	 * Gets wither or not the exit is open.
	 * @return this.exitOpne Returns true or false based on wither or not the exit is open.
	 */
	public boolean getExitOpen() {
		return this.exitOpen;
	}
	/**
	 * Gets wither a furniture has a trigger in it or not.
	 * @return this.isTrigger true if it is a trigger for an event false - if it is not a trigger for an event.
	 */
	public boolean getIsTrigger() {
		return this.isTrigger;
	}
	/**
	 * Gets wither or not an piece of furniture can be triggered or not.
	 * @return this.triggerable true if this furniture can be triggered false- if this furniture can not be triggered.
	 */
	public boolean getTriggerable() {
		return this.triggerable;
	}
	/**
	 * 
	 * @return
	 */
	public int getTriggerNumber() {
		return this.triggerType;
	}
	/**
	 * Gets the compatibility between an item and a piece of furniture.
	 * @return this.compatibility true if the item and furniture are compatible false - if they are not compatible.
	 */
	public int getCompatibility() {
		return this.compatibility;
	}
	/**
	 * Gets the items in the furniture.
	 * @return items Returns a string of items inside of the furniture.
	 */
	public String getItems() {
		String items = "";
		for(int i = 0; i < this.items.size(); i++) {
			items = items + this.items.get(i).getItemName() + " ";
		}
		return items;
	}
	
	
	// Setters
	/**
	 * Sets the max number of items allowed in the furniture.
	 * @param maxItems The max number of items possibly inside of the furniture.
	 */
	public void setMaxItems(int maxItems) {
		this.maxItems = maxItems;
	}
	/**
	 * Sets the furniture name
	 * @param name The new name of the furniture.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Sets searched to true or false.
	 * @param search true- if the furniture has been searched. false - if the furniture is no longer searched.
	 */
	public void setToSearched(boolean search) {
		this.searched = search;
	}
	/**
	 * Sets wither or not a piece of furniture is an exit or not
	 * @param exit true - means the furniture is now an exit. false - means the furniture is not an exit anymore.
	 */
	public void setExit(boolean exit) {
		this.exit = exit;
	}
	/**
	 * Sets the exit to open or closed.
	 * @param exitOpen true - the exit is open. false - the exit is closed.
	 */
	public void setExitOpen(boolean exitOpen) {
		this.exitOpen = exitOpen;
	}
	/**
	 * Sets a piece of furniture to be a trigger or no longer a trigger.
	 * @param trigger true - the furniture is now a trigger. false - the furniture is no longer a trigger.
	 */
	public void setIsTrigger(boolean trigger) {
		this.isTrigger = trigger;
	}
	/**
	 * Sets wither a piece of furniture is triggerable or not.
	 * @param b true - the furniture is triggerable. false - the furniture is not triggerable.
	 */
	public void setTriggerable(boolean b) {
		this.triggerable = b;
	}
	/**
	 * 
	 * @param newType
	 */
	public void setTriggerType(int newType) {
		this.triggerType = newType;
	}
	/**
	 * Sets the furniture compatibility with items
	 * @param compatibility What the furniture is compatible with.
	 */
	public void setCompatibility(int compatibility) {
		this.compatibility = compatibility;
	}
	/**
	 * Sets the new item inside of the furniture.
	 * @param item The new item to add to the furniture.
	 */
	public void setItems(Items item) {
		this.items.add(item);
	}

}
