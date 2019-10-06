public class Item {
    private String name;
    private String desc;
    private String use_room;
    private String use;

/*
 * @param description
 * @return A general description of an the item
 * @param use_room
 * @return The room a particular item can be used in
 * @param use
 * @return A system dialogue describing what happens when an item is used
 */
    public Item (String name, String description, String use_room, String use) {
        this.name = name;
        this.desc = description;
        this.use = use;
        this.use_room = use_room;

    }

    //Returns an item's name
    public String getName(){
        return this.name;
    }
    
    //Returns an item's use statement
    public String getUse(){
        return this.use;
    }

    //Returns an item's description
    public String examine() {
        return this.desc;
    }

    //Returns an item's use room
    public String getUseRoom() {
        return use_room;
    }
}
