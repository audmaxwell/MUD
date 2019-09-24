import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	private Room room;
	private ArrayList<Items> inventory;
	public Player(Room room, ArrayList<Items> inventory) {
		this.room = room;
		this.inventory = inventory;
		
	}
	
	public String move(String direction) {
		HashMap<String, Room> exits = room.exit();
		if (exits.containsKey(direction)) {
			this.room = exits.get(direction);
			return("You have entered the" + exits.get(direction));
		}
		else {
			return ("You cannot go this way.");
		}
	}
	
	
	public String take(Items item) {
		inventory.add(item);
		return(item + "has been added to your inventory.");
	}
	
	public void drop(Item) {
		
	}
	
	public String look() {
		return Room.look();
	}

}