
import java.util.ArrayList;

public class Room {
	private String name;
	private String desc;
	private ArrayList<String> exits;
	private ArrayList<Item> items;
	public Room(String name, String description, ArrayList<String> exits, ArrayList<Item> items ) {
		this.name = name;
		desc = description;
		
		
		
		
	}
	
	public String look() {
		return desc;
	}
	
	public void item_add() {
		
	}
	
	public void exit_add() {
		
	}
	
	
	private  ArrayList<Item> item = new ArrayList<Item>();
	private ArrayList<String> exit = new ArrayList<String>();
	
	
	
}
