import java.util.ArrayList;

import java.util.HashMap;


public class Room {
	private String name;
	private String desc;
	private HashMap<String, Room> exits = new HashMap<>();
	private ArrayList<Items> items;
	public Room(String name, String description, HashMap<String, Room> exits, ArrayList<Items> items ) {
		this.name = name;
		desc = description;
		this.exits = exits;
		this.items = items;
	}
	
	public String look() {
		return desc;
	}
	
	public HashMap<String, Room> exit() {{
		return exits;
	}
	}
	
	
}