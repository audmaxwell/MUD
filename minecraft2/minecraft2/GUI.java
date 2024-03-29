import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * GUI class to manage all visual components
 */
public class GUI implements Observer {

    private Player player;
    private ImageIcon bedroom;
    private ImageIcon hallway;
    private JPanel playerPanel;
    private JLabel center;
    private JLabel mobpic;
    private JComboBox<String> roominv;
    private JPanel invPanel;
    private Game game;
    private JPanel mobPanel;
    private JLabel mobtext;
    private JFrame gameFrame;

    /**
     * GUI constructor takes in a player to perform all commands and operations
     * @param player
     */
    public GUI(Player player, Game game){
        this.player = player;
        this.center = new JLabel();
        this.startGame();
        this.game = game;


    }

    /**
     * startGame method creates two windows; one for all movement commands, room images and descriptions,
     * the other window handles inventory and inventory commands
     */
    public void startGame(){
        JButton forwards = new JButton("forwards");
        JButton backwards = new JButton("backwards");
        JButton left = new JButton("left");
        JButton right = new JButton("right");
        JButton up = new JButton("up");
        JButton down = new JButton("down");
        JButton exit = new JButton("exit");

        JButton examine = new JButton("Examine");
        JButton drop = new JButton("Drop");
        JButton use = new JButton("Use");
        JButton take = new JButton("Take");
        JLabel invLabel = new JLabel("");
        JLabel emptyInv = new JLabel("Your Inventory Does Not Contain Any Items.");
        JLabel error = new JLabel("");

        JButton talk = new JButton("Talk");
        JButton pet = new JButton("Pet");
        JButton give = new JButton("Give");
        JLabel noMob = new JLabel("There is nobody in the room right now.");


        JComboBox<String> inv = new JComboBox<>();
        roominv = new JComboBox<>();

        invPanel = new JPanel();

        JTextArea desc = new JTextArea(player.look());
        desc.setFont(desc.getFont().deriveFont(20f));
        desc.setLineWrap(true);
        desc.setMaximumSize(new Dimension(1000,500));



        forwards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desc.setText(player.move("forwards") + player.exits());
                center.setIcon(player.roomImage());
                comboTime();

            }
        });
        backwards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desc.setText(player.move("backwards")  + player.exits());
                center.setIcon(player.roomImage());
                comboTime();


            }
        });
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desc.setText(player.move("up")  + player.exits());
                center.setIcon(player.roomImage());
                comboTime();
            }
        });
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desc.setText(player.move("down")  + player.exits());
                center.setIcon(player.roomImage());
                comboTime();


            }
        });
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desc.setText(player.move("left") + player.exits());
                center.setIcon(player.roomImage());
                comboTime();

            }
        });
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desc.setText(player.move("right") + player.exits());
                center.setIcon(player.roomImage());
                comboTime();

            }
        });


        JPanel playerPanel = new JPanel();
        //frame.setSize(1000, 1000);
        ImageIcon roomimg = player.roomImage();
        center.setIcon(roomimg);
        center.setPreferredSize(new Dimension(1000,1000));
        playerPanel.add(center, BorderLayout.CENTER);
        desc.setPreferredSize(new Dimension(300,100));
        playerPanel.add(desc,BorderLayout.SOUTH);
        JPanel commands = new JPanel();
        commands.setPreferredSize(new Dimension(200,300));
        commands.setLayout(new GridLayout(3,2));
        commands.add(forwards);
        commands.add(backwards);
        commands.add(right);
        commands.add(left);
        commands.add(up);
        commands.add(down);
        commands.setSize(new Dimension(300,500));
        playerPanel.add(commands,BorderLayout.EAST);
        playerPanel.add(exit, BorderLayout.NORTH);
        //frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.gameIsOver();
                game.someoneMoves();
            }
        });





        examine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(player.getInventory().size() != 0) {
                    if (inv.getSelectedItem() == null) {
                        error.setText("Please select an item.");
                    }
                    else{
                        String item_desc = player.examine(inv.getSelectedItem().toString());
                        invLabel.setText(item_desc);
                        error.setText("");
                        invPanel.add(invLabel,BorderLayout.CENTER);
                        SwingUtilities.updateComponentTreeUI(invPanel);
                }

                }
            }
        });


