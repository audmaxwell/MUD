
public class Items {

}
public class Item {
	private String name;
	private String desc;
	private ArrayList<Room> use_room;
	
	public Item(String name, String description, ArrayList<Room> use_room) {
		this.name = name;
		desc = description;
		this.use_room = use_room;
		
	}
	
	
			
	
	public String examine() {
		return desc;
	}
	
	public void use() {
		if(use_room.contains(Player.room)) {
			
		}else {
			System.out.println("This item cannot be used in this room.");
		}
		
	}
}
