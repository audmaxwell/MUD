import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	private Room room;
	private ArrayList<Item> inventory;
	public Player(Room room) {
		this.room = room;
		this.inventory = new ArrayList<>();
		
	}
	public String examine(String item){
		for (Item i: inventory){
			if (i.getName().equals(item)){
				return i.examine();
			}
		}
		return ("This item does not exist in your inventory.");
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


	public String take(String item) {
		for (Item i : room.getItems()) {
			if (i.getName().toLowerCase().equals(item)) {
				inventory.add(i);
				room.removeItem(i);
				return (i.getName() + " has been added to your inventory.");
			}
		}
		return ("This item does not exist here.");
	}

	public String drop(String item) {
		for (Item i : inventory) {
			if (i.getName().toLowerCase().equals(item)) {
				inventory.add(i);
				return (i.getName() + " has been removed from your inventory.");
			}
		}
		return ("This item is not in your inventory.");
		}


	public String use(String item) {
		for (Item i : inventory) {
			if (i.getName().equals(item)) {
				if (i.getUseRoom().equals(room.getName()))
					return (i.getUse());
			}
		}
		return ("This item is not in your inventory.");
	}

	public ArrayList<String> getInventory(){
		ArrayList<String> inven = new ArrayList<>();
		for(Item item: inventory){
			inven.add(item.getName());
		}
		return inven;
	}
	
	public Item[] getItemArray() {
		if(inventory.isEmpty() == true) {
			return null;
		} else {
			return (Item[]) (inventory.toArray());
		}
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
