import java.awt.EventQueue;

import javax.swing.JFrame;

public class Intro3 //extends MainMenu
{

	private JFrame frame;
	public static boolean visibility = false;
	public static Intro3 window = new Intro3();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		MainMenu e = new MainMenu();
		visibility = e.clear();
		
		if (visibility == true)
		{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					//Intro3 window = new Intro3();
					window.frame.setVisible(visibility);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		}
		else
		{
		}
	}

	/**
	 * Create the application.
	 */
	public Intro3() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
