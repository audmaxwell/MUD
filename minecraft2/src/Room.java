import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Room {
	private String name;
	private String desc;
	private HashMap<String, Room> exits;
	private ArrayList<Item> items;

	public Room(String name, String desc, HashMap<String, Room> exits, ArrayList<Item> items) {
		this.name = name;
		this.desc = desc;
		this.exits = exits;
		this.items = items;
	}
	public ArrayList<Item> getItems(){
		return items;
	}

	public String getName(){
		return this.name;
	}

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

	public HashMap<String, Room> getExits(){
		return exits;
	}

	public ArrayList<String> exit() {
		ArrayList<String> directions = new ArrayList<>();
		for(String key : exits.keySet()){
			directions.add(key + " : " + exits.get(key).getName());
		}
		return directions;
	}
}
