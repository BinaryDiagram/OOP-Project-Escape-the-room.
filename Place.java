/*
 * This is the place super class. It holds all the main details about the room the player is trying to escape.
 */
import java.util.ArrayList;

public class Place {
	public final static int NOCOMPAT = 0;
	public final static int KEYCOMPAT = 1;
	public static final int LIGHTBULBCOMPAT = 2;
	public final static int MINFURNITURE = 3;
	public final static int MAXFURNITURE = 6;
	
	int height;
	public final static int MINHEIGHT = 10;
	public final static int MAXHEIGHT = 20;
	int width;
	public final static int MINWIDTH = 5;
	public final static int MAXWIDTH = 30;
	int length;
	public final static int MINLENGTH = 15;
	public final static int MAXLENGTH = 40;
	int maxFurniture;
	//TODO change description to work for story telling
	String DESCRIPTION;
	ArrayList <Furniture> furniture = new ArrayList <Furniture>(maxFurniture);
	
	/**
	 * The place constructor.
	 * @param height The height of the room.
	 * @param width The width of the room
	 * @param length The length of the room.
	 * @param maxFurniture The max number of furniture allowed in the room.
	 */
	Place(int height,int width,int length, int maxFurniture){
		setHeight(height);
		setWidth(width);
		setLength(length);
		setMaxFurniture(maxFurniture);
	}
	/**
	 * This returns a description of the place.
	 */
	public String toString() {
		String furnitureDiscription = "";
		String discription = "This room has a \n";
		for(int i = 0; i< this.furniture.size(); i++) {
			if(this.furniture.get(i).getName().equals(Furniture.DOOR)) {
				furnitureDiscription = Output.clownDoor() + Output.clownDoorArt();
			}
			if(this.furniture.get(i).getName().equals(Furniture.CHAIR)) {
				furnitureDiscription = Output.clownChair() + Output.clownChairArt();
			}
			if(this.furniture.get(i).getName().equals(Furniture.CEILINGFAN)) {
				furnitureDiscription = Output.clownCeilingFan() + Output.ceilingFanArt();
			}
			if(this.furniture.get(i).getName().equals(Furniture.WINDOW)) {
				furnitureDiscription = Output.clownWindow() + Output.windowArt();
			}
			if(this.furniture.get(i).getName().equals(Furniture.DESK)) {
				furnitureDiscription = Output.clownDesk() + Output.deskArt();
			}
			if(this.furniture.get(i).getName().equals(Furniture.TABLE)) {
				furnitureDiscription = Output.clownTable() + Output.tableArt();
			}
			discription = discription + this.furniture.get(i).toString() + ", " + furnitureDiscription + "\n"; 
		}
		discription = discription + "and thats all.";
		return Output.stars() + "\n" +
				"This room is " + this.height + "ft high" + "\n" +
				"This room is " + this.width + "ft wide" + "\n" +
				"This room is " + this.length + "ft long" + "\n" +
				discription + "\n" +
				Output.stars();
	}
	/**
	 * Sets the height of the room. 
	 * @param height The new height of the room
	 * @return false If the room is not within height standards. true - If the room is within height standards.
	 */
	public boolean setHeight(int height) {
		if(height < MINHEIGHT || height > MAXHEIGHT) {
			System.err.println("The hight of this room must be between " + MINHEIGHT + " and " + MAXHEIGHT + ".");
			return false;
		}
		else {
			this.height = height;
			return true;
		}
	}
	/**
	 * Sets the width of the room.
	 * @param width The new width of the room.
	 * @return false If the room is not within width standards. true - If the room is within width standards.
	 */
	public boolean setWidth(int width) {
		if(width < MINWIDTH || width > MAXWIDTH) {
			System.err.println("The width of this room must be between " + MINWIDTH + " and " + MAXWIDTH + ".");
			return false;
		}
		else {
			this.width = width;
			return true;
		}
	}
	/**
	 * Sets the length of the room.
	 * @param length The new length of the room.
	 * @return false If the room is not within length standards. true - If the room is within length standards.
	 */
	public boolean setLength(int length) {
		if(length >= MINLENGTH && length <= MAXLENGTH) {
			this.length = length;
			return true;
		}
		else {
			System.out.println("The length of this room must be between " + MINLENGTH + " and " + MAXLENGTH + ".");
			return false;
		}
	}
	/**
	 * Sets the maximum amount of furniture allowed in the room.
	 * @param maxFurniture The new maximum amount of furniture in the room.
	 * @return false If the room is not within furniture standards. true - If the room is within furniture standards.
	 */
	public boolean setMaxFurniture(int maxFurniture) {
		if(height < MINFURNITURE) {
			System.err.println("This room must have more than " + this.maxFurniture + ".");
			return false;
		}
		else {
			this.maxFurniture = maxFurniture;
			return true;
		}
	}
	/**
	 * Sets the description for the room.
	 * @param description The new description of the room.
	 */
	public void setDescription(String description) {
		this.DESCRIPTION = description;
	}
	/**
	 * Gets the height of the room.
	 * @return this.height The height of the room.
	 */
	public int getHeight() {
		return this.height;
	}
	/**
	 * Gets the width of the room.
	 * @return this.width The width of the room.
	 */
	public int getWidth() {
		return this.width;
	}
	/**
	 * Gets the length of the room.
	 * @return this.length The length of the room.
	 */
	public int getLength() {
		return this.length;
	}
	/**
	 * Gets the maximum number of furniture allowed in the room.
	 * @return this.maxFurniture The max number of furniture allowed in the room.
	 */
	public int getMaxFurniture() {
		return this.maxFurniture;
	}

}
