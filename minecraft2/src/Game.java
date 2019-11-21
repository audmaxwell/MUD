import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * game class initializes all objects needed for game and calls + runs GUI class
 */
public class Game extends Observable {
	Player player;
	boolean isOver;

    /**
     * constructor initializes all rooms and items and creates player object
     */
	public Game() {
		isOver = false;
		HashMap<String, Room> bed_exits = new HashMap<>();
		HashMap<String, Room> hall_exits = new HashMap<>();
		HashMap<String, Room> guest_exits = new HashMap<>();
		HashMap<String, Room> living_exits = new HashMap<>();
		HashMap<String, Room> kitchen_exits = new HashMap<>();
		HashMap<String, Room> basement_exits = new HashMap<>();
		HashMap<String, Room> yard_exits = new HashMap<>();
		HashMap<String, Room> rubble_exits = new HashMap<>();
		HashMap<String, Room> shelter_exits = new HashMap<>();
		HashMap<String, Room> stream_exits = new HashMap<>();
		HashMap<String, Room> lab_exits = new HashMap<>();

		ImageIcon bedimg = new ImageIcon("src/images/bedroom.jpg");
		ImageIcon hallimg = new ImageIcon("src/images/hallway.png");
		ImageIcon guestimg = new ImageIcon("src/images/guestroom.jpg");
		ImageIcon livingimg = new ImageIcon("src/images/livingroom.png");
		ImageIcon frontimg = new ImageIcon("src/images/frontyard.jpeg");
		ImageIcon kitchimg = new ImageIcon("src/images/kitchen.jpg");
		ImageIcon baseimg = new ImageIcon("src/images/basement.jpeg");
		ImageIcon rubbleimg = new ImageIcon("src/images/rubblepile.jpg");
		ImageIcon sheltimg = new ImageIcon("src/images/shelter.jpg");
		ImageIcon streamimg = new ImageIcon("src/images/stream.png");
		ImageIcon labimg = new ImageIcon("src/images/lab.jpg");

		Room bedroom = new Room("Bed Room", "The room that you woke up in seems to be some kind of bedroom. A simple room design, there is the bed you woke up in, a dresser, and a mirror.", bed_exits, new ArrayList<>(), bedimg);
		Room hallway = new Room("Hallway", "A short hallway with a door on the other side and stairs leading down.", hall_exits, new ArrayList<>(), hallimg);
		Room guestroom = new Room("Guest Room", "A small bedroom, looks to be an extra room. There is a table next to the bed with an envelope on it.", guest_exits, new ArrayList<>(), guestimg);
		Room livingroom = new Room("Living Room", "A simple living room with a couch, TV and table. There seems to be a framed picture on the table.", living_exits, new ArrayList<>(),livingimg);
		Room kitchen = new Room("Kitchen", "A dimly lit kitchen with all the standard appliances, including a refrigerator that doesn't seem to be running, maybe there's some stuff in it...", kitchen_exits, new ArrayList<>(), kitchimg);
		Room basement = new Room("Basement", "A fairly clean basement with some empty cardboard boxes scattered around and a closed door at the other end of the room.", basement_exits, new ArrayList<>(),baseimg);
		Room frontyard = new Room("Front Yard", "You step out into the yard and see that this is the only standing house in the area, all the others have been reduced to heaps of rubble and ash. You don't see any people walking around, but maybe you can find someone by searching around.", yard_exits, new ArrayList<>(),frontimg);
		Room rubblepile = new Room("Rubble Pile", "You happen upon a fairly large pile of rubble. Next to it you see an odd looking man moving pieces of rubble from one side of the pile to the other and then back again.", rubble_exits, new ArrayList<>(),rubbleimg);
		Room shelter = new Room("Shelter", "You find yourself in a makeshift shelter that seems to be an abandoned convenience store. Inside the building you see an old woman who looks like she might need something.", shelter_exits, new ArrayList<>(),sheltimg);
		Room stream = new Room("Stream", "You followed a short trail into the woods and find yourself next to a flowing stream.", stream_exits, new ArrayList<>(),streamimg);
		Room lab = new Room("Lab", "The deepest layer of the house, a medium sized room with various tables and strange instruments. In the corner of the room you can see a computer.", lab_exits, new ArrayList<>(),labimg);

		bed_exits.put("forwards", hallway);
		hall_exits.put("forwards", guestroom);
		hall_exits.put("backwards", bedroom);
		hall_exits.put("down", livingroom);
		guest_exits.put("backwards", hallway);
		living_exits.put("right", kitchen);
		living_exits.put("down", basement);
		living_exits.put("up", hallway);
		kitchen_exits.put("forwards", frontyard);
		kitchen_exits.put("left", livingroom);
		basement_exits.put("up", livingroom);
		basement_exits.put("forwards", lab);
		yard_exits.put("backwards", kitchen);
		yard_exits.put("forwards", rubblepile);
		rubble_exits.put("forwards", shelter);
		rubble_exits.put("backwards", frontyard);
		shelter_exits.put("backwards", rubblepile);
		shelter_exits.put("forwards", stream);
		stream_exits.put("backwards", shelter);
		lab_exits.put("backwards", basement);

		Item letter = new Item("Letter", "A small letter that seems to be addressed to you.", "", "K");
		Item picture = new Item("Picture", "A framed picture of you alongside what seems to be a family.", "", "K");
		Item cinder_block = new Item("Cinder_block", "A heavy piece of concrete, seems very sturdy.", "", "K");
		Item flash_drive = new Item("Flash_drive", "A small flash drive given to you by the scientist. You'll need some sort of computer to see what's on it.", "Lab", "K");
		Item eggs = new Item("Eggs", "A carton of a dozen eggs. Have probably been rotten for a while...", "Rubble_pile", "You insert the flash drive into the computer and a list of files and documents pop up on screen. Your eyes are drawn to a document labeled ‘Final experiment thoughts’.");
		Item key = new Item("Key", "A small brass key. Perhaps it unlocks a door somewhere.", "Basement", "You put the key into the lock and turn, prepared for it to do nothing. To your surprise the key turns and the door opens. You see a dark room through the doorway. There must be a reason as to why this room has been locked away...");
		Item bucket = new Item("Bucket", "A yellow plastic bucket, probably belongs to someone.", "Shelter", "K");
		Item computer = new Item("Computer", "A standard desktop computer, looks like a flash drive could be plugged into it.", "Lab", "K");

		guestroom.addItem(letter);
		livingroom.addItem(picture);
		rubblepile.addItem(cinder_block);
		shelter.addItem(flash_drive);
		shelter.addItem(key);
		stream.addItem(bucket);
		kitchen.addItem(eggs);
		basement.addItem(computer);
		this.player =  new Player(bedroom);
		ImageIcon tomimg = new ImageIcon("src/mobs/tom.jpg");
		ImageIcon catimg = new ImageIcon("src/mobs/cat.jpg");
		GUI gui = new GUI(player,this);
		ArrayList<String> tomdialogue = new ArrayList<>(Arrays.asList("42","Hahahahahahaha 42", "Hello 42"));
		ArrayList<String> catdialogue = new ArrayList<>(Arrays.asList("Meow","Purr","Leave this house, mortal being."));
		Mob tom = new Mob("Tom",guestroom,tomdialogue,this,tomimg);
		Mob cat = new Mob ("Cat", livingroom, catdialogue, this,catimg);
		guestroom.addMob(tom);
		livingroom.addMob(cat);
		addObserver(tom);
		addObserver(cat);
		addObserver(gui);
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(cat);
		service.execute(tom);

	}
	public void gameIsOver(){
		isOver = true;
	}

	public void someoneMoves(){
		setChanged();
		notifyObservers();
	}

	/**
	 * main creates a game and GUI object, passes the player from game into the GUI constructor
	 * uses .startGame method in GUI to run the program
	 * @param args
	 */
		public static void main (String[]args){
			Game game = new Game();


		}

	}
