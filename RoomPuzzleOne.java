/*
 * This is the second puzzle created, it is a simple puzzle but gives the player an idea of what to expect in the game.
 */
public class RoomPuzzleOne extends Place{

	/**
	 * The second puzzle room constructor.
	 * @param height The height of the room.
	 * @param width The width of the room.
	 * @param length The length of the room.
	 * @param maxFurniture The max number of allowed furniture in the room.
	 */
	RoomPuzzleOne(int hight, int width, int length, int maxFurniture) {
		super(hight, width, length, maxFurniture);
		boolean placeLightBulb = true;
				
		//String name, int maxItems, int compatibility, boolean exit, boolean exitOpen, boolean isTrigger, boolean triggerable, int triggerType
		Furniture door    = new Furniture(Furniture.DOOR, Furniture.NOITEMS, KEYCOMPAT, Furniture.EXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.OPENEXIT);
		Furniture windows = new Furniture(Furniture.WINDOW, Furniture.NOITEMS, NOCOMPAT, Furniture.NONEXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.NOTRIGGER);
		Furniture desk    = new Furniture(Furniture.DESK, Furniture.SOMEITEMS , NOCOMPAT, Furniture.NONEXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.NOTRIGGER);
		Furniture chair   = new Furniture(Furniture.CHAIR, Furniture.ANITEM, NOCOMPAT, Furniture.NONEXIT, Furniture.NONEXIT, Furniture.NONTRIGGER, Furniture.NONTRIGGER, Furniture.NOTRIGGER);
		Furniture celingFan = new Furniture(Furniture.CEILINGFAN, Furniture.ANITEM, LIGHTBULBCOMPAT, Furniture.NONEXIT, Furniture.NONEXIT, Furniture.TRIGGER, Furniture.NONTRIGGER, Furniture.OPENEXIT);
		
		this.furniture.add(door);
		this.furniture.add(windows);
		this.furniture.add(desk);
		this.furniture.add(chair);
		this.furniture.add(celingFan);
		
		Items lightBulb = new Items(Items.LIGHTBULB, Items.SINGLEUSE, LIGHTBULBCOMPAT);
		
		while(placeLightBulb) {
			int rnd = IR4.getRandomNumber(0, this.furniture.size()-1);
//			System.out.println("size: " + this.furniture.size() + " number: " + numberOfFurniture + " rnd: " + rnd);
			for(int i = 0; i < this.furniture.size(); i++) {
				if(rnd == i && this.furniture.get(i).getMaxItems() > 0) {
					this.furniture.get(i).items.add(lightBulb);
					placeLightBulb = false;
				}
			}
		}
	}

}
