import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	private Room room;
	private ArrayList<Item> inventory;
	public Player(Room room, ArrayList<Item> inventory) {
		this.room = room;
		this.inventory = inventory;
		
	}
	public Room getRoom(){
		return this.room;
	}
	public String examine(Item item){
		return item.examine();
	}
	
	public String move(String direction) {
		HashMap<String, Room> exits = room.getExits();
		if (exits.containsKey(direction)) {
			this.room = exits.get(direction);
			return("You have entered the " + exits.get(direction).getName().toLowerCase() +".");
		}
		else {
			return ("You cannot go this way.");
		}
	}


	public String take(Item item) {
		if(room.getItems().contains(item)){
			inventory.add(item);
			room.getItems().remove(item);
			return(item.getName() + " has been added to your inventory.");
		}
		else{
			return("This item does not exist here.");
		}
	}
	
	public String drop(Item item) {
		if(inventory.contains(item)) {
			inventory.remove(item);
			this.room.getItems().add(item);
			return (item.getName() + " has been removed from your inventory.");
		}
		else{
			return ("This item does not exist.");
		}

	}
	public String use(Item item) {
		if (item.getUseRoom().equals(this.room.getName())) {
			if(item.getName().equals("Computer")){
				System.out.println("You win");
				System.exit(0);
			}
			return(item.getUse());
		}
		else {
			return ("This item cannot be used in this room.");
		}
	}

	public ArrayList<Item> getInventory(){
			return this.inventory;
		}
	public String look() {
		return room.look();
	}

	public String talk(Mob mob){
		return mob.talk();
	}

	public String pet(Mob mob){
		return mob.pet();
	}

	public String give(Mob mob, Item item){
		return mob.give(item);
	}

	public ArrayList<String> exits(){
		return this.room.exit();
	}
	

}
