import java.util.ArrayList;

public class Room {
	private String name;
	private String desc;
	public Room(String name, String description) {
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
	
	private  ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<String> exits = new ArrayList<String>();
	
	
	
}
