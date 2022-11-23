import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class InitialDisplay {
    // displays to user Yahtzee home page and start then gets config info
    // then goes to players page

    // constructor
    public InitialDisplay() {
        // do nothing
    }
    public void Display() {
        // intial Game startGameFrame settings
        JFrame startGameFrame = new JFrame("Yahtzee");
        startGameFrame.setLayout(new BorderLayout());
        
        JPanel imageP = new JPanel();
        JPanel configP = new JPanel();
        configP.setSize(400, 400);

        // image
        JLabel yahtzee = new JLabel();
        yahtzee.setIcon(new ImageIcon("images/Yahtzee.jpg"));
        imageP.add(yahtzee);

        // Get settings of game then call make players
        JButton start = new JButton("Start Game");
        start.setPreferredSize(new Dimension(600, 100));

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("Start Game Button Clicked");
                configP.removeAll();

                JLabel sdLbl = new JLabel("Number of Sides: ");
                JLabel dieLbl = new JLabel("Number of Dice: ");
                JLabel playerLbl = new JLabel("Number of Players");

                sdLbl.setFont(new Font("Attribute", Font.PLAIN, 30));
                dieLbl.setFont(new Font("Attribute", Font.PLAIN, 30));
                playerLbl.setFont(new Font("Attribute", Font.PLAIN, 30));
        
                // sides and number of die options
                String[] sides = {"6", "8", "12"};
                String[] die = {"5", "6", "7"};
                String[] player = {"1", "2", "3", "4"};
        
                // drop down menus
                final JComboBox<String> sd = new JComboBox<String>(sides);
                final JComboBox<String> di  = new JComboBox<String>(die);
                final JComboBox<String> pl = new JComboBox<String>(player);
        
                // formatting
                Box layout = Box.createVerticalBox();

                Box box = Box.createHorizontalBox();
                box.add(sdLbl);
                box.add(sd);

                Box box2 = Box.createHorizontalBox();
                box2.add(dieLbl);
                box2.add(di);

                Box box3 = Box.createHorizontalBox();
                box3.add(playerLbl);
                box3.add(pl);

                layout.add(box);
                layout.add(box2);
                layout.add(box3);
                sd.setVisible(true);
                configP.add(layout);
        
                // ok button
                JButton btn = new JButton("OK");
                btn.setPreferredSize(new Dimension(400, 100));
                btn.addActionListener(new ActionListener() {
                    // runs game based on user selections
                    public void actionPerformed(ActionEvent e) {

                        System.out.println("Okay Button clicked");

                        int index = sd.getSelectedIndex();

                        int sideDie = Integer.parseInt(sides[index]);
                        index = di.getSelectedIndex();

                        int numDie = Integer.parseInt(die[index]);
                        index = pl.getSelectedIndex();

                        int numPlayers = Integer.parseInt(player[index]);

                        startGameFrame.dispose();

                        MakePlayers mp = new MakePlayers(numDie, 2, sideDie, numPlayers);
                        mp.getPlayers();
                    }
                });
                configP.add(btn);

                configP.repaint();
                configP.revalidate(); 
            }
        });
        configP.add(start, BorderLayout.PAGE_END);

        startGameFrame.add(imageP, BorderLayout.PAGE_START);
        startGameFrame.add(configP, BorderLayout.CENTER);

        startGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startGameFrame.setSize(1000,800);
        startGameFrame.setLocationRelativeTo(null);
        startGameFrame.setResizable(false);
        startGameFrame.setVisible(true);  
    }
}
