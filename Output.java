
/**
 * This class holds most of the generic output for the program.
 * @author Cole Talbot
 *
 */
public class Output {
	
	public static void welcome() {
		System.out.println("_________________________________________________________________________");
		System.out.println("|Welcome to the texted based version of escape the room.                |");
		System.out.println("|You will be tasked to escape each room by solving a series of puzzles. |");
		System.out.println("|Each puzzle will have a random complexity to them. Some may seem easy  |");
		System.out.println("|others more dificult. Each room will hold one key that opens the door. |");
		System.out.println("|There is one door per room and you may not go back to previous rooms.  |");
		System.out.println("|Good luck and have fun!                                                |");
		System.out.println("+-----------------------------------------------------------------------+");
	}
	/**
	 * Displays the players choices.
	 * @param CHOICEARR The array with the players current choices.
	 */
	public static void getChoices(String[] CHOICEARR) {
		System.out.println(stars());
		System.out.println("These are the commands for the game:");
		
		String choices = "";
		for(int i = 0; i < CHOICEARR.length; i++) {
			choices = choices + CHOICEARR[i] + "\n";
		}
		System.out.println(choices);
		System.out.println(stars());
	}
	/**
	 * Displays what item you are going to use on what furniture.
	 * @param toBeUsedOn The furniture the player is using the item on.
	 * @param itemToUse The item the player is trying to use.
	 */
	public static void itemsUsedOn(String toBeUsedOn, String itemToUse) {
		System.out.println("You use " + itemToUse + " on " + toBeUsedOn + ".");
//		if(itemToUse.equals(Items.KEY)) {
//			System.out.println("The " + toBeUsedOn + " opens!");
//			System.out.print(stars());
//		}
		if(itemToUse.equals(Items.LIGHTBULB)) {
			System.out.println("You screw in the " + itemToUse + " into the " + toBeUsedOn);
			System.out.println(stars());
		}
		
	}
	/**
	 * Tells the player wither or not they have left the room or if the room is locked.
	 * @param firstRoom The room the player is currently in.
	 * @return false if the player makes it out of the room. true - If the player is still locked in the room.
	 */
	//TODO: Change this so that it only works with the real exit.
	public static boolean exit(Place firstRoom) {
		
		// look through furniture array until we find the exit. 
		// if there is no exit tell the player.
		for(int i = 0; i < firstRoom.furniture.size(); i++) {
//			System.err.println(firstRoom.furniture.get(i) + " is " + firstRoom.furniture.get(i).exitOpen);
			if(firstRoom.furniture.get(i).exitOpen) {
				System.out.println("You have made it out of the first room but more wait!");
				return false;
			}
		}
		if(!firstRoom.furniture.get(0).exitOpen) {
			System.out.println("The room is still locked!");
		}
		return true;
	}
/////////////////////////////////////////////////////////////////////////////Discriptions//////////////////////////////////////////////////
	//Clown room discriptions
	public static String clownDoor() {
		return "\nThe door is an odd rombus shape with pink and green stripes,\n"
				+ "and the door knob looks like it is a clowns nose.\n";
	}
	public static String clownTable() {
		return "\nIt is a hidious white table with red and yellow polkadots \n"
				+ "on the top and blue polkadots down the legs.\n";
	}
	public static String clownChair() {
		return "\nThe chair seems to be made out of baloons!\n";
	}
	public static String clownCeilingFan() {
		return "\nThe blades of the ceiling fan are made out of multicolored balloons\n"
				+ "with a hole in the center for a lightbulb.\n";
	}
	public static String clownDesk() {
		return "\nThe desk sits in the corner of the room spanning two walls. \n"
				+ "It has a hutch and a drawer, and it seems to be made out of chocolate!\n";
	}
	public static String clownWindow() {
		return "\nThis isnt a real window but is a drawing of a window over looking a pasture\n"
				+ "with clowns craming into a tiny car.\n";
	}
//////////////////////////////////////////////////////////////////////ASCI art of items////////////////////////////////////////////////////
	public static void headder() {
		System.out.println("    ,---,.                                                                   ___      ,---,                      ,-.----.                                ____   \r\n" + 
				"  ,'  .' |                                   ,-.----.                      ,--.'|_  ,--.' |                      \\    /  \\                             ,'  , `. \r\n" + 
				",---.'   |                                   \\    /  \\                     |  | :,' |  |  :                      ;   :    \\   ,---.     ,---.       ,-+-,.' _ | \r\n" + 
				"|   |   .'  .--.--.                          |   :    |                    :  : ' : :  :  :                      |   | .\\ :  '   ,'\\   '   ,'\\   ,-+-. ;   , || \r\n" + 
				":   :  |-, /  /    '     ,---.     ,--.--.   |   | .\\ :   ,---.          .;__,'  /  :  |  |,--.   ,---.          .   : |: | /   /   | /   /   | ,--.'|'   |  || \r\n" + 
				":   |  ;/||  :  /`./    /     \\   /       \\  .   : |: |  /     \\         |  |   |   |  :  '   |  /     \\         |   |  \\ :.   ; ,. :.   ; ,. :|   |  ,', |  |, \r\n" + 
				"|   :   .'|  :  ;_     /    / '  .--.  .-. | |   |  \\ : /    /  |        :__,'| :   |  |   /' : /    /  |        |   : .  /'   | |: :'   | |: :|   | /  | |--'  \r\n" + 
				"|   |  |-, \\  \\    `. .    ' /    \\__\\/: . . |   : .  |.    ' / |          '  : |__ '  :  | | |.    ' / |        ;   | |  \\'   | .; :'   | .; :|   : |  | ,     \r\n" + 
				"'   :  ;/|  `----.   \\'   ; :__   ,\" .--.; | :     |`-''   ;   /|          |  | '.'||  |  ' | :'   ;   /|        |   | ;\\  \\   :    ||   :    ||   : |  |/      \r\n" + 
				"|   |    \\ /  /`--'  /'   | '.'| /  /  ,.  | :   : :   '   |  / |          ;  :    ;|  :  :_:,''   |  / |        :   ' | \\.'\\   \\  /  \\   \\  / |   | |`-'       \r\n" + 
				"|   :   .''--'.     / |   :    :;  :   .'   \\|   | :   |   :    |          |  ,   / |  | ,'    |   :    |        :   : :-'   `----'    `----'  |   ;/           \r\n" + 
				"|   | ,'    `--'---'   \\   \\  / |  ,     .-./`---'.|    \\   \\  /            ---`-'  `--''       \\   \\  /         |   |.'                       '---'            \r\n" + 
				"`----'                  `----'   `--`---'      `---`     `----'                                  `----'          `---'                                          \r\n" + 
				"                                                                                                                                                          ");
	}
	public static String clownDoorArt() {
		return "|----------------------------------------|\n"
		+"|                                        |\n"
		+"|                  /================/    |\n"
		+"|                 /                /     |\n"
		+"|                /                /      |\n"
		+"|               /                /       |\n"
		+"|              /                /        |\n"
		+"|             /                /         |\n"
		+"|            /             () /          |\n"
		+"|           /                /           |\n"
		+"|          /                /            |\n"
		+"|         /                /             |\n"
		+"|        /                /              |\n"
		+"|       /================/               |\n"
		+"|----------------------------------------|\n";
	}
	public static String windowArt() {
		return "|--------------------------|\n"
		+"|                          |\n"
		+"|    |================|    |\n"
		+"|    |        |       |    |\n"
		+"|    |        |       |    |\n"
		+"|    |========+=======|    |\n"
		+"|    |        |       |    |\n"
		+"|    |        |       |    |\n"
		+"|    |================|    |\n"
		+"|--------------------------|\n";
	}
	public static String clownChairArt() {
		return "|---------------------------------|\n"
		+"|                                 |\n"
		+"|             ~[]                 |\n"
		+"|          ~~~~[]                 |\n"
		+"|       []~~~~~[]                 |\n"
		+"|       []~~~~~[]                 |\n"
		+"|       []~~~~~[]                 |\n"
		+"|       []~~~{=}()()()()(){=}     |\n"
		+"|       []~~()()()()()()(){ }     |\n"
		+"|       {=}()()()()(){=}  { }     |\n"
		+"|       { }  { }     { }  { }     |\n"
		+"|       { }  { }     { }  {_}     |\n"
		+"|       { }  {_}     { }          |\n"
		+"|       {_}          {_}          |\n"
		+"|---------------------------------|\n";
	}
	public static String ceilingFanArt() {
		return "|----------------------------------------|\n"
	          +"|                   |||                  |\n"
		      +"|   ~~~~~~~~~~~~~~~|~~~|~~~~~~~~~~~~~~   |\n"
			  +"|                  ( o )                 |\n"
			  +"|----------------------------------------|\n";
	}
	public static String tableArt() {
		return "|-------------------------------------------|\n"
			  +"|            {=}()()()()()()()()()(){=}     |\n"
			  +"|           ()()()()()()()()()()()(){ }     |\n"
			  +"|       {=}()()()()())(()()()(){=}  { }     |\n"
			  +"|       { }  { }               { }  { }     |\n"
			  +"|       { }  { }               { }  {_}     |\n"
			  +"|       { }  {_}               { }          |\n"
			  +"|       {_}                    {_}          |\n"
			  +"|-------------------------------------------|\n";
				}
	public static String deskArt() {
		return "|-------------------------------------------|\n"
			  +"|            {=}--------------------{=}     |\n"
			  +"|            {=}      |      |      {=}     |\n"
			  +"|            {=}--------------------{=}     |\n"
			  +"|            {=}                    {=}     |\n"
			  +"|            {=}                    {=}     |\n"
			  +"|            {=}()()()()()()()()()(){=}     |\n"
			  +"|           ()()()()()()()()()()()(){ }     |\n"
			  +"|       {=}()()()()())(()()()(){=}  { }     |\n"
			  +"|       { }  { }        [__'__]{ }  { }     |\n"
			  +"|       { }  { }               { }  {_}     |\n"
			  +"|       { }  {_}               { }          |\n"
			  +"|       {_}                    {_}          |\n"
			  +"|-------------------------------------------|\n";
				}
	public static void excapedArt() {
		System.out.println("        ,---,                                                                             ,-.----.                  ,---, \r\n" + 
				"       /_ ./|   ,---.           ,--,                                                      \\    /  \\               ,---.'| \r\n" + 
				" ,---, |  ' :  '   ,'\\        ,'_ /|                     .--.--.                          |   :    |              |   | : \r\n" + 
				"/___/ \\.  : | /   /   |  .--. |  | :            ,---.   /  /    '     ,---.     ,--.--.   |   | .\\ :   ,---.      |   | | \r\n" + 
				" .  \\  \\ ,' '.   ; ,. :,'_ /| :  . |           /     \\ |  :  /`./    /     \\   /       \\  .   : |: |  /     \\   ,--.__| | \r\n" + 
				"  \\  ;  `  ,''   | |: :|  ' | |  . .          /    /  ||  :  ;_     /    / '  .--.  .-. | |   |  \\ : /    /  | /   ,'   | \r\n" + 
				"   \\  \\    ' '   | .; :|  | ' |  | |         .    ' / | \\  \\    `. .    ' /    \\__\\/: . . |   : .  |.    ' / |.   '  /  | \r\n" + 
				"    '  \\   | |   :    |:  | : ;  ; |         '   ;   /|  `----.   \\'   ; :__   ,\" .--.; | :     |`-''   ;   /|'   ; |:  | \r\n" + 
				"     \\  ;  ;  \\   \\  / '  :  `--'   \\        '   |  / | /  /`--'  /'   | '.'| /  /  ,.  | :   : :   '   |  / ||   | '/  ' \r\n" + 
				"      :  \\  \\  `----'  :  ,      .-./        |   :    |'--'.     / |   :    :;  :   .'   \\|   | :   |   :    ||   :    :| \r\n" + 
				"       \\  ' ;           `--`----'             \\   \\  /   `--'---'   \\   \\  / |  ,     .-./`---'.|    \\   \\  /  \\   \\  /   \r\n" + 
				"        `--`                                   `----'                `----'   `--`---'      `---`     `----'    `----'    \r\n" + 
				"                                                                                         ,---,                            \r\n" + 
				"                                                                                      ,`--.' |                            \r\n" + 
				"    ___      ,---,                      ,-.----.                                ____  |   :  :                            \r\n" + 
				"  ,--.'|_  ,--.' |                      \\    /  \\                             ,'  , `.'   '  ;                            \r\n" + 
				"  |  | :,' |  |  :                      ;   :    \\   ,---.     ,---.       ,-+-,.' _ ||   |  |                            \r\n" + 
				"  :  : ' : :  :  :                      |   | .\\ :  '   ,'\\   '   ,'\\   ,-+-. ;   , ||'   :  ;                            \r\n" + 
				".;__,'  /  :  |  |,--.   ,---.          .   : |: | /   /   | /   /   | ,--.'|'   |  |||   |  '                            \r\n" + 
				"|  |   |   |  :  '   |  /     \\         |   |  \\ :.   ; ,. :.   ; ,. :|   |  ,', |  |,'   :  |                            \r\n" + 
				":__,'| :   |  |   /' : /    /  |        |   : .  /'   | |: :'   | |: :|   | /  | |--' ;   |  ;                            \r\n" + 
				"  '  : |__ '  :  | | |.    ' / |        ;   | |  \\'   | .; :'   | .; :|   : |  | ,    `---'. |                            \r\n" + 
				"  |  | '.'||  |  ' | :'   ;   /|        |   | ;\\  \\   :    ||   :    ||   : |  |/      `--..`;                            \r\n" + 
				"  ;  :    ;|  :  :_:,''   |  / |        :   ' | \\.'\\   \\  /  \\   \\  / |   | |`-'      .--,_                               \r\n" + 
				"  |  ,   / |  | ,'    |   :    |        :   : :-'   `----'    `----'  |   ;/          |    |`.                            \r\n" + 
				"   ---`-'  `--''       \\   \\  /         |   |.'                       '---'           `-- -`, ;                           \r\n" + 
				"                        `----'          `---'                                           '---`\" ");
	}
/////////////////////////////////////////////////////////////////////////////MISC//////////////////////////////////////////////////////////
	/**
	 * Displays a bunch of stars for esthetics.
	 * @return **** Returns a bunch of stars.
	 */
	public static String stars() {
		return "*******************************************";
	}
	public static void explainTutorial() {
		System.out.println("Welcome to escape the room. You have chosen to play the tutorail.\n"
				+ "In this tutorial you will play through 3 levels that are simple to solve.\n"
				+ "The first level all you need to do is find a key and open the door.\n"
				+ "The second and third room will be slightly more complicated but will \n"
				+ "highlight how the game works. Some rooms will have keys to open doors\n"
				+ "and other rooms you will have to solve the puzzle to get the door to open.\n"
				+ "But be careful not every door is shapped like a door!");		
	}

}
