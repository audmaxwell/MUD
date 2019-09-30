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
	
	
	private  ArrayList<Item> items = new ArrayList<Item>();
	
	
	
}
