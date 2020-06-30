
/**
 * @author Cole Talbot
 * @author This is a component of the OOP project.
 * @version OOP project v1
 */

/*
 * This is the driver program. It runs all the functions and classes that are 
 * in the other files and it holds the main loop for the game.
 */
import java.util.ArrayList;

public class GameDriver {
	private final static int STARTINGHEALTH = 100;
	private final static String[] QUICKCHOICEARR = {"h", "st","se", "u", "e", "q"};
	private final static String[] CHOICEARR = {"help", "status","search", "use", "exit room", "quit"};
	private final static int HELP = 0;
	private final static int STATUS = 1;
	private final static int SEARCH = 2;
	private final static int USE = 3;
	private final static int EXIT = 4;
	private final static int QUIT = 5;
	
	static ArrayList <Place> Rooms = new ArrayList <Place> ();
//	static ArrayList <Place> RoomsToBePlaced = new ArrayList <Place> (MAXROOMS);

	/**
	 * Calls the entry point for this program.
	 * @param args Null: Not used in this program.
	 */
	public static void main(String[] args) {
		int maxRooms;
		int currentRoom = 0;
		boolean inRoom = true;
		
		Output.headder();
		Output.welcome();
		
		String playerName = IR4.getString("Please enter your name");
		Player firstPlayer = new Player(STARTINGHEALTH, playerName, 1);
		maxRooms = IR4.getInteger("How many rooms would you like to escape?");
		boolean menuChoice = IR4.getYorN("Would you like to playe the tutorial? y/n"); 
		
		while(currentRoom < maxRooms) {
			if(menuChoice) {
				setUpTutorial(maxRooms);
			}
			menuChoice = false;
			Output.getChoices(CHOICEARR);			
			System.out.println(firstPlayer.toString());

			// Adds all the possible rooms to the list of rooms that can be placed.
			while(Rooms.size() < maxRooms) {
				createRandomRoom();
			}
			inRoom = true;
			System.out.println(Rooms.get(0).toString());
			
			while(inRoom) {
				String itemToUse = "";
				String[] playersChoice = validChoices();
				int choice = Integer.parseInt(playersChoice[0]);
				String interactable = playersChoice[1];
				
				switch(choice) {
				case(HELP):
					Output.getChoices(CHOICEARR);
				break;
				case(STATUS):
					System.out.println(firstPlayer.toString());
					System.out.println(Rooms.get(0).toString());
				break;
				case(SEARCH):
					if(interactable.length() > 0) {
						search(interactable, Rooms.get(0), firstPlayer);
						break;
					}
					if(interactable.length() == 0) {
						String itemToSearch = IR4.getString("What would you like to search?\n" + Rooms.get(0).furniture.toString());
						search(itemToSearch, Rooms.get(0), firstPlayer);
					}
					break;
				case(USE):
					if(firstPlayer.items.size() > 0) {
						if(interactable.length() > 0) {
							interactable = validItemToUse(firstPlayer, Rooms.get(0), interactable);
							toUse(interactable, Rooms.get(0), firstPlayer);
							break;
						}
						if(interactable.length() == 0) {
							itemToUse = validItemToUse(firstPlayer, Rooms.get(0), itemToUse);
							toUse(itemToUse, Rooms.get(0), firstPlayer);
						}
						
					}
					else {
						System.out.println("You have no items to use.");
					}
					break;
				case(EXIT):
					inRoom = Output.exit(Rooms.get(0));
					if(!inRoom) {currentRoom++; Rooms.remove(0);}
					break;
				case(QUIT):
					inRoom = false;
					currentRoom = maxRooms + 1;
				break;
				}
				interactable = "";
			}
			if(currentRoom >= maxRooms) {
				Output.excapedArt();
				boolean playAgain = IR4.getYorN("Would you like to play again? y/n");
				if(playAgain) {
					currentRoom = 0;
					playerName = IR4.getString("Please enter your name");
					firstPlayer = new Player(STARTINGHEALTH, playerName, 1);
					maxRooms = IR4.getInteger("How many rooms would you like to escape?");
					menuChoice = IR4.getYorN("Would you like to playe the tutorial? y/n");
				}
			}
		}
		if(currentRoom >= maxRooms) {
			System.out.println("Thank you for playing. Come escape again!");
		}
	}
	/**
	 * This validates the players decisions for interaction in the game.
	 * @return interaction The chosen interaction from the player.
	 */
	public static String[] validChoices() {
		String choice = "";
		String[] interaction = new String[2];
		boolean validChoice = false;
		choice = IR4.getString("What would you like to do?");
		choice = choice.trim().toLowerCase();
		String[] chArr = choice.split(" ");
		choice = chArr[0];
		for(int i = 0; i < CHOICEARR.length; i++) {
			if ((CHOICEARR[i].startsWith(choice) && choice.startsWith(QUICKCHOICEARR[i])) || choice.toLowerCase().equals(CHOICEARR[i])) {
				validChoice = true;
				String returnedNumber = Integer.toString(i);
				interaction[0] = returnedNumber;
//				System.out.println("0: " + chArr[0] + " 1: " + chArr[1] + " 2: " + chArr[2]);
				if(chArr.length < 3 && chArr.length != 1) {
					interaction[1] = chArr[1];
				}
				else if(chArr.length >= 3) {
					interaction[1] = chArr[1] + " " + chArr[2];
				}
				else {
					interaction[1] = "";
				}
				
				return interaction;
			}
		}
		while (!validChoice) {
			System.err.println("Unknown command.\n");
			choice = IR4.getString("What would you like to do?");
			choice = choice.trim().toLowerCase();
			chArr = choice.split(" ");
			choice = chArr[0];
			for(int i = 0; i < CHOICEARR.length; i++) {
				if ((CHOICEARR[i].startsWith(choice) && choice.startsWith(QUICKCHOICEARR[i])) || choice.toLowerCase().equals(CHOICEARR[i])) {
					String returnedNumber = Integer.toString(i);
					interaction[0] = returnedNumber;
					if(chArr.length < 3 && chArr.length != 1) {
						interaction[1] = chArr[1];
					}
					else if(chArr.length >= 3) {
						interaction[1] = chArr[1] + " " + chArr[2];
					}
					else {
						interaction[1] = "";
					}
					return interaction;
				}
			}
		}
		return interaction;
	}
	/**
	 * This checks to see what is being searched and returns either an item or a message.
	 * @param furnitureToSearch The furniture to be searched.
	 * @param place The current room.
	 * @param firstPlayer The player searching.
	 * @return -1 The item doesn't exist in the room 0 - The item is in the room 1 - The furniture doesnt have any items in it. 2 - The furniture has already been searched.
	 */
	public static int search(String furnitureToSearch, Place place, Player firstPlayer) {
		for (int i = 0; i < place.furniture.size(); i++) {
			if( place.furniture.get(i).getName().startsWith(furnitureToSearch) && !place.furniture.get(i).searched) {
				furnitureToSearch = place.furniture.get(i).getName();
				for(int x = 0; x < place.furniture.get(i).items.size(); x++) {
					System.out.println("You search " + furnitureToSearch + ".");
					System.out.println("You found " + place.furniture.get(i).items.get(x).toString());
					firstPlayer.items.add(place.furniture.get(i).items.get(x));
					place.furniture.get(i).items.remove(x);
					place.furniture.get(i).setToSearched(Furniture.SEARCHED);	
					System.out.println(Output.stars());
					return 0;
				}
				System.out.println(furnitureToSearch + " doesnt have any items.");
				place.furniture.get(i).setToSearched(Furniture.SEARCHED);
				System.out.println(Output.stars());
				return 1;
			}
			if(place.furniture.get(i).getName().startsWith(furnitureToSearch) && place.furniture.get(i).searched) {
				System.out.println(furnitureToSearch + " has already been searched");
				System.out.println(Output.stars());
				return 2;
			}
		}
		System.out.println(furnitureToSearch + " does not exist in the room.");
		System.out.println(Output.stars());
		return -1;
	}
	/**
	 * Validates that an item is in the players inventory.
	 * @param firstPlayer The player that is using the item.
	 * @param place The room the player is currently in.
	 * @return itemToUse The item the player is going to use.
	 */
	public static String validItemToUse(Player firstPlayer, Place place, String itemToUse) {
		boolean loop = true;
		if(itemToUse.equals("")) {
			itemToUse = IR4.getString("What would you like to use?\n" + firstPlayer.getItems());
		}
		while(loop) {
			itemToUse = itemToUse.trim().toLowerCase();
			for(int i = 0; i < firstPlayer.items.size(); i++) {
				if(firstPlayer.items.get(i).getItemName().startsWith(itemToUse)) {
					itemToUse = firstPlayer.items.get(i).getItemName();
					loop = false;
					return itemToUse;
				}
			}
			System.out.println("That is an invalid item, please choose from the items in your posession.");
			itemToUse = IR4.getString("What would you like to use?\n" + firstPlayer.getItems());
		}
		return "";
	}
	/**
	 * Checks to see if the item the player is using triggers the furniture the player is using the item on.
	 * @param itemToUse The item the player is using.
	 * @param place The current room the player is in.
	 * @param firstPlayer The current player.
	 * @return 1 The item the player is using works on the furniture. -1 - The item the user wants to use doesnt work on the furniture
	 */
	public static int toUse(String itemToUse, Place place, Player firstPlayer) {
		String toBeUsedOn = IR4.getString("What would you like to use " + itemToUse + " on?\n" + place.furniture.toString());
		toBeUsedOn = toBeUsedOn.trim().toLowerCase();
	
		for(int i = 0; i < place.furniture.size(); i++) {
			if(place.furniture.get(i).getName().startsWith(toBeUsedOn)) {
				toBeUsedOn = place.furniture.get(i).getName();
				if(place.furniture.get(i).getCompatibility() == firstPlayer.getItemObjectByName(itemToUse).getCompatibility()) {
					Output.itemsUsedOn(toBeUsedOn, itemToUse);
					Processing.exitsOpen(place.furniture.get(i));
					Processing.activateTrigger(place, place.furniture.get(i));
					Processing.itemDurability(itemToUse, firstPlayer);
					return 1;
				}
			}
		}
		System.out.println(toBeUsedOn + " is not a valid object to use that " + itemToUse + " on.");
		System.out.println(Output.stars());
		return -1;
	}
	
