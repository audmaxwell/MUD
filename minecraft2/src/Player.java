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

	/**
	 *
	 * @return room name
	 */
	public String getRoom() {
		return room.getName();
	}

	/**
	 *
	 * @return room object
	 */
	public Room getRoomobj(){
		return room;
	}

	/**
	 *
	 * @return list of items in the player's room
	 */
	public ArrayList<Item> getRoomItems() {
		return room.getItems();
	}

	/**
	 *
	 * @param item
	 * @return description of the item selected in jcombobox
	 */
	public String examine(String item){
		for (Item i: inventory){
			if (i.getName().equals(item)){
				return i.examine();
			}
		}
		return ("This item does not exist in your inventory.");
	}

	/**
	 *
	 * @param direction
	 * @return correct text for when player moves to a new location
	 */
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


	/**
	 *
	 * @param item
	 * adds an item to your inventory
	 * @return a statement saying you have taken that item
	 */
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

	/**
	 * drops the selected item into the player's room and removes it from the player's inventory
	 * @param item
	 * @return
	 */
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
			if (i.getName().toLowerCase().equals(item)) {
				if(i.getName().equals("Flash Drive")) {
					if (i.getUseRoom().equals(room.getName())) {
						inventory.remove(i);
						return ("You plug the flash drive into the computer. A small window opens up containing several files, one is labeled 'ExperimentSummary.txt' "
								+ "You open the file and glance at the author name. It's your name in the file. You start reading the contents of the file that is "
								+ "somehow written by you. According to what you read, you were a scientist doing research on nuclear fusion. "
								+ "The file details an experiment to test a small-scale fusion reactor. You read how there was a chance the device could fail and the "
								+ "radiation that would be released in failure could cause damage to yourself and possibly the area around them. However there were supposed to "
								+ "be safety measures in place. Clearly the experiment failed, causing you to lose your memory and destroy the surrounding area.");
					}
				}
				else if (i.getUseRoom().equals(room.getName())){
						inventory.remove(i);
						return ("You've succesfully used the " + item + "!");
					}
				else {
					return ("You cannot use this item.");
				}
				}

			}

		return("Please select an item.");


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
	public String give(String itemgiven){
		String text = "";
		if(this.getRoomobj().getStaticmob() == null){
			text =  this.getRoomobj().getMob().get(0).give();
		}
		else{
			text = this.getRoomobj().getStaticmob().give(itemgiven);
			if(this.getRoomobj().getStaticmob().isHasItem()){
				for(Item i: inventory){
					if (i.getName().equals(itemgiven)){
						inventory.remove(i);
						return text;
					}
				}
			}
		}
		return text;
	}


}
