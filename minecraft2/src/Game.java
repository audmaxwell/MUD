
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
	
	Room Guest_room = new Room("Guest Room", "The room that you woke up in seems to be some kind of bedroom. A simple room design, there is the bed you woke up in, a dresser, mirror, and a small bedside table that seems to have some kind of envelope on it.");
	Room Living_room = new Room("Living Room","A simple living room with a couch, TV and table. There seems to be a framed picture on the table.");
	Room Kitchen = new Room("Kitchen","A dimly lit kitchen with all the standard appliences, including a refridgerator that doesn't seem to be running, maybe there's some stuff in it...");
	Room Basement = new Room("Basement","");
	Room Front_yard = new Room("Front Yard","");
	Room Rubble_pile = new Room("Rubble Pile","");
	Room Shelter = new Room("Shelter","");
	Room Stream = new Room("Stream","");
	Room Lab = new Room("Lab","");

	
	private  ArrayList<Room> letter_rooms = new ArrayList<Room>(Arrays.asList(Guest_room));
	private  ArrayList<Room> picture_rooms = new ArrayList<Room>(Arrays.asList(Living_room));
	private  ArrayList<Room> block_rooms = new ArrayList<Room>(Arrays.asList(Shelter));
	private  ArrayList<Room> drive_rooms = new ArrayList<Room>(Arrays.asList(Lab));
	private  ArrayList<Room> eggs_rooms = new ArrayList<Room>(Arrays.asList(Rubble_pile));
	private  ArrayList<Room> key_rooms = new ArrayList<Room>(Arrays.asList(Basement));
	private  ArrayList<Room> bucket_rooms = new ArrayList<Room>(Arrays.asList(Shelter));
	private  ArrayList<Room> computer_rooms = new ArrayList<Room>(Arrays.asList(Lab));
	
	private  ArrayList<Room> cat_locations = new ArrayList<Room>(Arrays.asList(Guest_room, Living_room, Kitchen, Basement));
	private  ArrayList<Room> tom_locations = new ArrayList<Room>(Arrays.asList(Guest_room, Living_room, Kitchen, Basement, Front_yard, Stream));
	private  ArrayList<Room> caesar_locations = new ArrayList<Room>(Arrays.asList(Rubble_pile));
	private  ArrayList<Room> old_locations = new ArrayList<Room>(Arrays.asList(Shelter));
	private  ArrayList<Room> scientist_locations = new ArrayList<Room>(Arrays.asList(Shelter));
	
	
	
	Item letter = new Item("Letter", "A small letter that seems to be addresed to you.", letter_rooms );
	Item picture = new Item("Picture", "A framed picture of you alongside what seems to be a family.", picture_rooms);
	Item cinder_block = new Item("Cinder Block", "A heavy piece of concrete, seems very sturdy.", block_rooms);
	Item flash_drive = new Item("Flash Drive", "A small flash drive given to you by the scientist. You'll need some sort of computer to see what's on it.", drive_rooms);
	Item eggs = new Item("Eggs", "A carton of a dozen eggs. Have probably been rotten for a while...", eggs_rooms);
	Item key = new Item("Key", "A small brass key. Perhaps it unlocks a door somewhere.", key_rooms);
	Item bucket = new Item("Bucket", "A yellow plastic bucket, probably belongs to someone.", bucket_rooms);
	Item computer = new Item("Computer", "A standard desktop computer, looks like a flash drive could be plugged into it.", computer_rooms);
	
	Mobs cat = new Mobs("Cat", cat_locations, Guest_room);
	Mobs tom = new Mobs("Tom", tom_locations, Front_yard);
	Mobs caesar = new Mobs("Caesar Zepelli", caesar_locations, Rubble_pile);
	Mobs old = new Mobs("Old Woman", old_locations, Shelter);
	Mobs scientist = new Mobs("Scientist", scientist_locations, Shelter);
	
	private HashMap<String, Room> kitchexits = new HashMap <>();
	private ArrayList<Items> kitchenitems = new ArrayList<>();
	private ArrayList<Room> letter_rooms = new ArrayList<>(); 
	Items letter = new Items("Letter", "A small letter that seems to be addresed to you.", letter_rooms );
	Room Kitchen = new Room("Kitchen", "u r room", kitchexits, kitchenitems);
	kitchenitems.add(letter);
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
