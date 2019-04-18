import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

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
        
        //String IntroTxt = new String(Files.readAllBytes(Paths.get("/Volumes/ANDREW2/The_Rule_Of_Space/test.txt")));
        
        Color Purple = new Color(89, 21, 191);
        Color Neon = new Color(170, 255, 2);
        Color Sand =new Color(209, 159, 79);
        
        Intro.addActionListener(this);
        Begin.addActionListener(this);
        Back.addActionListener(this);
        Back2.addActionListener(this);
        
        JLabel MainbackGround = new JLabel("New label");
        MainbackGround.setBackground(Color.darkGray);
        MainbackGround.setIcon(new ImageIcon("/Volumes/ANDREW2/The_Rule_Of_Space/Galaxy_backround.png"));     
        
        JLabel IntrobackGround = new JLabel("New label");
        IntrobackGround.setBackground(Color.darkGray);
        IntrobackGround.setIcon(new ImageIcon("/Volumes/ANDREW2/The_Rule_Of_Space/IntroBackround.jpg")); 
        
        JLabel GamebackGround = new JLabel("New label");
        GamebackGround.setBackground(Color.darkGray);
        GamebackGround.setIcon(new ImageIcon("/Volumes/ANDREW2/The_Rule_Of_Space/GameBackround.jpeg")); 
        
        JPanel Menu = new JPanel();
        Menu.setBackground(Color.darkGray);
        Menu.setLayout(null);
        Menu.add(Begin);
        Begin.setBackground(Neon);
        Begin.setOpaque(true);
        Begin.setBorder(BorderFactory.createBevelBorder(0, Purple, Color.white));
        Begin.setBounds(779, 216, 362, 56);
        Begin.setForeground(Purple);
        Menu.add(Intro);
        Intro.setBackground(Neon);
        Intro.setOpaque(true);
        Intro.setBorder(BorderFactory.createBevelBorder(0, Purple, Color.white));
        Intro.setBounds(779, 335, 362, 91);
        Intro.setForeground(Purple);
        Menu.add(Title);
        Title.setFont(new Font("Desdemona", Font.BOLD,150));
        Title.setForeground(Neon);
        Title.setBounds(425, 37, 1500, 121);
        Menu.add(MainbackGround);
        MainbackGround.setBounds(0, 0, 1920, 1080);  
        
        JPanel Introduction = new JPanel();
        Introduction.setLayout(null);
        Introduction.add(Back2);
        Back2.setBackground(Sand);
        Back2.setOpaque(true);
        Back2.setBorder(BorderFactory.createBevelBorder(0, Color.white, Color.black));
        Back2.setForeground(Color.black);
        Back2.setBounds(50, 750, 362, 91);
        Introduction.add(IntrobackGround);
        IntrobackGround.setBounds(0, 0, 1920, 1080);
        
        JPanel Game = new JPanel();
        Game.setLayout(null);
        Game.add(Back);
        Back.setBounds(50, 750, 362, 91);
        Game.add(GamebackGround);
        GamebackGround.setBounds(0, 0, 1920, 1080);
        
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
        else if (e.getSource() == Back)
        {
         CardLayout cardLayout = (CardLayout) cards.getLayout();
         cardLayout.show(cards, "Menu");
        }
        else if (e.getSource() == Back2)
        {
         CardLayout cardLayout = (CardLayout) cards.getLayout();
         cardLayout.show(cards, "Menu");            
        }
        else
        {
        }
    }
    public static void main(String args[])
    {    
        new MainFile();  
    }
}
