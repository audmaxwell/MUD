import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Room {
    private String name;
    private String desc;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items;
    private ImageIcon image;
    private ArrayList<Mob> mobs;
    private StaticMob staticmob;

    /*
     * @param exits
     * @return A Hashmap of the rooms where the key is the direction typed and the value is the room that exit takes the player to
     * @param items
     * @return an arraylist of items that contains all the items in a particular room
     * @param image
     * @return The image that gets displayed on the Room JPanel
     */
    public Room(String name, String desc, HashMap<String, Room> exits, ArrayList<Item> items, ImageIcon image) {
        this.name = name;
        this.desc = desc;
        this.exits = exits;
        this.items = items;
        this.image = image;
        mobs = new ArrayList<>();
    }
    /*
     * @return A room's arrayList of items
     */
    public ArrayList<Item> getItems(){
        return items;
    }

    /*
     * @return A room's ImageIcon
     */
    public ImageIcon getImage(){
        return image;
    }
    /*
     * @param item object
     * adds an item to a room
     */
    public void addItem(Item item){
        items.add(item);

    }
    /*@param item object
     * Removes an item from a room
     */
    public void removeItem(Item item){
        items.remove(item);
    }

    /*
     * @return the mob in a room if the room is found to contain more than zero mobs, else returns null
     */
    public ArrayList<Mob> getMob(){
        if (mobs.size() > 0){
            return mobs;
        }
        else{
            return null;
        }
    }

    /*
     * @return name of the room
     */
    public String getName(){
        return this.name;
    }

    /*@param StaticMob object
     * adds a static mob to a room
     */
    public void addStaticMob(StaticMob mob){
        staticmob = mob;

    }
    
    /*
     * @return any Static Mob present in the room
     */
    public StaticMob getStaticmob(){
        return staticmob;
    }

    /*@param mob object
     * Adds a mob to the room
     */
    public void addMob(Mob mob){
        mobs.add(mob);
    }
    
    /*@param mob object
     * Removes a mob from the room
     */
    public void removeMob(Mob mob){
        mobs.remove(mob);
    }

    /*Checks if the room's item arraylist contains any items and returns the room's description.
     * If the arraylist is empty, returns a statement telling the player that there are no items in the room.
     * Otherwise it returns a statement informing the player of the items in the room.
     */
    public String look() {
        String output = desc;
        if(items.size() == 0){
            output += " There aren't any items you can take from this area.";
        }
        else{
            output += " Items in area: ";
            for(Item item : items){
                output += item.getName() + ", ";
            }
            output = output.substring(0, output.length() - 2);
        }
        return output;
    }

    /*
     *@return Hashmap of a room's exits
     */
    public HashMap<String, Room> getExits(){
        return exits;
    }

    /*
     * @return the directions for a room based off of the current room and the exits
     */
    public ArrayList<String> exit() {
        ArrayList<String> directions = new ArrayList<>();
        for(String key : exits.keySet()){
            directions.add(key + " : " + exits.get(key).getName());
        }
        return directions;
    }
}
