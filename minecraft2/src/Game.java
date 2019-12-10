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
	boolean isWon;
	boolean isTaken;

    /**
     * constructor initializes all rooms, mobs, static mobs, images, exits, and items and creates player object
	 * takes in  parameter to establish the number of players
	 * All mob dialogue is initialized and all mobs and static mobs are added to their rooms
     */
	public Game(int numPlayers) {
		isOver = false;
		isWon = false;
		isTaken = false;
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
		Item cinder_block = new Item("Cinder Block", "A heavy piece of concrete, seems very sturdy.", "", "K");
		Item flash_drive = new Item("Flash Drive", "A small flash drive given to you by the scientist. You'll need some sort of computer to see what's on it.", "Lab", "K");
		Item eggs = new Item("Eggs", "A carton of a dozen eggs. Have probably been rotten for a while...", "Rubble_pile", "You insert the flash drive into the computer and a list of files and documents pop up on screen. Your eyes are drawn to a document labeled ‘Final experiment thoughts’.");
		Item bucket = new Item("Bucket", "A yellow plastic bucket, probably belongs to someone.", "Shelter", "K");

		guestroom.addItem(letter);
		livingroom.addItem(picture);
		rubblepile.addItem(cinder_block);
		stream.addItem(bucket);
		kitchen.addItem(eggs);

		shelter.addItem(flash_drive);
		this.player =  new Player(bedroom);
		ImageIcon tomimg = new ImageIcon("src/mobs/tom.jpg");
		ImageIcon catimg = new ImageIcon("src/mobs/cat.jpg");
		GUI gui1 = new GUI(player,this);
		if (numPlayers == 2){
			Player player2 = new Player(hallway);
			GUI gui2 = new GUI(player2, this);
			addObserver(gui2);
		}
		ArrayList<String> tomdialogue = new ArrayList<>(Arrays.asList("This seems like a pretty nice house, too bad there aren't 42 bedrooms, it's just that one and the guest room...",
				"Don't mind me, just came in to take a nap. Say, isn't that letter over there addressed to you?",
				"Saw the picture that was in here, seems like you've got yourself a nice family. I wonder where they are?",
				"This kitchen is pretty empty, not nearly enough ingredients for a 42 course meal.",
				"Pretty big basement you got here, bet if you cleaned it out you could fit a 42 seat home theater down here.",
				"Someone really ought mow this lawn. I happen to know a guy who'll do it for only $42.",
				"You see that huge pile of rubble? I wonder how many pieces are in it. I'd guess 42.",
				"Seems like some folks have decided to hole up here. I wonder if anyone could use some help.",
				"Such a peaceful stream, wonder if people ever accidentally drop their stuff in it.",
				"Uhh, please stop that.",
				"Unless you have 41 others, I don't want that."));
		ArrayList<String> catdialogue = new ArrayList<>(Arrays.asList("Meow","Purr","Leave this house, mortal being."));
		ArrayList<String> oldladydialogue = new ArrayList<>(Arrays.asList("Oh my bucket! Thank you so much for getting this for me dear.",
				"Could you help me with something dear? I've lost my precious antique bucket, would you mind looking for it?",
				"My life is so much better now that I've got my bucket back, it's all thanks to you.",
				"I'm sorry dear but I'm afraid that this isn't my bucket. You know what a bucket looks like don't you?"));
		ArrayList<String> caesardialogue = new ArrayList<>(Arrays.asList("Ah! The block I've been missing! Thank you for returning it to me my friend.",
				"Excuse me, would you happen to be some sort of adventurer? One of my cinder blocks is missing and I cannot rest until I add it back to the pile where it belongs.",
				"Now that this rubble is in order I can continue my search for my comrade. Jojo must be around here somewhere...",
				"Huh? This isn't my missing cinder block..."));

		StaticMob oldlady = new StaticMob("Old Lady", oldladydialogue, "Bucket");
		StaticMob caesar = new StaticMob("Caesar Zepelli", caesardialogue, "Cinder Block");
		Mob tom = new Mob("Tom",guestroom,tomdialogue,this,tomimg);
		Mob cat = new Mob ("Cat", livingroom, catdialogue, this,catimg);
		guestroom.addMob(tom);
		livingroom.addMob(cat);
		shelter.addStaticMob(oldlady);
		rubblepile.addStaticMob(caesar);
		addObserver(tom);
		addObserver(cat);
		addObserver(gui1);
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(cat);
		service.execute(tom);

	}
	public void itemIsTaken(boolean tf){
		isTaken = tf;

	}

	/**
	 * gameIsOver method is used when the exit or end game buttons are pressed, sets isOver bool to true
	 */
	public void gameIsOver(){
		isOver = true;
	}
	/**
	 * gameIsWon method is used when a player uses the flash drive in the lab, effectively solving the game's puzzle
	 */
	public void gameIsWon(){ isWon = true;}

	/**
	 * used to notify observers and set changes implemented by mob or GUI class
	 */
	public void someoneMoves(){
		setChanged();
		notifyObservers();
	}


	}
