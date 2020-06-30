/*
 * The first room the player will need to escape, It has a few fixed items and a few random items.
 * Only one piece of furniture will hold a key.
 */
public class StartingRoom extends Place {

	/**
	 * The starting room constructor.
	 * @param height The height of the room.
	 * @param width The width of the room.
	 * @param length The length of the room.
	 * @param maxFurniture The max number of allowed furniture in the room.
	 */
	StartingRoom(int height, int width, int length, int maxFurniture) {
		super(height, width, length, maxFurniture);
		boolean placeKey = true;
		
		int numberOfFurniture = IR4.getRandomNumber(MINFURNITURE, maxFurniture);
		
		//String name, int maxItems, int compatibility, boolean exit, boolean exitOpen, boolean isTrigger, boolean triggerable, int triggerType
		Furniture door   = new Furniture(Furniture.DOOR, Furniture.NOITEMS, KEYCOMPAT, Furniture.EXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.NOTRIGGER);
		Furniture window = new Furniture(Furniture.WINDOW, Furniture.NOITEMS, NOCOMPAT, Furniture.NONEXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.NOTRIGGER);
		Furniture desk   = new Furniture(Furniture.DESK, Furniture.SOMEITEMS , NOCOMPAT, Furniture.NONEXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.NOTRIGGER);
		Furniture chair  = new Furniture(Furniture.CHAIR, Furniture.ANITEM, NOCOMPAT, Furniture.NONEXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.NOTRIGGER);
		Furniture table  = new Furniture(Furniture.TABLE, Furniture.SOMEITEMS , NOCOMPAT, Furniture.NONEXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.NOTRIGGER);
		Furniture celingFan = new Furniture(Furniture.CEILINGFAN, Furniture.ANITEM, NOCOMPAT, Furniture.NONEXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.NOTRIGGER);
		
		this.furniture.add(door);
		this.furniture.add(window);
		
		for(int i = 0; i < numberOfFurniture; i++) {
			int random = IR4.getRandomNumber(0, numberOfFurniture);
			if(random == 0 && !this.furniture.contains(desk)) {
				this.furniture.add(desk);
			}
			if(random == 1 && !this.furniture.contains(chair)) {
				this.furniture.add(chair);
			}
			if(random == 2 && !this.furniture.contains(celingFan)) {
				this.furniture.add(celingFan);
			}
			if(random == 3 && !this.furniture.contains(table)) {
				this.furniture.add(table);
			}
		}
		
		Items key = new Items(Items.KEY, Items.SINGLEUSE, Place.KEYCOMPAT);
		
		while(placeKey) {
			int rnd = IR4.getRandomNumber(0, this.furniture.size()-1);
//			System.out.println("size: " + this.furniture.size() + " number: " + numberOfFurniture + " rnd: " + rnd);
			for(int i = 0; i < this.furniture.size(); i++) {
				if(rnd == i && this.furniture.get(i).getMaxItems() > 0) {
					this.furniture.get(i).items.add(key);
					placeKey = false;
				}
			}
		}
	}
}
