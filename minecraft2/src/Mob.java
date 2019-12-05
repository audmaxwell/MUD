import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Mob implements Runnable, Observer {
    private String name;
    private Room room;
    private ArrayList<String> dialogue;
    private long moveTimer;
    private Boolean playerinRoom;
    private long starttime;
    private Game game;
    private ImageIcon image;

    /*
     * @param room
     * @return the room that a mob starts the game in
     * @param dialogue
     * @return an arraylist of Strings containing the dialogue for a mob
     * @param image
     * @return An image that gets displayed in the mob window when a mob is in the same room as the player
     */
    public Mob(String name, Room room, ArrayList<String> dialogue, Game game, ImageIcon image){
        this.room = room;
        this.name = name;
        this.game = game;
        this.image = image;
        this.dialogue = dialogue;
        starttime = System.currentTimeMillis();
        playerinRoom = false;

    }
    //Returns a mob's image
    public ImageIcon getImage(){
        return image;
    }
    //Returns dialogue based on which mob the player is talking to and will randomly pick from the available dialogue
    public String talk(){
        if(this.name.equals("Cat")){
            return dialogue.get(0);
        }
        else if(this.name.equals("Tom")) {
        	switch(this.room.getName()) {
        	case "Hallway":
        		return dialogue.get(0);
			case "Guest Room":
        		return dialogue.get(1);
			case "Living Room":
        		return dialogue.get(2);
			case "Kitchen":
        		return dialogue.get(3);
			case "Basement":
        		return dialogue.get(4);
			case "Front Yard":
        		return dialogue.get(5);
			case "Rubble Pile":
        		return dialogue.get(6);
        	case "Shelter":
        		return dialogue.get(7);
			case "Stream":
        		return dialogue.get(8);
        	}
        }
        else{
            Random rand = new Random();
            return dialogue.get(rand.nextInt(dialogue.size()));
        }
		return null;
    }
    
    public String pet() {
    	if(this.name.equals("Cat")) {
    		return dialogue.get(1);
    	} else if(this.name.equals("Tom")) {
    		return dialogue.get(9);
    	} else {
    		return null;
    	}
    }

    /*The run method is responsible for moving the mobs
     * It generates a random number between 11 and 20 and the mob will move at that interval after the start time has elapsed
     * 
     */
    @Override
    public void run() {
        Random num = new Random();
        moveTimer = (num.nextInt(11) + 10) * 1000;
        while(true){
            if (System.currentTimeMillis() > starttime + moveTimer) {
                if(!playerinRoom){
                    moveMob();
                    starttime = System.currentTimeMillis();
                }

            }

        }

    }

    /*Allows the mobs to move from room to room
     * Creates a random value and uses that value to choose which exit in a room to use to move
     * will store the direction the mob moves in to a var
     * When a mob chooses an exit it removes the instance of that mob from the room and creates a new instance in the new room
     * It then updates the rest of the program and will update the GUI accordingly
     */
    private void moveMob(){
        Random random = new Random();
        int roomnd = random.nextInt(room.getExits().size());
        int i = 0;
        String direction = "";
        for(String s: room.getExits().keySet()){
            if(i == roomnd){
                direction = s;
            }
            else{
                i++;
            }
        }
        Room newroom = room.getExits().get(direction);
        room.removeMob(this);
        newroom.addMob(this);
        room = newroom;
        game.someoneMoves();


    }

    //Checks if the game has been ended and if so exits the program
    @Override
    public void update(Observable o, Object arg) {
        if(game.isOver){
            System.exit(0);
        }
        else{
            playerinRoom = game.player.getRoomobj() == room;

        }


    }
}
