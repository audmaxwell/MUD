public class Item {
    private String name;
    private String desc;
    private String use_room;
    private String use;


    public Item (String name, String description, String use_room, String use) {
        this.name = name;
        this.desc = description;
        this.use = use;
        this.use_room = use_room;

    }


    public String getName(){
        return this.name;
    }

    public String getUse(){
        return this.use;
    }

    public String examine() {
        return this.desc;
    }

    public String getUseRoom() {
        return use_room;
    }
}
