/**
 * This class hold most of the math and processing for the game.
 * @author Cole Talbot
 *
 */
public class Processing {
	/**
	 * Decreases the items durability with each use.
	 * @param itemToUse The item the player is using.
	 * @param firstPlayer The player using the item.
	 */
	public static void itemDurability(String itemToUse, Player firstPlayer) {
		for(int x = 0; x < firstPlayer.items.size(); x++) {
			if(itemToUse.equals(firstPlayer.items.get(x).getItemName())) {
				if(firstPlayer.items.get(x).getNumberOfUses() > 1) {
					firstPlayer.items.get(x).setNumberOfUses(firstPlayer.items.get(x).getNumberOfUses() - 1);
				}
				else {
					firstPlayer.items.remove(x);
				}
			}
		}
	}

	public static void exitsOpen(Furniture furniture) {
		if(furniture.exit) {
			furniture.setExitOpen(Furniture.EXIT);
			System.out.println("The " + furniture.getName() + " opens to reveal an exit!");
			System.out.println(Output.stars());;
//			System.err.println(furniture + " should be open(true)" + furniture.exit);;
		}
		
		
	}

	public static void activateTrigger(Place place, Furniture furniture) {
		if(furniture.isTrigger) {
			Items key = new Items(Items.KEY, Items.SINGLEUSE, Place.KEYCOMPAT);
			Items lightbulb = new Items(Items.LIGHTBULB, Items.SINGLEUSE, Place.LIGHTBULBCOMPAT);
			
			furniture.setIsTrigger(false);
			
			int triggerType = furniture.getTriggerNumber();
			
			for(int i = 0; i < place.furniture.size(); i++) {
				//Use item in funiture to open the door.
				if (!place.furniture.get(i).equals(furniture) && place.furniture.get(i).getTriggerNumber() == triggerType && triggerType == Furniture.OPENEXIT) {
					System.out.println("\nYou hear a click come from " + place.furniture.get(i).getName() + ".");
					System.out.println(place.furniture.get(i).getName() + " opens to reveal an exit!.");
					 place.furniture.get(i).setExitOpen(Furniture.EXIT);
				}
				//Use an item on furniture to allow another furniture to be searched for a key.
				if (!place.furniture.get(i).equals(furniture) && place.furniture.get(i).getTriggerNumber() == triggerType && triggerType == Furniture.ADDKEY) {
					System.out.println("\nYou hear a click come from " + place.furniture.get(i).getName() + ".");
					 place.furniture.get(i).setToSearched(false);
					 place.furniture.get(i).setItems(key);
				}
				//Use an item on furniture to allow another furniture to be searched for a lightbulb.
				if (!place.furniture.get(i).equals(furniture) && place.furniture.get(i).getTriggerNumber() == triggerType && triggerType == Furniture.ADDLIGHTBULB) {
					System.out.println("\nYou hear a click come from " + place.furniture.get(i).getName() + ".");
					 place.furniture.get(i).setToSearched(false);
					 place.furniture.get(i).setItems(lightbulb);
				}
			}
		}
	}	
}
