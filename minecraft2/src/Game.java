
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
	
	private  ArrayList<Room> letter_rooms = new ArrayList<Room>(Arrays.asList());
	private  ArrayList<Room> picture_rooms = new ArrayList<Room>(Arrays.asList());
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

	Mobs cat = new Mobs("Cat", cat_locations, Guest_room);
	Mobs tom = new Mobs("Tom", tom_locations, Front_yard);
	Mobs caesar = new Mobs("Caesar Zepelli", caesar_locations, Rubble_pile);
	Mobs old = new Mobs("Old Woman", old_locations, Shelter);
	Mobs scientist = new Mobs("Scientist", scientist_locations, Shelter);
	
	Room Guest_room = new Room("Guest Room");
	Room Living_room = new Room("Living Room");
	Room Kitchen = new Room("Kitchen");
	Room Basement = new Room("Basement");
	Room Front_yard = new Room("Front Yard");
	Room Rubble_pile = new Room("Rubble Pile");
	Room Shelter = new Room("Shelter");
	Room Stream = new Room("Stream");











	
	Item letter = new Item("Letter", "A small letter that seems to be addresed to you.", letter_rooms );
	Item picture = new Item("Picture", "A framed picture of you alongside what seems to be a family.", picture_rooms);
	Item cinder_block = new Item("Cinder Block", "A heavy piece of concrete, seems very sturdy.", block_rooms);
	Item flash_drive = new Item("Flash Drive", "A small flash drive given to you by the scientist. You'll need some sort of computer to see what's on it.", drive_rooms);
	Item eggs = new Item("Eggs", "A carton of a dozen eggs. Have probably been rotten for a while...", eggs_rooms);
	Item key = new Item("Key", "A small brass key. Perhaps it unlocks a door somewhere.", key_rooms);
	Item bucket = new Item("Bucket", "A yellow plastic bucket, probably belongs to someone.", bucket_rooms);
	Item computer = new Item("Computer", "A standard desktop computer, looks like a flash drive could be plugged into it.", computer_rooms);
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
