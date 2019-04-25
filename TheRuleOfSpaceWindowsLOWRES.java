import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Random;
import javax.swing.border.Border;

public class RuleOfSpaceWindowsLOWRES
{
    JPanel cards, TheOutcome;
    JButton Intro, Begin, Back, Back2, DontAttack, Attack, Close, Close2, Close3, StoreButton, CloseStore, BuyTroops, BuyGroundVehicles, BuyAirVehicles;
    JButton  Planet1, Planet2, Planet3, Planet4, Planet5, Planet6;
    JLabel Title, GroundVehicleCounter, AirVehicleCounter, CannotAfford, Victory, Defeat, Description, IntroText;
    JPanel YesNo, NoMoney;
    int[] Troops1 = new int[12];    //creates an array for troops for each planet
    int[] GroundVehicles1 = new int[12];    //creates an array for GroundVehicles for each planet
    int[] AirVehicles1 = new int[12];   //creates an array for AirVehicles for each planet
    boolean[] PlanetOwnership = new boolean[12];    //creates a boolean array that tells if the player owns the planet or not
    private int Planet = 1; //An integer that says what planet is being interacted with
    private int PlayerTroops = 0; //Integer that says the amount of troops owned by the player
    private int PlayerGroundVehicles = 0;   //Integer that says the amount of ground vehicles owned by a player
    private int PlayerAirVehicles = 0;  //Integer that says the amount of air vehicles owned by a player
    private int PlayerMoney = 100000;   //Integer that says how much money the player has
    private JLabel TroopsCounter = new JLabel();
    private JLabel GroundVehiclesCounter = new JLabel();
    private JLabel AirVehiclesCounter = new JLabel();
    private JLabel MoneyCounter = new JLabel();
    private JLabel MoneyCounter2 = new JLabel();
    public RuleOfSpaceWindowsLOWRES()  
    { 
        JFrame RuleOfSpaceWindowsLOWRES = new JFrame();    //creates the main game JFrame
        RuleOfSpaceWindowsLOWRES.setSize(1366, 768);  //Sets bounds of main JFrame
        RuleOfSpaceWindowsLOWRES.setResizable(true);   //Allows the frame to be resized
        
        JFrame YesNo = new JFrame();    //Creates the JFrame for the selection window
        YesNo.setSize(700, 300);    //Sets bounds
        
        JFrame OutcomeWindow = new JFrame();    //creates a window that displays the outcome of the battle
        OutcomeWindow.setSize(1366, 768);  //Sets bounds
        
        JFrame Warning = new JFrame();  //Creates a new warning window
        Warning.setSize(500, 300);  //Sets bounds
        
        Intro = new JButton("Introduction");            //Start of creating obejects
        Begin = new JButton("Play Game");
        Back = new JButton("Back");
        Back2 = new JButton("Back");
        Title = new JLabel("The Rule Of Space");
        Attack = new JButton("ATTACK!");
        DontAttack = new JButton("Don't Attack");
        Close = new JButton("Close");
        Close2 = new JButton("Close");
        Close3 = new JButton("Colse");
        StoreButton = new JButton("Store");
        CloseStore = new JButton("Close");
        BuyTroops = new JButton("Buy Troops");
        BuyGroundVehicles = new JButton("Buy Ground Vehicles");
        BuyAirVehicles = new JButton("Buy Air Vehicles");
        CannotAfford = new JLabel("Not enough money");
        Victory = new JLabel("Victory");
        Defeat = new JLabel("Defeat");
        Description = new JLabel("");
        IntroText = new JLabel(FileReader());   //End of creating objects
        
        Color Purple = new Color(89, 21, 191); //Makes color objects
        Color Neon = new Color(170, 255, 2);
        Color Sand =new Color(209, 159, 79);
        Color GunMetal = new Color(42, 52, 57);   

        
        JLabel MainbackGround = new JLabel("");
        MainbackGround.setIcon(new ImageIcon("F:/The_Rule_Of_Space/Pics/Galaxy_backround.png"));    //gives the JLabel an image 
        
        JLabel IntrobackGround = new JLabel("");
        IntrobackGround.setIcon(new ImageIcon("F:/The_Rule_Of_Space/Pics/IntroBackround.jpg"));     //gives the JLabel an image
        
        JLabel GamebackGround = new JLabel("");
        GamebackGround.setIcon(new ImageIcon("F:/The_Rule_Of_Space/Pics/GameBackround.jpeg"));      //gives the JLabel an image
        
        JLabel StoreBackGround = new JLabel("");
        StoreBackGround.setIcon(new ImageIcon("F:/The_Rule_Of_Space/Pics/Store.jpg"));      //gives the JLabel an image
        
        JLabel VictoryBackGround = new JLabel("");
        VictoryBackGround.setIcon(new ImageIcon("F:/The_Rule_Of_Space/Pics/Victory.jpg"));      //gives the JLabel an image
        
        Planet1 = new JButton("");
        Planet1.setBackground(Color.darkGray);
        Planet1.setIcon(new ImageIcon("F:/The_Rule_Of_Space/Pics/Planet1.png"));    //gives the JLabel an image
        Planet1.setOpaque(false);
        Planet1.setContentAreaFilled(false);
        Planet1.setBorderPainted( false );
        
        Planet2 = new JButton("");
        Planet2.setBackground(Color.darkGray);
        Planet2.setIcon(new ImageIcon("F:/The_Rule_Of_Space/Pics/Planet2.png"));    //gives the JLabel an image
        Planet2.setOpaque(false);
        Planet2.setContentAreaFilled(false);
        Planet2.setBorderPainted( false );
        
        Planet3 = new JButton("");
        Planet3.setBackground(Color.darkGray);
        Planet3.setIcon(new ImageIcon("F:/The_Rule_Of_Space/Pics/Planet3.png"));    //gives the JLabel an image
        Planet3.setOpaque(false);
        Planet3.setContentAreaFilled(false);
        Planet3.setBorderPainted( false );
        
        Planet4 = new JButton("");
        Planet4.setBackground(Color.darkGray);
        Planet4.setIcon(new ImageIcon("F:/The_Rule_Of_Space/Pics/Planet4.png"));    //gives the JLabel an image
        Planet4.setOpaque(false);
        Planet4.setContentAreaFilled(false);
        Planet4.setBorderPainted( false );
        
        Planet5 = new JButton("");
        Planet5.setBackground(Color.darkGray);
        Planet5.setIcon(new ImageIcon("F:/The_Rule_Of_Space/Pics/Planet5.png"));    //gives the JLabel an image
        Planet5.setOpaque(false);
        Planet5.setContentAreaFilled(false);
        Planet5.setBorderPainted( false );
        
        Planet6 = new JButton("");
        Planet6.setBackground(Color.darkGray);
        Planet6.setIcon(new ImageIcon("F:/The_Rule_Of_Space/Pics/Planet6.png"));    //gives the JLabel an image
        Planet6.setOpaque(false);
        Planet6.setContentAreaFilled(false);
        Planet6.setBorderPainted( false );
        
        JPanel Win = new JPanel();  //Declares panel
        Win.setLayout(null);
        Win.add(Victory);   // Adds JLabel to panel
        Victory.setFont(new Font("Desdemona", Font.BOLD,300));  //Sets font and Size
        Victory.setForeground(Neon);    //Sets color
        Victory.setBounds(425, 300, 1500, 350); //Sets bounds and position of Victory text
        Win.add(Close2);    // Adds button to JPanel
        Close2.setBounds(50,500,275,72); //Sets bounds and position of button
        Close2.setBackground(GunMetal); //Sets color
        Close2.setForeground(Neon); //Sets color
        Win.add(VictoryBackGround); //Gives panel the JLabel to create background
        VictoryBackGround.setBounds(0,0,1366,768); //Sets bounds of background
        
        JPanel Lose = new JPanel();
        Lose.setBackground(Color.red);  //sets color
        Lose.setLayout(null);
        Lose.add(Defeat);   //Adds JLabel to JPanel
        Defeat.setFont(new Font("TimesRoman", Font.BOLD,300));  //Sets font and size
        Defeat.setForeground(GunMetal); //Sets color
        Defeat.setBounds(425, 300, 1500, 350);  //Sets position and bounds
        Lose.add(Close);    // adds Button to JPanel
        Close.setBounds(50,500,275,72);  //Sets bounds and position of button
        Close.setBackground(GunMetal);  //sets color
        Close.setForeground(Color.red); //Sets color
        
        JPanel Selection = new JPanel();  //Declares panel
        Selection.setBackground(GunMetal);  //Sets color
        Selection.setLayout(null);
        Selection.add(Description); //Adds Jlabel to Jpanel
        Description.setFont(new Font("TimesRoman", Font.BOLD,15));  //Sets font and font size
        Description.setText("This Planet Has " + Troops(Planet) + " Troops, " + GroundVehicles(Planet) + " Ground Vehicles, and " + AirVehicles(Planet) + " Air Vehicles");
        Description.setForeground(Neon); //sets color
        Description.setBounds(5, 0, 750, 50);   //Sets postion of text
        Selection.add(Attack);  //adds attack button         
        Attack.setBounds(225,60,200,75);    //Sets boundds and position
        Selection.add(DontAttack);  //adds dont attack button
        DontAttack.setBounds(225,150,200,75);   //Sets bounds and position
        
        JPanel Menu = new JPanel(); //Declares panel
        Menu.setLayout(null);
        Menu.add(Begin);    // adds Button to JPanel
        Begin.setBackground(Color.gray);    //sets color
        Begin.setOpaque(true);
        Begin.setBorder(BorderFactory.createBevelBorder(0, Color.white, Neon)); //Creates a border around button
        Begin.setBounds(500, 216, 362, 56); //sets bounds of button
        Begin.setForeground(Neon);  //sets color
        Menu.add(Intro);    //adds button to JPanel
        Intro.setBackground(Color.gray);    //sets color
        Intro.setOpaque(true);
        Intro.setBorder(BorderFactory.createBevelBorder(0, Color.white, Neon)); //Creates a border around button
        Intro.setBounds(500, 335, 362, 91); //sets bounds of button
        Intro.setForeground(Neon);  //sets color
        Menu.add(Title);    //adds JLabel to Jpanel
        Title.setFont(new Font("Desdemona", Font.BOLD,125));    //Sets font and font size
        Title.setForeground(Neon);  //sets color
        Title.setBounds(100, 37, 1500, 121);    //sets bounds and position
        Menu.add(MainbackGround);   // adds JLabel background to Jpanel
        MainbackGround.setBounds(0, 0, 1366, 768);  //sets bounds of background
        
        JPanel Introduction = new JPanel(); //Declares panel
        Introduction.setLayout(null);
        Introduction.add(IntroText); //Adds Jlabel to Jpanel
        IntroText.setFont(new Font("TimesRoman", Font.BOLD,25));    //Sets font and font size
        IntroText.setForeground(Neon);  //sets color
        IntroText.setBounds(800,100,362,91);    //sets bounds and position
        Introduction.add(Back2);    // adds Button to JPanel
        Back2.setBackground(Sand);  //sets color
        Back2.setOpaque(true);
        Back2.setBorder(BorderFactory.createBevelBorder(0, Color.white, Color.black));  //Creates a border around button
        Back2.setForeground(Color.black);   //sets color
        Back2.setBounds(50,500,275,72);  //sets bounds and position
        Introduction.add(IntrobackGround);   //Adds Jlabel to Jpanel
        IntrobackGround.setBounds(0, 0, 1366, 768);    //sets bounds and position of Background
        
        JPanel Game = new JPanel(); //Declares panel
        Game.setLayout(null);
        Game.add(MoneyCounter);  //Adds Jlabel to Jpanel
        MoneyCounter.setFont(new Font("TimesRoman", Font.BOLD,25)); //Sets font and font size
        MoneyCounter.setForeground(Neon);   //sets color
        MoneyCounter.setBounds(1625,5,362,91);  //sets bounds and position
        Game.add(Back); // adds Button to JPanel
        Back.setBounds(50,500,275,72);   //sets bounds and position
        Back.setBackground(GunMetal);   //sets color
        Back.setForeground(Color.blue); //sets color
        Game.add(StoreButton);  // adds Button to JPanel
        StoreButton.setBounds(50, 50, 275, 72); //sets bounds and position
        StoreButton.setBackground(GunMetal);    //sets color
        StoreButton.setForeground(Color.blue);  //sets color
        Game.add(GamebackGround);    //Adds Jlabel to Jpanel
        GamebackGround.setBounds(0, 0, 1366, 768); //sets bounds and position of Game back ground
        GamebackGround.add(Planet1);    // adds Button to JPanel
        Planet1.setBounds(500, 500, 200, 150);  //sets bounds and position of planet 1
        GamebackGround.add(Planet2);    // adds Button to JPanel
        Planet2.setBounds(200, 250, 175, 175);  //sets bounds and position of planet 2
        GamebackGround.add(Planet3);    // adds Button to JPanel
        Planet3.setBounds(1050, 200, 150, 150); //sets bounds and position of Planet3
        GamebackGround.add(Planet4);    // adds Button to JPanel
        Planet4.setBounds(750, 100, 150, 150);  //sets bounds and position of Planet 4
        GamebackGround.add(Planet5);    // adds Button to JPanel
        Planet5.setBounds(800, 500, 175, 175); //sets bounds and position of planet 5
        GamebackGround.add(Planet6);    // adds Button to JPanel
        Planet6.setBounds(1150, 500, 150, 150); //sets bounds and position of planet 6
        
        JPanel Store = new JPanel();    //Declares panel
        Store.setLayout(null);
        Store.add(StoreBackGround);  //Adds Jlabel to Jpanel
        StoreBackGround.setBounds(0,0,1366,768);
        StoreBackGround.add(MoneyCounter2);  //Adds Jlabel to Jpanel
        MoneyCounter2.setFont(new Font("TimesRoman", Font.BOLD,25));    //Sets font and font size
        MoneyCounter2.setForeground(Neon);  //sets color
        MoneyCounter2.setBounds(1100,5,275,72); //sets bounds and position
        StoreBackGround.add(TroopsCounter);  //Adds Jlabel to Jpanel
        TroopsCounter.setFont(new Font("TimesRoman", Font.BOLD,40));    //Sets font and font size
        TroopsCounter.setForeground(Neon);  //sets color
        TroopsCounter.setBounds(100,50,275,72); //sets bounds and position
        StoreBackGround.add(GroundVehiclesCounter);  //Adds Jlabel to Jpanel
        GroundVehiclesCounter.setFont(new Font("TimesRoman", Font.BOLD,40));    //Sets font and font size
        GroundVehiclesCounter.setForeground(Neon);  //sets color
        GroundVehiclesCounter.setBounds(500,50,500,91); //sets bounds and position
        StoreBackGround.add(AirVehiclesCounter);     //Adds Jlabel to Jpanel
        AirVehiclesCounter.setFont(new Font("TimesRoman", Font.BOLD,40));   //Sets font and font size
        AirVehiclesCounter.setForeground(Neon); //sets color
        AirVehiclesCounter.setBounds(1000,50,275,72);   //sets bounds and position
        StoreBackGround.add(CloseStore);    // adds Button to JPanel
        CloseStore.setBounds(50,500,275,72); //sets bounds and position
        CloseStore.setBackground(GunMetal); //sets color
        CloseStore.setForeground(Neon); //sets color
        StoreBackGround.add(BuyTroops); // adds Button to JPanel
        BuyTroops.setBounds(100, 300, 275, 72); //sets bounds and position
        BuyTroops.setBackground(GunMetal);  //sets color
        BuyTroops.setForeground(Neon);  //sets color
        StoreBackGround.add(BuyGroundVehicles); // adds Button to JPanel
        BuyGroundVehicles.setBounds(550, 300, 275, 72); //sets bounds and position
        BuyGroundVehicles.setBackground(GunMetal);  //sets color
        BuyGroundVehicles.setForeground(Neon);  //sets color
        StoreBackGround.add(BuyAirVehicles);    // adds Button to JPanel
        BuyAirVehicles.setBounds(1000, 300, 275, 72);   //sets bounds and position
        BuyAirVehicles.setBackground(GunMetal); //sets color
        BuyAirVehicles.setForeground(Neon); //sets color
        
        JPanel NoMoney = new JPanel();  //Declares panel
        NoMoney.setLayout(null);
        NoMoney.setBackground(GunMetal);    //sets color
        NoMoney.add(Close3);    // adds Button to JPanel
        Close3.setBounds(50,150,200,75);    //sets bounds and position
        Close3.setForeground(Color.red);    //sets color
        Close3.setBorder(BorderFactory.createBevelBorder(0, Color.red, Color.red));
        NoMoney.add(CannotAfford);   //Adds Jlabel to Jpanel
        CannotAfford.setFont(new Font("TimesRoman", Font.BOLD,25)); //Sets font and font size
        CannotAfford.setBounds(150,2,400,200);  //sets bounds and position
        CannotAfford.setForeground(Color.red);  //sets color

        
        cards = new JPanel(new CardLayout());   //creates new card layout
        
        cards.add(Menu, "Menu");    //adds Jpanel to card layout
        cards.add(Introduction, "Introduction");     //adds Jpanel to card layout
        cards.add(Game, "Game");     //adds Jpanel to card layout
        cards.add(Store, "Store");   //adds Jpanel to card layout
            
        TheOutcome = new JPanel(new CardLayout());  //creates new card layout
        
        TheOutcome.add(Lose, "Lose");   //adds Jpanel to card layout
        TheOutcome.add(Win, "Win"); //adds Jpanel to card layout
        
        RuleOfSpaceWindowsLOWRES.getContentPane().add(cards);
        YesNo.getContentPane().add(Selection);
        OutcomeWindow.getContentPane().add(TheOutcome);
        Warning.getContentPane().add(NoMoney);
        
        RuleOfSpaceWindowsLOWRES.setVisible(true); //sets visibility
        YesNo.setVisible(false);    //sets visibility
        OutcomeWindow.setVisible(false);    //sets visibility
        Warning.setVisible(false);  //sets visibility
        
        
        
        DontAttack.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 YesNo.setVisible(false);   //sets visibility
            }
        });
        
        
        Attack.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 boolean Outcome = Bttle(Planet);
                 YesNo.setVisible(false);   //sets visibility
                 if (Outcome == true)
                 {
                     OutcomeWindow.setVisible(true);    //sets visibility
                     CardLayout cardLayout = (CardLayout) TheOutcome.getLayout();
                     cardLayout.show(TheOutcome, "Win");
                     PlayerMoney = PlayerMoney + 200000;
                     MoneyCounter2.setText(TheMoneyCounter2(PlayerMoney) + " Dollars");
                     MoneyCounter.setText(TheMoneyCounter(PlayerMoney) + " Dollars");
                 }
                 else
                 {
                     OutcomeWindow.setVisible(true);    //sets visibility
                     CardLayout cardLayout = (CardLayout) TheOutcome.getLayout();
                     PlayerTroops = PlayerTroops/2;
                     PlayerGroundVehicles = PlayerGroundVehicles/2;
                     PlayerAirVehicles = PlayerAirVehicles/2;
                     cardLayout.show(TheOutcome, "Lose");
                 }
            }
        });
        
        
        Close.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 OutcomeWindow.setVisible(false);   //sets visibility
            }
        });
        

        Close2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 OutcomeWindow.setVisible(false);   //sets visibility
            }
        });
        
        
        Close3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 Warning.setVisible(false); //sets visibility
            }
        });
        
        
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
                 TheMoneyCounter(PlayerMoney);
                 TheMoneyCounter2(PlayerMoney);
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
        
        
        StoreButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 CardLayout cardLayout = (CardLayout) cards.getLayout();
                 cardLayout.show(cards, "Store");
            }
        });
        
        
        CloseStore.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 CardLayout cardLayout = (CardLayout) cards.getLayout();
                 cardLayout.show(cards, "Game");        
            }
        });
        
        
        BuyTroops.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (PlayerMoney >= 100)
                {
                    PlayerTroops = PlayerTroops + 1;       
                    PlayerMoney = PlayerMoney - 100;    //Subtracts money
                    TroopsCounter.setText("Troops " + TheTroopsCounter(PlayerTroops));  //changes the troops displayed
                    MoneyCounter2.setText(TheMoneyCounter2(PlayerMoney) + " Dollars");  //changes the money displayed
                    MoneyCounter.setText(TheMoneyCounter(PlayerMoney) + " Dollars");    //changes the money displayed
                }
                else
                {
                    Warning.setVisible(true);   //sets visibility
                }
            }
        });
        
        
        BuyGroundVehicles.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (PlayerMoney >= 10000)
                {
                    PlayerGroundVehicles = PlayerGroundVehicles + 1;       
                    PlayerMoney = PlayerMoney - 10000;  //Subtracts money
                    GroundVehiclesCounter.setText("Ground Vehicles " + TheGroundVehiclesCounter(PlayerGroundVehicles)); //changes the Ground vehicles displayed
                    MoneyCounter2.setText(TheMoneyCounter2(PlayerMoney) + " Dollars");  //changes the money displayed
                    MoneyCounter.setText(TheMoneyCounter(PlayerMoney) + " Dollars");    //changes the money displayed
                }
                else
                {
                    Warning.setVisible(true);   //sets visibility
                }       
            }
        });
        
        
        BuyAirVehicles.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (PlayerMoney >= 30000)
                {
                    PlayerAirVehicles = PlayerAirVehicles + 1;       
                    PlayerMoney = PlayerMoney - 30000;  //Subtracts money
                    AirVehiclesCounter.setText("Air Vehicles " + TheAirVehiclesCounter(PlayerAirVehicles)); //changes the Air Vehicles displayed
                    MoneyCounter2.setText(TheMoneyCounter2(PlayerMoney) + " Dollars");  //changes the money displayed
                    MoneyCounter.setText(TheMoneyCounter(PlayerMoney) + " Dollars");    //changes the money displayed
                }
                else
                {
                    Warning.setVisible(true);   //sets visibility
                }            
            }
        });
        
        
        Planet1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(PlanetOwnership[1] == false)
                {
                    YesNo.setVisible(true); //sets visibility
                    Planet = 1; //sets planet
                }
                else
                {
                }
            }
        });
        
        
        Planet2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(PlanetOwnership[2] == false)
                {
                    YesNo.setVisible(true); //sets visibility
                    Planet = 2; //sets planet
                }
                else
                {
                }
            }
        });
        
        
        Planet3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(PlanetOwnership[3] == false)
                {
                    YesNo.setVisible(true); //sets visibility
                    Planet = 3; //sets planet
                }
                else
                {
                }
            }
        });
        
        
        Planet4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(PlanetOwnership[4] == false)
                {
                    YesNo.setVisible(true); //sets visibility
                    Planet = 4; //sets planet
                }
                else
                {
                }
            }
        });
        
        
        Planet5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(PlanetOwnership[5] == false)
                {
                    YesNo.setVisible(true); //sets visibility
                    Planet = 5; //sets planet
                }
                else
                {
                }
            }
        });
        
        
        Planet6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(PlanetOwnership[6] == false)
                {
                    YesNo.setVisible(true); //sets visibility
                    Planet = 6; //sets planet
                }
                else
                {
                }
            }
        });
    } 
    
    
    public static void main(String args[]) 
    {    
        new RuleOfSpaceWindowsLOWRES();
    }
    
    
    
    public boolean Bttle(int Planet)    //Takes the army size for the player and the planet and calculates an outcome
    {
        boolean Outcome = false;
        int troops = Troops(Planet);
        int groundvehicles = GroundVehicles(Planet);
        int airvehicles = AirVehicles(Planet);
        int PlanetrandomValue = RandomMiz();
        int PlayerrandomValue = RandomMiz();
        
        int PlanetValue = (airvehicles * 8) + (groundvehicles * 5) + (troops * 2) + PlanetrandomValue;
        int PlayerValue = (PlayerAirVehicles * 8) + (PlayerGroundVehicles * 5) + (PlayerTroops * 2) + PlayerrandomValue;
        
        if (PlayerValue > PlanetValue)
        {
            Outcome = true;
            PlanetOwnership[Planet] = true;
        }
        else
        {
            Outcome = false;
            TheTroopsCounter(PlayerTroops);
            TheGroundVehiclesCounter(PlayerGroundVehicles);
            TheAirVehiclesCounter(PlayerAirVehicles);
        }
        
        return Outcome;
    }
    
    
    
    public int Troops(int Planet)   //Getting the right amout of troops from an array method
    {
        Troops1[1] = 1;
        Troops1[2] = 100;
        Troops1[3] = 900;
        Troops1[4] = 2000;
        Troops1[5] = 10000;
        Troops1[6] = 20000;
        int troops = Troops1[Planet];
        return troops;
    }
    
    
    
    public int GroundVehicles(int Planet)   //Getting the right amout of Ground Vehicles from an array method
    {
        GroundVehicles1[1] = 0;
        GroundVehicles1[2] = 3;
        GroundVehicles1[3] = 10;
        GroundVehicles1[4] = 16;
        GroundVehicles1[5] = 50;
        GroundVehicles1[6] = 100;
        int groundvehicles = GroundVehicles1[Planet];
        return groundvehicles;        
    }
    
    
    
    public int AirVehicles(int Planet)  //Getting the right amout of AirVehicles from an array method
    {
        AirVehicles1[1] = 0;
        AirVehicles1[2] = 1;
        AirVehicles1[3] = 3;
        AirVehicles1[4] = 4;
        AirVehicles1[5] = 10;
        AirVehicles1[6] = 20;
        int airvehicles = AirVehicles1[Planet];
        return airvehicles;
    }
    
    
    
    public int RandomMiz()  //Randomizer method
    {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(11);
        return rand_int1;
    }
    
    
    
    public String TheMoneyCounter(int PlayerMoney)  //Money display for Game panel method
    {
        String MoneyCounterTXT = "None";
        MoneyCounterTXT = MoneyCounterTXT.valueOf(PlayerMoney);
        return MoneyCounterTXT;
    }
    
    
    
    public String TheMoneyCounter2(int PlayerMoney)     //Money display for store panel method
    {
        String MoneyCounter2TXT = "None";
        MoneyCounter2TXT = MoneyCounter2TXT.valueOf(PlayerMoney);
        return MoneyCounter2TXT;
    }
    
    
    
    public String TheTroopsCounter(int PlayerTroops)    //Troops amount displayed method
    {
        String TroopsCounterTXT = "None";
        TroopsCounterTXT = TroopsCounterTXT.valueOf(PlayerTroops);
        return TroopsCounterTXT;
    }
    
    
    
    public String TheGroundVehiclesCounter(int PlayerGroundVehicles)    //Ground Vehicles amount diplayed method
    {
        String GroundVehiclesCounterTXT = "None";
        GroundVehiclesCounterTXT = GroundVehiclesCounterTXT.valueOf(PlayerGroundVehicles);
        return GroundVehiclesCounterTXT;
    }
    
    
    
    public String TheAirVehiclesCounter(int PlayerAirVehicles)  //Air Vehicles amount diplayed method
    {
        String AirVehiclesCounterTXT = "None";
        AirVehiclesCounterTXT = AirVehiclesCounterTXT.valueOf(PlayerAirVehicles);
        return AirVehiclesCounterTXT;
    }
    
    
    public String FileReader()  //file reading method
    {
        String text = "";
        try 
        { 
            text = new String(Files.readAllBytes(Paths.get("F:/The_Rule_Of_Space/testy.txt"))); 
        } 
        catch (IOException e) 
        {
            e.printStackTrace(); 
        } 
        return text; 
    }

}

