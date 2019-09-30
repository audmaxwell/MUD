import java.util.ArrayList;
import java.util.ArrayList;

import java.util.HashMap;


public class Room {
	private String name;
	private String desc;
	private HashMap<String, Room> exits = new HashMap<>();
	private ArrayList<Items> items = new ArrayList<Items>();
	public Room(String name, String desc, HashMap<String, Room> exits, ArrayList<Items> items ) {
		this.name = name;
		this.desc = desc;
		this.exits = exits;
		this.items = items;
	}
	
	public String look() {
		return this.desc;
	}
	
	public HashMap<String, Room> exit() {
		return exits;
	}
	}
	
