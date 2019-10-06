import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
 * @author Audrey Maxwell and Ethan Buckborough
 */
public class Game {

	/*
	 * @param itemHashMap
	 * @return a HashMap of the rooms where the key is the room name and the value is the corresponding room object.
	 * A method to initialize and create all of the Room class objects
	 */
	public HashMap<String, Room> initializeRooms(HashMap<String, Item> itemHashMap) {
		HashMap<String, Room> bed_exits = new HashMap <>();
		HashMap<String, Room> hall_exits = new HashMap <>();
		HashMap<String, Room> guest_exits = new HashMap <>();
		HashMap<String, Room> living_exits = new HashMap <>();
		HashMap<String, Room> kitchen_exits = new HashMap <>();
		HashMap<String, Room> basement_exits = new HashMap <>();
		HashMap<String, Room> yard_exits = new HashMap <>();
		HashMap<String, Room> rubble_exits = new HashMap <>();
		HashMap<String, Room> shelter_exits = new HashMap <>();
		HashMap<String, Room> stream_exits = new HashMap <>();
		HashMap<String, Room> lab_exits = new HashMap <>();

		ArrayList<Item> guest_room_items = new ArrayList<Item>();
		guest_room_items.add(itemHashMap.get("letter"));
		ArrayList<Item> living_room_items = new ArrayList<Item>();
		living_room_items.add(itemHashMap.get("picture"));
		ArrayList<Item> rubble_pile_items = new ArrayList<Item>();
		rubble_pile_items.add(itemHashMap.get("cinder block"));
		ArrayList<Item> shelter_items = new ArrayList<Item>();
		shelter_items.add(itemHashMap.get("flash drive"));
		shelter_items.add(itemHashMap.get("key"));
		ArrayList<Item> kitchen_items = new ArrayList<Item>();
		kitchen_items.add(itemHashMap.get("eggs"));
		ArrayList<Item> stream_items = new ArrayList<Item>();
		stream_items.add(itemHashMap.get("bucket"));

		Room bed_room = new Room("Bed Room", "The room that you woke up in seems to be some kind of bedroom. A simple room design, there is the bed you woke up in, a dresser, and a mirror.", bed_exits, new ArrayList<>());
		Room hallway = new Room("Hallway", "A short hallway with a door on the other side and stairs leading down.", hall_exits, new ArrayList<>());
		Room guest_room = new Room("Guest Room", "A small bedroom, looks to be an extra room. There is a table next to the bed with an envelope on it." , guest_exits, guest_room_items);
		Room living_room = new Room("Living Room","A simple living room with a couch, TV and table. There seems to be a framed picture on the table.", living_exits, living_room_items);
		Room kitchen = new Room("Kitchen","A dimly lit kitchen with all the standard appliances, including a refrigerator that doesn't seem to be running, maybe there's some stuff in it...", kitchen_exits, kitchen_items);
		Room basement = new Room("Basement","A fairly clean basement with some empty cardboard boxes scattered around and a closed door at the other end of the room.", basement_exits, new ArrayList<>());
		Room front_yard = new Room("Front Yard","You step out into the yard and see that this is the only standing house in the area, all the others have been reduced to heaps of rubble and ash. You don't see any people walking around, but maybe you can find someone by searching around.", yard_exits, new ArrayList<>());
		Room rubble_pile = new Room("Rubble Pile","You happen upon a fairly large pile of rubble. Next to it you see an odd looking man moving pieces of rubble from one side of the pile to the other and then back again.", rubble_exits, rubble_pile_items);
		Room shelter = new Room("Shelter","You find yourself in a makeshift shelter that seems to be an abandoned convenience store. Inside the building you see an old woman who looks like she might need something.", shelter_exits, shelter_items);
		Room stream = new Room("Stream","You followed a short trail into the woods and find yourself next to a flowing stream.", stream_exits, stream_items);
		Room lab = new Room("Lab","The deepest layer of the house, a medium sized room with various tables and strange instruments. In the corner of the room you can see a computer.", lab_exits, new ArrayList<>());

		bed_exits.put("forwards", hallway);
		hall_exits.put("forwards", guest_room);
		hall_exits.put("backwards", bed_room);
		hall_exits.put("down", living_room);
		guest_exits.put("backwards", hallway);
		living_exits.put("right", kitchen);
		living_exits.put("down", basement);
		living_exits.put("up", hallway);
		kitchen_exits.put("forwards", front_yard);
		kitchen_exits.put("left", living_room);
		basement_exits.put("up", living_room);
		basement_exits.put("forwards", lab);
		yard_exits.put("backwards", kitchen);
		yard_exits.put("forwards", rubble_pile);
		rubble_exits.put("forwards", shelter);
		rubble_exits.put("backwards", front_yard);
		shelter_exits.put("backwards", rubble_pile);
		shelter_exits.put("forwards", stream);
		stream_exits.put("backwards", shelter);
		lab_exits.put("backwards", basement);

		HashMap<String, Room> rooms = new HashMap<>();
		rooms.put(bed_room.getName().toLowerCase(), bed_room);
		rooms.put(hallway.getName().toLowerCase(), hallway);
		rooms.put(guest_room.getName().toLowerCase(), guest_room);
		rooms.put(living_room.getName().toLowerCase(), living_room);
		rooms.put(kitchen.getName().toLowerCase(), kitchen);
		rooms.put(basement.getName().toLowerCase(), basement);
		rooms.put(front_yard.getName().toLowerCase(), front_yard);
		rooms.put(rubble_pile.getName().toLowerCase(), rubble_pile);
		rooms.put(shelter.getName().toLowerCase(), shelter);
		rooms.put(stream.getName().toLowerCase(), stream);
		rooms.put(lab.getName().toLowerCase(), lab);


		return rooms;
	}
	
