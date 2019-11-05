import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Room {
	private String name;
	private String desc;
	private HashMap<String, Room> exits;
	private ArrayList<Item> items;
	private ImageIcon image;

	public Room(String name, String desc, HashMap<String, Room> exits, ArrayList<Item> items, ImageIcon image) {
		this.name = name;
		this.desc = desc;
		this.exits = exits;
		this.items = items;
		this.image = image;
	}
	public ArrayList<Item> getItems(){
		return items;
	}

	public ImageIcon getImage(){
		return image;
	}
	public void addItem(Item item){
		items.add(item);

	}
	public void removeItem(Item item){
		items.remove(item);
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
