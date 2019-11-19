import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	private Room room;
	private ArrayList<Item> inventory;
	public Player(Room room) {
		this.room = room;
		this.inventory = new ArrayList<>();

	}

	//returns the room that the player is in
	public String getRoom() {
		return room.getName();
	}
	public Room getRoomobj(){
		return room;
	}

	//returns the items that are in the room the player is in
	public ArrayList<Item> getRoomItems() {
		return room.getItems();
	}

	//Returns the description of the item the player chooses
	public String examine(String item){
		for (Item i: inventory){
			if (i.getName().equals(item)){
				return i.examine();
			}
		}
		return ("This item does not exist in your inventory.");
	}

	//Moves the player based on whether the direction input matches a possible exit for the current room
	public String move(String direction) {
		HashMap<String, Room> exits = room.getExits();
		if (exits.containsKey(direction)) {
			this.room = exits.get(direction);
			return("You have entered the " + exits.get(direction).getName().toLowerCase() +".");
		}
		else {
			return ("You cannot go this way.");
		}
	}


	//Takes an item from the current room if it contains one, otherwise returns error message
	public String take(String item) {
		for (Item i : room.getItems()) {
			if (i.getName().toLowerCase().equals(item)) {
				inventory.add(i);
				room.removeItem(i);
				return (i.getName() + " has been added to your inventory.");
			}
		}
		return ("This item does not exist here.");
	}

	//Drops the selected item in the current room if possible, otherwise returns error message
	public String drop(String item) {
		for (Item i : inventory) {
			if (i.getName().toLowerCase().equals(item)) {
				inventory.remove(i);
				room.addItem(i);
				return (i.getName() + " has been removed from your inventory.");
			}
		}
		return ("This item is not in your inventory.");
	}


	//Uses the currently selected item if possible, otherwise returns error message
	public String use(String item) {
		for (Item i : inventory) {
			if (i.getName().equals(item)) {
				if (i.getUseRoom().equals(room.getName()))
					return (i.getUse());
			}
		}
		return ("This item is not in your inventory.");
	}

	//returns the player's inventory as an arraylist of the item's names
	public ArrayList<String> getInventory(){
		ArrayList<String> inven = new ArrayList<>();
		for(Item item: inventory){
			inven.add(item.getName());
		}
		return inven;
	}

	//calls the look method from the room class
	public String look() {
		return room.look();
	}

	//calls the roomImage method from the room class
	public ImageIcon roomImage() {
		return room.getImage();
	}

	//returns an arraylist of the current room's exits
	public ArrayList<String> exits(){
		return this.room.exit();
	}


}