	/*
	 * @param roomHashMap
	 * @return A hashmap of the mobs where the key is a string of the mob's name and the value is the corresponding mob object
	 * A method to initialize and create all of the mob class objects
	 */
	public HashMap<String, Mob> initializeMobs(HashMap<String, Room> roomHashMap){
		ArrayList<String> cat_dialogue = new ArrayList<>();
		ArrayList<Room> cat_locations = new ArrayList<>();
		cat_locations.add(roomHashMap.get("Guest Room"));
		cat_locations.add(roomHashMap.get("Living Room"));
		cat_locations.add(roomHashMap.get("Kitchen"));
		cat_locations.add(roomHashMap.get("Basement"));
		Mob cat = new Mob("Cat", cat_locations, cat_dialogue, "", "bed room");

		ArrayList<String> tom_dialogue = new ArrayList<>();
		ArrayList<Room> tom_locations = new ArrayList<>();
		tom_locations.add(roomHashMap.get("Guest Room"));
		tom_locations.add(roomHashMap.get("Living Room"));
		tom_locations.add(roomHashMap.get("Kitchen"));
		tom_locations.add(roomHashMap.get("Basement"));
		tom_locations.add(roomHashMap.get("Lab"));
		tom_locations.add(roomHashMap.get("Front Yard"));
		tom_locations.add(roomHashMap.get("Stream"));
		Mob tom = new Mob("Tom", tom_locations, tom_dialogue, "", "living room");

		ArrayList<String> caesar_dialogue = new ArrayList<>();
		ArrayList<Room> caesar_locations = new ArrayList<>();
		caesar_locations.add(roomHashMap.get("Rubble Pile"));
		Mob caesar = new Mob("Caesar Zepelli", caesar_locations, caesar_dialogue, "Eggs", "rubble pile");

		ArrayList<String> old_dialogue = new ArrayList<>();
		ArrayList<Room> old_locations = new ArrayList<>();
		old_locations.add(roomHashMap.get("Shelter"));
		Mob old = new Mob("Old Woman", old_locations, old_dialogue, "Bucket", "shelter");

		ArrayList<String> scientist_dialogue = new ArrayList<>();
		ArrayList<Room> scientist_locations = new ArrayList<>();
		scientist_locations.add(roomHashMap.get("Shelter"));
		Mob scientist = new Mob("Scientist", scientist_locations, scientist_dialogue, "","shelter");

		HashMap<String, Mob> mobHashMap = new HashMap<>();
		mobHashMap.put(cat.getName().toLowerCase(), cat);
		mobHashMap.put(tom.getName().toLowerCase(), tom);
		mobHashMap.put(caesar.getName().toLowerCase(), caesar);
		mobHashMap.put(old.getName().toLowerCase(), old);
		mobHashMap.put(scientist.getName().toLowerCase(), scientist);

		return mobHashMap;
	}

