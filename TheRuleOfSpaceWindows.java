
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Random;
import javax.swing.border.Border;

public class TheRuleOfSpaceWindows
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
    public TheRuleOfSpaceWindows()  
    { 
        JFrame TheRuleOfSpaceWindows = new JFrame();    //creates the main game JFrame
        TheRuleOfSpaceWindows.setSize(1920, 1080);  //Sets bounds of main JFrame
        TheRuleOfSpaceWindows.setResizable(true);   //Allows the frame to be resized
        
        JFrame YesNo = new JFrame();    //Creates the JFrame for the selection window
        YesNo.setSize(700, 300);    //Sets bounds
        
        JFrame OutcomeWindow = new JFrame();    //creates a window that displays the outcome of the battle
        OutcomeWindow.setSize(1920, 1080);  //Sets bounds
        
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
        Close2.setBounds(50, 750, 362, 91); //Sets bounds and position of button
        Close2.setBackground(GunMetal); //Sets color
        Close2.setForeground(Neon); //Sets color
        Win.add(VictoryBackGround); //Gives panel the JLabel to create background
        VictoryBackGround.setBounds(0,0,1920,1080); //Sets bounds of background
        
        JPanel Lose = new JPanel();
        Lose.setBackground(Color.red);  //sets color
        Lose.setLayout(null);
        Lose.add(Defeat);   //Adds JLabel to JPanel
        Defeat.setFont(new Font("TimesRoman", Font.BOLD,300));  //Sets font and size
        Defeat.setForeground(GunMetal); //Sets color
        Defeat.setBounds(425, 300, 1500, 350);  //Sets position and bounds
        Lose.add(Close);    // adds Button to JPanel
        Close.setBounds(50, 750, 362, 91);  //Sets bounds and position of button
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
        DontAttack.setBounds(225,150,200,75);
        
        JPanel Menu = new JPanel();
        Menu.setBackground(Color.darkGray);
        Menu.setLayout(null);
        Menu.add(Begin);
        Begin.setBackground(Color.gray);
        Begin.setOpaque(true);
        Begin.setBorder(BorderFactory.createBevelBorder(0, Color.white, Neon));
        Begin.setBounds(779, 216, 362, 56);
        Begin.setForeground(Neon);
        Menu.add(Intro);
        Intro.setBackground(Color.gray);
        Intro.setOpaque(true);
        Intro.setBorder(BorderFactory.createBevelBorder(0, Color.white, Neon));
        Intro.setBounds(779, 335, 362, 91);
        Intro.setForeground(Neon);
        Menu.add(Title);
        Title.setFont(new Font("Desdemona", Font.BOLD,150));
        Title.setForeground(Neon);
        Title.setBounds(425, 37, 1500, 121);
        Menu.add(MainbackGround);
        MainbackGround.setBounds(0, 0, 1920, 1080);  
        
        JPanel Introduction = new JPanel();
        Introduction.setLayout(null);
        Introduction.add(IntroText);
        IntroText.setFont(new Font("TimesRoman", Font.BOLD,25));
        IntroText.setForeground(Neon);
        IntroText.setBounds(800,100,362,91);
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
        Game.add(MoneyCounter);
        MoneyCounter.setFont(new Font("TimesRoman", Font.BOLD,25));
        MoneyCounter.setForeground(Neon);
        MoneyCounter.setBounds(1625,5,362,91);
        Game.add(Back);
        Back.setBounds(50, 750, 362, 91);
        Back.setBackground(GunMetal);
        Back.setForeground(Color.blue);
        Game.add(StoreButton);
        StoreButton.setBounds(50, 50, 362, 91);
        StoreButton.setBackground(GunMetal);
        StoreButton.setForeground(Color.blue);
        Game.add(GamebackGround);
        GamebackGround.setBounds(0, 0, 1920, 1080);
        GamebackGround.add(Planet6);
        Planet6.setBounds(1000, 500, 150, 150);
        GamebackGround.add(Planet1);
        Planet1.setBounds(500, 500, 200, 150);
        GamebackGround.add(Planet2);
        Planet2.setBounds(500, 750, 175, 175);
        GamebackGround.add(Planet3);
        Planet3.setBounds(1250, 200, 150, 150);
        GamebackGround.add(Planet4);
        Planet4.setBounds(750, 100, 150, 150);
        GamebackGround.add(Planet5);
        Planet5.setBounds(1400, 800, 175, 175);
        GamebackGround.add(Planet6);
        Planet6.setBounds(1000, 500, 150, 150);
        
        JPanel Store = new JPanel();
        Store.setLayout(null);
        Store.add(StoreBackGround);
        StoreBackGround.setBounds(0,0,1920,1080);
        StoreBackGround.add(MoneyCounter2);
        MoneyCounter2.setFont(new Font("TimesRoman", Font.BOLD,25));
        MoneyCounter2.setForeground(Neon);
        MoneyCounter2.setBounds(1625,5,362,91);
        StoreBackGround.add(TroopsCounter);
        TroopsCounter.setFont(new Font("TimesRoman", Font.BOLD,50));
        TroopsCounter.setForeground(Neon);
        TroopsCounter.setBounds(220,50,362,91);
        StoreBackGround.add(GroundVehiclesCounter);
        GroundVehiclesCounter.setFont(new Font("TimesRoman", Font.BOLD,50));
        GroundVehiclesCounter.setForeground(Neon);
        GroundVehiclesCounter.setBounds(700,50,500,91);
        StoreBackGround.add(AirVehiclesCounter);
        AirVehiclesCounter.setFont(new Font("TimesRoman", Font.BOLD,50));
        AirVehiclesCounter.setForeground(Neon);
        AirVehiclesCounter.setBounds(1350,50,362,91);
        StoreBackGround.add(CloseStore);
        CloseStore.setBounds(50, 750, 362, 91);
        CloseStore.setBackground(GunMetal);
        CloseStore.setForeground(Neon);
        StoreBackGround.add(BuyTroops);
        BuyTroops.setBounds(150, 300, 362, 91);
        BuyTroops.setBackground(GunMetal);
        BuyTroops.setForeground(Neon);
        StoreBackGround.add(BuyGroundVehicles);
        BuyGroundVehicles.setBounds(750, 300, 362, 91);
        BuyGroundVehicles.setBackground(GunMetal);
        BuyGroundVehicles.setForeground(Neon);
        StoreBackGround.add(BuyAirVehicles);
        BuyAirVehicles.setBounds(1350, 300, 362, 91);
        BuyAirVehicles.setBackground(GunMetal);
        BuyAirVehicles.setForeground(Neon);
        /**Store.add(StoreBackGround);
        StoreBackGround.setBounds(0,0,1920,1080);**/
        
        JPanel NoMoney = new JPanel();
        NoMoney.setLayout(null);
        NoMoney.setBackground(GunMetal);
        NoMoney.add(Close3);
        Close3.setBounds(50,150,200,75);
        Close3.setForeground(Color.red);
        Close3.setBorder(BorderFactory.createBevelBorder(0, Color.red, Color.red));
        NoMoney.add(CannotAfford);
        CannotAfford.setFont(new Font("TimesRoman", Font.BOLD,25));
        CannotAfford.setBounds(150,2,400,200);
        CannotAfford.setForeground(Color.red);

        
        cards = new JPanel(new CardLayout());
        
        cards.add(Menu, "Menu");
        cards.add(Introduction, "Introduction");
        cards.add(Game, "Game");
        cards.add(Store, "Store");
        
        TheOutcome = new JPanel(new CardLayout());
        
        TheOutcome.add(Lose, "Lose");
        TheOutcome.add(Win, "Win");
        
        TheRuleOfSpaceWindows.getContentPane().add(cards);
        YesNo.getContentPane().add(Selection);
        OutcomeWindow.getContentPane().add(TheOutcome);
        Warning.getContentPane().add(NoMoney);
        
        TheRuleOfSpaceWindows.setVisible(true);
        YesNo.setVisible(false);
        OutcomeWindow.setVisible(false);
        Warning.setVisible(false);
        
        
        
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
                 boolean Outcome = Bttle(Planet);
                 YesNo.setVisible(false);
                 if (Outcome == true)
                 {
                     OutcomeWindow.setVisible(true);
                     CardLayout cardLayout = (CardLayout) TheOutcome.getLayout();
                     cardLayout.show(TheOutcome, "Win");
                     PlayerMoney = PlayerMoney + 200000;
                     MoneyCounter2.setText(TheMoneyCounter2(PlayerMoney) + " Dollars");
                     MoneyCounter.setText(TheMoneyCounter(PlayerMoney) + " Dollars");
                 }
                 else
                 {
                     OutcomeWindow.setVisible(true);
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
                 OutcomeWindow.setVisible(false);
            }
        });
        

        Close2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 OutcomeWindow.setVisible(false);
            }
        });
        
        
        Close3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 Warning.setVisible(false);       
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
                    PlayerMoney = PlayerMoney - 100;
                    TroopsCounter.setText("Troops " + TheTroopsCounter(PlayerTroops));
                    MoneyCounter2.setText(TheMoneyCounter2(PlayerMoney) + " Dollars");
                    MoneyCounter.setText(TheMoneyCounter(PlayerMoney) + " Dollars");
                }
                else
                {
                    Warning.setVisible(true);
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
                    PlayerMoney = PlayerMoney - 10000;
                    GroundVehiclesCounter.setText("Ground Vehicles " + TheGroundVehiclesCounter(PlayerGroundVehicles));
                    MoneyCounter2.setText(TheMoneyCounter2(PlayerMoney) + " Dollars");
                    MoneyCounter.setText(TheMoneyCounter(PlayerMoney) + " Dollars");
                }
                else
                {
                    Warning.setVisible(true);
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
                    PlayerMoney = PlayerMoney - 30000;
                    AirVehiclesCounter.setText("Air Vehicles " + TheAirVehiclesCounter(PlayerAirVehicles));
                    MoneyCounter2.setText(TheMoneyCounter2(PlayerMoney) + " Dollars");
                    MoneyCounter.setText(TheMoneyCounter(PlayerMoney) + " Dollars");
                }
                else
                {
                    Warning.setVisible(true);
                }            
            }
        });
        
        
        Planet1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(PlanetOwnership[1] == false)
                {
                    YesNo.setVisible(true);
                    Planet = 1;
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
                    YesNo.setVisible(true);
                    Planet = 2;
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
                    YesNo.setVisible(true);
                    Planet = 3;
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
                    YesNo.setVisible(true);
                    Planet = 4;
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
                    YesNo.setVisible(true);
                    Planet = 5;
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
                    YesNo.setVisible(true);
                    Planet = 6;
                }
                else
                {
                }
            }
        });
    } 
    
    
    public static void main(String args[]) 
    {    
        new TheRuleOfSpaceWindows();
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
