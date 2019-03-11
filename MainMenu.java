import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Button;

public class MainMenu 
{

	private JFrame frame;
	private final Action action = new BeginAction();
	private final Action action_1 = new IntroAction();
	private JLabel lblSpaceDictators = new JLabel("Space Dictators");
	private JButton btnIntro = new JButton("Intro");
	private JButton btnBegin = new JButton("Begin");
	private JTextPane txtpnIntro = new JTextPane();
	private final Action action_2 = new BackAction();
	private JButton btnBack = new JButton("Back");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.scrollbar);
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//JButton btnBegin = new JButton("Begin");
		btnBegin.setAction(action);
		btnBegin.setBounds(779, 216, 362, 56);
		frame.getContentPane().add(btnBegin);
		
		//JButton btnIntro = new JButton("Intro");
		btnIntro.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		btnIntro.setAction(action_1);
		btnIntro.setBounds(779, 335, 362, 91);
		frame.getContentPane().add(btnIntro);
		
		//JLabel lblSpaceDictators = new JLabel("Space Dictators");
		lblSpaceDictators.setFont(new Font("Lucida Grande", Font.PLAIN, 80));
		lblSpaceDictators.setBounds(647, 37, 626, 121);
		frame.getContentPane().add(lblSpaceDictators);
		
		//JTextPane txtpnIntro = new JTextPane();
		txtpnIntro.setText("Intro");
		txtpnIntro.setBounds(851, 292, 218, 16);
		frame.getContentPane().add(txtpnIntro);
		txtpnIntro.setVisible(false);
		
		//JButton btnNewButton = new JButton("Back");
		btnBack.setAction(action_2);
		btnBack.setBounds(900, 230, 117, 29);
		frame.getContentPane().add(btnBack);
		btnBack.setVisible(false);
	}
	private class BeginAction extends AbstractAction 
	{
		public BeginAction() 
		{
			putValue(NAME, "Begin");
			putValue(SHORT_DESCRIPTION, "To Play");
		}
		public void actionPerformed(ActionEvent e) 
		{
			lblSpaceDictators.setVisible(false);
			btnIntro.setVisible(false);
			btnBegin.setVisible(false);
		}
	}
	private class IntroAction extends AbstractAction 
		{
		public IntroAction() 
		{
			putValue(NAME, "Introduction");
			putValue(SHORT_DESCRIPTION, "For Help");
		}	
		public void actionPerformed(ActionEvent e) 
		{
			txtpnIntro.setVisible(true);
			System.out.println("Intro button preformed");
			btnIntro.setVisible(false);
			btnBegin.setVisible(false);
			btnBack.setVisible(true);
		}
	}
	private class BackAction extends AbstractAction 
	{
		public BackAction() 
		{
			putValue(NAME, "Back");
			putValue(SHORT_DESCRIPTION, "Go back to the main screen");
		}
		public void actionPerformed(ActionEvent e) 
		{
			txtpnIntro.setVisible(false);
			btnIntro.setVisible(true);
			btnBegin.setVisible(true);
			btnBack.setVisible(false);
		}
	}
}
