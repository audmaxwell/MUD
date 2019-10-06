import java.util.ArrayList;

public class Mob {
    private String name;
    private ArrayList<Room> locations;
    private String position;
    private ArrayList<String> dialogue;
    private String item;
    private Integer talktimes;

    /*
     * @param locations
     * @return An arraylist that contains the rooms that a mob can appear in
     * @param dialogue
     * @return An arraylist that contains a mob's dialogue 
     * @param item
     * @return The item that a specific mob can be given by the player
     * @param position
     * @return The room that the mob is currently in
     */
    public Mob  (String name, ArrayList<Room> locations, ArrayList<String> dialogue, String item, String position) {
        this.name = name;
        this.locations = locations;
        this.position = position;
        this.dialogue = dialogue;
        this.item = item;
    }

    //Returns a mob's current position
    public String getPosition(){
        return position;
    }

    //Returns a mob's list of potential locations
    public ArrayList<Room> getLocations(){
        return locations;
    }

    //Returns a mob's name
    public String getName(){
        return name;
    }

    //The player attempts the pet a mob, if the mob is the cat then it will return unique dialogue, otherwise will return another statement
    public String pet() {
        if(this.name.equals("Cat")) {
            return("The cat hacks up a hairball.");
        }
        else {
            return("You are asked politely to stop.");
        }
    }

    /*The player tries to give a mob an item. If the item is an item the mob can accept, will return the mob's given item dialogue 
     * Otherwise will return a statement saying that the mob does not want the item
    */
    public String give(Item item) {
        if(item.getName().equals(this.item)) {
            return this.dialogue.get(0);

        }
        else {
            return("They do not want this item.");
        }
    }
    
    //Returns a dialogue piece from a mob's dialogue list. Will iterate through the list properly
    public String talk() {
        talktimes += 1;
        if(talktimes >= dialogue.size()){
            return this.dialogue.get(dialogue.size() - 1);
        }
        return this.dialogue.get(talktimes);
    }
}