	/*
	 * Initializes and creates the Item class objects. 
	 * Creates a hashmap 'itemHashMap' that has an item's name as a string as the key and the value is the corresponding Item object
	 */
	public HashMap<String, Item> initializeItems() {
		Item letter = new Item("Letter", "A small letter that seems to be addressed to you.", "", "");
		Item picture = new Item("Picture", "A framed picture of you alongside what seems to be a family.","", "");
		Item cinder_block = new Item("Cinder Block", "A heavy piece of concrete, seems very sturdy.", "","");
		Item flash_drive = new Item("Flash Drive", "A small flash drive given to you by the scientist. You'll need some sort of computer to see what's on it.", "Lab", "You insert the flash drive into the computer and a list of various files and documents pops up on the screen. Your eye is drawn to a particular document named ‘Final experiment thoughts’.");
		Item eggs = new Item("Eggs", "A carton of a dozen eggs. Have probably been rotten for a while...", "Rubble_pile", "");
		Item key = new Item("Key", "A small brass key. Perhaps it unlocks a door somewhere.", "Basement", "You put the key into the lock and turn, prepared for it to do nothing. To your surprise the key turns and the door opens. You see a dark room through the doorway. There must be a reason as to why this room has been locked away...");
		Item bucket = new Item("Bucket", "A yellow plastic bucket, probably belongs to someone.", "Shelter", "");
		Item computer = new Item("Computer", "A standard desktop computer, looks like a flash drive could be plugged into it.", "Lab", "");

		HashMap<String, Item> itemHashMap = new HashMap<>();
		itemHashMap.put(letter.getName().toLowerCase(), letter);
		itemHashMap.put(picture.getName().toLowerCase(), picture);
		itemHashMap.put(cinder_block.getName().toLowerCase(), cinder_block);
		itemHashMap.put(flash_drive.getName().toLowerCase(), flash_drive);
		itemHashMap.put(eggs.getName().toLowerCase(), eggs);
		itemHashMap.put(key.getName().toLowerCase(), key);
		itemHashMap.put(bucket.getName().toLowerCase(), bucket);
		itemHashMap.put(computer.getName().toLowerCase(), computer);

		return itemHashMap;
	}

	/*Creates a scanner that continues in a loop until the user inputs 'exit' as well as responding to to commands and inputs
	 * Gives the player a brief text tutorial telling them how to play the game and the basic commands
	 * This tutorial can be displayed again at any time by entering the 'help' command
	 * When the player enters a room, the scanner will return a description of the room, the items currently in the room, and the exits of the room and the rooms they lead to
	 */
	private void startGame(){
		HashMap<String, Item> items = initializeItems();
		HashMap<String, Room> rooms = initializeRooms(items);
		HashMap<String, Mob> mobs = initializeMobs(rooms);
		Player player = new Player(rooms.get("bed room"), new ArrayList<>());

		System.out.println();
		// TODO Auto-generated method stub
		System.out.println("You wake up in an unfamiliar bedroom.");
		System.out.println("You can enter 'help' at any time to access playable actions.");
		String instructions = "To exit a given room, enter 'move' followed by a direction."
				+ " You can move forwards, backwards, right, left, up, and down. \n"
				+ "Some locations may contain items that you can interact with. \n"
				+ "Items can be added to your inventory by entering 'take' followed by the item. Check your inventory by entering 'inventory'."
				+ "The commands 'drop', 'use', and 'examine' can all be executed when followed by an item in your inventory.";

		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println(player.look());
			System.out.println("Exits : \n" + player.exits());
			String input = in.nextLine();
			if(input.equals("exit")) {
				break;
			}
			if (input.equals("help")){
				System.out.println(instructions);
			}
			else{
				parseInput(player, input, items, mobs, rooms);
			}
		}
		System.out.println("Thank you for playing.");

	}

	/**
	 *
	 * @param player 
	 * @return creates a new instance of the player class
	 * @param input
	 * @return the input that the user puts into the scanner
	 * @param items
	 * @return The Hashmap of the item objects
	 * @param mobs
	 * @return The hashmap of the Mob objects
	 * @param rooms
	 * @return The hashmap of the room objects
	 * Reads the user input to determine if the user is trying to use a valid command, if the command is valid then the corresponding method will be called
	 * if the input is invalid, then the system will return a statement informing the user that the command they entered is invalid
	 */
	public void parseInput(Player player, String input, HashMap<String, Item> items, HashMap<String, Mob> mobs, HashMap<String, Room> rooms){
		 String[] in = input.split(" ");
		 String command = in[0];
		 switch (command.toLowerCase()){
			 case "take":
			 	if (in.length == 2) {
					System.out.println(player.take(items.get(in[1])));
				}
			 	else{
					System.out.println("Invalid command.");
				}
			 	break;
			 case "look":
				 System.out.println(player.look());
				 break;
			 case "move":
				 if (in.length == 2) {
					 System.out.println(player.move(in[1]));
				 }
				 else{
					 System.out.println("Invalid command.");
				 }
			 	break;
			 case "exits":
				 System.out.println(player.exits());
				 break;
			 case "inventory":
			 	if(player.getInventory().isEmpty()){
					System.out.println("There is nothing in your inventory");
				}
			 	else {
					System.out.println(player.getInventory());
				}
				 break;
			 case "drop":
				 if (in.length == 2) {
					 System.out.println(player.drop(items.get(in[1])));
				 }
				 else{
					 System.out.println("Invalid command.");
				 }
					break;
			 case "examine":
				 if (in.length == 2) {
					 System.out.println(player.examine(items.get(in[1])));
				 }
				 else{
					 System.out.println("Invalid command.");
				 }

		 }

	}


	//Main methods that creates a new game object and uses the startGame method to start the game
	public static void main(String[] args) {
		Game game = new Game();
		game.startGame();

		

	}

}
