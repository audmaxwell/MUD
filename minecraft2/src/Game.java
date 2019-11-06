import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * GUI class to manage all visual components
 */
public class GUI {
    private Player player;
    private ImageIcon bedroom;
    private ImageIcon hallway;
    private JFrame frame;
    private JLabel center;

    /**
     * GUI constructor takes in a player to perform all commands and operations
     * @param player
     */
    public GUI(Player player){
        this.player = player;
        this.center = new JLabel();


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

        JTextArea desc = new JTextArea(player.look());
        desc.setFont(desc.getFont().deriveFont(20f));
        desc.setLineWrap(true);
        desc.setMaximumSize(new Dimension(1000,500));
        forwards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desc.setText(player.move("forwards") + player.exits());
                center.setIcon(player.roomImage());

            }
        });
        backwards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desc.setText(player.move("backwards"));
                center.setIcon(player.roomImage());

            }
        });
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desc.setText(player.move("up"));
                center.setIcon(player.roomImage());

            }
        });
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desc.setText(player.move("down"));
                center.setIcon(player.roomImage());

            }
        });
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desc.setText(player.move("left"));
                center.setIcon(player.roomImage());

            }
        });
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desc.setText(player.move("right"));
                center.setIcon(player.roomImage());

            }
        });


        JFrame frame = new JFrame("Image display");
        frame.setSize(1000, 1000);
        ImageIcon roomimg = player.roomImage();
        center.setIcon(roomimg);
        center.setPreferredSize(new Dimension(1000,1000));
        frame.add(center, BorderLayout.CENTER);
        desc.setPreferredSize(new Dimension(300,100));
        frame.add(desc,BorderLayout.SOUTH);
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
        frame.add(commands,BorderLayout.EAST);
        frame.setVisible(true);

        JButton examine = new JButton("Examine");
        JButton drop = new JButton("Drop");
        JButton use = new JButton("Use");
        JButton take = new JButton("Take");
        JLabel invLabel = new JLabel("");
        JLabel emptyInv = new JLabel("Your Inventory Does Not Contain Any Items.");
        JLabel error = new JLabel("");

        JComboBox<String> inv = new JComboBox<>();

        JFrame invFrame = new JFrame("Inventory");
        invFrame.setSize(1000, 1000);




        examine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(player.getInventory().size() == 0) {
                    String no_item = "No items in inventory";
                    error.setText(no_item);
                } else {
                    String item_desc = player.examine(inv.getItemAt(inv.getSelectedIndex()));
                    invLabel.setText(item_desc);
                    error.setText("");
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
                if(player.getInventory().size() == 0) {
                    String no_item = "No items in inventory";
                    error.setText(no_item);
                }
                if (inv.getSelectedItem() == null){
                    error.setText("Please select an item.");
                }else {
                    player.drop(inv.getSelectedItem().toString().toLowerCase());
                    inv.removeItem(inv.getSelectedItem());
                    error.setText("");
                    invLabel.setText("");
                    desc.setText(player.look());
                    if(inv.getItemCount() == 0) {
                        invFrame.remove(inv);
                        invFrame.add(emptyInv);
                        desc.setText(player.look());
                        SwingUtilities.updateComponentTreeUI(invFrame);
                    }
                }
            }
        });


        take.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(player.getRoomItems().size() == 0) {
                    error.setText("There are no items in this room");
                } else {
                    player.take(player.getRoomItems().get(0).getName().toLowerCase());
                    invFrame.remove(emptyInv);
                    int i = (player.getInventory().size() - 1);
                    inv.addItem(player.getInventory().get(i));
                    invFrame.add(inv, BorderLayout.WEST);
                    desc.setText(player.look());
                    error.setText("");
                    SwingUtilities.updateComponentTreeUI(invFrame);
                }

            }
        });
        JPanel invComs = new JPanel();
        invComs.setPreferredSize(new Dimension(200,300));
        invComs.setLayout(new GridLayout(1,4));
        invComs.add(take);
        invComs.add(examine);
        invComs.add(use);
        invComs.add(drop);
        invFrame.add(emptyInv, BorderLayout.WEST);
        invFrame.add(error, BorderLayout.CENTER);
        invFrame.add(invLabel, BorderLayout.EAST);
        invFrame.add(invComs, BorderLayout.SOUTH);
        invFrame.setVisible(true);
        invFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

}
