import java.util.ArrayList;

public class RoomPuzzleRandom extends Place {
	public final static int KEYSPAWNPERCENT = 100;
	public final static int LIGHTBULBSPAWNPERCENT = 100;

	RoomPuzzleRandom(int height, int width, int length, int maxFurniture) {
		super(height, width, length, maxFurniture);		
		int numberOfFurniture = IR4.getRandomNumber(MINFURNITURE, MAXFURNITURE);
		
		// trigger type need to be random but always in pairs.
		// if it has a trigger type one of them needs to be triggerable.
		// There can only be one exit. that exit needs to be set to NONEXIT until it is oppened.
			// The exit needs to wrok with a key or with the exit trigger.
		// if something is a lightbulb trigger it needs to be lightbulb compatable
		// if there is going to be a key in furniture allow for either a trigger exit or a key exit.
		
		//String name, int maxItems, int compatibility, boolean exit, boolean exitOpen, boolean isTrigger, boolean triggerable, int triggerType
		Furniture door   = new Furniture(Furniture.DOOR, Furniture.NOITEMS, NOCOMPAT, Furniture.NONEXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.NOTRIGGER);
		Furniture window = new Furniture(Furniture.WINDOW, Furniture.NOITEMS, NOCOMPAT, Furniture.NONEXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.NOTRIGGER);
		Furniture desk   = new Furniture(Furniture.DESK, Furniture.SOMEITEMS , NOCOMPAT, Furniture.NONEXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.NOTRIGGER);
		Furniture chair  = new Furniture(Furniture.CHAIR, Furniture.ANITEM, NOCOMPAT, Furniture.NONEXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.NOTRIGGER);
		Furniture table  = new Furniture(Furniture.TABLE, Furniture.SOMEITEMS , NOCOMPAT, Furniture.NONEXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.NOTRIGGER);
		Furniture celingFan = new Furniture(Furniture.CEILINGFAN, Furniture.ANITEM, NOCOMPAT, Furniture.NONEXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.NOTRIGGER);
		
		while(furniture.size() < numberOfFurniture) {
			int random = IR4.getRandomNumber(0, numberOfFurniture);
			if(random == 0 && !this.furniture.contains(door)) {
				this.furniture.add(door);
			}
			if(random == 1 && !this.furniture.contains(window)) {
				this.furniture.add(window);
			}
			if(random == 2 && !this.furniture.contains(desk)) {
				this.furniture.add(desk);
			}
			if(random == 3 && !this.furniture.contains(chair)) {
				this.furniture.add(chair);
			}
			if(random == 4 && !this.furniture.contains(celingFan)) {
				this.furniture.add(celingFan);
			}
			if(random == 5 && !this.furniture.contains(table)) {
				this.furniture.add(table);
			}
		}			
		Items skelitonKey = new Items(Items.KEY, Items.SINGLEUSE, Place.KEYCOMPAT);
		Items fashionableLightbulb = new Items(Items.LIGHTBULB, Items.SINGLEUSE, Place.LIGHTBULBCOMPAT);
		Items lightbulb = new Items(Items.LIGHTBULB, Items.SINGLEUSE, Place.LIGHTBULBCOMPAT);
		//Sets a random furniture to become an exit to the room.
		int getRandomFurnitureExit = IR4.getRandomNumber(0, this.furniture.size()-1);
		this.furniture.get(getRandomFurnitureExit).setExit(Furniture.EXIT);
		this.furniture.get(getRandomFurnitureExit).setCompatibility(KEYCOMPAT);
		this.furniture.get(getRandomFurnitureExit).setTriggerType(Furniture.OPENEXIT);
//		System.err.println("exit is " + this.furniture.get(getRandomFurnitureExit).getName());
		
		int randomRoomSetup = IR4.getRandomNumber(0, 2);
		if(randomRoomSetup == 0) {
//			System.err.println("Room setup 0 ");
			//Set up a random key placement
			int getRandomFurniture = IR4.getRandomNumber(0, this.furniture.size()-1);
			this.furniture.get(getRandomFurniture).setItems(skelitonKey);
		}
		if(randomRoomSetup == 1) {
//			System.err.println("Room setup 1 ");
			//Set up if something is a lightbulb trigger or not.
			// This lightbulbe trigger will open the exit.
			int getRandomFurniture = IR4.getRandomNumber(0, this.furniture.size()-1);
			this.furniture.get(getRandomFurniture).setItems(lightbulb);
			
			getRandomFurniture = IR4.getRandomNumber(0, this.furniture.size()-1);
			this.furniture.get(getRandomFurniture).setIsTrigger(true);
			this.furniture.get(getRandomFurniture).setCompatibility(LIGHTBULBCOMPAT);
			this.furniture.get(getRandomFurniture).setTriggerType(Furniture.OPENEXIT);
		}
		if(randomRoomSetup == 2) {
//			System.err.println("Room setup 2 ");
			// set up light bulb to triger something else to be searchable for a key.
			int getRandomFurniture = IR4.getRandomNumber(0, this.furniture.size()-1);
			this.furniture.get(getRandomFurniture).setItems(fashionableLightbulb);
			
			getRandomFurniture = IR4.getRandomNumber(0, this.furniture.size()-1);
			while(getRandomFurniture == getRandomFurnitureExit) {
				getRandomFurniture = IR4.getRandomNumber(0, this.furniture.size()-1);
			}
			this.furniture.get(getRandomFurniture).setIsTrigger(true);
			this.furniture.get(getRandomFurniture).setCompatibility(LIGHTBULBCOMPAT);
			this.furniture.get(getRandomFurniture).setTriggerType(Furniture.ADDKEY);
			
			int getRandomFurnitureTriggered = IR4.getRandomNumber(0, this.furniture.size()-1);
			while (getRandomFurnitureTriggered == getRandomFurniture) {
				getRandomFurnitureTriggered = IR4.getRandomNumber(0, this.furniture.size()-1);
			}
			this.furniture.get(getRandomFurnitureTriggered).setTriggerType(Furniture.ADDKEY);
		}
	}
	
	public static void setupFurniture(ArrayList<Furniture> furniture, int numberOfFurniture) {
		
	}
}
