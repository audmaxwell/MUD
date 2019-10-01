
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Game {
		
	private ArrayList<Item> guest_items = new ArrayList<Item>();
	private ArrayList<Item> living_items = new ArrayList<Item>();
	private ArrayList<Item> kitchen_items = new ArrayList<Item>();
	private ArrayList<Item> basement_items = new ArrayList<Item>();
	private ArrayList<Item> yard_items = new ArrayList<Item>();
	private ArrayList<Item> rubble_items = new ArrayList<Item>();
	private ArrayList<Item> shelter_items = new ArrayList<Item>();
	private ArrayList<Item> stream_items = new ArrayList<Item>();
	private ArrayList<Item> lab_items = new ArrayList<Item>();

	private HashMap<String, Room> guest_exits = new HashMap <>();
	private HashMap<String, Room> living_exits = new HashMap <>();
	private HashMap<String, Room> kitchen_exits = new HashMap <>();
	private HashMap<String, Room> basement_exits = new HashMap <>();
	private HashMap<String, Room> yard_exits = new HashMap <>();
	private HashMap<String, Room> rubble_exits = new HashMap <>();
	private HashMap<String, Room> shelter_exits = new HashMap <>();
	private HashMap<String, Room> stream_exits = new HashMap <>();
	private HashMap<String, Room> lab_exits = new HashMap <>();
	
	private  ArrayList<Room> letter_rooms = new ArrayList<Room>(Arrays.asList());
	private  ArrayList<Room> picture_rooms = new ArrayList<Room>(Arrays.asList());
	private  ArrayList<Room> block_rooms = new ArrayList<Room>(Arrays.asList());
	private  ArrayList<Room> drive_rooms = new ArrayList<Room>(Arrays.asList());
	private  ArrayList<Room> eggs_rooms = new ArrayList<Room>(Arrays.asList());
	private  ArrayList<Room> key_rooms = new ArrayList<Room>(Arrays.asList());
	private  ArrayList<Room> bucket_rooms = new ArrayList<Room>(Arrays.asList());
	private  ArrayList<Room> computer_rooms = new ArrayList<Room>(Arrays.asList());
	
	private ArrayList<String> cat_dialogue = new ArrayList<String>(Arrays.asList());
	private ArrayList<String> tom_dialogue = new ArrayList<String>(Arrays.asList());
	private ArrayList<String> caesar_dialogue = new ArrayList<String>(Arrays.asList());
	private ArrayList<String> old_dialogue = new ArrayList<String>(Arrays.asList());
	private ArrayList<String> scientist_dialogue = new ArrayList<String>(Arrays.asList());

	private  ArrayList<Room> cat_locations = new ArrayList<Room>(Arrays.asList());
	private  ArrayList<Room> tom_locations = new ArrayList<Room>(Arrays.asList());
	private  ArrayList<Room> caesar_locations = new ArrayList<Room>(Arrays.asList());
	private  ArrayList<Room> old_locations = new ArrayList<Room>(Arrays.asList());
	private  ArrayList<Room> scientist_locations = new ArrayList<Room>(Arrays.asList());
	
	private ArrayList<Item> cat_items = new ArrayList<Item>(Arrays.asList());
	private ArrayList<Item> tom_items = new ArrayList<Item>(Arrays.asList());
	private ArrayList<Item> caesar_items = new ArrayList<Item>(Arrays.asList());
	private ArrayList<Item> old_items = new ArrayList<Item>(Arrays.asList());
	private ArrayList<Item> scientist_items = new ArrayList<Item>(Arrays.asList());

	
	Item letter = new Item("Letter", "A small letter that seems to be addresed to you.", letter_rooms );
	Item picture = new Item("Picture", "A framed picture of you alongside what seems to be a family.", picture_rooms);
	Item cinder_block = new Item("Cinder Block", "A heavy piece of concrete, seems very sturdy.", block_rooms);
	Item flash_drive = new Item("Flash Drive", "A small flash drive given to you by the scientist. You'll need some sort of computer to see what's on it.", drive_rooms);
	Item eggs = new Item("Eggs", "A carton of a dozen eggs. Have probably been rotten for a while...", eggs_rooms);
	Item key = new Item("Key", "A small brass key. Perhaps it unlocks a door somewhere.", key_rooms);
	Item bucket = new Item("Bucket", "A yellow plastic bucket, probably belongs to someone.", bucket_rooms);
	Item computer = new Item("Computer", "A standard desktop computer, looks like a flash drive could be plugged into it.", computer_rooms);
	
	Room Guest_room = new Room("Guest Room", "The room that you woke up in seems to be some kind of bedroom. A simple room design, there is the bed you woke up in, a dresser, mirror, and a small bedside table that seems to have some kind of envelope on it.", guest_exits, guest_items);
	Room Living_room = new Room("Living Room","A simple living room with a couch, TV and table. There seems to be a framed picture on the table.", living_exits, living_items);
	Room Kitchen = new Room("Kitchen","A dimly lit kitchen with all the standard appliences, including a refridgerator that doesn't seem to be running, maybe there's some stuff in it...", kitchen_exits, kitchen_items);
	Room Basement = new Room("Basement","A fairly clean basement with some empty cardboard boxes scattered around and a closed door at the other end of the room.", basement_exits, basement_items);
	Room Front_yard = new Room("Front Yard","You step out into the yard and see that this is the only standing house in the area, all the others have been reduced to heaps of rubble and ash. You don't see any people walking around, but maybe you can find someone by searching around.", yard_exits, yard_items);
	Room Rubble_pile = new Room("Rubble Pile","You happen upon a fairly large pile of rubble. Next to it you see an odd looking man moving pieces of rubble from one side of the pile to the other and then back again.", rubble_exits, rubble_items);
	Room Shelter = new Room("Shelter","You find yourself in a makeshift shelter that seems to be an abandoned convenience store. Inside the building you see an old woman who looks like she might need something.", shelter_exits, shelter_items);
	Room Stream = new Room("Stream","You followed a short trail into the woods and find yourself next to a flowing stream.", stream_exits, stream_items);
	Room Lab = new Room("Lab","The deepest layer of the house, a medium sized room with various tables and strange instruments. In the corner of the room you can see a computer.", lab_exits, lab_items);

	Mobs cat = new Mobs("Cat", cat_locations, Guest_room, cat_dialogue, cat_items);
	Mobs tom = new Mobs("Tom", tom_locations, Front_yard, tom_dialogue, tom_items);
	Mobs caesar = new Mobs("Caesar Zepelli", caesar_locations, Rubble_pile, caesar_dialogue, caesar_items);
	Mobs old = new Mobs("Old Woman", old_locations, Shelter, old_dialogue, old_items);
	Mobs scientist = new Mobs("Scientist", scientist_locations, Shelter, scientist_dialogue, scientist_items);
	
	caesar_items.add(eggs);
	old_items.add(bucket);
	
	
	guest_items.add(letter);
	living_items.add(picture);
	kitchen_items.add(eggs);
	rubble_items.add(cinder_block);
	shelter_items.add(flash_drive);
	shelter_items.add(key);
	stream_items.add(bucket);
	lab_items.add(computer);
	
	letter_rooms.add(Guest_room);
	picture_rooms.add(Living_room);
	block_rooms.add(Rubble_pile);
	drive_rooms.add(Shelter);
	eggs_rooms.add(Kitchen);
	key_rooms.add(Shelter);
	bucket_rooms.add(Stream);
	computer_rooms.add(Lab);
	
	cat_locations.add(Guest_room);
	cat_locations.add(Living_room);
	cat_locations.add(Kitchen);
	cat_locations.add(Basement);
	tom_locations.add(Guest_room);
	tom_locations.add(Living_room);
	tom_locations.add(Kitchen);
	tom_locations.add(Basement);
	tom_locations.add(Lab);
	tom_locations.add(Yard);
	tom_locations.add(Stream);
	caesar_locations.add(Rubble_pile);
	old_locations.add(Shelter);
	scientist_locations.add(Shelter);


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
