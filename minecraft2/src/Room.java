import java.util.ArrayList;
import java.util.HashMap;

public class Room {
	private String name;
	private String desc;
	private HashMap<String, Room> exits;
	private ArrayList<Item> items;
	
	/*
	 * @param exits
	 * @return A Hashmap of the rooms where the key is the direction typed and the value is the room that exit takes the player to
	 * @param items
	 * @return an arraylist of items that contains all the items in a particular room
	 */

	public Room(String name, String desc, HashMap<String, Room> exits, ArrayList<Item> items) {
		this.name = name;
		this.desc = desc;
		this.exits = exits;
		this.items = items;
	}
	
	//Returns the items from a room's arraylist of items
	public ArrayList<Item> getItems(){
		return items;
	}

	//returns the name of a room
	public String getName(){
		return this.name;
	}

	/*Checks if the room's item arraylist contains any items and returns the room's description.
	 * If the arraylist is empty, returns a statement telling the player that there are no items in the room.
	 * Otherwise it returns a statement informing the player of the items in the room.
	 */
	
	public String look() {
		String output = desc;
		if(items.size() == 0){
			output += " There aren't any items you can take from this area.";
		}
		else{
			output += " Items in area: ";
			for(Item item : items){
				output += item.getName() + ", ";
			}
			output = output.substring(0, output.length() - 2);
		}
		return output;
	}

	//Returns the exits hashmap for a room
	public HashMap<String, Room> getExits(){
		return exits;
	}

	//Ask for clarification
	public ArrayList<String> exit() {
		ArrayList<String> directions = new ArrayList<>();
		for(String key : exits.keySet()){
			directions.add(key + " : " + exits.get(key).getName());
		}
		return directions;
	}
}