/**
 * use actionlistener currently returns nothing as no items can be used until we implement the MOB class
 */
        use.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(player.getInventory().size() == 0) {
                    String no_item = "No items in inventory";
                    error.setText(no_item);
                } else {
                    player.use(player.getInventory().get(0).toLowerCase());
                    error.setText("");

                }
            }
        });

        drop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(player.getInventory().size() != 0) {
                    player.drop(inv.getSelectedItem().toString().toLowerCase());
                    inv.removeItem(inv.getSelectedItem());
                    roominv.addItem(player.getRoomobj().getItems().get(player.getRoomobj().getItems().size() - 1).getName());
                    error.setText("");
                    invLabel.setText("");
                    desc.setText(player.look());
                }
                else if (inv.getSelectedItem() == null){
                    error.setText("Please select an item.");
                }
                }
        });


        take.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(player.getRoomobj().getItems().size() == 0) {
                    error.setText("There are no items in this room");
                } else {
                    if (roominv.getSelectedItem() == null){
                        error.setText("Please select an item.");
                    }else {
                        invPanel.remove(emptyInv);
                        player.take(roominv.getSelectedItem().toString().toLowerCase());
                        int i = (player.getInventory().size() - 1);
                        inv.addItem(player.getInventory().get(i));
                        invPanel.add(inv, BorderLayout.WEST);
                        desc.setText(player.look());
                        error.setText("");
                        SwingUtilities.updateComponentTreeUI(invPanel);

                        roominv.removeItem(roominv.getSelectedItem());
                        error.setText("");
                        invLabel.setText("");
                        desc.setText(player.look());
                        if(inv.getItemCount() == 0) {
                            invPanel.remove(inv);
                            invPanel.add(emptyInv);
                            desc.setText(player.look());
                            SwingUtilities.updateComponentTreeUI(invPanel);
                        }
                    }

                }

            }
        });
        JPanel invComs = new JPanel();
        invComs.setPreferredSize(new Dimension(200,300));
        invComs.setLayout(new GridLayout(1,4));
        invComs.add(take);
        invComs.add(drop);
        invComs.add(examine);
        invComs.add(use);
        invPanel.add(emptyInv, BorderLayout.WEST);
        invPanel.add(error, BorderLayout.CENTER);
        invPanel.add(invLabel, BorderLayout.EAST);
        invPanel.add(invComs, BorderLayout.SOUTH);
       // invFrame.setVisible(true);
        //invFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mobPanel = new JPanel();
        //mobPanel.setSize(1000,1000);
        JPanel mobComs = new JPanel();
        mobComs.setPreferredSize(new Dimension(200,300));
        mobComs.setLayout(new GridLayout(1,4));
        mobComs.setSize(1000, 1000);
        mobComs.add(talk);
        mobComs.add(pet);
        mobComs.add(give);
        mobPanel.add(mobComs, BorderLayout.SOUTH);
        mobtext = new JLabel("There is nobody around...");
        mobPanel.setVisible(true);
        //mobPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mobpic = new JLabel();
        mobPanel.add(mobtext,BorderLayout.CENTER);
        mobtext.setFont(new Font("Serif", Font.PLAIN, 20));
        mobPanel.add(mobpic, BorderLayout.WEST);

        talk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mobtext.setText(player.getRoomobj().getMob().get(0).talk());

            }
        });
        
        gameFrame = new JFrame("game window");
        gameFrame.setSize(2000,2000);
        GridLayout gameLayout = new GridLayout(1,3);
        gameFrame.setLayout(gameLayout);
        gameFrame.add(invPanel);
        gameFrame.add(playerPanel);
        gameFrame.add(mobPanel);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    
    
    public void comboTime(){
            for(int i = 0; i < roominv.getItemCount() ; i++){
                    roominv.removeItemAt(i);

            }
            for(int i = 0; i < player.getRoomobj().getItems().size() ; i++){
                roominv.addItem(player.getRoomobj().getItems().get(i).getName());
            }
            invPanel.add(roominv,BorderLayout.EAST);
            game.someoneMoves();
            SwingUtilities.updateComponentTreeUI(invPanel);


    }

    @Override
    public void update(Observable o, Object arg) {
        if(game.isOver){
            System.exit(0);
        }
        else if(player.getRoomobj().getMob() != null){
            for(Mob mob:player.getRoomobj().getMob()){
                mobpic.setIcon(mob.getImage());
                mobPanel.add(mobpic, BorderLayout.WEST);
                mobtext.setText("");
                SwingUtilities.updateComponentTreeUI(mobPanel);
            }
        }
        else{
            mobtext.setText("There is nobody around...");
            mobPanel.remove(mobpic);
            mobPanel.repaint();
            SwingUtilities.updateComponentTreeUI(mobPanel);
        }


    }
}
