import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Mob implements Runnable, Observer {
    private String name;
    private Room room;
    private ArrayList<String> dialogue;
    private float moveTimer;
    private Boolean isTalking;
    private float starttime;

    public Mob(String name, Room room, ArrayList<String> dialogue){
        this.room = room;
        this.name = name;
        this.dialogue = dialogue;
        starttime = System.currentTimeMillis();

    }

    @Override
    public void run() {
        Random num = new Random();
        float timePassed = 0;
        moveTimer = (num.nextInt(10) + 10) * 1000;
        while(true){
            if (System.currentTimeMillis() > starttime + moveTimer) {

            }

        }

    }

    private void moveMob(){
        Random random = new Random();
        int roomnd = random.nextInt(room.getExits().size());
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
