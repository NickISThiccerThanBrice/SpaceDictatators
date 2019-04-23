import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.border.Border;

public class MainFile2
{
    JPanel cards;
    JButton Intro, Begin, Back, Back2, Planet6, DontAttack, Attack;
    JLabel Title;
    JPanel YesNo;
    int[] Troops1 = new int[12];
    int[] GroundVehicles1 = new int[12];
    int[] AirVehicles1 = new int[12];
    public int Planet = 1;
    public MainFile2()
    {
        
        JFrame MainFile2 = new JFrame();
        
        JFrame YesNo = new JFrame();
        YesNo.setSize(500, 300);       
        
        MainFile2.setSize(1920, 1080);
        MainFile2.setResizable(true);
        MainFile2.setBackground(Color.gray);
        
        Intro = new JButton("Introduction");
        Begin = new JButton("Play Game");
        Back = new JButton("Back");
        Back2 = new JButton("Back");
        Title = new JLabel("The Rule Of Space");
        Attack = new JButton("ATTACK!");
        DontAttack = new JButton("Don't Attack");
        
        Color Purple = new Color(89, 21, 191);
        Color Neon = new Color(170, 255, 2);
        Color Sand =new Color(209, 159, 79);
        
        JLabel MainbackGround = new JLabel("");
        MainbackGround.setBackground(Color.darkGray);
        MainbackGround.setIcon(new ImageIcon("/Volumes/ANDREW2/The_Rule_Of_Space/Pics/Galaxy_backround.png"));     
        
        JLabel IntrobackGround = new JLabel("");
        IntrobackGround.setBackground(Color.darkGray);
        IntrobackGround.setIcon(new ImageIcon("/Volumes/ANDREW2/The_Rule_Of_Space/Pics/IntroBackround.jpg")); 
        
        JLabel GamebackGround = new JLabel("");
        GamebackGround.setBackground(Color.darkGray);
        GamebackGround.setIcon(new ImageIcon("/Volumes/ANDREW2/The_Rule_Of_Space/Pics/GameBackround.jpeg")); 
        
        Planet6 = new JButton("");
        //JLabel Planet6 =new JLabel("");
        Planet6.setBackground(Color.darkGray);
        Planet6.setIcon(new ImageIcon("/Volumes/ANDREW2/The_Rule_Of_Space/Pics/Planet6.png"));
        //Planet6.setCursor(Cursor.getDefaultCursor());
        Planet6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 YesNo.setVisible(true);
                 Planet = 6;
            }
        });
        
        DontAttack.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 YesNo.setVisible(false);
            }
        });
        
        Attack.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 boolean Outcome = Bttle(6);
                 if (Outcome == true)
                 {
                 }
                 else
                 {
                 }
            }
        });
        
        JPanel Selection = new JPanel();
        Selection.setBackground(Purple);
        Selection.setLayout(null);
        Selection.add(Attack);
        Attack.setBounds(160,50,200,75);
        Selection.add(DontAttack);
        DontAttack.setBounds(160,150,200,75);
        
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
        GamebackGround.add(Planet6);
        Planet6.setBounds(1000, 500 , 150, 150);
        
        cards = new JPanel(new CardLayout());
        
        cards.add(Menu, "Menu");
        cards.add(Introduction, "Introduction");
        cards.add(Game, "Game");
        
        MainFile2.getContentPane().add(cards);
        YesNo.getContentPane().add(Selection);
        MainFile2.setVisible(true);
        YesNo.setVisible(false);
        
        Intro.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 CardLayout cardLayout = (CardLayout) cards.getLayout();
                 cardLayout.show(cards, "Introduction");        
            }
        });
        Begin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 CardLayout cardLayout = (CardLayout) cards.getLayout();
                 cardLayout.show(cards, "Game");        
            }
        });
        Back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 CardLayout cardLayout = (CardLayout) cards.getLayout();
                 cardLayout.show(cards, "Menu");        
            }
        });
        Back2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 CardLayout cardLayout = (CardLayout) cards.getLayout();
                 cardLayout.show(cards, "Menu");        
            }
        });
    }   
    public static void main(String args[])
    {    
        new MainFile2();
    }
    public boolean Bttle(int Planet)
    {
        boolean Outcome = false;
        int troops = Troops(Planet);
        int groundvehicles = GroundVehicles(Planet);
        int AirVehicles = AirVehicles(Planet);
        return Outcome;
        //planet value - your armys battle
    }
    public int Troops(int Planet)
    {
        Troops1[6] = 20000;
        int troops = Troops1[Planet];
        return troops;
    }
    public int GroundVehicles(int Planet)
    {
        GroundVehicles1[6] = 100;
        int groundvehicles = GroundVehicles1[Planet];
        return groundvehicles;        
    }
    public int AirVehicles(int Planet)
    {
        AirVehicles1[6] = 20;
        int airvehicles = AirVehicles1[Planet];
        return airvehicles;
    }
    
}
