import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFile extends JFrame implements ActionListener
{
    JPanel cards;
    JButton Intro, Begin, Back, Back2;
    JLabel Title;
    public MainFile()
    {
        setSize(1920, 1080);
        setResizable(true);
        setBackground(Color.gray);
        Intro = new JButton("Introduction");
        Begin = new JButton("Play Game");
        Back = new JButton("Back");
        Back2 = new JButton("Back");
        Title = new JLabel("The Rule Of Space");
        
        Intro.addActionListener(this);
        Begin.addActionListener(this);
        Back.addActionListener(this);
        Back2.addActionListener(this);
        
        JLabel backGround = new JLabel("New label");
        backGround.setBackground(Color.darkGray);
        backGround.setIcon(new ImageIcon("/Volumes/ANDREW2/The_Rule_Of_Space/Galaxy_backround.png"));     
        
        JPanel Menu = new JPanel();
        Menu.setBackground(Color.darkGray);
        Menu.setLayout(null);
        Menu.add(Begin);
        Begin.setBounds(779, 216, 362, 56);
        Menu.add(Intro);
        Intro.setBounds(779, 335, 362, 91);
        Menu.add(Title);
        Title.setFont(new Font("Lucia Grande", Font.PLAIN,80));
        Title.setBounds(647, 37, 800, 121);
        Menu.add(backGround);
        backGround.setBounds(0, 6, 1920, 1080);  
        
        JPanel Introduction = new JPanel();
        Introduction.setLayout(null);
        Introduction.add(Back2);
        Back2.setBounds(50, 750, 362, 91);
        
        JPanel Game = new JPanel();
        Game.setLayout(null);
        Game.add(Back);
        Back.setBounds(50, 750, 362, 91);
        
        cards = new JPanel(new CardLayout());
        
        cards.add(Menu, "Menu");
        cards.add(Introduction, "Introduction");
        cards.add(Game, "Game");
        
        getContentPane().add(cards);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {    
        if (e.getSource() == Begin)
        {    
         CardLayout cardLayout = (CardLayout) cards.getLayout();
         cardLayout.show(cards, "Game");   
        }
        else if (e.getSource() == Intro)
        {
         CardLayout cardLayout = (CardLayout) cards.getLayout();
         cardLayout.show(cards, "Introduction");
        }
        else
        {
         CardLayout cardLayout = (CardLayout) cards.getLayout();
         cardLayout.show(cards, "Menu");
        }
    }
    public static void main(String args[])
    {    
        new MainFile();  
    }
}
