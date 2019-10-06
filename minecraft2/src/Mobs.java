import java.util.ArrayList;

public class Mob {
    private String name;
    private ArrayList<Room> locations;
    private String position;
    private ArrayList<String> dialogue;
    private String item;
    private Integer talktimes;

    public Mob  (String name, ArrayList<Room> locations, ArrayList<String> dialogue, String item, String position) {
        this.name = name;
        this.locations = locations;
        this.position = position;
        this.dialogue = dialogue;
        this.item = item;
    }

    public String getPosition(){
        return position;
    }

    public ArrayList<Room> getLocations(){
        return locations;
    }

    public String getName(){
        return name;
    }

    public String pet() {
        if(this.name.equals("Cat")) {
            return("The cat hacks up a hairball.");
        }
        else {
            return("You are asked politely to stop.");
        }
    }

    public String give(Item item) {
        if(item.getName().equals(this.item)) {
            return this.dialogue.get(0);

        }
        else {
            return("They do not want this item.");
        }
    }
    public String talk() {
        talktimes += 1;
        if(talktimes >= dialogue.size()){
            return this.dialogue.get(dialogue.size() - 1);
        }
        return this.dialogue.get(talktimes);
    }
}
