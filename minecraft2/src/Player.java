import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	private Room room;
	private ArrayList<Item> inventory;
	
	/*
	 * @param room
	 * @return the item that the player is currently in
	 * @param inventory
	 * @return a list of all the items that the player has picked during a game session
	 */
	public Player(Room room, ArrayList<Item> inventory) {
		this.room = room;
		this.inventory = inventory;
		
	}
	
	//Returns the room that the player is in
	public Room getRoom(){
		return this.room;
	}
	
	//A command that allows the player to get an item's description
	public String examine(Item item){
		return item.examine();
	}
	
	/*A command that allows the player to enter a direction and based on the room they are currently in will move the player through the corresponding exit to another room
	* Otherwise will return a statement telling the player that they cannot move in that direction
	*/
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

	//A command that allows the player to put an item in their inventory. If the item the player wants to pick up is not in the room, a statement will be returned saying so
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
	
	//A command that allows the player to remove an item from their inventory. If the item the player wants to remove is not in the inventory, a statement will be returned saying so
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
	
	/*A command that allows the player to use an item as well as beat the game. 
	 * When the current room matches the item's use room, its use statement will be returned
	 * If the player tries to use the Flash Drive item and they are in its use room, the game will return a statement saying the player has won, in addition to the use statement
	 */
	public String use(Item item) {
		if (item.getUseRoom().equals(this.room.getName())) {
			if(item.getName().equals("Flash Drive")){
				System.out.println("You win");
				System.exit(0);
			}
			return(item.getUse());
		}
		else {
			return ("This item cannot be used in this room.");
		}
	}

	//Returns the player's inventory list
	public ArrayList<String> getInventory(){
        ArrayList<String> inven = new ArrayList<>();
        for(Item item: inventory){
            inven.add(item.getName());
        }
        return inven;
	}
	//A command that the player can use to see if there are any items in the room and to get the room's description
	public String look() {
		return room.look();
	}

	//A command that allows the player to receive dialogue from a mob
	public String talk(Mob mob){
		return mob.talk();
	}

	//A command that allows the player to try and pet a mob
	public String pet(Mob mob){
		return mob.pet();
	}

	//A command that allows the player to try and give an item to a mob
	public String give(Mob mob, Item item){
		return mob.give(item);
	}

	//Returns the exits of the current room
	public ArrayList<String> exits(){
		return this.room.exit();
	}
	

}
