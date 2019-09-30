import java.util.ArrayList;

public class Mobs {
	private String name;
	private ArrayList<Room> locations;
	private Room position;
	private ArrayList<String> dialogue = new ArrayList<>();
	private Items item;
	private Integer talktimes;
	
	public Mobs(String name, ArrayList<Room> locations, Room position, ArrayList<String> dialogue, Items item) {
		this.name = name;
		this.locations = locations;
		this.position = position;
		this.dialogue = dialogue;		
		this.item = item;
	}
	
	public String pet() {
		if(this.name == "Cat") {
			return("The cat hacks up a hairball.");
		}
		else {
			return("You are asked politely to stop.");
		}
	}
	
	public String give(Items item) {
		if(item == this.item) {
			return this.dialogue.get(0);

		}
		else {
			return("They do not want this item.");
		}
	}
	public String talk() {
		talktimes += 1;
		return this.dialogue.get(talktimes);
	}
	
	
}
