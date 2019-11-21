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

    public Mob(String name, Room room, ArrayList<String> dialogue, Game game, ImageIcon image){
        this.room = room;
        this.name = name;
        this.game = game;
        this.image = image;
        this.dialogue = dialogue;
        starttime = System.currentTimeMillis();
        playerinRoom = false;

    }
    public ImageIcon getImage(){
        return image;
    }
    public String talk(){
        if(this.name.equals("Cat")){
            return dialogue.get(0);
        }
        else{
            Random rand = new Random();
            return dialogue.get(rand.nextInt(dialogue.size()));
        }
    }

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