	public static void setUpTutorial(int maxRooms) {
		int height;
		int width;
		int length;
		int maxItems;
		
		Output.explainTutorial();
		height = IR4.getRandomNumber(Place.MINHEIGHT, Place.MAXHEIGHT);
		width = IR4.getRandomNumber(Place.MINWIDTH, Place.MAXWIDTH);
		length = IR4.getRandomNumber(Place.MINLENGTH, Place.MAXLENGTH);
		maxItems = IR4.getRandomNumber(Place.MINFURNITURE, Place.MAXFURNITURE);
//		System.out.println("hight: " + hight + " width: " + width + " length:" + length);
		
		StartingRoom firstRoom = new StartingRoom(height, width, length, maxItems);
		Rooms.add(firstRoom);
		
		if(maxRooms > 1) {
			height = IR4.getRandomNumber(Place.MINHEIGHT, Place.MAXHEIGHT);
			width = IR4.getRandomNumber(Place.MINWIDTH, Place.MAXWIDTH);
			length = IR4.getRandomNumber(Place.MINLENGTH, Place.MAXLENGTH);
			maxItems = IR4.getRandomNumber(Place.MINFURNITURE, Place.MAXFURNITURE);
			
			RoomPuzzleOne secondRoom = new RoomPuzzleOne(height, width, length, maxItems);
			Rooms.add(secondRoom);
		}
		if(maxRooms > 2) {
			height = IR4.getRandomNumber(Place.MINHEIGHT, Place.MAXHEIGHT);
			width = IR4.getRandomNumber(Place.MINWIDTH, Place.MAXWIDTH);
			length = IR4.getRandomNumber(Place.MINLENGTH, Place.MAXLENGTH);
			maxItems = IR4.getRandomNumber(Place.MINFURNITURE, Place.MAXFURNITURE);
			
			RoomPuzzleTwo thirdRoom = new RoomPuzzleTwo(height, width, length, maxItems);
			Rooms.add(thirdRoom);
		}
	}
	
	public static void createRandomRoom() {
		int height;
		int width;
		int length;
		int maxItems;
		
		height = IR4.getRandomNumber(Place.MINHEIGHT, Place.MAXHEIGHT);
		width = IR4.getRandomNumber(Place.MINWIDTH, Place.MAXWIDTH);
		length = IR4.getRandomNumber(Place.MINLENGTH, Place.MINLENGTH);
		maxItems = IR4.getRandomNumber(Place.MINFURNITURE, Place.MAXFURNITURE);

		RoomPuzzleRandom randomRoom = new RoomPuzzleRandom(height, width, length, maxItems);
		Rooms.add(randomRoom);
//		System.out.println("random room");
	}
}
